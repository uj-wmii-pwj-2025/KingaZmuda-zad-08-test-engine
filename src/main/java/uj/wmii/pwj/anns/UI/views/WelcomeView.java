package uj.wmii.pwj.anns.UI.views;

import uj.wmii.pwj.anns.UI.components.banner.BannerPrinter;
import uj.wmii.pwj.anns.UI.components.testList.TestListPrinter;

public class WelcomeView implements View {

    BannerPrinter bannerPrinter;
    TestListPrinter testListPrinter;

    public WelcomeView(BannerPrinter bannerPrinter, TestListPrinter testListPrinter) {
        this.bannerPrinter = bannerPrinter;
        this.testListPrinter = testListPrinter;
    }

    @Override
    public void show() {
        bannerPrinter.print("Test Engine");
        System.out.println();
        System.out.println("> TESTS ABOUT TO BE RUN:");
        testListPrinter.print();
        System.out.println();
    }
}
