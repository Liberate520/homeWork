import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ViewFamilyTree<T extends People> {
    Family<T> familytree;
    T people;
    List<Option> commList;

    Family<People> family = new Family<>();

    public ViewFamilyTree(Family<T> familytree) {
        
        this.familytree = familytree;
        this.commList = new ArrayList<>();
        this.commList.add(new addPeople<>(this));
        this.commList.add(new showAll<>(this));
        this.commList.add(new exit<>(this));
        this.commList.add(new saveTree<>(this));
        this.commList.add(new loadTree<>(this));
        // this.commList.add(new searchByName<>(this));
        this.commList.add(new sortByName<>(this));
        this.commList.add(new sortByDate<>(this));
        
    }
    
    public void startView() {

        int menu = 0;
        while(menu != 3){ //3 - exit
            for(int i = 0; i < commList.size(); i++){
                System.out.println(i + ": " + commList.get(i).info());
            }

            System.out.println(": ");
            Scanner iscanner = new Scanner(System.in);
            menu = iscanner.nextInt();
            commList.get(menu).execute();
        }

        emptyLineIn();
        for (int i = 0; i < commList.size(); ++i) {
            System.out.printf("%d --> %s\n", i, commList.get(i).info());
        }
        emptyLineOut();
    }

    public static void emptyLineIn(){
        System.out.println("\n");
        System.out.println("======================================================");
    }

    public static void emptyLineOut(){
        System.out.println();
        System.out.println("======================================================");
    }


    public void saveTree() {
        emptyLineIn();
        family.saveFamily();
        emptyLineOut();
    }

    public void loadTree() {
        emptyLineIn();
        family.readFile();
    }

    public void searchByName() {
        // familytree.getFamMembers();
    }

    public void addPeople() {
        // family.add();
    }

    public void sortByName() {
        family.sortByName();
    }

    public void sortByDate() {
        family.sortByDate();
    }

    public void showAll() {
        emptyLineIn();
        family.showAll();
        emptyLineOut();
    }


    public void exit() {
        System.out.println("Выход из программы ...");
        System.exit(0);
    }

    private static void errorMessage(Exception e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
        System.out.println("Повторите ввод, пожалуйста.\n");
    }
}
