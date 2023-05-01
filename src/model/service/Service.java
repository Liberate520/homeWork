package model.service;

import model.fileWork.FilehandlerOS;
import model.fileWork.FilehandlerTXT;
import model.fileWork.Writeable;
import model.group.Groupable;
import model.group.comparators.HumanComparatorById;
import model.group.comparators.HumanComparatorByName;
import model.human.Human;
import model.restoreHuman.RestoreHumanFromConsole;
import view.CollecterInfo;

public class Service {
    private Groupable<Human> group;
    private Writeable<Human> fileOS;
    private Writeable<Human> fileTXT;

    public Service(Groupable<Human> group) {
        this.group = group;
        fileOS = new FilehandlerOS<>();
        fileTXT = new FilehandlerTXT<>();
    }

    public void addRecord(CollecterInfo collecterInfo) {
        if (group.getHumanByName(collecterInfo.getName()) == null) {
            RestoreHumanFromConsole rHuman = new RestoreHumanFromConsole();
            Human human = rHuman.restoreHumanFromConsole(group, collecterInfo);
            group.addHuman(human);
            System.out.printf("Запись '" + human.getName() + "' добавлена.");
        } else
            System.out.println("Такой человек уже внесен.");
    }
    public String getHumanList() {
        return group.getHumanList().toString();
    }

    public void findRecord(String name) {
        group.findHuman(name);
    }

    public String loadHumanListOS() {
        group = fileOS.LoadFromFile("FamilyTree.dat");
        return group.getHumanList().toString();
    }

    public String loadHumanListTXT() {
        group = fileTXT.LoadFromFile("FamilyTree.txt");
        return group.getHumanList().toString();
    }

    public String saveHumanList() {
        fileOS.SaveToFile(group, "FamilyTree.dat");
        fileTXT.SaveToFile(group, "FamilyTree.txt");
        return group.getHumanList().toString();
    }
    public void sortRecordsByName() {
        group.getHumanList().sort(new HumanComparatorByName<>());
        System.out.println(group);
    }

    public void sortRecordsById() {
        group.getHumanList().sort(new HumanComparatorById<>());
        System.out.println(group);
    }
}
