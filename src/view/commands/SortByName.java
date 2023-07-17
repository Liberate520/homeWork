package view.commands;

import view.Console;

public class SortByName extends Command{
	public SortByName(Console console){
		super(console, ". Отсортировать древо по имени");
	}

	public void execute(){
		console.sortByName();
	}
}
