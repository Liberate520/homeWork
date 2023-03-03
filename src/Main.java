import Model.FamilyFree;
import Model.Human;
import presenter.Presenter;
import Viev.Console;
import Viev.View;

public class Main {
    public static void main(String[] args) {
        FamilyFree<Human> familyFree = new FamilyFree<>();
        familyFree.addFamilyFree(new Human("Игорь", "муж.", 35));
        familyFree.addFamilyFree(new Human("Алекс", "жен.", 27));
        familyFree.addFamilyFree(new Human("Павел", "муж.", 7,
                familyFree.getByName("Анна"), familyFree.getByName("алекс")));
        familyFree.addFamilyFree(new Human("Катя", "жен.", 5,
                familyFree.getByName("Вова"), familyFree.getByName("алекс")));

        familyFree.addFamilyFree(new Human("Григорий", "жен.", 333));
        familyFree.getByName("Алекс").addChild(familyFree.getByName("Алиса"));

        View view = new Console();
        new Presenter(view, familyFree);
        view.start();
    }
}