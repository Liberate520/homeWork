import java.util.*;

public class UserParametrized {
    private String name;
    private String gender;
    private UserParametrized father;
    private UserParametrized mother;
    private List<UserParametrized> children;



    public void addChild(UserParametrized child) {
        this.children.add(child);
    }

    public UserParametrized getFather() {
        return father;
    }

    public UserParametrized getMother() {
        return mother;
    }

    public String getName() {
        return name;
    }

    public Integer getChildrenSize() {
        return children.size();
    }


    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(name);
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }
    
    private String getFatherInfo() {
        String res = "Отец: ";
        if (father != null) {
            res += father.getName();
        }
        else {
            res += "нет";
        }
        return res;
    }

    private String getMotherInfo() {
        String res = "Мать: ";
        if (mother != null) {
            res += mother.getName();
        }
        else {
            res += "нет";
        }
        return res;
    }

    private String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Дети (");
        res.append(children.size());
        res.append("): ");
        if (children.size() != 0) {
            for (int i = 0; i < children.size(); i++) {
                res.append(children.get(i).getName());
                res.append(", ");
            }
        }
        else {
            res.append("нет");
        }
        res.append("\n");
        return res.toString();
    }

    public void addChild(Human child) {
        children.add(child);
    }

}
