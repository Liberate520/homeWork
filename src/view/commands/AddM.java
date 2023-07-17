package view.commands;

import view.Console;

public class AddM extends Command {

	public AddM(Console console){
		super(console, ". Добавить члена семьи");
	}

	public void execute(){
		console.addM();
	}
}
