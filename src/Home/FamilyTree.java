package Home;

import java.util.List;

public class FamilyTree extends Human {

    public FamilyTree(String name, int age) {
        super(name, age);
    }

    public String getMotherDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getName()).append(" Mother:").append("\n");
        if (mother != null) {
            sb.append(mother.getName()).append(", ").append("age: ").append(mother.getAge()).append('\n');
            if (mother.getMother() != null) {
                sb.append(super.getName()).append(" maternal").append(" grandmother:").append("\n");
                sb.append(mother.getMother().getName()).append(", ").append("age: ").append(mother.getMother().getAge()).append('\n');
            }
            if (mother.getFather() != null) {
                sb.append(super.getName()).append(" maternal").append(" grandfather:").append("\n");
                sb.append(mother.getFather().getName()).append(", ").append("age: ").append(mother.getFather().getAge()).append('\n');
            }
            return sb.toString();
        } else {
            return "No mother details available.";
        }
    }

    public String getFatherDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getName()).append(" Father:").append("\n");
        if (father != null) {
            sb.append(father.getName()).append(", ").append("age: ").append(father.getAge()).append('\n');
            if (father.getFather() != null) {
                sb.append(super.getName()).append(" paternal").append(" grandfather:").append("\n");
                sb.append(father.getFather().getName()).append(", ").append("age: ").append(father.getFather().getAge()).append('\n');
            }
            if (father.getMother() != null) {
                sb.append(super.getName()).append(" paternal").append(" grandmother:").append("\n");
                sb.append(father.getMother().getName()).append(", ").append("age: ").append(father.getMother().getAge()).append('\n');
            }
            return sb.toString();
        } else {
            return "No father details available.";
        }
    }
    public String getGrandfatherDetails() {
        StringBuilder sb = new StringBuilder();
        if (father.getFather() != null) {
            sb.append(super.getName()).append(" paternal").append(" grandfather:").append("\n");
            sb.append(father.getFather().getName()).append(", ").append("age: ").append(father.getFather().getAge()).append('\n');
        }
        if (mother.getFather() != null) {
            sb.append(super.getName()).append(" maternal").append(" grandfather:").append("\n");
            sb.append(mother.getFather().getName()).append(", ").append("age: ").append(mother.getFather().getAge()).append('\n');
            return sb.toString();
        }
        else {
            return "No grandfather details available.";
        }
    }
    public String getGrandmatherDetails() {
        StringBuilder sb = new StringBuilder();
        if (mother.getMother() != null) {
            sb.append(super.getName()).append(" maternal").append(" grandmother:").append("\n");
            sb.append(mother.getMother().getName()).append(", ").append("age: ").append(mother.getFather().getAge()).append('\n');
        }
        if (father.getMother() != null) {
            sb.append(super.getName()).append(" paternal").append(" grandmother:").append("\n");
            sb.append(father.getMother().getName()).append(", ").append("age: ").append(father.getFather().getAge()).append('\n');
            return sb.toString();
        }
        else {
            return "No grandfather details available.";
        }
    }

    public String getChildrenDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getName()).append(" Cildrens:").append("\n");
        if (childrens != null) {
            for (Human child : childrens) {
                sb.append(child.getName()).append(", ").append("age: ").append(child.getAge()).append("\n");
            }
        } else {
            sb.append('\n').append("No children details available.");
        }
        return sb.toString();
    }

    public String getSisterDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getName()).append(" Sisters:").append("\n");
        if (sisters != null) {
            for (Human child : sisters) {
                sb.append(child.getName()).append(", ").append("age: ").append(child.getAge()).append("\n");
            }
        } else {
            sb.append('\n').append("No sisters details available.");
        }
        return sb.toString();
    }

    public String getBrothersDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getName()).append(" Brothers:").append("\n");
        if (brothers != null) {
            for (Human child : brothers) {
                sb.append(child.getName()).append(", ").append("age: ").append(child.getAge()).append("\n");
            }
        } else {
            sb.append('\n').append("No brothers details available.");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (mother != null) {
            sb.append(getMotherDetails());
        }
        if (father != null) {
            sb.append(getFatherDetails());
        }
        if (brothers != null) {
            sb.append(getBrothersDetails());
        }
        if (sisters != null) {
            sb.append(getSisterDetails());
        }
        if (childrens!= null) {
            sb.append(getChildrenDetails());
        }
        return sb.toString();
    }

}
