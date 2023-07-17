package view.commands;

import view.Console;

public class GetFamilyInfo extends Command{
	public GetFamilyInfo(Console console){
		super(console, ". Вывести дерево");
	}

	public void execute(){
		console.getFamilyInfo();
	}
}
