package uj.wmii.pwj.anns;

public record TestResultEntry(String methodName, TestResult status, String expected, String actual,
                              Throwable exception) {
}