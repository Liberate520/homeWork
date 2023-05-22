package familyTree.presenter;

import familyTree.model.Service;
import familyTree.model.person.Person;
import familyTree.ui.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }
    public boolean addPerson(Person person){
        service.addPerson(person);
        return true;
    }
    public void sortName(){
        service.sortName();
    }
    public void sortAge(){
        service.sortAge();
    }
    public void sortGender(){
        service.sortGender();
    }
    public  void getParents(Person person){
        view.print(service.getParents(person));
    }
    public  void getChildren(Person person) {
        view.print(service.getChildren(person));
    }
    public  void getGrandParents(Person person){
        view.print(service.getGrandParents(person));
    }
    public void getInfoTree(){
        view.print(service.getInfoTree());
    }
    public Person search(String e){
        return service.search(e);
    }

    public void saveFile(String path) {
       service.saveFile(path);
    }
    public void readFile(String path) {
        service.readFile(path);
    }

}
