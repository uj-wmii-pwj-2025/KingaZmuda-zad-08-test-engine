package uj.wmii.pwj.anns.UI.components.banner;

import java.util.HashMap;
import java.util.Map;

public class DefaultAsciiFont implements Font {
    private final int height;
    private final Map<Character, String[]> alphabet;

    public DefaultAsciiFont() {
        alphabet = getAlphabet();
        height = 7; // 7 lines
    }

    @Override
    public String[] getCharacter(char c) {
        String[] charLines = alphabet.get(c);

        if (charLines == null) {
            charLines = alphabet.get((char)(c - 32)); //convert to uppercase
        }

        return charLines;
    }
    @Override
    public int getHeight() {
        return height;
    }

    private Map<Character, String[]> getAlphabet() {
        Map<Character, String[]> defaultAlphabet = new HashMap<>();
        defaultAlphabet.put('A', new String[]{
                "  ###  ",
                " #   # ",
                "#     #",
                "#######",
                "#     #",
                "#     #",
                "#     #"
        });

        defaultAlphabet.put('B', new String[]{
                "###### ",
                "#     #",
                "#     #",
                "###### ",
                "#     #",
                "#     #",
                "###### "
        });

        defaultAlphabet.put('C', new String[]{
                " ##### ",
                "#     #",
                "#      ",
                "#      ",
                "#      ",
                "#     #",
                " ##### "
        });

        defaultAlphabet.put('D', new String[]{
                "#####  ",
                "#    # ",
                "#     #",
                "#     #",
                "#     #",
                "#    # ",
                "#####  "
        });

        defaultAlphabet.put('E', new String[]{
                "#######",
                "#      ",
                "#      ",
                "#####  ",
                "#      ",
                "#      ",
                "#######"
        });

        defaultAlphabet.put('F', new String[]{
                "#######",
                "#      ",
                "#      ",
                "#####  ",
                "#      ",
                "#      ",
                "#      "
        });

        defaultAlphabet.put('G', new String[]{
                " ##### ",
                "#     #",
                "#      ",
                "#  ####",
                "#     #",
                "#     #",
                " ##### "
        });

        defaultAlphabet.put('H', new String[]{
                "#     #",
                "#     #",
                "#     #",
                "#######",
                "#     #",
                "#     #",
                "#     #"
        });

        defaultAlphabet.put('I', new String[]{
                " ##### ",
                "   #   ",
                "   #   ",
                "   #   ",
                "   #   ",
                "   #   ",
                " ##### "
        });

        defaultAlphabet.put('J', new String[]{
                "###### ",
                "    #  ",
                "    #  ",
                "    #  ",
                "#   #  ",
                "#   #  ",
                " ###   "
        });

        defaultAlphabet.put('K', new String[]{
                "#    # ",
                "#   #  ",
                "#  #   ",
                "###    ",
                "#  #   ",
                "#   #  ",
                "#    # "
        });

        defaultAlphabet.put('L', new String[]{
                "#      ",
                "#      ",
                "#      ",
                "#      ",
                "#      ",
                "#      ",
                "###### "
        });

        defaultAlphabet.put('M', new String[]{
                "#     #",
                "##   ##",
                "# # # #",
                "#  #  #",
                "#     #",
                "#     #",
                "#     #"
        });

        defaultAlphabet.put('N', new String[]{
                "#     #",
                "##    #",
                "# #   #",
                "#  #  #",
                "#   # #",
                "#    ##",
                "#     #"
        });

        defaultAlphabet.put('O', new String[]{
                " ##### ",
                "#     #",
                "#     #",
                "#     #",
                "#     #",
                "#     #",
                " ##### "
        });

        defaultAlphabet.put('P', new String[]{
                "###### ",
                "#     #",
                "#     #",
                "###### ",
                "#      ",
                "#      ",
                "#      "
        });

        defaultAlphabet.put('Q', new String[]{
                " ##### ",
                "#     #",
                "#     #",
                "#     #",
                "#   # #",
                "#    # ",
                " #### #"
        });

        defaultAlphabet.put('R', new String[]{
                "###### ",
                "#     #",
                "#     #",
                "###### ",
                "#   #  ",
                "#    # ",
                "#     #"
        });

        defaultAlphabet.put('S', new String[]{
                " ##### ",
                "#     #",
                "#      ",
                " ##### ",
                "      #",
                "#     #",
                " ##### "
        });

        defaultAlphabet.put('T', new String[]{
                "#######",
                "   #   ",
                "   #   ",
                "   #   ",
                "   #   ",
                "   #   ",
                "   #   "
        });

        defaultAlphabet.put('U', new String[]{
                "#     #",
                "#     #",
                "#     #",
                "#     #",
                "#     #",
                "#     #",
                " ##### "
        });

        defaultAlphabet.put('V', new String[]{
                "#     #",
                "#     #",
                "#     #",
                " #   # ",
                " #   # ",
                "  # #  ",
                "   #   "
        });

        defaultAlphabet.put('W', new String[]{
                "#     #",
                "#  #  #",
                "#  #  #",
                "#  #  #",
                "#  #  #",
                "# # # #",
                " #   # "
        });

        defaultAlphabet.put('X', new String[]{
                "#     #",
                " #   # ",
                "  # #  ",
                "   #   ",
                "  # #  ",
                " #   # ",
                "#     #"
        });

        defaultAlphabet.put('Y', new String[]{
                "#     #",
                " #   # ",
                "  # #  ",
                "   #   ",
                "   #   ",
                "   #   ",
                "   #   "
        });

        defaultAlphabet.put('Z', new String[]{
                "#######",
                "     # ",
                "    #  ",
                "   #   ",
                "  #    ",
                " #     ",
                "#######"
        });

        defaultAlphabet.put(' ', new String[]{
                "       ",
                "       ",
                "       ",
                "       ",
                "       ",
                "       ",
                "       "
        });

        return defaultAlphabet;
    }
}
