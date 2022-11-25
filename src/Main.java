package DZ.DZ1;

public class Main {
    public static void main(String[] args) {

        //List<FamilyTree> familyTreePetrov  = new ArrayList<>();
        FamilyTree familyTreePetrov = new FamilyTree(); // Так более правильно?
        //List<Human> listHuman = new ArrayList<>();
        
        Human human1 = new Human("Иван Петров", TypeGender.Male);
        Human human2 = new Human("Наталья Петрова", TypeGender.Female);
        Human human3 = new Human("Андрей Петров", TypeGender.Male);
        
        familyTreePetrov.addHuman(human1);
        familyTreePetrov.addHuman(human2);
        //listHuman.add(human1);

        human1.addCommunication(human3, TypeCommunication.Son);
        human2.addCommunication(human3, TypeCommunication.Son);
        human3.addCommunication(human1, TypeCommunication.Father);

        human1.showCommunication(TypeCommunication.Son); //Выводим сына
        
        System.out.println(familyTreePetrov); // Выводим всю ветвь семьи списком
        //System.out.println(listHuman);
    }
}
