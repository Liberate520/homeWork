package ui.commands;

import ui.Console;

public class RemovePerson extends Commands {
	public RemovePerson(Console console) {
		super(console);
	}
	
	@Override
	public String description() {
		return "Remove person";
	}
	
	@Override
	public void run() {
	getConsole().removePerson();
	}
	
}
