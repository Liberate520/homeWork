package HomeWork5;

import java.io.IOException;

import HomeWork5.model.FamilyFree;
import HomeWork5.model.Human;
import HomeWork5.model.IO;  
import HomeWork5.presenter.Presenter;
import HomeWork5.ui.Console;
import HomeWork5.ui.View;

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        FamilyFree<Human> familyFree = new FamilyFree<>();

        familyFree.addFamilyFree(new Human("Иван", "муж.", 32));
        familyFree.addFamilyFree(new Human("Аня", "жен.", 29));
        familyFree.addFamilyFree(new Human("Миша", "муж.", 6, 
            familyFree.getByName("Аня"), familyFree.getByName("Иван"))); 
        familyFree.addFamilyFree(new Human("Кейт", "жен.", 5, 
            familyFree.getByName("Аня"), familyFree.getByName("Иван")));

        IO save = new IO();              
        familyFree.saveObj(save);     
        save.load("FreeFamily.data");
        
        View view = new Console();
        new Presenter(view, familyFree);
        view.start();
    }
    
}