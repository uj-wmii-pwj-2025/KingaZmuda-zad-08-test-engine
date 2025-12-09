package uj.wmii.pwj.anns.UI.views;

import uj.wmii.pwj.anns.TestResultEntry;
import java.util.List;

public class ResultsView implements View {

    private final List<TestResultEntry> entries;

    public ResultsView(List<TestResultEntry> entries) {
        this.entries = entries;
    }

    @Override
    public void show() {

        String headerFormat = "%-25s | %-10s | %-20s | %-20s | %-50s\n";

        String headerLine = String.format(
                headerFormat,
                "Method", "Status", "Expected", "Actual", "Exception"
        );

        int tableWidth = headerLine.length();

        System.out.print(headerLine);

        System.out.println(
                "-".repeat(tableWidth)
        );

        for (TestResultEntry e : entries) {
            System.out.printf(
                    headerFormat,
                    e.methodName(),
                    e.status(),
                    e.expected() == null ? "-" : e.expected(),
                    e.actual() == null ? "-" : e.actual(),
                    e.exception() == null ? "-" : e.exception().toString()
            );
        }

        System.out.println("-".repeat(tableWidth));
        System.out.println();
    }
}