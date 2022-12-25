package Homework_002;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        FamilyTree familyTree = new FamilyTree();
        Human human0= new Human("Иван", "м");
        Human human1= new Human("Мария", "ж");
        Human human2= new Human("Петр", "м");
        Human human3= new Human("Николай", "м", "12.01.1990");
        Human human4= new Human("Ирина", "ж", "15.02.1992");
        human0.setParent(human2);
        human3.setParent(human0);
        human3.setParent(human1);
        human4.setParent(human1);
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

        
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
            new FileOutputStream("Homework_002\\familyTree.out"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
           
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("Homework_002\\familyTree.out"));
        FamilyTree familyTreeRestored = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();

        
        Research research2 = new Research(familyTreeRestored, human4);
        System.out.println("\nВосстановленные:");
        System.out.println("Братья " + human4.getName()+ " :" + research2.getBrothers());
        System.out.println("\n");
        System.out.println(familyTreeRestored.getAll());



    }
}