package ui.commands;

import ui.Console;

public class ShowTreeInfo extends Commands{
	public ShowTreeInfo(Console console){
		super(console);
	}
	@Override
	public String description() {
		return "Show list of objects";
	}
	
	@Override
	public void run() {
		getConsole().showList();
	}
}
