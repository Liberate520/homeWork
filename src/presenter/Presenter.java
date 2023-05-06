package presenter;

import module.essence.Human;
import module.service.HumanService;
import ui.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Presenter{
    private final View view;
    private final HumanService humanService;

    public Presenter(View view, HumanService humanService) {
        this.view = view;
        this.humanService = humanService;
        view.setPresenter(this);
    }

    public void getFamily() {
        List<String> answer = humanService.getFamily();
        StringBuilder sb = new StringBuilder();
        for (String s:answer) {
            sb.append(s);
            sb.append("\n");
        }
        view.print(String.valueOf(sb));
    }
    public List<String> getMembers(){
        return humanService.getFamily();
    }
    public void getRelatives(String human){
        List<Human> answer = new ArrayList<>(humanService.getRelatives(humanService.findByName(human)));
        StringBuilder sb = new StringBuilder();
        for (Human s:answer) {
            sb.append(s);
            sb.append("\n");
        }
        view.print(String.valueOf(sb));
    }
    public void save() throws IOException {
        humanService.save();
    }
    public void load() throws IOException, ClassNotFoundException {
        humanService.loadFamily();
    }

    public void addMember(String name, String day, String month, String year, String gender) {
        humanService.addMember(name, day, month, year, gender);
    }
}

