import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String userSelect = "EMPTY";
        String invite = " 1 - посмотреть всех \n"+
                        " 2 - добавить человека  \n"+
                        " 3 - удалить человека по id \n"+
                        " 4 - показать детей по id \n"+
                        " 5 - добавить человеку связь \n"+
                        " q - выход\n";
        ArrayList<Human> Humans = new ArrayList<Human>();
        int id = 0;


        System.out.println("Привет!");

        while (!userSelect.equals("q")){

            userSelect = UserInputFromConsole.inputKey(invite);

            if (userSelect.equals("1")) {
                // посмотреть всех
                for (Human human : Humans) {
                    Human.printHuman(Humans);
                }
            }
            
            else if (userSelect.equals("2")) {
                // добавить человека 
                Humans.add(Human.createHuman(Humans));
            }

            else if (userSelect.equals("3")) {
                // удалить человека по id
                id = Integer.parseInt(UserInputFromConsole.inputKey("Выберите Id для удаления"));
                Human.deleteHuman(Humans, id);
            }

            else if (userSelect.equals("4")) {
                // показать детей по id
                id = Integer.parseInt(UserInputFromConsole.inputKey("Выберите Id для установления детей"));
                Human.printChildrens(Humans, id);
            }

            else if (userSelect.equals("5")) {
                // Добавить человеку связь
                id = Integer.parseInt(UserInputFromConsole.inputKey("Выберите Id для добавления связи"));
                Human.addRelation(Humans, id);
            }
        }    
    System.out.println("Пока!");
    }
}
