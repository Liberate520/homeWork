package presenter;

import service.Service;
import ui.View;

import java.util.List;

public class Presenter {
	private View view;
	private Service service;
	
	public Presenter(View view, Service service) {
		this.view = view;
		this.service = service;
		view.setPresenter(this);
	}
 	public void addPerson(List<String> person) {
		if (person != null && person.size() >= 2) {
			service.addPerson(person.get(0), person.get(1));
		}
	}
 	public void removePerson(int id) {
		if (service.removePerson(id)) {
			StringBuilder sb = new StringBuilder();
			sb.append("Information removed");
			view.print(sb.toString());
		}
		else {
			StringBuilder sb = new StringBuilder();
			sb.append("Unable to remove information by this ID");
			view.print(sb.toString());
		}
	}
 	public void searchPerson(String lastName) {
		if (lastName != null) {
			StringBuilder sb = new StringBuilder();
			sb.append(service.searchPerson(lastName).toString());
			view.print(sb.toString());
		}
	}
 	public void saveList(String nameToFile) {
		if (nameToFile != null) {
			service.saveFamilyGroup(nameToFile);
			StringBuilder sb = new StringBuilder();
			sb.append("Information saved");
			view.print(sb.toString());
		}
	}
 	public void loadList(String nameFile) {
		if (nameFile != null) {
			service.loadFamilyGroup(nameFile);
			StringBuilder sb = new StringBuilder();
			sb.append("Information loaded");
			view.print(sb.toString());
		}
	}
 	public void showList() {
		StringBuilder sb = new StringBuilder();
		sb.append(service.getFamilyGroup().toString());
		view.print(sb.toString());
	}
}
