package ui;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<Options> commands;
	private Console console;
	
	public Menu(Console console){
		this.console = console;
		commands = new ArrayList<>();
		commands.add(new AddPerson(console));
		commands.add(new RemovePerson(console));
		commands.add(new Exit(console));
	}
	void run(int num){
		Options options = commands.get(num-1);
		options.run();
	}
	public String openMenu(){
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < commands.size(); i++) {
			stringBuilder.append(i+1);
			stringBuilder.append(": ");
			stringBuilder.append(commands.get(i).description());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}
