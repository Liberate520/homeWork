import java.util.ArrayList;
import java.util.HashMap;

public class Tree {
    private Integer generation;
    private HashMap<Integer, String> index_humans;
    private ArrayList<Human> arlist_humans;

    public Tree() {
        this.generation = 1;
        this.index_humans = new HashMap<>();
        this.arlist_humans = new ArrayList<>();
    }

    private Integer getGeneration() {
        return generation;
    }

    private void setGeneration(Integer generation) {
        this.generation = generation;
    }

    private Integer getGen(Integer index) {
        for (int i = 1; i <= index_humans.size(); i++) {
            if (index_humans.get(i).contains(Integer.toString(index))) return i;
        }
        return index;
    }

    public void add(Human human) {
        this.arlist_humans.add(human);
        Integer stop = 0;
        for (int i = arlist_humans.size() - 2; i >= 0; i--) {
            if (arlist_humans.get(i).toString().split(",")[0].split(" = ")[1].equals(human.getNameFather())) {
                arlist_humans.get(i).addChild(human);
                setGeneration(getGen(i) + 1);
                stop += 1;
            }
            if (arlist_humans.get(i).toString().split(",")[0].split(" = ")[1].equals(human.getNameMother())) {
                arlist_humans.get(i).addChild(human);
                setGeneration(getGen(i) + 1);
                stop += 1;
            }
            if (stop == 2) break;
        }
        String last_value = index_humans.get(getGeneration());
        if (last_value == null) last_value = "";
        this.index_humans.put(getGeneration(), last_value + Integer.toString(arlist_humans.size() - 1));
    }

    public String getTree() {
        String result = "";
        for (int i = 1; i <= index_humans.size(); i++) {
            for (int j = 0; j < index_humans.get(i).length(); j++) {
                Integer index = Integer.parseInt(String.valueOf(index_humans.get(i).charAt(j)));
                result += Integer.toString(i) + " поколение. " + arlist_humans.get(index) + "\n";
            }
        }
        return result;
    }

    public String getInfoHuman(String name_human) {
        for (int i = 0; i < arlist_humans.size(); i++) {
            if (arlist_humans.get(i).getName().equalsIgnoreCase(name_human)) {
                return Integer.toString(getGen(i)) + "поколение - " + arlist_humans.get(i).toString();
            }
        }
        return "Unkown name";
    }

    public String getInfoChildren(String name_human) {
        String result = "";
        for (int i = 0; i < arlist_humans.size(); i++) {
            if (arlist_humans.get(i).getName().equalsIgnoreCase(name_human)) {
                for (int j = 0; j < arlist_humans.get(i).getChildren().size(); j++) {
                    result += arlist_humans.get(i).getChildren().get(j) + "\n";
                }
                return result;
            }
        }
        return "Unkown name";
    }

    public String getInfoMother(String name_human) {
        for (int i = 0; i < arlist_humans.size(); i++) {
            if (arlist_humans.get(i).getName().equalsIgnoreCase(name_human)) {
                for (int j = i; j >= 0; j--) {
                    if (arlist_humans.get(j).getName().equalsIgnoreCase(arlist_humans.get(i).getNameMother())) {
                        return arlist_humans.get(j).toString();
                    }
                }
            }
        }
        return "Unkown name";
    }

    public String getInfoFather(String name_human) {
        for (int i = 0; i < arlist_humans.size(); i++) {
            if (arlist_humans.get(i).getName().equalsIgnoreCase(name_human)) {
                for (int j = i; j >= 0; j--) {
                    if (arlist_humans.get(j).getName().equalsIgnoreCase(arlist_humans.get(i).getNameFather())) {
                        return arlist_humans.get(j).toString();
                    }
                }
            }
        }
        return "Unkown name";
    }
}