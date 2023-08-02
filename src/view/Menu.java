package view;

import java.util.ArrayList;
import java.util.List;

import view.commands.getList;

public class Menu {
  private List<getList> list;

  public Menu(Console console){
    list = new ArrayList<>();
    list.add(new getList(console));
  }

  public String print(){
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < list.size(); i++) {
      stringBuilder.append(i + 1);
      stringBuilder.append(". ");
      stringBuilder.append(list.get(i).getDescription());
      stringBuilder.append("\n");
    }
    return stringBuilder.toString();
  }

  public void execute(String choice){
    list.get(Integer.parseInt(choice) - 1).execute();
  }
}
