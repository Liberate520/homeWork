package HomeWork5;

import java.io.IOException;

import HomeWork5.model.FamilyFree;
import HomeWork5.model.Human;
import HomeWork5.model.IO;
import HomeWork5.model.comporator.HumanComporatorByAge;
import HomeWork5.presenter.Presenter;
import HomeWork5.ui.Console;
import HomeWork5.ui.View;

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        FamilyFree<Human> familyFree = new FamilyFree<>();

        familyFree.addFamilyFree(new Human("Майк", "муж.", 37));
        familyFree.addFamilyFree(new Human("Алекс", "муж.", 35));
        familyFree.addFamilyFree(new Human("Аннет", "жен.", 27));
        familyFree.addFamilyFree(new Human("Сири", "муж.", 7, 
            familyFree.getByName("Аннет"), familyFree.getByName("алекс"))); 
        familyFree.addFamilyFree(new Human("Кейт", "жен.", 5, 
            familyFree.getByName("Аннет"), familyFree.getByName("алекс")));
        
        // Модуль MVP
        View view = new Console();
        IO serializ = new IO();
        HumanComporatorByAge sortAge =  new HumanComporatorByAge();
        new Presenter(view, familyFree, serializ, sortAge);
        view.start();
    }
    
}
