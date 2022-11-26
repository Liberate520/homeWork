import java.util.ArrayList;
import java.util.List;

public class Tree{
    static List<Human> familyTree = new ArrayList<>();
    int idCount;
    int marregeCount;
    public List<Pets> pets;

     public void createFamilyHeader(String name, String data, String gender){
        Human p = new Human(name,  data, gender,  null, null);
        p.setId(idCount);
        idCount+=1;
        familyTree.add(p);
    }

    public void born(Human father, Human mother, String name, String data, String gender){
        Human p = new Human(name, data, gender, father, mother); //дата рождения
        p.setId(idCount);
        father.addChildren(p);
        mother.addChildren(p);
        familyTree.add(p);
        idCount+=1;
    }
    public void marrage(Human husbend, Human wife){
        marregeCount+=1;
        husbend.setMarrageNo(marregeCount);
        wife.setMarrageNo(marregeCount);
    }
    public Human getPerson(String name, String data){ //дата рождения
        ArrayList<Human> findList = new ArrayList<>();
        for (Human test : familyTree) {
            if (test.getName() == name && test.getData() == data) {
                findList.add(test);
            }
        }
        return findList.get(0);
    }
    public void Print(){
        for (int i = 0; i < familyTree.size(); i++) {
            System.out.println(familyTree.get(i).toString());
        }
    }
    public void Print2(String name){
        ArrayList<Human> findList = new ArrayList<>();
        for (Human test : familyTree) {
            if (test.getName() == name){
                findList.add(test);
            }
        }
        for (int i = 0; i < findList.size(); i++) {
            System.out.println(findList.get(i));

        }

    }
//    public void petFamily(String name, String type, Human master){
//        Pets p = new Pets(name, type, master);
//        p.setIdPets(master.getId());
//        pets.add(p);
//     }

}
