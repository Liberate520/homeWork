import presenter.Presenter;
import service.Service;
import tree.FamilyTree;
import ui.Console;
import ui.View;

public class Main {
	public static void main(String[] args) {
		FamilyTree familyTree = new FamilyTree();
		Service service = new Service(familyTree);
//
		View view = new Console();
		Presenter presenter = new Presenter(view, service);
		view.start();
	}
}
