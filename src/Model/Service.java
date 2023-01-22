package Model;

import Model.tree.Cat;
import Model.tree.Container;
import Model.tree.Gender;
import Model.tree.Human;

public class Service {

    Container menuContainer;

    public Service() {
        this.menuContainer = new Container<>();
    }

    public void CreateButtonOnClick(String name) {
        System.out.println("Выполнена команда создать " + name);
    }

    public void SaveButtonOnClick(String name) {
        System.out.println("Выполнена команда сохранить " + name);
    }

    public void ExitButtonOnClick(){
        System.exit(0);
    }

    public void CreateCatButtonOnClick(String name, Gender gender, Integer age){
        Cat cat = new Cat(name, gender, age);
        System.out.println();
        System.out.println(cat);
        this.menuContainer.getContainer().add(cat);
    }

    public void CreateHumanButtonOnClick(String name, Gender humanGender, Integer humanAge) {
        Human human = new Human(name, humanGender, humanAge);
        System.out.println();
        System.out.println(human);
        this.menuContainer.getContainer().add(human);
    }

    public void PrintContainerButtonOnClick() {
        System.out.println(this.menuContainer);
    }
}
