package model;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Service {
    private FamilyTree<Human> tree;
    private Printable printable;
    private Savable savable;
    public Service(Printable printable, Savable savable) {
        tree = new FamilyTree<>();
        this.printable = printable;
        this.savable = savable;
    }
    public void fillTree(Fillable fillable){
        fillable.fillTree(tree);
    }

    public String showList()
    {
        return printable.printer(tree.getHumanList());
    }

    public void sortByName(){
        new SortByName().sort(tree);
    }

    public void sortByBirthDate(){
        new SortByBirthDate().sort(tree);
    }

    public void addHuman(String name, LocalDate date, Gender gender, String fathersName, String mothersName)
    {
        tree.addHuman(name, date, gender, fathersName, mothersName);
    }

    public String findByName(String name){
        if (tree.getByName(name) == null){return "Запись не найдена";}
        return "Запись найдена:" + "\n" + tree.getByName(name).toString();
    }

    public String findBrothers(String name){
        if (tree.getByName(name) == null){return "Запись не найдена";}
        List<Human> brothersList = new FindBrothers().find(tree.getByName(name));
        String printer = "Найдено " + brothersList.size() + " братьев" + "\n";
        for(Human item : brothersList){
            printer += item.toString() + "\n";
        }
        return printer;
    }

    public void saveToFile(String filename) throws IOException {
        savable.save(tree, filename);
    }

    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        tree = (FamilyTree<Human>) savable.load(filename);
    }
}
