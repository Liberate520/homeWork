package presenter;

import model.group.FamilyTree;
import model.group.TreeItem;
import model.human.Human;
import view.View;
import model.service.Service;
import model.human.Gender;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(int human_Id, int parent_Id, String name, LocalDate birthday, Gender gender, String second_parent) {
        service.addHuman(human_Id, parent_Id, name, birthday, gender, second_parent);
        getHumanInfo();
    }

    public void getHumanInfo() {
        String info = service.getHumanInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
        String info = service.getHumanInfo();
    }


    public void sortByName() {
        service.sortByName();
        String info = service.getHumanInfo();
    }


    public void importTree() {
        FamilyTree tree = new FamilyTree();
        String file;
        String[] word;
        String filename = "./Family_Tree_In.txt";
        Scanner sc = null;
        try {
            sc = new Scanner(new File(filename));
            while (sc.hasNextLine()) {
                file = sc.nextLine();
                word = file.split(",");
                for (int i = 0; i < word.length; i++) {
                    word[i] = word[i].trim();
                }
                int human_ID = Integer.parseInt(word[0], 10);
                int first_parent_ID;
                if (!word[1].isEmpty()) first_parent_ID = Integer.parseInt(word[1], 10);
                else first_parent_ID = -1;
                LocalDate ld = LocalDate.parse(word[3]);
                Gender gen = Gender.valueOf(word[4]);
                Human name = new Human(human_ID, first_parent_ID, word[2], ld, gen, word[5]);
                tree.addHuman((TreeItem) name);
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        tree.addFirstParent();
//  System.out.println(tree.getInfo());
    }

    public void load() {
        service.load();
    }

    public void save() {
        service.save();
    }

    public void addFP(int humanId, int parentId) {
        service.addFP(humanId, parentId);
    }
}
