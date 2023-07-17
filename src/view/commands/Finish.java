package view.commands;

import view.Console;

public class Finish extends Command{
	public Finish(Console console){
		super(console, ". Закончить работу");
	}

	public void execute(){
		console.finish();
	}
}
