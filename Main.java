import java.util.jar.Attributes.Name;

public class Main {
    public static void main(String[] args) {
        Human human = new Human("Смирнов Василий Степанович", "25.05.1988", "Смирнова Антонина Васильевна", "Смирнов Степан Юрьевич", "Смирнова Анна Игоревна", "Смирнов Антон Васильевич");

        Wife wife = new Wife("Смирнова Анна Игоревна", "01.04.1988", "Петрова Татьяна Ивановна", "Петров Игорь Иванович", "Смирнов Василий Степанович", "Смирнов Антон Васильевич");

        FamilyTree familyTree = new FamilyTree();
        familyTree.addHuman(human);
        
       
        System.out.println(human);
        System.out.println(wife);

    
    }

}