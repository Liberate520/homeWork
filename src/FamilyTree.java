import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FamilyTree {
    private List<Human> tree = new ArrayList<>();
    private HashMap<Human, Human> fathersList = new HashMap<>();
    private HashMap<Human, Human> mothersList = new HashMap<>();

    public void addPerson(Human human){
        tree.add(human);
    }

    public void addFather(String surname, String name, String patronymic, Gender gender, int birthYear, int birthMonth, int birthDay, Human human){
        Human father = new Human(surname, name, patronymic, Gender.Male, birthYear, birthMonth, birthDay);
        tree.add(father); //добавляем его в общий список персон
        fathersList.put(human, father); //добавляем в словарь отцов
        human.setFather(father); //определяем поле отец у человека, для которого вызвали метод
        List<Human> children = father.getChildren(); //находим других детей этого отца
        if (children == null){
            children = new ArrayList<>();
            children.add(human);
        }
        else children.add(human); //добавляем человека, для которого вызвали метод
        father.setChildren(children); //переопределяем поле дети у этого отца
    }

    public void addMother(String surname, String name, String patronymic, Gender gender, int birthYear, int birthMonth, int birthDay, Human human){
        Human mother = new Human(surname, name, patronymic, Gender.Female, birthYear, birthMonth, birthDay);
        tree.add(mother);
        mothersList.put(human, mother);
        human.setMother(mother);
        List<Human> children = mother.getChildren();
        if (children == null){
            children = new ArrayList<>();
            children.add(human);
        }
        else children.add(human);
        mother.setChildren(children);
    }

    public String findParents(Human human){
        StringBuilder parents = new StringBuilder();
        Human father = fathersList.get(human);
        Human mother = mothersList.get(human);
        if (father != null) parents.append("Father:\n" + father + "\n");
        else parents.append("Father not found\n");
        if (mother != null) parents.append("Mother:\n" + mother + "\n");
        else parents.append("Mother not found\n");
        return parents.toString().replaceAll("]", "").replaceAll("\\[", "").replaceAll("\n, ", "\n\n");
    }

    @Override
    public String toString(){
        return tree.toString().replaceAll("]", "").replaceAll("\\[", "").replaceAll("\n, ", "\n\n");
    }
}