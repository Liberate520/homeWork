package GenerationTree.Presenter;

import GenerationTree.Person.FamilyTreeService;
import GenerationTree.Person.PersonIdGenerator;
import GenerationTree.Tree.Service;
import GenerationTree.ui.View;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
    }

    public void setTreeService(String name) {
        this.service = new FamilyTreeService();
        boolean loaded = this.service.loadTree(name);
        if (loaded) {
            view.print("Древо семьи " + name + " загружено из файла.");
        } else {
            this.service = new FamilyTreeService(name, new PersonIdGenerator());
            view.print("Файл с такой фамилией не найден... Создано новое древо семьи: " + name);
        }
    }
}