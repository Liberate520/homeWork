package ui;

public class AddPerson extends Commands{
	public AddPerson(Console console){
		super(console);
	}
	
	@Override
	public String description(){
		return "Add person to the tree";
	}
	
	@Override
	public void run(){
		getConsole().addNote();
	}
}
