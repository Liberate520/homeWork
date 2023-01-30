package presenters;

import java.util.List;
import java.util.Map;

import enums.Gender;
import models.*;
import relationFamilyTree.Relationships;
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
    public void createNewTree() {
        
        this.familyTree.getDemoMap();
        consoleInterface.outResult("Демо дерево создано");
        this.consoleInterface.menu();
    }

    @Override
    public void createTreeFromFile() {
        this.familyTree.read();
        consoleInterface.outResult("Дерево из файла загружено");
        this.consoleInterface.menu();
    }

    @Override
    public void addHuman() {
        this.consoleInterface.outStr("Введите Фамилию:\n--> ");
        String lastName = this.consoleInterface.inputText();
        this.consoleInterface.outStr("Введите Имя:\n--> ");
        String name = this.consoleInterface.inputText();
        this.consoleInterface.outStr("Введите Отчество:\n--> ");
        String secondName = this.consoleInterface.inputText();
        this.consoleInterface.outStr("Введите Пол\n0 - женский\n1 - мужской:\n--> ");
        Gender gender = Gender.MAN;
        Boolean loop = true;
        while (loop) {
            try {
                int choice = Integer.parseInt(this.consoleInterface.inputText());
                if ((choice == 0)) {
                    gender = Gender.WOMAN;
                    loop = false;
                } else if (((choice == 1))) {
                    gender = Gender.MAN;
                    loop = false;
                } else {
                    this.consoleInterface.outStr("0 или 1. Еще раз.:\n--> ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Не число. Еще раз.");
            }
        }

        Human human = new Human(lastName, name, secondName, gender);
        this.consoleInterface.outResult(human.getUuid() + " -> " + human.getFIOtoString() + " создан");

        this.consoleInterface.outStr("Uuid супруга/супруги или 0 - если нет:\n--> ");
        this.text = this.consoleInterface.inputText();

        if (!this.text.equals("0")) {
            human.setSpouse(this.familyTree.getHumanByUuid(this.text));  
        }
        
        this.consoleInterface.outStr("Uuid отца или 0 - если нет:\n--> ");
        this.text = this.consoleInterface.inputText();

        if (!this.text.equals("0")) {
            human.setParentFather(this.familyTree.getHumanByUuid(this.text));
        }

        this.consoleInterface.outStr("Uuid матери или 0 - если нет:\n--> ");
        this.text = this.consoleInterface.inputText();

        if (!this.text.equals("0")) {
            human.setParentMother(this.familyTree.getHumanByUuid(this.text));
        }

        this.consoleInterface.outResult(human.toString());
    }

    @Override
    public void deleteHuman() {
        this.consoleInterface.outStr("Введите uuid:\n--> ");
        this.text = this.consoleInterface.inputText();
        Human human = this.familyTree.removeHumanByUuid(this.text);
        consoleInterface.outResult(human.getUuid() + " -> " + human.getFIOtoString() + " удален!");
        this.consoleInterface.menu();
    }

    @Override
    public void outoutHumanByUuid() {
        this.consoleInterface.outStr("Введите uuid:\n--> ");
        this.text = this.consoleInterface.inputText();
        
        Human human = this.familyTree.getHumanByUuid(this.text);
        if (human != null) {
            this.consoleInterface.outResult(human.toString());
        } else {
            this.consoleInterface.outResult("По этому uuid ничего не найдено");
        }
        this.consoleInterface.menu();
        
    }

    @Override
    public void deleteChildToHuman() {
        this.consoleInterface.outStr("Введите uuid родителя:\n--> ");
        this.text = this.consoleInterface.inputText();
        
        Human human = this.familyTree.getHumanByUuid(this.text);
        if (human != null) {
            this.consoleInterface.outResult(human.getUuid() + " -> " + human.getFIOtoString());
            this.consoleInterface.outStr("Введите uuid ребенка:\n--> ");
            this.text = this.consoleInterface.inputText();
            Human human2 = this.familyTree.getHumanByUuid(this.text);
            if (human2 != null) {
                Human.removeChild(human, human2);
                this.consoleInterface.outResult(
                    "Ребенок: " + human.getUuid() + " -> " + human.getFIOtoString() + " удален\n"
                    + "у родителя : " + human2.getUuid() + " -> " + human2.getFIOtoString()
                );
            } else {
                this.consoleInterface.outResult("По этому uuid ничего не найдено");
            }
        } else {
            this.consoleInterface.outResult("По этому uuid ничего не найдено");
        }

        this.consoleInterface.menu();
    }

    @Override
    public void findByFIO() {
        this.consoleInterface.outStr("Введите ФИО:\n--> ");
        this.text = this.consoleInterface.inputText();
        List<Human> humans = this.familyTree.serchHumanByFio(this.text);
        
        this.text = "";

        if (humans.size() > 0) {
            for (Human hum : humans) {
                this.text = (this.text.length() > 0 ? this.text + "\n" : "")
                    + hum.getUuid() + " -> " + hum.getFIOtoString();
            }
        }

        this.consoleInterface.outResult(this.text);
        this.consoleInterface.menu();
    }

    @Override
    public void outputEntireTree() {
        this.printHumans();
        this.consoleInterface.menu();
    }

    @Override
    public void writeTreeToFile() {
        this.familyTree.save();
        consoleInterface.outResult("Дерево записано в файл");
        this.consoleInterface.menu();
    }

    @Override
    public void addMotherToHuman() {
        this.consoleInterface.outStr("Введите uuid:\n--> ");
        this.text = this.consoleInterface.inputText();
        
        Human human = this.familyTree.getHumanByUuid(this.text);
        if (human != null) {
            this.consoleInterface.outResult(human.toString());
            this.consoleInterface.outStr("Uuid матери:\n--> ");
            this.text = this.consoleInterface.inputText();
            Human human2 = this.familyTree.getHumanByUuid(this.text);
            if (human2 != null) {
                human.setParentMother(human2);
                this.consoleInterface.outResult(
                    "Мать" + human2.getUuid()
                    + " -> " + human2.getFIOtoString()
                    + " назначена"
                );
            } else {
                this.consoleInterface.outResult("По этому uuid ничего не найдено");
            }
        } else {
            this.consoleInterface.outResult("По этому uuid ничего не найдено");
        }

        this.consoleInterface.menu();
    }

    @Override
    public void addFatherToHuman() {
        this.consoleInterface.outStr("Введите uuid:\n--> ");
        this.text = this.consoleInterface.inputText();
        
        Human human = this.familyTree.getHumanByUuid(this.text);
        if (human != null) {
            this.consoleInterface.outResult(human.getUuid() + " -> " + human.getFIOtoString());
            this.consoleInterface.outStr("Uuid отца:\n--> ");
            this.text = this.consoleInterface.inputText();
            Human human2 = this.familyTree.getHumanByUuid(this.text);
            if (human2 != null) {
                human.setParentFather(human2);
                this.consoleInterface.outResult(
                    "Отец" + human2.getUuid()
                    + " -> " + human2.getFIOtoString()
                    + " назначен"
                );
            } else {
                this.consoleInterface.outResult("По этому uuid ничего не найдено");
            }
        } else {
            this.consoleInterface.outResult("По этому uuid ничего не найдено");
        }

        this.consoleInterface.menu();
    }

    @Override
    public void addSpouseToHuman() {
        this.consoleInterface.outStr("Введите uuid:\n--> ");
        this.text = this.consoleInterface.inputText();
        
        Human human = this.familyTree.getHumanByUuid(this.text);
        if (human != null) {
            this.consoleInterface.outResult(human.getUuid() + " -> " + human.getFIOtoString());
            this.consoleInterface.outStr("Uuid супруга/супруги:\n--> ");
            this.text = this.consoleInterface.inputText();
            Human human2 = this.familyTree.getHumanByUuid(this.text);
            if (human2 != null) {
                human.setSpouse(human2);
                this.consoleInterface.outResult(
                    human.getUuid() + " -> " + human.getFIOtoString() + "\n"
                    + human2.getUuid() + " -> " + human2.getFIOtoString() + "\n" 
                    + "муж и жена"
                );
            } else {
                this.consoleInterface.outResult("По этому uuid ничего не найдено");
            }
        } else {
            this.consoleInterface.outResult("По этому uuid ничего не найдено");
        }

        this.consoleInterface.menu();
    }

    @Override
    public void establishKinshipRelationship() {
        this.consoleInterface.outStr("Введите uuid:\n--> ");
        this.text = this.consoleInterface.inputText();
        
        Human human = this.familyTree.getHumanByUuid(this.text);
        if (human != null) {
            this.consoleInterface.outResult(human.getUuid() + " -> " + human.getFIOtoString());
            this.consoleInterface.outStr("Введите uuid второго человека:\n--> ");
            this.text = this.consoleInterface.inputText();
            Human human2 = this.familyTree.getHumanByUuid(this.text);
            if (human2 != null) {
                this.consoleInterface.outResult(
                    "Объект: " + human.getUuid() + " -> " + human.getFIOtoString() + "\n"
                    + Relationships.getRelationships(human, human2) + "\n"
                    + "Объекту: " + human2.getUuid() + " -> " + human2.getFIOtoString()
                );
            } else {
                this.consoleInterface.outResult("По этому uuid ничего не найдено");
            }
        } else {
            this.consoleInterface.outResult("По этому uuid ничего не найдено");
        }

        this.consoleInterface.menu();
    }

    public void start() {
        this.consoleInterface.menu();
    }

    public void printHumans() {
        this.text = ""; 
        Map<String, Human> humans = this.familyTree.getHumanMap();
        humans.forEach((id, x) -> {
            this.text = (this.text.length() > 0 ? this.text + "\n" : "") + id + " -> " + x.getFIOtoString();
        });
  
        this.consoleInterface.outResult(this.text);
    }
}
