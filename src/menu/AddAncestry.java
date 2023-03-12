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
        chois=choisPerson();
        if (chois<0) return 10;
        while (chois1>0) {
            this.getView().print("Выбранный персонаж:");
            this.getView().print(this.getView().showPerson(chois));
            this.getView().print("\nВыберете желаемое действие:\n\n1. Добавление отца\n2. Удаление отца\n3. Добавление матери\n4. Удаление матери\n5. Печать списка детей\n6. Добавление детей\n7. Удаление детей\n0. Выход ");
            chois1=scanner.nextInt();
            this.getView().print("");
            switch (chois1) {
                case (1): {
                    chois2=choisPerson();
                    if (chois<0) return 10;
                    this.getView().addFater(chois, chois2);
                    break;
                }
                case (2): {
                    this.getView().addFater(chois, null);
                    break;
                }
                case (3): {
                    chois2=choisPerson();
                    if (chois<0) return 10;
                    this.getView().addMother(chois, chois2);
                    break;
                }
                case (4): {
                    this.getView().addMother(chois, null);
                    break;
                }
                case (5): {
                    this.getView().print("Список детей:");
                    this.getView().print(this.getView().сhildrentoSring(chois));
                    break;
                }
                case (6): {
                    chois2=choisPerson();
                    if (chois<0) return 10;
                    this.getView().addChild(chois, chois2);
                    break;
                }
                case (7): {
                    this.getView().addChild(chois, null);
                    break;
                }

            }
        }       
        return 10+chois;
        }

    private int choisPerson(){
        this.getView().print("\nВыберете персону или 0 для выхода:\n");
        this.getView().showAllPerson();
        return scanner.nextInt()-1;
    }
}
