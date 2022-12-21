package JavaOOP.Family;

import java.io.*;
import java.util.*;
import java.util.List;

public class FamilyTree {

    List<Human> humans;
    List<Human> humansOnTree;
    Human nodeOfTree;
    public static final int COUNT = 10;

    public  FamilyTree(){
        humans = new ArrayList<Human>();
        humansOnTree = new ArrayList<>();
    }
    public void drawTreeInConsole(Human root, int space){
        if(root ==null)
            return;
        space += COUNT;

        drawTreeInConsole(root.mother,space);

        for (int i = COUNT;i<space;i++)
            System.out.print(" ");
        System.out.println(root.fName + " ur."+root.DateofBirth+  "\n ");


        drawTreeInConsole(root.father,space);
    }

    public void saveTreeToFile(Human root,int space){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("tree.txt"));
            drawInFile(writer,root,space);
            writer.close();
        }catch (IOException e){
            System.out.println("Что-то пошло не так!");
        }
    }
    public static void drawInFile(BufferedWriter writer,Human root,int space) throws IOException {
        if(root==null)
            return;
        space+=COUNT;
        drawInFile(writer,root.mother,space);
        for (int i=COUNT;i<space;i++)
            writer.write(" ");
        writer.write(root.fName+ " ur."+root.DateofBirth + "\n\n");

        drawInFile(writer,root.father,space);
    }


    public void showInfoAboutParticularPerson(Human human){
        String motherInfo = informationAboutFamilyMember(human.mother,"Мать");
        String fatherInfo = informationAboutFamilyMember(human.father, "Отец");
        String childrenInfo = informationAboutFamilyMember(human.children,"Ребёнок");
        String partnerInfo = informationAboutFamilyMember(human.partner,"Партнёр");

        System.out.println("Имя: "+ human.fName +  ", Год рождения: "+ human.DateofBirth
                +"\nИнформация о матери: "+motherInfo
                +"\nИнформация об отце: " + fatherInfo
                +"\nИнформация о детях: "+ childrenInfo
                +"\nИнформация о партнёре: "+ partnerInfo);
    }

    public String informationAboutFamilyMember(Human human,String member){
        if(human==null){
            return "Нет информации о "+member;
        }else{
            return "Имя: "+ human.fName+", Год рождения: "+human.DateofBirth;
        }
    }

    public Human findBersonById(int id){
        Human human;
        try {
           human= humans.get(id);
        }catch (IndexOutOfBoundsException e){
            human = null;
        }
        return human;

    }
    public Human findBersonOnTreeById(int id){
        Human human;
        try {
            human= humansOnTree.get(id);
        }catch (IndexOutOfBoundsException e){
            human = null;
        }
        return human;

    }
    public  void showTreeForTakenPerson(Scanner scanner) {
        if (this.humansOnTree.size() == 0) {
            System.out.println("В семейном древе нет людей для отображения");
        } else {
            generateForEachLoop(this.humansOnTree);
            String wybor = scanner.next();
            Human p1 = this.findBersonOnTreeById(Integer.parseInt(wybor));
            System.out.println("#######################################################################");
            System.out.println();
            this.drawTreeInConsole(p1,0);
            System.out.println();
            System.out.println("#######################################################################");
        }
    }

    public static void generateForEachLoop(List<Human> list){
        for (Human p : list
        ) {
            System.out.println("Nr." + list.indexOf(p)+ ": " + p.fName + ", Год рождения: " + p.DateofBirth);
        }
    }

    public  void addPerson(Scanner scanner) {
        Human p;
        int DateofBirth;
        System.out.println("Введите имя: ");
        String fName = scanner.next();
        System.out.println("Введите год рождения");
        String year = scanner.next();
        while (true) {
            if (year.length() == 4 && (year.charAt(0) == '2' || year.charAt(0) == '1')) {
                DateofBirth = Integer.parseInt(year);
                break;
            }
            System.out.println("Ошибка! Год должен начинаться с 1 или 2 и состоять из 4х цифр.: ");
            year = scanner.next();

        }
        while (true) {
            System.out.println("Выберете пол:  m - мужск  / f - женс");
            String gender = scanner.next();
            if(Objects.equals(gender, "m") || Objects.equals(gender, "f")){
                p = new Human(DateofBirth, fName, getCorrectSex(gender));
                this.humans.add(p);
                break;
            }
        }
    }
    public static Gender getCorrectSex(String gender){
        return Objects.equals(gender, "m") ?Gender.MAN:Gender.WOMAN;
    }

    public void selectPersonToDisplay(Scanner scanner){
        if(this.humansOnTree.size()==0){
            System.out.println("Древо пустое.\n");

        }else {
            System.out.println("Выберете ID пользователя, которого нужно показать:");
            generateForEachLoop(this.humansOnTree);
            String wybor = scanner.next();
            Human p1 = this.findBersonOnTreeById(Integer.parseInt(wybor));
            if (p1 == null) {
                System.out.println("Пользователя с таким ID не существует!");
            } else {
                this.showInfoAboutParticularPerson(p1);
            }
        }
    }
    public  void showListOfPersonToSelectNodeOfFamilyTree(Scanner scanner) {
        if (this.humansOnTree.size() != 0) {
            System.out.println("У дерева уже есть связь");
        } else if(this.humans.size()==0) {
            System.out.println("Список пуст");
        }
            else{
                System.out.println("Выберете ID человека для создания связи");
                generateForEachLoop(this.humans);
                String wybor = scanner.next();
                Human p = this.findBersonById(Integer.parseInt(wybor));
                if (p == null) {
                    System.out.println("Пользователя с таким ID не существует!");
                } else {

                    if (this.humansOnTree.contains(p)) {
                        System.out.println("Этот человек уже вписан в древо");
                    } else {
                        this.humansOnTree.add(p);
                        System.out.println(p.fName + ", Родился:  " + p.DateofBirth + " добавлен к узлу древа");
                        this.nodeOfTree = p;
                    }
                }
            }
        }


    public void addingRelation(Scanner scanner){
        if( this.nodeOfTree==null){
            System.out.println("В древе нет элементов!");
            return;
        }
        boolean canBeParent=false;
        Human children;
        Human parent;
        List<Human> personList = new ArrayList<>();
        for (Human p : this.humansOnTree){
            if(p.mother==null || p.father == null){
                personList.add(p);
            }
        }
        this.drawTreeInConsole(this.nodeOfTree,0);
        System.out.println("Выберете человека, чтобы добавить его родителей:");
        generateForEachLoop(personList);
        String wybor = scanner.next();
        try {
            children = personList.get(Integer.parseInt(wybor));
        }catch (IndexOutOfBoundsException e){
            children = null;
        }

        if(children==null){
            System.out.println("Пользователя с таким ID не существует!");

        }
        else {
            List<Human> prospectiveParentList = new ArrayList<>();
            for (Human p : this.humans){
                if(!this.humansOnTree.contains(p)){
                    prospectiveParentList.add(p);
                }
            }

            if(prospectiveParentList.size()==0){
                System.out.println("Нет людей для создания связей. Вам нужно добавить кого-то, используя метод 1");
                return;
            }
            System.out.println("Выберите предполагаемого родителя: ");
            generateForEachLoop(prospectiveParentList);
            String choice2 = scanner.next();
            try {
                parent = prospectiveParentList.get(Integer.parseInt(choice2));
            }catch (IndexOutOfBoundsException e){
                parent = null;
            }
            if (parent==null){
                System.out.println("Пользователя с таким ID не существует!");
            }
            else
            {
                if (parent.gender == Gender.MAN){
                   canBeParent = children.addFather(parent);
                   if(canBeParent)
                        this.humansOnTree.add(parent);
                    personList.clear();
                    prospectiveParentList.clear();
                }else {
                    canBeParent = children.addMother(parent);
                    if(canBeParent)
                        this.humansOnTree.add(parent);
                    personList.clear();
                    prospectiveParentList.clear();
                }
            }

        }
    }
    public void clearFamilyTree(){
        for (Human p : this.humansOnTree
             ) {
            p.father= null;
            p.mother=null;
            p.children = null;
            p.partner=null;
        }
        this.nodeOfTree = null;
        this.humansOnTree.clear();
        System.out.println("Древо снова пустое");
    }

    public void saveCurrentFamilyMembersToFile(Scanner scanner){
        System.out.println("Введите имя файла, чтобы записать список членов генеалогического древа: ");
        String fileName = scanner.next();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName+".txt"));
            for (Human p :this.humansOnTree
                 ) {
                String gender =p.gender.equals(Gender.MAN)?"m":"f";
                String human = p.DateofBirth+";"+p.fName+";"+gender;
                writer.write(human);
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println("Что-то пошло не так!");
        }

    }

    public FamilyTree readDataFromFile(Scanner scanner){
        if(this.humansOnTree.size()!=0 || this.nodeOfTree!=null){
            System.out.println("Генеалогическое древо не пусто. Удалите текущее дерево, чтобы создать новое");
        }else{
            System.out.println("Введите имя файла: ");
            String filename = scanner.next();
            try (FileInputStream fileInputStream = new FileInputStream(filename+".txt");
                 BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream))){
                String line;
                while ((line = br.readLine()) != null) {
                    String[] humans = line.split(";");
                    if (getCorrectSex(humans[2]) == null) {
                        System.out.println("Некорректные данные человека в файле!");
                        System.out.println();
                    } else {
                        Human p1 = new Human(Integer.parseInt(humans[0]), humans[1], getCorrectSex(humans[2]));
                        this.humans.add(p1);
                    }

                }
            }catch (IOException e){
                System.out.println("Не получается прочитать данные из файла");
            }
        }
        return this;
    }
}
