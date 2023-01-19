package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Controller.Controller;
import Model.HumanTreeModel;
import Model.Model;
import View.Command.Command1;
import View.Command.Command2;
import View.Command.Command3;
import View.Command.Option;

public class View {
    
    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        List<Option> commandList = new ArrayList<Option>();
        commandList.add(new Command1(this));
        commandList.add(new Command2(this));
        commandList.add(new Command3(this));
        System.out.println("Choose number of action:");
        for (int index = 0; index < commandList.size(); index++) {
            System.out.println(commandList.get(index).discription());
        } 
               
        int myChoose = scanner.nextInt();
        commandList.get(myChoose-1).execute();
        
    }
    
    public void choose_1() {
        Model humanTreeModel = new HumanTreeModel();  
        Controller controller = new Controller(this, humanTreeModel);     
        controller.onClick_1();
    }

    public void choose_2() {
        Model humanTreeModel = new HumanTreeModel();  
        Controller controller = new Controller(this, humanTreeModel);     
        controller.onClick_2();
    }

    public void choose_3() {
        Model humanTreeModel = new HumanTreeModel();  
        Controller controller = new Controller(this, humanTreeModel);     
        controller.onClick_3();
    }
}
