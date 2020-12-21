package Main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Filter {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private BufferedImage input;
    private BufferedImage output;
    private int mode;

    public Filter(BufferedImage input) {
        this.input = input;
        output = new BufferedImage(input.getWidth(), input.getHeight(), input.getType());
    }
    /*public BufferedImage getInput(){
        return input;
    }
    public BufferedImage getOutput(){
        return output;
    }
    public int getMode(){
        return mode;
    }*/
    public BufferedImage singleThreadUse() {
        for (int i = 0; i < output.getWidth(); i++){
            for (int j = 0; j < output.getHeight(); j++){
                output.setRGB(i, j, getNewRGB(i, j, input));
            }
        }
        return output;
    }
    private static int convertColorsToRGB(int red, int green, int blue) {
        red = red * 256 * 256;
        green = green * 256;
        return (red + green + blue);
    }

    static int getNewRGB(int x, int y, BufferedImage image) {
        int redSum = 0;
        int greenSum = 0;
        int blueSum = 0;
        int n = 0;
        for (int u = -1; u <= 1; u++) {
            for (int v = -1; v <= 1; v++) {
                if (isInRange(x + u, y + v, image)) {
                    n++;
                    Color color = new Color(image.getRGB(x + u, y + v));
                    redSum += color.getRed();
                    greenSum += color.getGreen();
                    blueSum += color.getBlue();
                }
            }
        }
        redSum /= n;
        greenSum /= n;
        blueSum /= n;
        return convertColorsToRGB(redSum, greenSum, blueSum);
    }
    private static boolean isInRange(int x, int y, BufferedImage image) {
        return ((x >= 0) && (x < image.getWidth()) && (y >= 0) && (y < image.getHeight()));
    }
    public BufferedImage multipleThreadUse(int procs, int mode) throws InterruptedException {
        int linesForOneThread;
        this.mode = mode;
        int end;
        if (mode == HORIZONTAL) {
            linesForOneThread = input.getHeight() / procs;
            end = input.getHeight();
        }
        else {
            linesForOneThread = input.getWidth() / procs;
            end = input.getWidth();
        }
        FilterThread[] threads = new FilterThread[procs];
        for (int i = 0; i < procs - 1; i++) {
            threads[i] = new FilterThread(input, output, mode, i * linesForOneThread, (i + 1) * linesForOneThread);
            threads[i].start();
        }
        threads[procs - 1] = new FilterThread(input, output, mode, (procs - 1) * linesForOneThread, end);
        threads[procs - 1].start();
        for (int i = 0; i < procs; i++) {
            threads[i].join();
        }
        return output;

    }
}
