package faminly_tree.view.add_human;

import faminly_tree.view.ConsoleUI;
import java.util.ArrayList;
import java.util.List;

public class AddHuman {
    private List<HumanData> dataList;
    ConsoleUI consoleUI;
    Container container;

    public AddHuman(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.container = new Container();
        dataList = new ArrayList<>();
        dataList.add(new HumanName(consoleUI, container));
        dataList.add(new HumanSurname(consoleUI, container));
        dataList.add(new HumanPatronymic(consoleUI, container));
        dataList.add(new HumanGender(consoleUI, container));
        dataList.add(new Birth(consoleUI, container));
        dataList.add(new Death(consoleUI, container));
        dataList.add(new Finish(consoleUI, container));
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
