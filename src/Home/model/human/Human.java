package Home.model.human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private int age;
    protected Human mother;
    protected Human father;
    protected List<Human> sisters;
    protected List<Human> brothers;
    protected List<Human> childrens;

    public Human(String name, int age, Human father, Human mother) {
    }


    public void setMother(Human mother) { this.mother = mother; }
    public void setFather(Human father) {
        this.father = father;

    }
    public  void setChildrens(List<Human> childrens) { this.childrens = childrens; }
    public void setSisters(List<Human> sisters) { this.sisters = sisters; }
    public void setBrothers(List<Human> brothers) { this.brothers = brothers; }

    public Human(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Human(String name, int age, Human father, Human mother, ArrayList<Human> children, ArrayList<Human> sisters, ArrayList<Human> brothers) {
        this(name, age, father, mother);
        if (children != null) {
            this.childrens = new ArrayList<>(children);
        } else {
            this.childrens = new ArrayList<>();
        }
        if (sisters != null) {
            this.sisters = new ArrayList<>(sisters);
        } else {
            this.sisters = new ArrayList<>();
        }
        if (brothers != null) {
            this.brothers = new ArrayList<>(brothers);
        } else {
            this.brothers = new ArrayList<>();
        }
    }


    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getSisters() {
        return sisters;
    }

    public List<Human> getBrothers() {
        return brothers;
    }

    public List<Human> getChildrens() {
        return childrens;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMotherDetails(Human human) {
        StringBuilder sb = new StringBuilder();
        sb.append(human.getName()).append(" Mother:").append("\n");
        if (human.getMother() != null) {
            sb.append(human.getMother().getName()).append(", ").append("age: ").append(human.getMother().getAge()).append('\n');
            if (human.getMother().getMother() != null) {
                sb.append(human.getName()).append(" maternal").append(" grandmother:").append("\n");
                sb.append(human.getMother().getMother().getName()).append(", ").append("age: ").append(human.getMother().getMother().getAge()).append('\n');
            }
            if (human.getMother().getFather() != null) {
                sb.append(human.getName()).append(" maternal").append(" grandfather:").append("\n");
                sb.append(human.getMother().getFather().getName()).append(", ").append("age: ").append(human.getMother().getFather().getAge()).append('\n');
            }
            return sb.toString();
        } else {
            return "No mother details available.";
        }
    }

    public String getFatherDetails(Human human) {
        StringBuilder sb = new StringBuilder();
        sb.append(human.getName()).append(" Father:").append("\n");
        if (human.getFather() != null) {
            sb.append(human.getFather().getName()).append(", ").append("age: ").append(human.getFather().getAge()).append('\n');
            if (human.getFather().getFather() != null) {
                sb.append(human.getName()).append(" paternal").append(" grandfather:").append("\n");
                sb.append(human.getFather().getFather().getName()).append(", ").append("age: ").append(human.getFather().getFather().getAge()).append('\n');
            }
            if (human.getFather().getMother() != null) {
                sb.append(human.getName()).append(" paternal").append(" grandmother:").append("\n");
                sb.append(human.getFather().getMother().getName()).append(", ").append("age: ").append(human.getFather().getMother().getAge()).append('\n');
            }
            return sb.toString();
        } else {
            return "No father details available.";
        }
    }
    public String getGrandfatherDetails(Human human) {
        StringBuilder sb = new StringBuilder();
        if (human.getFather().getFather() != null) {
            sb.append(human.getName()).append(" paternal").append(" grandfather:").append("\n");
            sb.append(human.getFather().getFather().getName()).append(", ").append("age: ").append(human.getFather().getFather().getAge()).append('\n');
        }
        if (human.getMother().getFather() != null) {
            sb.append(human.getName()).append(" maternal").append(" grandfather:").append("\n");
            sb.append(human.getMother().getFather().getName()).append(", ").append("age: ").append(human.getMother().getFather().getAge()).append('\n');
            return sb.toString();
        }
        else {
            return "No grandfather details available.";
        }
    }
    public String getGrandmatherDetails(Human human) {
        StringBuilder sb = new StringBuilder();
        if (human.getMother().getMother() != null) {
            sb.append(human.getName()).append(" maternal").append(" grandmother:").append("\n");
            sb.append(human.getMother().getMother().getName()).append(", ").append("age: ").append(human.getMother().getFather().getAge()).append('\n');
        }
        if (human.getFather().getMother() != null) {
            sb.append(human.getName()).append(" paternal").append(" grandmother:").append("\n");
            sb.append(human.getFather().getMother().getName()).append(", ").append("age: ").append(human.getFather().getFather().getAge()).append('\n');
            return sb.toString();
        }
        else {
            return "No grandfather details available.";
        }
    }

    public String getChildrenDetails(Human human) {
        StringBuilder sb = new StringBuilder();
        sb.append(human.getName()).append(" Cildrens:").append("\n");
        if (human.getChildrens() != null) {
            for (Human child : human.getChildrens()) {
                sb.append(child.getName()).append(", ").append("age: ").append(child.getAge()).append("\n");
            }
        } else {
            sb.append('\n').append("No children details available.");
        }
        return sb.toString();
    }

    public String getSisterDetails(Human human) {
        StringBuilder sb = new StringBuilder();
        sb.append(human.getName()).append(" Sisters:").append("\n");
        if (human.getSisters() != null) {
            for (Human child : human.getSisters()) {
                sb.append(child.getName()).append(", ").append("age: ").append(child.getAge()).append("\n");
            }
        } else {
            sb.append('\n').append("No sisters details available.");
        }
        return sb.toString();
    }

    public String getBrothersDetails(Human human) {
        StringBuilder sb = new StringBuilder();
        sb.append(human.getName()).append(" Brothers:").append("\n");
        if (human.getBrothers() != null) {
            for (Human child : human.getBrothers()) {
                sb.append(child.getName()).append(", ").append("age: ").append(child.getAge()).append("\n");
            }
        } else {
            sb.append('\n').append("No brothers details available.");
        }
        return sb.toString();
    }
    public String getHumanInfo(Human human){
        StringBuilder sb = new StringBuilder();
        sb.append(human.toString());
        if (human.getMother() != null) {
            sb.append(getMotherDetails(human));
        }
        if (human.getFather() != null) {
            sb.append(getFatherDetails(human));
        }
        if (human.getBrothers() != null) {
            sb.append(getBrothersDetails(human));
        }
        if (human.getSisters() != null) {
            sb.append(getSisterDetails(human));
        }
        if (human.getSisters() != null) {
            sb.append(getChildrenDetails(human));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return name  +
                ", age: " + age +
                "\n";
    }
}
