import java.util.ArrayList;
import java.util.List;

public class View {
    Family<Human> family = new Family<>();
    OperationsWithFamily owf = new OperationsWithFamily(family);
    Service service = new Service(family,owf);
    InAndOut iao = new InAndOut();

    List<Option> commandList;

    public void start(){
        View view = new View();
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(view));
        commandList.add(new ShowAll(view));
        commandList.add(new FindHuman(view));
        commandList.add(new FindParents(view));
        Exit exit = new Exit(view);
        commandList.add(exit);

        int stopMenu = commandList.indexOf(exit);

        int menu = 0;
        while(menu != stopMenu){
            for(int i = 0; i < commandList.size(); i++){
                iao.print(i + ": " + commandList.get(i).discription());
            }
            iao.print(": ");
            menu = Integer.parseInt(iao.input());
            commandList.get(menu).execute();
        }
    }

    public void addHuman(){
        service.createPerson();
    }
    public void showAll(){
        iao.print(service.show().toString());
    }
    public void findHuman(){
        iao.print(service.searchMember().toString());
    }
    public void findParents(){
        iao.print(service.findParents().toString());
    }
    public void exit(){
    }
}
