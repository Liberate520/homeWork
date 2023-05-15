package ui;

import presenter.Presenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Console implements View {
	private Scanner scanner;
	private Presenter presenter;
	private Menu menu;
	private boolean running;
	
	@Override
	public void start() {
		scanner = new Scanner(System.in);
		menu = new Menu(this);
		running = true;
		while (running){
			greetings();
			String command = scanner.nextLine();
			if (checkInput(command)){
				menu.run(Integer.parseInt(command));
			} else {
				System.out.println("Error");
			}
		}
	}
	
	private void greetings() {
		System.out.println(menu.openMenu());
	}
	public void finish(){
		running = false;
	}
	public void addNote() {
		System.out.println("Введите имя: ");
		String firstName = scanner.nextLine();
		List<String> person = new ArrayList<>();
		Collections.addAll(person, firstName);
		presenter.addNote(person.toString());
	}
	
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	@Override
	public void print(String text) {
		System.out.println(text);
	}
	private boolean checkInput(String text){
		return text.matches("[0-9]+");
	}
}
