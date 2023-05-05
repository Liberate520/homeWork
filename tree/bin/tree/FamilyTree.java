public class FamilyTree {
    public static void main(String[] args) {
    Parent father = new Parent("Сергей", 'M', "01/01/1970");
    Parent mother = new Parent("Оля", 'F', "02/02/1970");
    Child son = new Child("Ваня", 'M', "03/03/1995");
    Child daughter = new Child("Наташа", 'F', "04/04/1997");
        father.addChild(son);
        father.addChild(daughter);
        mother.addChild(son);
        mother.addChild(daughter);
        son.setMother(mother);
        son.setFather(father);
        daughter.setMother(mother);
        daughter.setFather(father);
    
        System.out.println("Father: " + father.getName());
        System.out.println("Mother: " + mother.getName());
        System.out.println("Children:");
        for (Person child : father.getChildren()) {
            System.out.println("- " + child.getName());
        }
    }
    }