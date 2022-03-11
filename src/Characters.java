import java.io.IOException;
import java.util.*;

public class Characters {
    public static void main(String[] args) throws IOException {
        Controller controller = new Controller(new ConsoleView());
        controller.Go();
    }
}
