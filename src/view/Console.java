package view;

import model.FTImpersonal;
import presenter.Presenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Console<E extends FTImpersonal<E>> implements View{
	private Presenter presenter;
	private Scanner sc;
	private boolean work;
	private Menu menu;
	public Console(){
		presenter = new Presenter(this);
		sc = new Scanner(System.in);
		work = true;
		menu = new Menu(this);
	}

	@Override
	public void start() {

		while (work){
			System.out.println(menu.menu());
			String choice = sc.nextLine();
			int numChoice = Integer.parseInt(choice);
			menu.execute(numChoice);
			}
	}

	public void addM() {
		System.out.println("Введите фамилию:" );
		String lastName = sc.nextLine();
		System.out.println("Введите имя:" );
		String firstName = sc.nextLine();
		System.out.println("Введите пол (Male или Female):" );
		String gender = sc.nextLine();
		System.out.println("Введите дату рождения (ГГГГ-ММ-ДД):" );
		String birthDay = sc.nextLine();
		System.out.println("Введите фамилию и имя отца:" );
		String dad = sc.nextLine();
		System.out.println("Введите фамилию и имя матери:" );
		String mom = sc.nextLine();
		List<String> human = new ArrayList<>();
		Collections.addAll(human, firstName, lastName, gender, birthDay, dad, mom);
		presenter.addM(human);
	}

	public void getFamilyInfo(){
		presenter.getFamilyInfo();
	}

	public void sortByName(){
		presenter.sortByName();
	}

	public void sortByDate(){
		presenter.sortByDate();
	}

	public void finish(){
		System.out.println("Пока!");
		work = false;
	}

	@Override
	public void answer(String text) {
		System.out.println(text);
	}
}
