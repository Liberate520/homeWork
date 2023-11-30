package view.consoles;

import view.ConsoleUI;
import java.util.Scanner;

public class ConsoleRelative {
    private Scanner scanner;
    private ConsoleUI cons;
    private int id0, id1, index;
    private String name0, name1; 

    public ConsoleRelative(ConsoleUI cons){
        scanner = new Scanner(System.in);
        this.cons = cons;
    }
    
    public void work(){
        System.out.print("Введите id первого человека: ");
        id0 = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите id второго человека: ");
        id1 = Integer.parseInt(scanner.nextLine());
        name0 = cons.getPresenter().getHumanId(id0).getName();
        name1 = cons.getPresenter().getHumanId(id1).getName();
        System.out.println("Кем является "+name1+" для "+name0+":\n" + //
                "1-отцом;\n2-матерью;\n" + //
                "3-супругом;\n4-ребенком");
        index = Integer.parseInt(scanner.nextLine());
        cons.getPresenter().addHumanRelatives(id0, id1, index);

    }
}
