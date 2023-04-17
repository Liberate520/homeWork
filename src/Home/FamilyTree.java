package Home;

import java.util.List;

public class FamilyTree {



    public String getMotherDetails(Human human) {
        StringBuilder sb = new StringBuilder();
        sb.append(human.getName()).append(" Mother:").append("\n");
        if (human.mother != null) {
            sb.append(human.mother.getName()).append(", ").append("age: ").append(human.mother.getAge()).append('\n');
            if (human.mother.getMother() != null) {
                sb.append(human.getName()).append(" maternal").append(" grandmother:").append("\n");
                sb.append(human.mother.getMother().getName()).append(", ").append("age: ").append(human.mother.getMother().getAge()).append('\n');
            }
            if (human.mother.getFather() != null) {
                sb.append(human.getName()).append(" maternal").append(" grandfather:").append("\n");
                sb.append(human.mother.getFather().getName()).append(", ").append("age: ").append(human.mother.getFather().getAge()).append('\n');
            }
            return sb.toString();
        } else {
            return "No mother details available.";
        }
    }

    public String getFatherDetails(Human human) {
        StringBuilder sb = new StringBuilder();
        sb.append(human.getName()).append(" Father:").append("\n");
        if (human.father != null) {
            sb.append(human.father.getName()).append(", ").append("age: ").append(human.father.getAge()).append('\n');
            if (human.father.getFather() != null) {
                sb.append(human.getName()).append(" paternal").append(" grandfather:").append("\n");
                sb.append(human.father.getFather().getName()).append(", ").append("age: ").append(human.father.getFather().getAge()).append('\n');
            }
            if (human.father.getMother() != null) {
                sb.append(human.getName()).append(" paternal").append(" grandmother:").append("\n");
                sb.append(human.father.getMother().getName()).append(", ").append("age: ").append(human.father.getMother().getAge()).append('\n');
            }
            return sb.toString();
        } else {
            return "No father details available.";
        }
    }
    public String getGrandfatherDetails(Human human) {
        StringBuilder sb = new StringBuilder();
        if (human.father.getFather() != null) {
            sb.append(human.getName()).append(" paternal").append(" grandfather:").append("\n");
            sb.append(human.father.getFather().getName()).append(", ").append("age: ").append(human.father.getFather().getAge()).append('\n');
        }
        if (human.mother.getFather() != null) {
            sb.append(human.getName()).append(" maternal").append(" grandfather:").append("\n");
            sb.append(human.mother.getFather().getName()).append(", ").append("age: ").append(human.mother.getFather().getAge()).append('\n');
            return sb.toString();
        }
        else {
            return "No grandfather details available.";
        }
    }
    public String getGrandmatherDetails(Human human) {
        StringBuilder sb = new StringBuilder();
        if (human.mother.getMother() != null) {
            sb.append(human.getName()).append(" maternal").append(" grandmother:").append("\n");
            sb.append(human.mother.getMother().getName()).append(", ").append("age: ").append(human.mother.getFather().getAge()).append('\n');
        }
        if (human.father.getMother() != null) {
            sb.append(human.getName()).append(" paternal").append(" grandmother:").append("\n");
            sb.append(human.father.getMother().getName()).append(", ").append("age: ").append(human.father.getFather().getAge()).append('\n');
            return sb.toString();
        }
        else {
            return "No grandfather details available.";
        }
    }

    public String getChildrenDetails(Human human) {
        StringBuilder sb = new StringBuilder();
        sb.append(human.getName()).append(" Cildrens:").append("\n");
        if (human.childrens != null) {
            for (Human child : human.childrens) {
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
        if (human.sisters != null) {
            for (Human child : human.sisters) {
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
        if (human.brothers != null) {
            for (Human child : human.brothers) {
                sb.append(child.getName()).append(", ").append("age: ").append(child.getAge()).append("\n");
            }
        } else {
            sb.append('\n').append("No brothers details available.");
        }
        return sb.toString();
    }
    public String getHumanInfo(Human human){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (human.mother != null) {
            sb.append(getMotherDetails(human));
        }
        if (human.father != null) {
            sb.append(getFatherDetails(human));
        }
        if (human.brothers != null) {
            sb.append(getBrothersDetails(human));
        }
        if (human.sisters != null) {
            sb.append(getSisterDetails(human));
        }
        if (human.childrens != null) {
            sb.append(getChildrenDetails(human));
        }
        return sb.toString();
    }



}
