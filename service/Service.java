package service;
import human.Human;
import humanGroup.ListAllHuman;


public class Service {
    private ListAllHuman listAllHuman;

    public Service() {
        listAllHuman = new ListAllHuman();
    }

    public void addHumans(Human human){
        listAllHuman.addHumans(human);
    }
    public String getHumanList(){
        StringBuilder builder = new StringBuilder();
        builder.append("Семья:\n");
        for (Human human : listAllHuman) {
            builder.append(human);
            builder.append("\n");
        }
        return builder.toString();
    }
    public void sortByName(){
        ListAllHuman.sortByName();
    }

    public void sortByAge() {

        ListAllHuman.sortByAge();
    }
}
