package menu;

import buttons.MenuButton;
import tree.*;

public class Model {
    //метод Create на case

    public Cat CreateCat(){
        Cat cat = new Cat("Cat", Gender.Male, 3);

        return cat;
    }

    public Cat CreateHuman(){
        Cat human = new Cat("Human", Gender.Female, 27);

        return human;
    }
}
