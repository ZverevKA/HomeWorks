package Main;

public class SingleThreadAlg {
    public static int[] SumInt(int[] firstN, int[] secondN) {
        int[] result = new int[Math.max(firstN.length, secondN.length) + 1];
        int c = 0;
        int y;
        for (int i = 0; i < result.length - 1; i++) {
            if (firstN.length <= i ) {
                y = secondN[i] + c;
            }
            else if (secondN.length <= i) {
                y = firstN[i] + c;
            }
            else{
                y = firstN[i] + secondN[i];
            }
            if (y > 9) {
                result[i] = y - 10;
                c = 1;
            }
            else{
                result[i] = y;
                c = 0;
            }
        }
        result[result.length - 1] = c;
        return result;
    }
}
