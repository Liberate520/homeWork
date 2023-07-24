package view;

import view.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<Command> commands;
	public Menu(Console console){
		commands = new ArrayList<>();
		commands.add(new AddM(console));
		commands.add(new GetFamilyInfo(console));
		commands.add(new SortByDate(console));
		commands.add(new SortByName(console));
		commands.add(new WriteFile(console));
		commands.add(new ReadFile(console));
		commands.add(new Finish(console));
	}
	public int getSize(){
		return commands.size();
	}
	public String menu(){
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < commands.size(); i++) {
			builder.append(i+1);
			builder.append(commands.get(i).getScript());
			builder.append("\n");
		}
		return builder.toString();
	}
	public void execute(int choice) throws IOException, ClassNotFoundException {
		Command command = commands.get(choice-1);
		command.execute();
	}
}
