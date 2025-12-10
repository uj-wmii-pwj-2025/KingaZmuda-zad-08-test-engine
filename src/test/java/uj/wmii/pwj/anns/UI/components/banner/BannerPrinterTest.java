package uj.wmii.pwj.anns.UI.components.banner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BannerPrinterTest {

    private Font fontMock;
    private BannerPrinter bannerPrinter;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        fontMock = mock(Font.class);

        when(fontMock.getHeight()).thenReturn(2);
        when(fontMock.getCharacter('A')).thenReturn(new String[]{"AA1", "AA2"});
        when(fontMock.getCharacter('B')).thenReturn(new String[]{"BB1", "BB2"});

        bannerPrinter = new BannerPrinter(fontMock);
    }

    @Test
    void testPrintSingleWord() {
        bannerPrinter.print("AB");

        String expectedOutput = "AA1   BB1   \n" +
                "AA2   BB2   \n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintMultipleCharacters() {
        when(fontMock.getCharacter('C')).thenReturn(new String[]{"CC1", "CC2"});

        bannerPrinter.print("ABC");

        String expectedOutput = "AA1   BB1   CC1   \n" +
                "AA2   BB2   CC2   \n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @AfterEach
    void restoreSystemOut() {
        System.setOut(originalOut);
    }
}
