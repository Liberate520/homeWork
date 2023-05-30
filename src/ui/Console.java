package ui;

import presenter.Presenter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

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
		while (running) {
			greetings();
			String command = scanner.nextLine();
			if (checkInput(command)) {
				menu.run(Integer.parseInt(command));
			} else {
				System.out.println("Error");
			}
		}
	}
	
	private void greetings() {
		System.out.println(menu.openMenu());
	}
	
	public void finish() {
		running = false;
	}
	
	public void addPerson() {
		System.out.println("Enter name: ");
		String firstName = scanner.nextLine();
		System.out.println("Enter lastname: ");
		String lastName = scanner.nextLine();
		List<String> person = new ArrayList<>();
		Collections.addAll(person, firstName, lastName);
		presenter.addPerson(person);
		System.out.println("Person added");
	}
	
	public void removePerson() {
		System.out.println("Enter ID to delete object: ");
		String strId = scanner.nextLine();
		try {
			int id = Integer.parseInt(strId);
			presenter.removePerson(id);
		}catch (NumberFormatException e){
			System.out.println("Incorrect Id");
		}
	}
	
	public void showTreeInfo() {
		presenter.showList();
	}
	
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	@Override
	public void print(String text) {
		System.out.println(text);
	}
	
	private boolean checkInput(String text) {
		return text.matches("[0-9]+");
	}
	
	public void searchPerson() {
		System.out.println("Enter lastname to search");
		String lastName = scanner.nextLine();
		presenter.searchPerson(lastName);
	}
	
	public void saveList() {
		System.out.println("Enter filename to save: ");
		String nameToFile = scanner.nextLine();
		presenter.saveList(nameToFile);
	}
	
	public void loadFile() {
		System.out.println("Enter filename to load from: ");
		String nameFile = scanner.nextLine();
		presenter.loadList(nameFile);
	}
	
	public void showList() {
		presenter.showList();
	}
}
