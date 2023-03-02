package src.Presenter;

import src.UI.View;

import java.util.ArrayList;
import java.util.List;


public class Menu {
    private List<Option> commands;
    private View view;

    public Menu(View view) {
        this.view = view;
        commands = new ArrayList();
        System.out.println("Menu");
//        commands.add(new PrintingListOfPersons());
        commands.add(new YearsOfTheReignOfPersons());
        commands.add(new Quit());
        }

        void execute(int num){
            Option option = commands.get(num-1);
            option.execute();
        }

        public String printMenu(){
            StringBuilder strMenu = new StringBuilder();
            for (int i = 0; i < commands.size(); i++) {
                strMenu.append(i);
                strMenu.append(": ");
                strMenu.append(commands.get(i).description());
                strMenu.append("\n");
            }
            return strMenu.toString();
        }
    }

