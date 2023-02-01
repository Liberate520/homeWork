package presenters;

import java.util.List;
import java.util.Map;

import enums.Gender;
import models.*;
import relationFamilyTree.Relationships;
import views.Command;
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
    
    @Override
    public String createNewTree() {
        this.familyTree.getDemoMap();
        return "Демо дерево создано";
    }

    @Override
    public String createTreeFromFile() {
        this.familyTree.read();
        return "Дерево из файла загружено";
    }

    @Override
    public String addHuman(String uuidLastName, String uuidName, String uuidSecondName, int genderInt) {
        this.consoleInterface.outStr("Введите Фамилию:\n--> ");
        String lastName = this.consoleInterface.inputText();
        this.consoleInterface.outStr("Введите Имя:\n--> ");
        String name = this.consoleInterface.inputText();
        this.consoleInterface.outStr("Введите Отчество:\n--> ");
        String secondName = this.consoleInterface.inputText();
        this.consoleInterface.outStr("Введите Пол\n0 - женский\n1 - мужской:\n--> ");
        Gender gender = Gender.MAN;
        Boolean loop = true;

        if (genderInt == 0) {
            gender = Gender.WOMAN;
        } else if (genderInt == 1) {
            gender = Gender.MAN;
        }

        Human human = new Human(lastName, name, secondName, gender);
        return human.getUuid();
    }

    @Override
    public String deleteHuman(String uuidHuman) {
        Human human = this.familyTree.removeHumanByUuid(uuidHuman);
        return humanToString(human) + " удален!";
    }

    @Override
    public String outputHumanByUuid(String uuidHuman) {
        Human human = this.familyTree.getHumanByUuid(uuidHuman);
        if (human != null) {
            return human.toString();
        }

        return "По этому uuid ничего не найдено";
    }

    @Override
    public String deleteChildToHuman(String uuidHuman, String uuidChild) {
        Human human = this.familyTree.getHumanByUuid(uuidHuman);
        if (human != null) {
            Human human2 = this.familyTree.getHumanByUuid(uuidChild);
            if (human2 != null) {
                Human.removeChild(human, human2);
                return (
                    "Ребенок: " + humanToString(human) + " удален\n"
                    + "у родителя : " + humanToString(human2)
                );
            }
        }

        return "По этому uuid ничего не найдено";
    }

    @Override
    public String findByFIO(String fio) {
        List<Human> humans = this.familyTree.serchHumanByFio(fio);
        this.text = "";
        if (humans.size() > 0) {
            for (Human hum : humans) {
                this.text = (this.text.length() > 0 ? this.text + "\n" : "") + humanToString(hum);
            }
        }

        return this.text;
    }

    @Override
    public String outputEntireTree() {
        Map<String, Human> humans = this.familyTree.getHumanMap();
        this.text = "";
        humans.forEach((id, x) -> {
            this.text = (text.length() > 0 ? this.text + "\n" : "") + id + " -> " + x.getFIOtoString();
        });
  
        return this.text;
    }

    @Override
    public String writeTreeToFile() {
        this.familyTree.save();
        return "Дерево записано в файл";
    }

    @Override
    public String addMotherToHuman(String uuidHuman, String uuidMother) {
        Human human = this.familyTree.getHumanByUuid(uuidHuman);
        if (human != null) {
            Human human2 = this.familyTree.getHumanByUuid(uuidMother);
            if (human2 != null) {
                human.setParentMother(human2);
                return "Мать" + humanToString(human2) + " назначена";
            }
        }

        return "По этому uuid ничего не найдено";
    }

    @Override
    public String addFatherToHuman(String uuidHuman, String uuidFather) {
        Human human = this.familyTree.getHumanByUuid(uuidHuman);
        if (human != null) {
            Human human2 = this.familyTree.getHumanByUuid(uuidFather);
            if (human2 != null) {
                human.setParentFather(human2);
                return "Отец" + humanToString(human2) + " назначен";
            }
        }
        
        return "По этому uuid ничего не найдено";
    }

    @Override
    public String addSpouseToHuman(String uuidFirst, String uuidSecond) {
        Human human = this.familyTree.getHumanByUuid(uuidFirst);
        if (human != null) {
            Human human2 = this.familyTree.getHumanByUuid(uuidSecond);
            if (human2 != null) {
                human.setSpouse(human2);
                return (
                    humanToString(human) + "\n"
                    + humanToString(human2) + "\n" 
                    + "муж и жена"
                );
            }
        }

        return "По этому uuid ничего не найдено";
    }

    @Override
    public String establishKinshipRelationship(String uuidFirst, String uuidSecond) {
        Human human = this.familyTree.getHumanByUuid(uuidFirst);
        if (human != null) {
            Human human2 = this.familyTree.getHumanByUuid(uuidSecond);
            if (human2 != null) {
                return (
                    "Объект: " + humanToString(human) + "\n"
                    + Relationships.getRelationships(human, human2) + "\n"
                    + "Объекту: " + humanToString(human2)
                );
            }
        }
        
        return "По этому uuid ничего не найдено";
    }

    public void start() {
        this.consoleInterface.menu();
    }

    public String humanToString(Human human) {
        return human.getUuid() + " -> " + human.getFIOtoString();
    }
}
