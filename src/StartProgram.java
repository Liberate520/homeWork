import model.Services.ServiceDog;
import model.Services.ServiceHuman;
import presenter.PresenterDog;
import presenter.PresenterHuman;
import ui.Console.ConsoleDog;
import ui.Console.ConsoleHuman;
import ui.View.ViewDog;
import ui.View.ViewHuman;

import java.util.Scanner;

public class StartProgram {
    private ViewHuman viewHuman;
    private ViewDog viewDog;
    private ServiceHuman serviceHuman;
    private ServiceDog serviceDog;
    private Scanner scanner;

    public StartProgram() {
        scanner = new Scanner(System.in);
    }

    public void start(){
        String type = "";
        while (!type.equals("человек") && !type.equals("собака")) {
            System.out.print("Введите тип данных дерева (человек/собака): ");
            type = scanner.nextLine();
        }
        if(type.equals("человек")) {
            viewHuman = new ConsoleHuman();
            serviceHuman = new ServiceHuman();
            new PresenterHuman(viewHuman, serviceHuman);
            viewHuman.start();
        }
        if(type.equals("собака")) {
            viewDog = new ConsoleDog();
            serviceDog = new ServiceDog();
            new PresenterDog(viewDog, serviceDog);
            viewDog.start();
        }
    }
}
