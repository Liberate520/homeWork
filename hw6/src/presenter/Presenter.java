package presenter;

import model.HumanList;
import model.Output;
import view.ConsoleView;

public class Presenter {
    private final HumanList list = new HumanList();
    private final Output output = new Output();

    public void printAllHuman(){
        ConsoleView.print(output.outputPrintList(list));
    }

    public void addHuman(String name, int age){
        ConsoleView.print(output.outputStr(list.addHuman(name, age)));
    }

    public void removeHuman(int id){
        ConsoleView.print(output.outputStr(list.removeHuman(id)));
    }

    public void printChildren(int id){
        ConsoleView.print(output.outputStr(list.printChildren(id)));
    }

    public void addRelationHuman(int id, int relationId, int relationHumanId){
        ConsoleView.print(output.outputStr(list.addRelationHuman(id, relationId, relationHumanId)));
    }
}
