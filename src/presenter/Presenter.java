package presenter;

import common.FTImpersonal;
import human.Gender;
import human.Human;
import model.FamilyTree;
import view.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter<E extends FTImpersonal<E>> {
	private View view;
	private FamilyTree familyTree;
	public Presenter(View view) {
		this.view = view;
		familyTree = new FamilyTree<>();
	}

	public void addM(List<String> human) {
		familyTree.add(new Human(human.get(0),human.get(1),
				Gender.valueOf(human.get(2)),
				LocalDate.parse(human.get(3)),
				(Human) familyTree.getByName(human.get(4)),
				(Human) familyTree.getByName(human.get(5))));
		view.answer(familyTree.getInfo());
	}

	public void getFamilyInfo(){
		view.answer(familyTree.getInfo());
	}
	public void sortByName() {
		familyTree.sortByName();
		getFamilyInfo();
	}

	public void sortByDate() {
		familyTree.sortByBirthDay();
		getFamilyInfo();
	}
}
