package Main;

public class SingleThreadAlg {
    public static boolean MatchBrackets(char[] array) {
        int x = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                x++;
            }
            else {
                x--;
            }
            if (x < 0) {
                return false;
            }
        }
        if (x != 0) {
            return false;
        }
        return true;
    }
}
