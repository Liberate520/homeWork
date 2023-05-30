package ui;

import ui.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<Options> commands;
	private Console console;
	
	public Menu(Console console) {
		this.console = console;
		commands = new ArrayList<>();
		commands.add(new AddPerson(console));
		commands.add(new RemovePerson(console));
		commands.add(new SearchPerson(console));
		commands.add(new SaveFileCom(console));
		commands.add(new LoadFileCom(console));
		commands.add(new ShowTreeInfo(console));
		
		commands.add(new Exit(console));
	}
	
	void run(int num) {
		try {
			Options options = commands.get(num - 1);
			options.run();
		} catch (Exception e) {
			System.out.print("Choose an option from 1 to 7!\n");
		}
		
	}
	
	public String openMenu() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < commands.size(); i++) {
			stringBuilder.append(i + 1);
			stringBuilder.append(": ");
			stringBuilder.append(commands.get(i).description());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}
