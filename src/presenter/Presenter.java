package presenter;


import model.Output;
import model.PersonList;
import model.SaveTo;
import view.PrintView;

public class Presenter {
    private final PersonList list = new PersonList();
    private final SaveTo save = new SaveTo();
    private final Output output = new Output();
    private final PrintView console = new PrintView();

    public void PrintAllPerson(){
        console.print(output.outputListToString(list));
    }

    public void addPerson(String name, Integer age){
        console.print(output.outputString(list.addPerson(name, age)));
    }

    public void removePerson(int id){
        console.print(output.outputString(list.removeItem(id)));       
    }

    public void printChildren(int id){
        console.print(output.outputString(list.printChildren(id)));
    }

    public void addRelationToPerson(int id, int relationId, int relationToPersonId){
        console.print(output.outputString(list.addRelationToItem(id, relationId, relationToPersonId)));
    }

    public void addToTxt(int id){
        console.print(output.outputString(save.addToTxt(list,id)));
    }

    public void addToCsv(int id){
        console.print(output.outputString(save.addToCsv(list,id)));
    }
}
