package DZ.DZ2;

public class Main {
    public static void main(String[] args) {

        //interfaceFamilyTree familyTreePetrov = new FamilyTree();
        FamilyTree familyTreePetrov = new FamilyTree();
        
        
        Human human1 = new Human("Иван Петров", TypeGender.Male);
        Human human2 = new Human("Наталья Петрова", TypeGender.Female);
        Human human3 = new Human("Андрей Петров", TypeGender.Male);
        
        familyTreePetrov.addHuman(human1);
        familyTreePetrov.addHuman(human2);
        familyTreePetrov.addHuman(human3);        

        human1.addCommunication(human3, TypeCommunication.Son);
        human2.addCommunication(human3, TypeCommunication.Son);        

        human1.showCommunication(TypeCommunication.Son); //Выводим сына
        familyTreePetrov.findHuman(human1); // поиск конкретного чел
        familyTreePetrov.findHuman("Иван"); // поиск по имени
        
        System.out.println(familyTreePetrov); // Выводим всю ветвь семьи списком
    }
}
