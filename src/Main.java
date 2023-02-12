public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree1 = new FamilyTree();

        Human human1 = new Human("Иван", Gender.male);
        Human human2 = new Human("Мария", Gender.female);
        Human human3 = new Human("Анна", Gender.female, human1, human2);
        Human human4 = new Human("Пётр", Gender.male, human1, human2);
        Human human5 = new Human("Владимир", Gender.male, human1, human2);
        Human human6 = new Human("Александр", Gender.male);
        Human human7 = new Human("Николай", Gender.male,human6,human3);
        Human human8 = new Human("Софья", Gender.female);


        // familyTree1.add(human1);
        // human4.addChild(human8);
        
        // System.out.println(familyTree1.toString());

        // for(int i=0;i<familyTree1.size();i++){
        //     System.out.println(familyTree1.get(i));
        // } 
        System.out.println(human1.getInfo());
        System.out.println(human7.getInfo());
    }
}
