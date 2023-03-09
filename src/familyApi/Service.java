package familyApi;

import java.io.IOException;
import java.util.Calendar;

import presenter.Presenter;

public class Service {
    private Presenter presenter;
    private FamilyTree<Human> familyTree;
    private FileHandler<Human> fileHandler;

    public Service() {
        this.familyTree = new FamilyTree<Human>();
        this.fileHandler = new FileHandler<>();
        
        try {
            fileHandler.load(familyTree);
        } catch (IOException e) {
            
        } catch (ClassNotFoundException e) {
            
        }
    }

    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }

    public String getFamilyTree() {
        StringBuilder str = new StringBuilder();
        for(Human human: familyTree){
            str.append(human + "\n");
        }
        return str.toString();
    }

    public String sortFamilyTreeByName(){
        familyTree.sortByName();
        return getFamilyTree();
    }

    public String sortFamilyTreeByBirthdate(){
        familyTree.sortByDate();
        return getFamilyTree();
    }

    public String addHuman() {
        boolean val = true;
        String firstname = presenter.getStringInfo("Имя");
        String lastname = presenter.getStringInfo("Фамилия");
        Integer year = presenter.getIntInfo("Год");
        Integer monat = presenter.getIntInfo("Месяц") - 1;
        Integer day = presenter.getIntInfo("День");
        Human father = familyTree.getByName(presenter.getStringInfo("Имя отца"));
        Human mother = familyTree.getByName(presenter.getStringInfo("Имя матери"));

        for(Human human: familyTree) {
            if(human.getFirstname().equals(firstname) &&
                human.getLastname().equals(lastname) &&
                human.getBirthdate().get(Calendar.YEAR) == year &&
                human.getBirthdate().get(Calendar.MONTH) == monat &&
                human.getBirthdate().get(Calendar.DAY_OF_MONTH) == day &&
                human.getFather().getFirstname().equals(father.getFirstname()) &&
                human.getMother().getFirstname().equals(mother.getFirstname()))

                switch (presenter.getStringInfo(human.toString() + "\n" + "Похоже такой человек уже есть в дереве\n" + "Всё равно добавить? (да/нет)")) {
                    case "да":
                        val = true;
                        familyTree.add(new Human(firstname, lastname, father, mother, year, monat, day));
                        break;
                    case "нет":
                        val = false;
                        break;
                }
        }
        
        if (val) familyTree.add(new Human(firstname, lastname, father, mother, year, monat, day));
        return "Все отлично";
    }

    public String exit() {
        StringBuilder str = new StringBuilder();
        try {
            fileHandler.save(familyTree);
            str.append("Сохранение прошло успешно");
            presenter.finish();
            return str.toString();
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public String getByName() {
        String name = presenter.getStringInfo("Введите имя:");
        for(Human human: familyTree){
            if(human.getFirstname().equals(name)){
                return human.toString();
            }
        }
        return null;
    }

    public String livingHuman() {
        StringBuilder str = new StringBuilder();
        for(Human human: familyTree){
            if(human.getDeathdate() == null){
                str.append(human.toString() + "\n");
            }
        }
        return str.toString();
    }
}