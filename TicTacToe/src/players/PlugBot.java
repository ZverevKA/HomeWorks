package players;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public interface PlugBot {

    public void chooseCell();
    public String getName();
}