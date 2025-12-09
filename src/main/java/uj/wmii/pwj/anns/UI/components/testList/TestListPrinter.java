package uj.wmii.pwj.anns.UI.components.testList;

import java.lang.reflect.Method;
import java.util.List;

public class TestListPrinter {

    List<Method> testMethods;

    public TestListPrinter(List<Method> testMethods) {
        this.testMethods = testMethods;
    }

    public void print() {
        for (Method method : testMethods) {
            System.out.println(method.getName());
        }
    }
}
