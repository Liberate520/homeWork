package presenter;

import model.Output;
import model.PersonList;
import model.SaveTo;
import view.ConsoleView;

public class Presenter {

    private final PersonList list = new PersonList();
    private final SaveTo s = new SaveTo();
    private final Output output = new Output();

    public void consolePrintAllPerson(){
        ConsoleView.print(output.outputListToString(list));
    }

    public void addPerson(String name, Integer age){
        ConsoleView.print(output.outputString(list.addPereson(name, age)));
    }

    public void removePerson(int id){
        ConsoleView.print(output.outputString(list.removePerson(id)));
    }

    public void printChildren(int id){
        ConsoleView.print(output.outputString(list.printChildren(id)));
    }

    public void addRelationToPerson(int id, int relationId, int relationToPersonId){
        ConsoleView.print(output.outputString(list.addReletionToPerson(id, relationId, relationToPersonId)));
    }

    public void addToTxt(int id){
        ConsoleView.print(output.outputString(s.addToTxt(list,id)));    
    }

    public void addToCsv(int id){
        ConsoleView.print(output.outputString(s.addToCSV(list,id)));
    }
}
