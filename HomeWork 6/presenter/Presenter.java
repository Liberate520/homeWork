package HomeWork5.presenter;

import HomeWork5.model.FamilyFree;
import HomeWork5.model.Human;
import HomeWork5.model.IO;
import HomeWork5.model.comporator.HumanComporatorByAge;
import HomeWork5.ui.View;

public class Presenter 
{
    private View view;
    private IO serializ;
    private FamilyFree<Human> familyConnect;
    private HumanComporatorByAge sortAge;

    public Presenter(View view, FamilyFree<Human> familyConnect, IO serializ, HumanComporatorByAge sortAge) 
    {
        this.familyConnect = familyConnect;
        this.view = view;
        this.serializ = serializ;
        this.sortAge = sortAge;
        view.setPresenter(this);
    }

    public void addHumanNew(String name, String sex, int age)
    {        
        familyConnect.addFamilyFree(new Human(name, sex, age));
        view.print("Новый член семьи добавлен !");
    }

    public void familyPrint() 
    {
        String family = familyConnect.toString();
        view.print(family);       
    }

    public void humanSearch(String name) 
    {
        Human chelovek = familyConnect.getByName(name);
        if (chelovek == null) view.print("Такого человека нет в семье !");
        
        else 
        {
            String human = chelovek.toString();
            view.print(human);
        }
    }

    public void saveFamily()
    {
        familyConnect.saveObj(serializ);
        view.print("Семейное древо сохранено !");
    }

    public void loadFamily()
    {
        serializ.load("FreeFamily.data");
    }

        public void sortFamily(int choice)
        {
            if (choice == 1) { familyConnect.getFamilyFree().sort(null); }
            else             { familyConnect.getFamilyFree().sort(sortAge); }
            view.print("Сортировка завершена !");
        }
}
