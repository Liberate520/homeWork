package HomeWork5;

import HomeWork5.model.FamilyFree;
import HomeWork5.model.Human;
import HomeWork5.presenter.Presenter;
import HomeWork5.ui.Console;
import HomeWork5.ui.View;

public class Main 
{
    public static void main(String[] args)
    {
        FamilyFree<Human> familyFree = new FamilyFree<>();
        familyFree.addFamilyFree(new Human("Алекс", "муж.", 35));
        familyFree.addFamilyFree(new Human("Аннет", "жен.", 27));
        familyFree.addFamilyFree(new Human("Сири", "муж.", 7, 
            familyFree.getByName("Аннет"), familyFree.getByName("алекс"))); // equalsIgnoreCase
        familyFree.addFamilyFree(new Human("Кейт", "жен.", 5, 
            familyFree.getByName("Аннет"), familyFree.getByName("алекс")));
        //теперь родителей можно добавлять переменными(в предыдущем задании так) либо методом getByName !
        //родители добовлются автоматически ( и дети родителям тоже )

        familyFree.addFamilyFree(new Human("Алиса", "жен.", 3));
        familyFree.getByName("Алекс").addChild(familyFree.getByName("Алиса"));
        //конструкция говорит о том что Алекс завел ребекна на стороне :D

        // Модуль MVP
        View view = new Console();
        new Presenter(view, familyFree);
        view.start();
    }
    
}
