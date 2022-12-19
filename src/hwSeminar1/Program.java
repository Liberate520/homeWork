package hwSeminar1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Human human1 = new Human("Irina", 71, false, null, null);
        Human human2 = new Human("Leonid", 69, true, null, null);
        Human human3 = new Human("Liudmila", 62, false, null, null);
        Human human4 = new Human("Alexander", 65, true,null, null);
        Human human5 = new Human("Kate", 36, false, human2, human1);
        Human human6 = new Human("Pavel", 37, true, human4, human3);
        Human human7 = new Human("Yaroslav", 7, true, human6, human5);
        Human human8 = new Human("Sviatoslav", 3, true, human6, human5);

        FamilyTree tree = new FamilyTree();
        tree.add(human1);
        tree.add(human2);
        tree.add(human3);
        tree.add(human4);
        tree.add(human5);
        tree.add(human6);
        tree.add(human7);
        tree.add(human8);
        Scanner iScanner = new Scanner(System.in);

        while (true) {

            System.out.println("""
                \nSelect menu of FamilyTree: \n1 Add new human \n2 Get FamilyTree 
                3 Get Grands \n4 Get Sister/Brother \n5 Set Father \n6 Set Mother \n7 Exit""");
            String get_user = iScanner.nextLine();
            if (get_user.equals("1")) {
                System.out.println("Введите имя: ");
                String name = iScanner.nextLine();
                System.out.println("Возраст: ");
                int age = iScanner.nextInt();
                System.out.println("Введите пол М - true или Ж - false: ");
                Boolean gender = iScanner.nextBoolean();
                Human human9 = new Human(name, age, gender, null, null);//чтобы не вводить сразу много данных
                tree.add(human9);                                             //отца и мать можно добавить потом
            }
            if (get_user.equals("2")) {
                System.out.println(tree);
            }
            if (get_user.equals("3")) {
                System.out.println("Enter Name of human: ");
                String getName = iScanner.nextLine();
                List<Human> res = tree.getHumanbyName(getName);
                List<Human> grands = new ArrayList<>();
                for (Human human : res) {
                    grands = human.getGrands();
                }
                System.out.printf("Grands of %s are: \n%s", getName, grands);
            }
            if (get_user.equals("4")) {
                System.out.println("Enter Name of human: ");
                String getName = iScanner.nextLine();
                List<Human> res = tree.getHumanbyName(getName);
                List<Human> sisBro = new ArrayList<>();
                for (Human human : res) {
                    sisBro = human.getSisBro();
                }
                System.out.printf("Sister/Brother of %s are: \n%s", getName, sisBro);
            }
            if (get_user.equals("5")){
                System.out.println("Enter Name of human: ");
                String getName = iScanner.nextLine();
                List<Human> res = tree.getHumanbyName(getName);
                System.out.println("Enter Father's name: ");
                String nameFather = iScanner.nextLine();
                List<Human> res2 = tree.getHumanbyName(nameFather);
                for (Human human : res) {
                    for (Human hum : res2) {
                        human.setFather(hum);
                        hum.setChildren(res); //одновременно отцу добавится ребенок
                    }      
                }
                for (Human element : res) {
                    for (Human el : res2) {
                        System.out.printf("%s добавились дети: \n%s", el.getName(), el.getChildren());
                        System.out.printf("\n%s добавился отец: \n%s", element.getName(), element.getFather());
                    }    
                }    
            }
            if (get_user.equals("6")){
                System.out.println("Enter Name of human: ");
                String getName = iScanner.nextLine();
                List<Human> res = tree.getHumanbyName(getName);
                System.out.println("Enter Mothers's name: ");
                String nameMother = iScanner.nextLine();
                List<Human> res2 = tree.getHumanbyName(nameMother);
                for (Human human : res) {
                    for (Human hum : res2) {
                        human.setMother(hum);
                        hum.setChildren(res);//одновременно матери добавится ребенок
                    }      
                }
                for (Human element : res) {
                    for (Human el : res2) {
                        System.out.printf("%s добавились дети: \n%s", res2, el.getChildren());
                        System.out.printf("\n%s добавилась мать: \n%s", res, element.getMother());
                    }    
                }   
            }
            if (get_user.equals("7")) {
                System.out.println("GoodBye");
            }
            //iScanner.close();
        }
        
    }
}
