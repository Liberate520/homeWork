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

    public StringBuilder getFamilyTree() {
        StringBuilder str = new StringBuilder();
        for(Human human: familyTree){
            str.append(human + "\n");
        }
        return str;
    }

    public StringBuilder sortFamilyTreeByName(){
        familyTree.sortByName();
        return getFamilyTree();
    }

    public StringBuilder sortFamilyTreeByBirthdate(){
        familyTree.sortByDate();
        return getFamilyTree();
    }

    public void addHuman(){
        familyTree.add(new Human(presenter.getStringInfo("Имя"), 
                                 presenter.getStringInfo("Фамилия"), 
                                 familyTree.getByName(presenter.getStringInfo("Имя отца")), 
                                 familyTree.getByName(presenter.getStringInfo("Имя матери")), 
                                 presenter.getIntInfo("Год"), 
                                 presenter.getIntInfo("Месяц") - 1, 
                                 presenter.getIntInfo("День")));
    }

    public StringBuilder exit() {
        StringBuilder str = new StringBuilder();
        try {
            fileHandler.fileWrite(familyTree);
            str.append("Сохранение прошло успешно");
            return str;
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public Human getByName(String name){
        for(Human human: familyTree){
            System.out.println(human);
            if(human.getFirstname().equals(name)){
                return human;
            }
        }
        return null;
    }
}