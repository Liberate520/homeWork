package menu;

import java.util.Scanner;

import ui.View;

public class AddAncestry extends Command{
    private Scanner scanner;
    
    public AddAncestry(View view) {
        super(view);
        scanner = new Scanner(System.in);
    }

    @Override
    public String description() {
        return "Редактирование персонажа ";
    }

    @Override
    public int execute() {

        
        Integer chois;
        Integer chois1 = 1;
        Integer chois2;
        this.getView().print("\nВыберете родителя или 0 для выхода:\n");
        chois=choisPerson();
        if (chois<0) return 10;
        while (chois1>0) {
            this.getView().print("Выбранный персонаж:");
            this.getView().print(this.getView().showPerson(chois));
            this.getView().print("\nВыберете желаемое действие:\n\n1. Печать списка детей\n2. Добавление детей\n3. Удаление детей\n0. Выбор другого персонажа для редактирования ");
            chois1=scanner.nextInt();
            this.getView().print("");
            switch (chois1) {

                case (1): {
                    this.getView().print("Список детей:");
                    this.getView().print(this.getView().сhildrentoSring(chois));
                    break;
                }
                case (2): {
                    this.getView().print("\nВыберете ребенка или 0 для выхода:\n");
                    chois2=choisPerson();
                    if (chois<0) return 10;
                    this.getView().addChild(chois, chois2,null);
                    break;
                }
                case (3): {
                    chois2=choisChildren(chois);
                    if (chois<0) return 10;
                    this.getView().addChild(chois, null, chois2);
                    break;
                }

            }
        }       
        return 10+chois;
        }

    private int choisPerson(){
        this.getView().showAllPerson();
        return scanner.nextInt()-1;
    }
    private int choisChildren(Integer cur){
        this.getView().print("\nВыберете ребёнка или 0 для выхода:\n");
        this.getView().print(this.getView().сhildrentoSring(cur));
        return scanner.nextInt()-1;
    }
}
