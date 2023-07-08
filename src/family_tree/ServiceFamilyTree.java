package family_tree;

import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.marriage.Marriage;

import java.time.LocalDate;

public class ServiceFamilyTree {
    private int idHuman, idMarriage;
    private FamilyTree tree;

    public ServiceFamilyTree(){
        tree = new FamilyTree();
    }

    public Human addHuman(String name, LocalDate dateBirth, Gender gender){
        Human h = new Human(idHuman++, name, dateBirth, gender);
        tree.addHuman(h);
        return h;
    }
    //регистрируем брак и возвращаем ссылку на экземпляр
    //Если нарушены условия, return null
    public Marriage addMarriage(LocalDate startDate, Human wife, Human husband){
        Marriage m = new Marriage(idMarriage, startDate, wife, husband);
        if(m.getIsError()) return null;
        tree.addMarriage(m);
        idMarriage++;
        return m;
    }
    // добавляем связь родитель - потомок
    public boolean addChild(Human parent, Human child){
        return parent.addChild(child);
    }
    public boolean addChild(int idParent, int idChild){
        Human parent = getHumanById(idParent);
        if(parent==null) return false;
        Human child = getHumanById(idChild);
        if(child==null) return false;
        return parent.addChild(child);
    }
    //return null, если список пуст либо id вне имеющихся
    public Human getHumanById(int id){
        return tree.getHumanById(id);
    }

    //return null, если список пуст либо id вне имеющихся
    public Marriage getMarriageById(int id){
        return tree.getMarriageById(id);
    }

    public boolean stopMarriageById(int id, LocalDate date){
        Marriage m = tree.getMarriageById(id);
        if(m == null) return false; // брак не найден
        return !m.stop(date);
    }

    public String getHumansInfo(){
        return tree.getHumansInfo();
    }
    public String getMarriagesInfo(){
        return tree.getMarriagesInfo();
    }

    public void sortHumansByName(){
        tree.sortHumansByName();
    }
    public void sortHumansByAge(){
        tree.sortHumansByAge();
    }

    public String getInfoAll(){
        return tree.getInfoAll();
    }

    public FamilyTree getTree(){
        return tree;
    }
}
