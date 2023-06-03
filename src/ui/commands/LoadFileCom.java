package ui.commands;

import ui.Console;

public class LoadFileCom extends Commands {
	
	
	public LoadFileCom(Console console) {
		super(console);
	}
	
	@Override
	public String description() {
		return "Loading data from a file...";
	}
	
	@Override
	public void run() {
	getConsole().loadFile();
	}
}
