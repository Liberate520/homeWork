package presenter;

import module.essence.Gender;
import module.essence.Human;
import service.Service;
import ui.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Presenter{
    private final View view;
    private final Service<Human> service;

    public Presenter(View view, Service<Human> service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void getFamily() {
        List<String> answer = service.getFamily();
        StringBuilder sb = new StringBuilder();
        for (String s:answer) {
            sb.append(s);
            sb.append("\n");
        }
        view.print(String.valueOf(sb));
    }
    public List<String> getMembers(){
        return service.getFamily();
    }
    public void getRelatives(String human){
        List<Human> answer = new ArrayList<>(service.getRelatives(service.findByName(human)));
        StringBuilder sb = new StringBuilder();
        for (Human s:answer) {
            sb.append(s);
            sb.append("\n");
        }
        view.print(String.valueOf(sb));
    }
    public void save() throws IOException {
        service.save();
    }
    public void load() throws IOException, ClassNotFoundException {
        service.loadFamily();
    }

    public void addMember(String name, String day, String month, String year, String gender) {
        int day_new = Integer.parseInt(day);
        int month_new = Integer.parseInt(day);
        int year_new = Integer.parseInt(day);
        if (Objects.equals(gender, "м")){
            service.addMember(name, day_new, month_new, year_new, Gender.Male);;
        }
        else if(Objects.equals(gender, "ж"))
        {service.addMember(name, day_new, month_new, year_new, Gender.Female);}
    }
}

