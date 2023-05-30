package ui.commands;

import ui.Console;

public class SearchPerson extends Commands {
	public SearchPerson(Console console) {
		super(console);
	}
	
	@Override
	public String description() {
		return "Searching by the lastname";
	}
	
	@Override
	public void run() {
	getConsole().searchPerson();
	}
}
