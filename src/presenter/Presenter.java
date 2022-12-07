package presenter;

import model.HumanList;
import model.Output;
import model.SaveTo;
import view.ConsoleView;

public class Presenter {

    private HumanList list = new HumanList();
    private SaveTo s = new SaveTo();
    private Output output = new Output();

    public void consolePrintAllHumans(){
        ConsoleView.print(output.outputListToString(list));
    }

    public void addHuman(String name, Integer age){
        ConsoleView.print(output.outputString(list.addHuman(name, age)));        
    }

    public void removeHuman(int id){
        ConsoleView.print(output.outputString(list.removeHuman(id)));       
    }

    public void printChildrens(int id){
        ConsoleView.print(output.outputString(list.printChildrens(id)));       
    }

    public void addReletionToHuman(int id, int relationId, int reletionToHumanId){
        ConsoleView.print(output.outputString(list.addReletionToHuman(id, relationId, reletionToHumanId)));        
    }

    public void addToTxt(int id){
        ConsoleView.print(output.outputString(s.addToTxt(list,id)));    
    }

    public void addToDoc(int id){
        ConsoleView.print(output.outputString(s.addToDoc(list,id)));
    }
}
