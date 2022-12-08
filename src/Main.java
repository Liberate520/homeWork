

public class Main {
    public static void main(String[] args) {

        //interfaceFamilyTree familyTreePetrov = new FamilyTree();
        FamilyTree<Human> familyTreePetrov = new FamilyTree<>();
        
        
        Human human1 = new Human("Иван Петров", TypeGender.Male);
        Human human2 = new Human("Наталья Петрова", TypeGender.Female);
        Human human3 = new Human("Андрей Петров", TypeGender.Male);
        
        familyTreePetrov.add(human1);
        familyTreePetrov.add(human2);
        familyTreePetrov.add(human3);        

        human1.addCommunication(human3, TypeCommunication.Son);
        human2.addCommunication(human3, TypeCommunication.Son);        

        human1.showCommunication(TypeCommunication.Son); //Выводим сына
        familyTreePetrov.find(human1); // поиск конкретного чел
        familyTreePetrov.find("Иван"); // поиск по имени
        
        System.out.println(familyTreePetrov); // Выводим всю ветвь семьи списком
    }
}
