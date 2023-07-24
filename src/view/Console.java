package view;

import model.FTImpersonal;
import model.Gender;
import model.Human;
import model.HumanIterator;
import presenter.Presenter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Console implements View{
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
	public void start() throws IOException, ClassNotFoundException {
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
		Gender gender = Gender.valueOf(sc.nextLine());
		System.out.println("Введите дату рождения (ГГГГ-ММ-ДД):" );
		LocalDate birthDay = LocalDate.parse(sc.nextLine());
		System.out.println("Введите фамилию отца:" );
		String nameDad = sc.nextLine();
		System.out.println("Введите имя отца:" );
		String firstNameDad = sc.nextLine();
		System.out.println("Введите фамилию матери:" );
		String nameMom = sc.nextLine();
		System.out.println("Введите имя матери:" );
		String firstNameMom = sc.nextLine();
		presenter.addM(firstName, lastName, gender, birthDay, nameDad, firstNameDad, nameMom, firstNameMom);
	}

	public void getFamilyInfo(){
		presenter.getInfo();
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

	public void writeF() throws IOException {
		System.out.println("Введите имя файла для записи данных:" );
		String file = sc.nextLine();
		presenter.writeF(file);
		System.out.println("Данные успешно записаны в файл " + file);
	}

	public void readF() throws IOException, ClassNotFoundException {
		System.out.println("Введите имя файла для загрузки данных:" );
		String file = sc.nextLine();
		presenter.readF(file);
		System.out.println("Данные успешно загружены из файла " + file);
		presenter.getInfo();
	}
}
