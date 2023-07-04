public class Main {
    public static void main(String[] args){
        Human human1 = new Human(Gender.Male);
        human1.setName("father");
        System.out.println(human1.getName());
        Human human2 = new Human(Gender.Female);
        human2.setName("mother");
        System.out.println(human2.getName());
        Human human3 = new Human(Gender.Female);
        human3.setName("child");
        System.out.println(human3.getName());
    }
}