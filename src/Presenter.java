import java.util.List;

public class Presenter {
    private Service service;
    private ConsoleUI console;

    // public String
    public Presenter(Service service, ConsoleUI console) {
        this.service = service;
        this.console = console;
        console.setPresenter(this);
    }

    public void onClick(String command) {
        String answer = "";

        if (command.equals("show:")) {
            answer = this.service.showTheFamily();
        }

        if (command.contains("id:") && !command.contains("sort by")) {
            String id_s = command.replaceAll("id:", "").trim();
            int id = Integer.parseInt(id_s);
            answer = service.getFamily_tree().get(id).toStringFull();
        }

        if (command.equals("save:")) {
            Boolean saved = service.getBd_file().saveFile(service.getFamily_tree());
            if (saved){
                answer = service.getBd_file().getFile_name() + " File saved!";
            } else {
                answer = "File " + service.getBd_file().getFile_name() + " not saved!";
            }
        }

        if (command.contains("new:")){
            String[] edit_arr = command.split("\\:");
            String name = edit_arr[1];
            int id = service.addPerson(name);
            answer = service.getFamily_tree().get(id).toStringFull();
        } 

        if (command.contains("name:")){
            String name = command.replace("name:", "").strip();
            for (Person person : service.getFamily_tree().searchByName(name)) {
                answer += person.toString();
            }
        }

        if (command.equals("sort by name:")){
            List<Person> persons_list = service.getFamily_tree().getThePersonsList();
            Service.sortPersonsByName(persons_list);
            for (Person person : persons_list) {
                answer += person.toString();
            }
        }

        if (command.equals("sort by id:")){
            List<Person> persons_list = service.getFamily_tree().getThePersonsList();
            Service.sortPersonsById(persons_list);
            for (Person person : persons_list) {
                answer += person.toString();
            }
        }

        if (command.contains("add.")){
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
            
            answer = service.getFamily_tree().get(id).toStringFull();
        }
        this.console.print(answer);
    }
}
