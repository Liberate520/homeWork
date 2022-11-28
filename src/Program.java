import java.util.ArrayList;
import java.util.List;

public class Program{
    public static void main(String[] args) {
        
        UserInputFromConsole scan = new UserInputFromConsole();

        int idForMenu;
        String userSelect = "EMPTY";
        String invite = " 1 - посмотреть всех \n"+
                        " 2 - добавить человека  \n"+
                        " 3 - удалить человека по id \n"+
                        " 4 - показать детей по id \n"+
                        " 5 - добавить человеку связь \n"+
                        " 6 - Записать человека в файл txt \n"+
                        " 7 - Записать человека в файл doc \n"+
                        " q - выход\n";

        List<Human> humans = new ArrayList<Human>();

        // тестовые ребята
        // Вася
        Human vasya = new Human();
        vasya.setId(11); 
        vasya.setName("Василий");
        vasya.setAge(40);
        humans.add(vasya);
        System.out.println(vasya.getRelationships());

        // Марина
        Human marina = new Human();
        marina.setId(22); 
        marina.setName("Марина");
        marina.setAge(50);
        humans.add(marina);

        // Петя
        Human petya = new Human();
        petya.setId(33); 
        petya.setName("Петр");
        petya.setAge(10);
        humans.add(petya);

        // Петя сын Васи
        Relationship vasyapetya = new Relationship(2,33);
        vasya.setRelationship(vasya,vasyapetya);



        System.out.println("Привет!");

        while (!userSelect.equals("q")){

            userSelect = scan.inputKey(invite);

            if (userSelect.equals("1")) {
                // посмотреть всех
                for (Human human : humans) {
                    human.printHuman(human.getHuman(human));
                }
            }
            
            else if (userSelect.equals("2")) {
                // Добавить человека
                Human humanToAdd = new Human(humans, scan.inputKey("Введите имя "),
                                            Integer.parseInt(scan.inputKey("Введите возраст "))); 

                humans.add(humanToAdd);
            }

            else if (userSelect.equals("3")) {
                // удалить человека по id
                idForMenu = Integer.parseInt(scan.inputKey("Выберите Id для удаления "));
                int tempId = 0;
                int count = 0;
                for (Human human : humans){
                    if (human.getId() == idForMenu){
                        tempId = count;
                    }
                    count++;
                }
                humans.remove(tempId);
            }

            else if (userSelect.equals("4")) {
                // показать детей по id
                idForMenu = Integer.parseInt(scan.inputKey("Выберите Id для установления детей "));
                for (Human human : humans){
                    if (human.getId() == idForMenu){
                        human.printChildrens(human);
                    }
                }
            }

            else if (userSelect.equals("5")) {
                // Добавить человеку связь
                idForMenu = Integer.parseInt(scan.inputKey("Выберите Id человека для добавления связи "));
                for (Human human : humans){
                    if (human.getId() == idForMenu){
                        Relationship relationship = new Relationship(Integer.parseInt(scan.inputKey("Введите название связи:\n"+
                                                            "1 - муж/жена\n"+
                                                            "2 - ребенок ")),
                                                            Integer.parseInt(scan.inputKey("Введите номер человека для связи ")));
                        human.setRelationship(human,relationship);
                    }
                }
            }
            
            else if (userSelect.equals("6")) {
                // Записать человека в файл txt
                idForMenu = Integer.parseInt(scan.inputKey("Выберите Id человека записи "));
                for (Human human : humans){
                    if (human.getId() == idForMenu){
                        SaveToTxt txt = new SaveToTxt();
                        txt.saveAs(human.getHuman(human));
                    }
                }
            }
            
            else if (userSelect.equals("7")) {
                // Добавить человеку связь
                idForMenu = Integer.parseInt(scan.inputKey("Выберите Id человека для записи "));
                for (Human human : humans){
                    if (human.getId() == idForMenu){
                        SaveToDoc doc = new SaveToDoc();
                        doc.saveAs(human.getHuman(human));
                    }
                }
            }   
        }
    scan.input.close();
    System.out.println("Пока!");
    }

}