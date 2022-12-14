namespace GeekBrains;

public class Presenter {

    private ItemList list = new ItemList();
    private SaveTo s = new SaveTo();
    private Output output = new Output();
    private ConsoleView console = new ConsoleView();

    public void consolePrintAllHumans(){
        console.print(output.outputListToString(list));
    }

    public void addHuman(String name, int age){
        console.print(output.outputString(list.addHuman(name, age)));        
    }

    public void removeHuman(int id){
        console.print(output.outputString(list.removeItem(id)));       
    }

    public void printChildrens(int id){
        console.print(output.outputString(list.printChildrens(id)));       
    }

    public void addReletionToHuman(int id, int relationId, int reletionToHumanId){
        console.print(output.outputString(list.addReletionToItem(id, relationId, reletionToHumanId)));        
    }

    public void addToTxt(int id){
        console.print(output.outputString(s.addToTxt(list,id)));    
    }

    public void addToDoc(int id){
        console.print(output.outputString(s.addToDoc(list,id)));
    }
}
