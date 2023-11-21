package fam_tree;


import java.util.ArrayList;
import java.util.List;
public class MainMenu {

    private final List<Instruction> instructionList;

    public MainMenu(Look look) {
        instructionList = new ArrayList<>();
        instructionList.add(new AddHuman(look));
        instructionList.add(new GetTreeInfo(look));
        instructionList.add(new SortByAge(look));
//        instructionList.add(new SortByName(look));
        instructionList.add(new Exit(look));
    }

    public String  print(){
        StringBuilder sb = new StringBuilder();
        sb.append("Выберете пункт меню: \n");
        for (int i = 0; i < instructionList.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(instructionList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice){
        Instruction instruction = instructionList.get(choice-1);
        instruction.execute();
    }

    public int size(){
        return instructionList.size();
    }
}
