import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> familyMembers;

    public FamilyTree(){
        familyMembers = new ArrayList<>();
    }

    public void addMember(Human human){
        familyMembers.add(human);
    }

    /**
     * Метод добавляет в партнеры одного объекта другого.
     * Если пол объекта женский, то фамилия объекта меняется на фамилию партнера с добавлением буквы "а"
     * Также если семейное дерево не содержит какойто из объектов, то добавляет его
     */
    public void getMarried(Human human1, Human human2) {
        human1.setPartner(human2);
        human2.setPartner(human1);
        if(human1.getGender().equals(Gender.Female)) {
            human1.setLastName(human2.getLastName() + "а");
        }
        else {
            human2.setLastName(human1.getLastName() + "а");
        }
        if(!familyMembers.contains(human1)){
            familyMembers.add(human1);
        }
        if(!familyMembers.contains(human2)) {
            familyMembers.add(human2);
        }
    }

    /**
     * Метод, в зависимости от пола указанного родителя и самого ребенка, меняет фамилию ребенка,
     * добавляет родителей в объект ребенка.
     * Также добавляет ребенка в семейное дерево и в список детей обоих родителей
     */
    public void addChaild(Human human, Human chaild) {
        if (chaild.getGender().equals(Gender.Female)) {
            if (human.getGender().equals(Gender.Female)) {
                chaild.setLastName(human.getLastName());
            } else {
                chaild.setLastName(human.getPartner().getLastName());
            }
        } else {
            if (human.getGender().equals(Gender.Female)) {
                chaild.setLastName(human.getPartner().getLastName());
            } else {
                chaild.setLastName(human.getLastName());
            }
        }
        if (human.getGender().equals(Gender.Female)) {
            chaild.setMother(human);
            chaild.setFather(human.getPartner());
        } else {
            chaild.setFather(human);
            chaild.setMother(human.getPartner());
        }
        this.addMember(chaild);
        human.addChaild(chaild);
        human.getPartner().addChaild(chaild);
    }

    /**
     * Возвращаются в виде строки имена родителей объекта
     */
    public String getParents(Human human) {
        return "Мама: " + human.getMother().getFirstName() + "\n" +
                "Папа: " + human.getFather().getFirstName();
    }

    /**
     * Выводятся имена сестер и братьев объекта
     */
    public List<Human> getBrothersAndSisters(Human human) {
        List<Human> bros = new ArrayList<>();
        for (Human broAndSis :
                human.getFather().getChildren()) {
            if(!broAndSis.equals(human)) {
                bros.add(broAndSis);
            }
        }
        return bros;
    }

    /**
     * Возвращается имя и фамилия партнера объекта
     */
    public String getPartner(Human human) {
        String role;
        if(human.getGender().equals(Gender.Female)) {
            role = "Муж: ";
        } else {
            role = "Жена: ";
        }
        return role + human.getPartner().getLastName() + " " + human.getPartner().getFirstName();

    }

    /**
     * Возвращается строка с полом, именем, фамилией и детьми объекта
     */
    public String getInfoByMember(Human human) {
        return "Пол: " + human.getGender() + "\n" +
                "Имя: " + human.getFirstName() + "\n" +
                "Фамилия: " + human.getLastName() + "\n" +
                "Дети: " + human.getChildren();
    }
}
