package presenter;

import java.util.List;
import model.Person;
import model.Service;
import view.ConsoleUI;

public class Presenter {
    private Service service;
    private ConsoleUI console;

    public Presenter(Service service, ConsoleUI console) {
        this.service = service;
        this.console = console;
        console.setPresenter(this);
    }

    public void commandShow() {
        this.console.print(this.service.showTheFamily());
    }

    public void commandFullPersonInfo(String whom) {
        int id;
        String answer = "";
        try {
            id = Integer.parseInt(whom.strip());
            answer = service.getFamily_tree().get(id).toStringFull();
        } catch (Exception e) {
            answer = "Incorrect person id:" + whom;
        }
        this.console.print(answer);
    }

    public void commandFileSave() {
        String file_name = service.getBd_file().getFile_name();
        Boolean saved = service.getBd_file().saveFile(service.getFamily_tree());
        String answer = saved ? file_name + " File saved!" : "File " + file_name + " not saved!";
        this.console.print(answer);
    }

    public void commandAddNewPerson(String name){
        int id = service.addPerson(name);
        String answer = service.getFamily_tree().get(id).toStringFull();
        this.console.print(answer);
    }

    public void commandSearchPersonByName(String name){
        String answer = "";
        for (Person person : service.getFamily_tree().searchByName(name)) {
            answer += person.toString();
        }
        this.console.print(answer);
    }

    public void commandShowPersonsSortByName(){
        List<Person> persons_list = service.getFamily_tree().getThePersonsList();
        Service.sortPersonsByName(persons_list);
        String answer = "";
        for (Person person : persons_list) {
            answer += person.toString();
        }
        this.console.print(answer);
    }

    public void commandShowPersonsSortById(){
        List<Person> persons_list = service.getFamily_tree().getThePersonsList();
        Service.sortPersonsById(persons_list);
        String answer = "";
        for (Person person : persons_list) {
            answer += person.toString();
        }
        this.console.print(answer);
    }

    public void commandEditPerson(String whom, String field, String what){
        int id,id_parent;
        try {
            id = Integer.parseInt(whom.strip());
        } catch (Exception e) {
            return;
        }

        if (field.equals("sex")){
            service.getFamily_tree().get(id).setPerson_sex(what);
            String answer = service.getFamily_tree().get(id).toStringFull();
            this.console.print(answer);
            return;
        }

        try {
            id_parent = Integer.parseInt(what.strip());
        } catch (Exception e) {
            this.console.print("Incorrect parent id:" + what);
            return;
        }

        if (field.equals("mother"))
            service.getFamily_tree().addMother(id, id_parent);

        if (field.equals("father"))
            service.getFamily_tree().addFather(id, id_parent);

        String answer = service.getFamily_tree().get(id).toStringFull();
        this.console.print(answer);
    }

}
