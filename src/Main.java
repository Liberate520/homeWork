
public class Main {
   public static void main(String[] args) {
      FamilyTree familyTree = new FamilyTree(123);
      
      Human human=new Human("Алексей",Gender.male,"22.05.1979");
      Human human1=new Human("Сергей", Gender.male,"06.04.2023");
      Human human2=new Human("Антон",Gender.male, "11.12.2021");

      Human human3=new Human("Фаина",Gender.female, "13.01.1949");
      Human human4=new Human("Валерий",Gender.female, "13.01.1947","14.11.2020");

      familyTree.addHuman(human);
      familyTree.addHuman(human1);
      familyTree.addHuman(human2);
      familyTree.addHuman(human3);
      familyTree.addHuman(human4);
      System.out.println(familyTree.getHumansInfo());

      
      human.addCildren(human1);
      human.addCildren(human2);
      System.out.println(human.getCildren());

      human3.addCildren(human);
      System.out.println(human3.getCildren());

      human4.addCildren(human);
      System.out.println(human4.getCildren());
      
      
      //System.out.println(human);
      familyTree.addCildren(human1, human2);
      
      

        
   }
}
