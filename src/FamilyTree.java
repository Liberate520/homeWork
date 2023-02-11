package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FamilyTree {


    public FamilyTree(List<Human> family) {
        this.family = family;
    }
    public FamilyTree() {
        this(null);
    }

    public List<Human> getFamily() {
        return family;
    }

    private List<Human> family = new ArrayList<>();



    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("------------------------\n");
        for (Human h:
             family) {
            result.append(h.getLastName()).append(" ").append(h.getFirstName()).append(" ").append(h.getPatronymic()).append("\n");
        }

        return result.toString();
    }

    public void addToFamily(Human human){
        if(this.family == null) {
            this.family = new ArrayList<>();
        }
        this.family.add(human);
    }



    private List<Human> findFamilyList(String lastName){
        List<Human> result = new ArrayList<>();
        for (Human human:
             family) {
            if(Objects.equals(human.getLastName(), lastName)){
                result.add(human);
            }
        }
        return result;
    }

    public String findFamily(String name){
        StringBuilder result = new StringBuilder();
        List<Human> lst = findFamilyList(name);
        if(!lst.isEmpty()){
            for (Human h:
                    lst) {
                result.append(h.getLastName()).append(" ").append(h.getFirstName()).append(" ").append(h.getPatronymic()).append("\n");
            }
        } else {
            result.append("Нет результатов удовлетворящих критериям поиска");
        }
        return result.toString();
    }

    public void getStatistics(Human human){
        if(family.contains(human)) {
            StringBuilder result = new StringBuilder();
            List<Human> children = getChildrenList(human);
            result.append("---------------------------\n");
            result.append("ФИО: ").append(human.getLastName()).append(" ").append(human.getFirstName()).append(" ").append(human.getPatronymic());
            result.append("\n");
            result.append("Родился ").append(human.getDateOfBorn()).append(" г. в ").append(human.getPlaceOfBirth()).append("\n");
            if (!human.isAlive()) {
                result.append("Умер ").append(human.getDateOfDeath()).append(" г\n");
                result.append("Прожил ").append(human.getAge()).append(" полных лет\n");
            }
            result.append("Имеет ").append(human.getChildren().size()).append(" детей и ").append(children.size() - human.getChildren().size()).append(" внуков");
            System.out.println(result);
        }
    }
    public List<Human> getChildrenList(Human human){
        List<Human> hlist = new ArrayList<>();
        hlist.add(human);
        List<Human> result = createChildrenList(hlist);
        result.remove(0);
        return result;
    }
    private List<Human> createChildrenList(List<Human> lst) {
        List<Human> result = new ArrayList<>(lst);
        int st = lst.size();
        for (Human h :
                lst) {
                if(!h.getChildren().isEmpty()){
                    for (Human hh :
                            h.getChildren()) {
                        if(!result.contains(hh)){
                            result.add(hh);
                        }
                    }
                }

        }
        if(result.size()==lst.size()){
            return result;
        } else {
            result = createChildrenList(result);
        }
        return result;
    }
}
