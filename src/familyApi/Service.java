package familyApi;

import java.io.IOException;

import presenter.Presenter;

public class Service {
    private Presenter presenter;
    private FamilyTree<Human> familyTree;
    private FileHandler<Human> fileHandler;

    public Service() {
        this.familyTree = new FamilyTree<Human>();
        this.fileHandler = new FileHandler<>();
        
        try {
            fileHandler.fileRead(familyTree);
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
        familyTree.add(new Human(presenter.getStringInfo("Имя"), 
                                 presenter.getStringInfo("Фамилия"), 
                                 familyTree.getByName(presenter.getStringInfo("Имя отца")), 
                                 familyTree.getByName(presenter.getStringInfo("Имя матери")), 
                                 presenter.getIntInfo("Год"), 
                                 presenter.getIntInfo("Месяц") - 1, 
                                 presenter.getIntInfo("День")));
        return "Все отлично";
    }

    public String exit() {
        StringBuilder str = new StringBuilder();
        try {
            fileHandler.fileWrite(familyTree);
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
}