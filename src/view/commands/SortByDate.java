package view.commands;

import view.Console;

public class SortByDate extends Command{
	public SortByDate(Console console){
		super(console, ". Отсортировать древо по дате рождения");
	}

	public void execute(){
		console.sortByDate();
	}
}
