public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Mikhail", Gender.MALE, "06.06.1984");
        Human human2 = new Human("Ekaterina", Gender.FEMALE, "18.07.1987");
        Human human3 = new Human("Kirill", Gender.MALE, "25.12.2008");
        Human human4 = new Human("Elizaveta", Gender.FEMALE, "19.08.2016");

        FamilyTree family = new FamilyTree();
        family.addFather(human1);
        family.addMother(human2);
        if (family.getFamilyMembers().contains(human1)) {
            human3.setFatherName(human1.getName());
            family.addSon(human3);
        } else {
            System.out.println("Error: Father not found in the family tree.");
        }
        if (family.getFamilyMembers().contains(human1)) {
            human4.setFatherName(human1.getName());
            family.addDaughter(human4);
        } else {
            System.out.println("Error: Father not found in the family tree.");
        }

        System.out.println(human1.getName() + " - " + human1.getGender() + ", birthDate" + human1.getBirthDate());
    }
}