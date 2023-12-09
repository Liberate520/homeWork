import java.util.List;

public class HumanPrint {
    private Human human;

    public HumanPrint(Human human) {
        if (human != null) {
            this.human = human;
            // System.out.println("Human is not null");
        }
    }

    public Human getHuman() {
        return this.human;
    }

    public void printChildren() {
        if (this.human.getChildren() == null) {
            System.out.println("no children");
        }
        for (Human children : this.human.getChildren()) {
            System.out.println(children.getLastName() + " " + children.getFirstName() + " " + children.getAge());
        }
    }

    public void printHumanBasic(Human human) {
        System.out.println(human.getFirstName() + " " + human.getLastName() + " " + human.getAge());
    }

    public static void printHumanFLA(Human human) {
        System.out.println(human.getFirstName() + " " + human.getLastName() + " " + human.getAge());
    }

    static void printHumanFLAList(List<Human> humanlist) {
        for (Human human : humanlist) {
            System.out.println(human.getFirstName() + " " + human.getLastName() + " " + human.getAge());
        }

    }

    public void printParrents() {
        if (this.human.getMather() != null) {
            printHumanBasic(this.human.getMather());
        } else if (this.human.getFather() != null) {
            printHumanBasic(this.human.getFather());
        } else {
            System.out.println("no parrents");
        }
    }
}
