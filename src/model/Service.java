package Tree.homeWork.src.model;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private List<String> list;

    public Service() {
        list = new ArrayList<>();
        list.add("vdfgdfgdf");
        list.add("dsasfasf");
    }

    public void addHuman(String firstName, String lastName) {
        list.add(firstName + " " + lastName);
    }
    public String getHumanList(){
        return list.toString();
    }
}
