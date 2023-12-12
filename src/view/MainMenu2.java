package homeWork.src.view;

import homeWork.src.view.commands2.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu2 {
    private List<Command2> commandList2;
    public MainMenu2(View2 view2){
        commandList2 = new ArrayList<>();
        commandList2.add(new ChangeName(view2));
        commandList2.add(new ChangeSurname(view2));
        commandList2.add(new ChangePatronymicName(view2));
        commandList2.add(new ChangeGender(view2));
        commandList2.add(new ChangeBirthDate(view2));
        commandList2.add(new ChangeDeathDate(view2));
        commandList2.add(new ChangeSpouse(view2));
        commandList2.add(new ChangeMother(view2));
        commandList2.add(new ChangeFather(view2));
        commandList2.add(new Exit(view2));
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        sb.append("List of commands:\n");
        for (int i = 0; i < commandList2.size(); i++) {
            sb.append(i+1)
                    .append(". ")
                    .append(commandList2.get(i).getDescription2())
                    .append("\n");
        }

        return sb.toString();
    }

    public void execute(int choice){
        Command2 command = commandList2.get(choice - 1);
        command.execute();
    }
}
