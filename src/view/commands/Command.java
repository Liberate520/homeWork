package view.commands;

import view.Console;

import java.io.IOException;

public abstract class Command {
	String script;
	Console console;

	public Command(Console console, String script){
		this.console = console;
		this.script = script;
	}

	public String getScript(){
		return script;
	}
	public abstract void execute() throws IOException, ClassNotFoundException;





}
