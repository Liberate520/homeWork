package ui.commands;

import ui.Console;

public class SaveFileCom extends Commands{
	
	public SaveFileCom(Console console) {
		super(console);
	}
	
	@Override
	public String description() {
		return "Save changes";
	}
	
	@Override
	public void run() {
	getConsole().saveList();
	}
}
