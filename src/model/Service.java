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

    public void addHuman(String name, LocalDate date, Gender gender){
        tree.addHuman(name, date, gender);
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

    public void SaveToFile(String filename) throws IOException {
        savable.save(tree, filename);
    }

    public void LoadFromFile(String filename) throws IOException, ClassNotFoundException {
        FamilyTree<Human> familyTreeRestored = (FamilyTree<Human>) savable.load(filename);
    }
}
