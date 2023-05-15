package ui;

public class Exit extends Commands {
	public Exit(Console console) {
		super(console);
	}
	@Override
	public String description(){
		return "Exit the app";
	}
	
	@Override
	public void run(){
		getConsole().finish();
	}
	
}
