package GenerationTree.Presenter;

import java.time.LocalDate;

import GenerationTree.Person.FamilyTreeService;
import GenerationTree.Person.PersonIdGenerator;
import GenerationTree.Person.Structs.Gender;
import GenerationTree.Tree.Service;
import GenerationTree.ui.View;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
    }

    public void setTreeService(String name) {
        this.service = new FamilyTreeService(name, new PersonIdGenerator());
        this.service.addTreeItem("Анна", Gender.FEMALE, LocalDate.of(1970, 1, 1));

        view.print("Древо семьи " + name + " готово.\n         Дальнейший функционал в разработке...");
    }
}
