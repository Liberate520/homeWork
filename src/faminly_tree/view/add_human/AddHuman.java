package faminly_tree.view.add_human;

import faminly_tree.view.ConsoleUI;
import java.util.ArrayList;
import java.util.List;

public class AddHuman {
    private List<HumanData> dataList;
    ConsoleUI consoleUI;

    public AddHuman(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        dataList = new ArrayList<>();
        dataList.add(new HumanName(consoleUI));
        dataList.add(new HumanSurname(consoleUI));
        dataList.add(new HumanPatronymic(consoleUI));
        dataList.add(new Birth(consoleUI));
        dataList.add(new Death(consoleUI));
        dataList.add(new Finish(consoleUI));
    }
    public String getChoice(){
        StringBuilder sb = new StringBuilder("Выберите параметр для добавления. " +
                "В случае повторного выбора одного и того же параметра, будет записан последний введенный вариант:\n");
        for (int i = 0; i < dataList.size(); i++) {
            sb.append(i + 1);
            sb.append(". ");
            sb.append(dataList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice){
        HumanData data = dataList.get(choice - 1);
        data.execute();
    }
    public int getSize(){
        return dataList.size();
    }
}
