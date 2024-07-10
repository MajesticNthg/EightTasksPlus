import java.util.ArrayList;
import java.util.Comparator;

public class GreenCodeOfMatrix {
    public static String digital_rain(String col) {
        String copy = new String(col);
        int sizeSubstring;
        ArrayList<String> searchMaxSubstring = new ArrayList<String>();
        copy = copy.replaceAll("1", "");

        if (copy.length() <= col.length() / 2) {
            sizeSubstring = copy.length() * 2;
        } else {
            copy = new String(col);
            copy = copy.replaceAll("0", "");
            sizeSubstring = copy.length() * 2;
        }

        createList(sizeSubstring, col, 0, searchMaxSubstring);
        if (searchMaxSubstring.isEmpty()) return "";

        searchMaxSubstring.sort(Comparator.naturalOrder());
        return searchMaxSubstring.getLast();
    }

    public static ArrayList createList(int sizeSubstring, String col, int start, ArrayList<String> searchMaxSubstring) {
        if (sizeSubstring <= 1) return searchMaxSubstring;
        char[] substring = new char[sizeSubstring];

        for (int y = 0; y < col.length() - sizeSubstring + 1; y++, start++) {
            int one = 0;
            int zero = 0;
            for (int x = 0; x < sizeSubstring; x++) {
                substring[x] = col.charAt(start + x);
                if (substring[x] == '1') one++;
                else zero++;
            }
            if (one == zero) {
                searchMaxSubstring.add(new String(substring));
            }
        }

        if (searchMaxSubstring.isEmpty()) createList(sizeSubstring - 1, col, 0, searchMaxSubstring);
        return searchMaxSubstring;
    }
}

