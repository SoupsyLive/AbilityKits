package live.soupsy.ak.utils;

public final class ArgNumbCheckUtil {
    public static boolean isInt(String s) { //int check
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static boolean isDouble(String s) { //int check
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
