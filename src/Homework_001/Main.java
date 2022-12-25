package Homework_001;

public class Main {
    public static void main(String[] args)  {
        
        FamilyTree familyTree = new FamilyTree();
        Human human0= new Human("Иван", "м");
        Human human1= new Human("Мария", "ж");
        Human human2= new Human("Петр", "м");
        Human human3= new Human("Николай", "м", "12.01.1990");
        Human human4= new Human("Ирина", "ж", "15.02.1992");
        human0.setRelationship(human2);
        human3.setRelationship(human0);
        human3.setRelationship(human1);
        human4.setRelationship(human1);
        familyTree.add(human0);
        familyTree.add(human1);
        familyTree.add(human2);
        familyTree.add(human3);
        familyTree.add(human4);  

        Research research1 = new Research(familyTree, human4);
        
        System.out.println("Записанные в файл:");
        System.out.println("Братья " + human4.getName()+ " :" + research1.getBrothers());
        System.out.println("\n");
        System.out.println(familyTree.getAll());

        
        
        
       

    }
}