package presenter;

import java.util.List;
import model.Service;
import model.file.FileBinary;
import model.file.FileCSV;
import model.person.Person;
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

    public Service getService(){
        return this.service;
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

    public void commandFileSaveAsCSV() {
        FileCSV fcsv = service.getBd_csv();
        if (fcsv==null){
            fcsv = new FileCSV();
            service.setBd_csv(fcsv);
        }
        String file_name = fcsv.getFile_name();
        Boolean saved = fcsv.saveFile(service.getFamily_tree());
        String answer = saved ? file_name + " File saved!" : "File " + file_name + " not saved!";
        this.console.print(answer);
    }

    public void commandFileSaveAsBinary() {
        FileBinary fbin = service.getBd_binary();
        if (fbin==null){
            fbin = new FileBinary();
            service.setBd_binary(fbin);
        }
        String file_name = fbin.getFile_name();
        Boolean saved = fbin.saveFile(service.getFamily_tree());
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

    public void commandAddSex(int id, String what){
        service.getFamily_tree().get(id).setPerson_sex(what);
        String answer = service.getFamily_tree().get(id).toStringFull();
        this.console.print(answer);
        return;
    }

    public void commandEditPerson(int id, String field, int id_parent){

        if (field.equals("mother"))
            service.getFamily_tree().addMother(id, id_parent);

        if (field.equals("father"))
            service.getFamily_tree().addFather(id, id_parent);

        String answer = service.getFamily_tree().get(id).toStringFull();
        this.console.print(answer);
    }

}
