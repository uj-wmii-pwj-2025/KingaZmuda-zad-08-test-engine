package uj.wmii.pwj.anns;

public class MyMagnificentTestSuite {

    @MyTest
    public String testSomething() {
        System.out.println("I'm testing something!");
        return "OK";
    }

    @MyTest(
            params = {"a param"},
            expectedResult = "a param processed",
            isExpectedResultSet = true
    )
    public String testWithOneParam(String param) {
        return param + " processed";
    }

    @MyTest(
            params = {"A", "B", "C"},
            expectedResult = "C processed",
            isExpectedResultSet = true
    )
    public String testMultipleParams(String param) {
        return param + " processed";
    }

    public void notATest() {
        System.out.println("I'm not a test.");
    }

    @MyTest(
            isExpectedResultSet = true,
            expectedResult = "never happens"
    )
    public String imFailure() {
        throw new NullPointerException("Intentional failure");
    }
}
