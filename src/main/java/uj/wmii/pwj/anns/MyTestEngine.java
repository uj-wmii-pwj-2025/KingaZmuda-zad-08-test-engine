package uj.wmii.pwj.anns;

import uj.wmii.pwj.anns.UI.components.banner.BannerFactory;
import uj.wmii.pwj.anns.UI.components.banner.BannerPrinter;
import uj.wmii.pwj.anns.UI.components.testList.TestListPrinter;
import uj.wmii.pwj.anns.UI.views.ResultsView;
import uj.wmii.pwj.anns.UI.views.WelcomeView;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyTestEngine {

    private final String className;
    private static WelcomeView welcomeView;
    private static ResultsView resultsView;

    private static void init(List<Method> testMethods) {
        BannerPrinter bannerPrinter = new BannerPrinter(BannerFactory.create());
        TestListPrinter testListPrinter = new TestListPrinter(testMethods);
        welcomeView = new WelcomeView(bannerPrinter, testListPrinter);
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please specify test class name");
            System.exit(-1);
        }

        String className = args[0].trim();

        final Object unit = getObject(className);
        List<Method> testMethods = getTestMethods(unit);
        init(testMethods);

        welcomeView.show();

        System.out.printf("> Testing class: %s\n\n", className);
        MyTestEngine engine = new MyTestEngine(className);
        engine.runTests();
    }

    public MyTestEngine(String className) {
        this.className = className;
    }

    public void runTests() {
        List<TestResultEntry> entries = new ArrayList<>();

        final Object unit = getObject(className);
        List<Method> testMethods = getTestMethods(unit);

        for (Method m : testMethods) {
            entries.add(launchSingleMethod(m, unit));
        }

        long pass = entries.stream().filter(e -> e.status() == TestResult.PASS).count();
        long fail = entries.stream().filter(e -> e.status() == TestResult.FAIL).count();
        long error = entries.stream().filter(e -> e.status() == TestResult.ERROR).count();

        System.out.printf("> Engine launched %d tests.\n", testMethods.size());
        System.out.printf("> %d passed, %d failed, %d errors.\n\n", pass, fail, error);

        resultsView = new ResultsView(entries);
        resultsView.show();
    }

    private TestResultEntry launchSingleMethod(Method m, Object unit) {
        printTestStart(m);

        try {
            Object actual = invokeTestMethod(m, unit);
            TestResult status = evaluateResult(m, actual);

            if (status == TestResult.PASS) printSuccess(m);
            else printFail(m, actual);

            return new TestResultEntry(
                    m.getName(),
                    status,
                    getExpected(m),
                    str(actual),
                    null
            );

        } catch (ReflectiveOperationException e) {
            Throwable cause = e.getCause();
            if (cause != null) {
                printFailWithException(m, cause);
                return new TestResultEntry(
                        m.getName(),
                        TestResult.FAIL,
                        getExpected(m),
                        null,
                        cause
                );
            }

            printError(m, e);
            return new TestResultEntry(
                    m.getName(),
                    TestResult.ERROR,
                    getExpected(m),
                    null,
                    e
            );
        }
    }

    private Object invokeTestMethod(Method m, Object unit) throws ReflectiveOperationException {
        String[] params = m.getAnnotation(MyTest.class).params();

        if (params.length == 0) {
            return m.invoke(unit);
        }

        Object last = null;
        for (String p : params) {
            last = m.invoke(unit, p);
        }
        return last;
    }

    private TestResult evaluateResult(Method m, Object actual) {
        MyTest t = m.getAnnotation(MyTest.class);

        if (t.isExpectedResultSet()) {
            if (!t.expectedResult().equals(str(actual))) {
                return TestResult.FAIL;
            }
        }
        return TestResult.PASS;
    }

    private String getExpected(Method m) {
        MyTest t = m.getAnnotation(MyTest.class);
        return t.isExpectedResultSet() ? t.expectedResult() : null;
    }

    private String str(Object o) {
        return o == null ? null : o.toString();
    }

    private static List<Method> getTestMethods(Object unit) {
        return Arrays.stream(unit.getClass().getDeclaredMethods())
                .filter(m -> m.getAnnotation(MyTest.class) != null)
                .collect(Collectors.toList());
    }

    private static Object getObject(String className) {
        try {
            Class<?> unitClass = Class.forName(className);
            return unitClass.getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
            return new Object();
        }
    }

    private void printTestStart(Method m) {
        System.out.printf("> Testing method: %s...\n", m.getName());
    }

    private void printSuccess(Method m) {
        System.out.printf("> Tested method: %s test successful.\n\n", m.getName());
    }

    private void printFail(Method m, Object actual) {
        System.out.printf("> Tested method: %s failed (actual: %s)\n\n",
                m.getName(), str(actual));
    }

    private void printFailWithException(Method m, Throwable t) {
        System.out.printf("> Tested method: %s failed with exception: %s\n\n",
                m.getName(), t);
    }

    private void printError(Method m, Throwable t) {
        System.out.printf("> Tested method: %s error: %s\n\n",
                m.getName(), t);
    }
}
