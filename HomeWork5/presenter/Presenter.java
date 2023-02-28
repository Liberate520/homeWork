package HomeWork5.presenter;

import HomeWork5.model.FamilyFree;
import HomeWork5.model.Human;
import HomeWork5.ui.View;

public class Presenter 
{
    private View view;
    private FamilyFree<Human> familyConnect;

    public Presenter(View view, FamilyFree<Human> familyConnect) 
    {
        this.familyConnect = familyConnect;
        this.view = view;
        view.setPresenter(this);
    }

    public void addHumanNew(String name, String sex, int age)
    {        
        familyConnect.addFamilyFree(new Human(name, sex, age));
        view.print("Новый член семьи добавлен !");
    }

    public void familyPrint() 
    {
        view.print(familyConnect);       
    }

    public void humanSearch(String name) 
    {
        Human chelovek = familyConnect.getByName(name);
        if (chelovek == null) view.print("Такого человека нет в семье !");
        else view.print(chelovek);
    }
}
