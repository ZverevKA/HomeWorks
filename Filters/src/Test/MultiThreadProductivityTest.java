package Test;


import Main.Filter;
import org.openjdk.jmh.annotations.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
public class MultiThreadProductivityTest {
    public Filter filter;
    public String PATH = "res/";

    @Param({"big.jpg","middle.jpg", "small.jpg"})
    public String imgName;
    @Param({"1", "2", "4"})
    public int numOfThread;
    @Param({"0", "1"})
    public int mode;
    @Setup
    public void prepareImg() throws IOException {
        BufferedImage input = ImageIO.read(new File(PATH + imgName));
        filter = new Filter(input);
    }
    @Benchmark
    public void multiThreadTest() throws InterruptedException {
        BufferedImage output = filter.multipleThreadUse(numOfThread, mode);
    }


}
