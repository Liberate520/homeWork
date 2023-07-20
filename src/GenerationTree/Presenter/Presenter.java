package GenerationTree.Presenter;

import GenerationTree.Model.Person.FamilyTreeService;
import GenerationTree.Model.Person.PersonIdGenerator;
import GenerationTree.Model.Tree.Service;
import GenerationTree.View.View;

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
            this.service.saveTree();
            view.print("Файл с такой фамилией не найден... Создано новое древо семьи: " + name);
        }
    }
}