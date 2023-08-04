package presenter;

import model.FamilyTree.FileHolders.FileReader;
import model.FamilyTree.FileHolders.FileSaver;
import model.Organisms.Person.OrganismType;
import model.Organisms.Person.Person;
import model.Organisms.Person.Sex;
import model.Service.Service;
import view.Text;
import view.UI;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Presenter {
    private UI ui;
    private Service service;

    public Presenter(UI ui) {
        this.ui = ui;
        this.service = new Service();
    }

    public List<Person> getTree() {return service.getTree();}


    public void sortByName() {
        service.sortByName();
    }

    public void sortByAge() {
        service.sortByBirthday();
    }

    public void writeToFile() {
        service.writeToFile(new FileSaver());
    }

    public void readFromFile() {
        service.readFromFile(new FileReader());
    }

    public void setSpouse(int index1, int index2){
        service.setSpouse(index1, index2);
    }
    public void setChild(int indexParent, int indexChild){
        service.setChild(indexParent, indexChild);
    }

    public void createPerson(){
        Scanner scanner = new Scanner(System.in);
        OrganismType organismType = ui.inputType(scanner);
        String name = ui.inputName(scanner);
        LocalDate date = ui.inputBirthday();
        Sex sex = ui.inputSex();
        if (organismType == OrganismType.dog){
            service.addDog(name,date,sex);
        } else if (organismType == OrganismType.human) {
            service.addHuman(name,date,sex);
        }
    }
}
