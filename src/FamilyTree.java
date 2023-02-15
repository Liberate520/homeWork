import java.util.*;

public class FamilyTree {
    Set<Human> family;

    public FamilyTree() {
        this.family = new HashSet<>();
    }
    public void adHuman(Human human){
        this.family.add(human);
    }
    public Human search(String name){
        for(Human human : family){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }
    public void inputAndAddChild(){
        Human humanToAdd = new Human();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name to add: ");
        humanToAdd.setName(sc.nextLine());
        System.out.println("Enter sex (male/female) : ");
        if(sc.nextLine().equalsIgnoreCase("male")){
            humanToAdd.setGender(Gender.MALE);
        } else {
            humanToAdd.setGender(Gender.FEMALE);
        }
        Calendar calendar = new GregorianCalendar();
        System.out.println("Enter year of birth : ");
        calendar.set(Calendar.YEAR, sc.nextInt());
        System.out.println("Enter month of of birth (0-11): ");
        calendar.set(Calendar.MONTH, sc.nextInt());
        System.out.println("Enter day of birth : ");
        calendar.set(Calendar.DAY_OF_MONTH, sc.nextInt());
        humanToAdd.setDateOfBirth(new GregorianCalendar());

        System.out.println("Enter year of death : ");
        calendar.set(Calendar.YEAR, sc.nextInt());
        System.out.println("Enter month of of death (0-11): ");
        calendar.set(Calendar.MONTH, sc.nextInt());
        System.out.println("Enter day of death : ");
        calendar.set(Calendar.DAY_OF_MONTH, sc.nextInt());
        humanToAdd.setDateOfDeath(new GregorianCalendar());

        boolean found = false;
        Human father = new Human();
        Human mother = new Human();
        sc.nextLine();
        while(!found){
            System.out.println("Enter valid father name : ");
            father = search(sc.nextLine());
            if (father != null){
                humanToAdd.setFather(father);
                found = true;
            }
        }
        found = false;
        while(!found){
            System.out.println("Enter valid mother name : ");
            mother = search(sc.nextLine());
            if (mother != null){
                humanToAdd.setMother(mother);
                found = true;
            }
        }
        humanToAdd.setChildren(new HashSet<Human>());
        family.add(humanToAdd);
        father.adChild(humanToAdd);
        mother.adChild(humanToAdd);
    }

    @Override
    public String toString() {
        String str = new String();
        for(Human human : family) {
            str = str + human.toString();
        }
        return str + "\n";
    }
}
