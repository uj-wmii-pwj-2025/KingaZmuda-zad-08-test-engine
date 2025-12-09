package uj.wmii.pwj.anns.UI.components.banner;

import java.util.Arrays;

public class BannerPrinter {
    private final Font font;

    public BannerPrinter(Font font) {
        this.font = font;
    }

    public void print(String text) {
        int height = font.getHeight();

        for (int i = 0; i < height; i++) {
            StringBuilder sb = new StringBuilder();
            int textLength = text.length();

            for (int c = 0; c < textLength; c++) {
                char current = text.charAt(c);
                sb.append(font.getCharacter(current)[i]).append("   ");
            }

            System.out.println(sb);
        }
    }
}
