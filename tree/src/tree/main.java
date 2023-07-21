package tree;
public class main {
    public static void main(String[] args) {
        Parent father = new Parent("John", 'M', "01/01/1970");
        Parent mother = new Parent("Jane", 'F', "02/02/1970");
        Child son = new Child("Tom", 'M', "03/03/1995");
        Child daughter = new Child("Emily", 'F', "04/04/1997");

        father.addChild(son);
        father.addChild(daughter);
        mother.addChild(son);
        mother.addChild(daughter);
        son.setMother(mother);
        son.setFather(father);
        daughter.setMother(mother);
        daughter.setFather(father);

        System.out.println("Father: " + father.name);
        System.out.println("Mother: " + mother.name);
        System.out.println("Children:");
        for (Person child : father.children) {
            System.out.println("- " + child.name);
        }
    }
}
