package ui.commands;

import service.Service;
import ui.Console;

public abstract class Commands implements Options {
	private Console console;
	private Service service;
	public Commands(Console console) {
		this.console = console;
	}
	
	public Console getConsole(){
		return console;
	}
}
