import java.io.IOException;
import java.util.Scanner;

public class ConsoleView implements IView {
    public void Start(String prompt){
        System.out.println(prompt);
    }

    public void Show(String message){
        System.out.println(message);
    }

    public void Stop() throws IOException {
        System.out.close();
    }

    public int GetInt(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);

        return scanner.nextInt();
    }

    public String GetString(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);

        return scanner.nextLine();
    }

}
