package home1.presenter;

import home1.model.FamilyTree;
import home1.model.Human;
import home1.ui.View;

public class Presenter {
    private View view;
    FamilyTree<Human> familyConnect;

    public Presenter(View view, FamilyTree<Human> familyConnect) {
        this.familyConnect = familyConnect;
        this.view = view;
        view.setPresenter(this);
    }

    public void addHumanNew() {
        System.out.print("Введите имя-> ");
        String name = view.scan();
        System.out.print("Введите пол(муж./жен.)-> ");
        String sex = view.scan();
        System.out.print("Введите возраст-> ");
        int age = Integer.parseInt(view.scan());
        System.out.println();
        familyConnect.addFamilyTree(new Human(name, sex, age));
        view.print("Новый член семьи добавлен !");
        view.print(familyConnect.getFamilyTree().get(familyConnect.getFamilyTree().size() - 1));
    }

    public void familyPrint() {
        view.print(familyConnect);
    }

    public void humanSearch() {
        System.out.print("Введите имя человека для поиска-> ");
        String name = view.scan();
        System.out.println(name);
        Human human = familyConnect.getByName(name);
        if (human == null)
            view.print("Такого человека нет в семье !");
        else
            view.print(human);
    }
}
