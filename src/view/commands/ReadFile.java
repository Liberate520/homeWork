package view.commands;

import view.Console;

import java.io.IOException;

public class ReadFile extends Command{
	public ReadFile(Console console){
		super(console, ". Загрузить из файла");
	}

	public void execute() throws IOException, ClassNotFoundException {
		console.readF();
	}

}
