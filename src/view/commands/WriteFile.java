package view.commands;

import view.Console;

import java.io.IOException;

public class WriteFile extends Command{
	public WriteFile(Console console){
		super(console, ". Записать в файл");
	}

	public void execute() throws IOException {
		console.writeF();
	}
}
