package Test;

import Main.Filter;
import org.openjdk.jmh.annotations.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
public class SingeThreadProductivityTest {
    public Filter filter;
    public String PATH = "res/";

    @Param({"big.jpg","middle.jpg", "small.jpg"})
    public String imgName;

    @Setup
    public void prepareImg() throws IOException {
        BufferedImage input = ImageIO.read(new File(PATH + imgName));
        filter = new Filter(input);
    }
    @Benchmark
    public void singleThreadTest(){
        BufferedImage output = filter.singleThreadUse();
    }
}
