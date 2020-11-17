package Main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        String filename = "res/input.jpg";
        BufferedImage input;
        input = ImageIO.read(new File(filename));
        Filter filter = new Filter(input);
        BufferedImage output = filter.multipleThreadUse(4, Filter.HORIZONTAL);
        ImageIO.write(output, "jpg", new File("res/output.jpg"));

    }
}
