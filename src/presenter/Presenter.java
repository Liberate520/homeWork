package presenter;

import model.FTImpersonal;
import model.FamilyTree;
import model.Gender;
import model.Human;
import model.service.Service;
import view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Presenter<E extends FTImpersonal<E>> {
	private View view;
	private Service service;
	public Presenter(View view) {
		this.view = view;
		service = new Service();
	}

	public void sortByName() {
		service.sortByName();
		getInfo();
	}

	public void sortByDate() {
		service.sortByBirthDay();
		getInfo();
	}

	public void addM(String lastName, String firstName, Gender gender, LocalDate birthDay, String nameDad, String firstNameDad, String nameMom, String firstNameMom) {
		service.addM(lastName, firstName, gender, birthDay, new Human(nameDad, firstNameDad, gender), new Human(nameMom, firstNameMom, gender));
		getInfo();
	}
	public void getInfo(){
		String textInfo = service.getInfo();
		view.answer(textInfo);
	}

	public void writeF(String file) throws IOException {
		service.writeF(file);
	}

	public void readF(String file) throws IOException, ClassNotFoundException {
		service.readF(file);
	}
}

