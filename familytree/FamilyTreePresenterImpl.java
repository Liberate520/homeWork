package homeWork.familytree;

import java.time.LocalDate;
import java.util.List;

public class FamilyTreePresenterImpl implements FamilyTreePresenter {
    private FamilyTreeModel model;
    private FamilyTreeView view;

    public FamilyTreePresenterImpl(FamilyTreeModel model, FamilyTreeView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onAddMember(String name, String dateOfBirth, Human.Gender gender) {
        LocalDate dob = LocalDate.parse(dateOfBirth);
        Human member = new Human(name, dob, gender);
        model.addMember(member);
    }

    @Override
    public void onDisplayFamilyTree() {
        List<Human> members = model.getAllMembers();
        view.showMembers(members);
    }

    // Implement other methods to handle user interactions and updates
}
