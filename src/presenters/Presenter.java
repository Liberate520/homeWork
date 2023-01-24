package presenters;

import java.util.Map;

import enums.Gender;
import models.*;
import views.ConsoleInterface;
import writables.FileHandler;

public class Presenter implements Command {

    private FamilyTree<Human> familyTree;
    private ConsoleInterface consoleInterface;
    private String text;   
    

    public Presenter() {
        this.familyTree = new FamilyTree<>();
        this.consoleInterface = new ConsoleInterface(this);
        this.familyTree.setWritable(new FileHandler<Human>());
    }
    // Human a = new Human("Беляева", "Мария", "Александровна", Gender.WOMAN);
    @Override
    public void createNewTree() {
        Human a = new Human("Беляева", "Мария", "Александровна", Gender.WOMAN);
        Human b = new Human("Беляев", "Владимир", "Кириллович", Gender.MAN);
        Human c = new Human("Беляев", "Юрий", "Владмирович", Gender.MAN);
        Human d = new Human("Беляева", "Марина", "Владмировна", Gender.WOMAN);

        a.setSpouse(b);

        c.setParentFather(b);
        c.setParentMother(a);

        d.setParentFather(b);
        d.setParentMother(a);

        Human e = new Human("Зайцева", "Галина", "Васильевна", Gender.WOMAN);
        Human f = new Human("Зйцев", "Николай", "Иванович", Gender.MAN);
        Human g = new Human("Зайцева", "Ирина", "Николаевна", Gender.WOMAN);

        e.setSpouse(f);

        g.setParentFather(f);
        g.setParentMother(e);

        c.setSpouse(g);

        Human h = new Human("Беляева", "Вероника", "Юрьевна", Gender.WOMAN);

        h.setParentFather(g);
        h.setParentMother(c);

        this.familyTree.addHuman(a);
        this.familyTree.addHuman(b);
        this.familyTree.addHuman(c);
        this.familyTree.addHuman(d);
        this.familyTree.addHuman(e);
        this.familyTree.addHuman(f);
        this.familyTree.addHuman(g);
        this.familyTree.addHuman(h);
    }

    @Override
    public void createTreeFromFile() {
        this.familyTree.read();
        consoleInterface.outPrint("Дерево создано");
        this.consoleInterface.menu();
    }

    @Override
    public void addHuman() {
        // this.familyTree.addHuman();
    }

    @Override
    public void deleteHuman() {
        // this.familyTree.deleteHuman();
    }

    @Override
    public void outoutHumanByUuid() {
        this.consoleInterface.inputUuiddByHuman();
    }

    @Override
    public void deleteChildToHuman() {
        // this.familyTree.deleteChildToHuman();
    }

    @Override
    public void findByFIO() {
        // this.familyTree.findByFIO();
    }

    @Override
    public void outputEntireTree() {
        this.printHumans();
        this.consoleInterface.menu();
    }

    @Override
    public void writeTreeToFile() {
        this.familyTree.save();
        consoleInterface.outPrint("Дерево записано в файл");
        this.consoleInterface.menu();
    }

    public void start() {
        this.consoleInterface.menu();
    }

    public void getHumanByUuid(String uuid) {
        Human human = this.familyTree.getHumanByUuid(uuid);
        if (human != null) {
            this.consoleInterface.outPrint(human.toString());
        } else {
            this.consoleInterface.outPrint("По этому uuid ничего не найдено");
        }
        this.consoleInterface.menu();
    }

    public void printHumans() {
        this.text = ""; 
        Map<String, Human> humans = this.familyTree.getHumanMap();
        humans.forEach((id, x) -> {
            this.text = (this.text.length() > 0 ? this.text + "\n" : "") + id + " -> " + x.getFIOtoString();
        });
  
        this.consoleInterface.outPrint(this.text);
    }
}
