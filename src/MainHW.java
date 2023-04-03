public class MainHW {
    public static void main(String[] args) {
       Human member1 = new Human("Пирожков Артур"); 
       Human member2 = new Human("Пирожкова Анна"); 
       Human member3 = new Human("Пирожков Владимир", member2, member1); 
       Human member4 = new Human("Пирожкова Мария", member2, member1);

       FamilyTree familyTree1 = new FamilyTree();
       member1.addChild(member3);
       member2.addChild(member3);
       member1.addChild(member4);
       member2.addChild(member4);

       System.out.println("Children of " + member1.toString() + " : " + member1.printChildren());
       System.out.println("Children of " + member3.toString() + " : " + member3.printChildren());

       familyTree1.addHumanList(member1);
       familyTree1.addHumanList(member2);
       familyTree1.addHumanList(member3);
       familyTree1.addHumanList(member4);
       familyTree1.printHumanList();
    }
}