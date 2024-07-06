public class WhiteWalkersUPD {
    public static boolean white_walkers(String village) {
        String copy = new String(village);
        copy = copy.replaceAll("[^=0-9]", "");

        return TrueFalse(copy, false, 0, 0, -1, -1);
    }
    public static boolean TrueFalse (String copy, boolean findWalkers, int f, int amt, int start, int end) {
        if (start + end == 10 && amt == 3) {
            findWalkers = true;
            start = end;
            end = -2;
            amt = 0;
        }
        else if (start + end == 10 && amt != 3) {
            findWalkers = false;
            return findWalkers;
        }
        else if (start >= 0 && end >= 0) {
            start = end;
            end = -2;
            amt = 0;
        }

        if (f == copy.length()) return findWalkers;

        if (copy.charAt(f) != '=' && start < 0) {
            start = Character.getNumericValue(copy.charAt(f));
        }

        else if (copy.charAt(f) == '=' && start >= 0) {
            amt++;
        }

        else if (copy.charAt(f) != '=' && start >= 0) {
            end = Character.getNumericValue(copy.charAt(f));
        }

        return TrueFalse(copy, findWalkers, f + 1, amt, start, end);

    }
}

