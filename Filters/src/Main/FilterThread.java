package Main;

import java.awt.image.BufferedImage;

public class FilterThread extends Thread{

    private BufferedImage input;
    private BufferedImage output;
    private int mode;
    private int from;
    private int to;

    public FilterThread(BufferedImage input, BufferedImage output, int mode, int from, int to) {
        this.input = input;
        this.output = output;
        this.mode = mode;
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
    if (mode == Filter.HORIZONTAL){
            for (int j = from; j < to; j++){
                for (int i = 0; i < input.getWidth(); i++){
                    output.setRGB(i, j, Filter.getNewRGB(i, j, input));
                }
            }
        }
        if (mode == Filter.VERTICAL){
            for (int i = from; i < to; i++){
                for (int j = 0; j < input.getHeight(); j++){
                    output.setRGB(i, j, Filter.getNewRGB(i, j, input));
                }
            }
        }
    }
}
