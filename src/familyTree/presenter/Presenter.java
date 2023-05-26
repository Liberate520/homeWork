package familyTree.presenter;

import familyTree.model.Service;
import familyTree.model.fileWorkers.FileWorkable;
import familyTree.model.person.Person;
import familyTree.ui.View;

import java.io.Serializable;

public class Presenter implements FileWorkable {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }
    public boolean addPerson(int age,String gender,String name,String mother,String father){
        service.addPerson(age,gender,name,mother,father);
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



    @Override
    public boolean saveFile(Serializable serializable, String filePath) {
       return service.saveFile(serializable,filePath);
    }

    @Override
    public Object readFile(String filePath) {
       return service.readFile(filePath);
    }


}
