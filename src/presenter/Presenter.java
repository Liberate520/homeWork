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

    public void commandFullPersonInfo(String command) {
        String id_s = command.replaceAll("id:", "").trim();
        int id = Integer.parseInt(id_s);
        String answer = service.getFamily_tree().get(id).toStringFull();
        this.console.print(answer);
    }

    public void commandFileSave() {
        String file_name = service.getBd_file().getFile_name();
        Boolean saved = service.getBd_file().saveFile(service.getFamily_tree());
        String answer = saved ? file_name + " File saved!" : "File " + file_name + " not saved!";
        this.console.print(answer);
    }

    public void commandAddNewPerson(String command){
        String[] edit_arr = command.split("\\:");
        String name = edit_arr[1];
        int id = service.addPerson(name);
        String answer = service.getFamily_tree().get(id).toStringFull();
        this.console.print(answer);
    }

    public void commandSearchPersonByName(String command){
        String name = command.replace("name:", "").strip();
        String answer = "";
        for (Person person : service.getFamily_tree().searchByName(name)) {
            answer += person.toString();
        }
        this.console.print(answer);
    }

    public void commandShowPersonsSortByName(String command){
        List<Person> persons_list = service.getFamily_tree().getThePersonsList();
        Service.sortPersonsByName(persons_list);
        String answer = "";
        for (Person person : persons_list) {
            answer += person.toString();
        }
        this.console.print(answer);
    }

    public void commandShowPersonsSortById(String command){
        List<Person> persons_list = service.getFamily_tree().getThePersonsList();
        Service.sortPersonsById(persons_list);
        String answer = "";
        for (Person person : persons_list) {
            answer += person.toString();
        }
        this.console.print(answer);
    }

    public void commandEditPerson(String command){
        String[] edit_arr = command.split("\\.");

        int id = Integer.parseInt(edit_arr[1]);
        String key = edit_arr[2];
        int id_parent = 0;
        try {
            id_parent = Integer.parseInt(edit_arr[3]);
        } catch (Exception e) {
        }

        if (key.equals("sex"))
            service.getFamily_tree().get(id).setPerson_sex(edit_arr[3]);

        if (key.equals("father"))
            service.getFamily_tree().addFather(id, id_parent);

        if (key.equals("mother"))
            service.getFamily_tree().addMother(id, id_parent);

        String answer = service.getFamily_tree().get(id).toStringFull();
        this.console.print(answer);
    }

}
