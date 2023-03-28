import java.util.ArrayList;
import java.util.Scanner;

public class FamilyTree {

    private ArrayList<Person> famyliTree = new ArrayList<>();

    public void addPerson(Person person) {
        famyliTree.add(person);
        if (person.getMother() != null)
            person.getMother().addChildrens(person);
            
        if (person.getFather() != null)
            person.getFather().addChildrens(person);
    }

    @Override
    public String toString() {
        return famyliTree.toString();
    }

    public void findPerson(){
        System.out.println("Введите имя или фамилию для поиска:");
        Scanner iScanner=new Scanner(System.in, "cp866");
        String findName=iScanner.nextLine();
        boolean find=false;
        for (int i = 0; i < famyliTree.size(); i++) {
            if (famyliTree.get(i).getName().contains(findName)) {
                System.out.println(famyliTree.get(i));
                find=true;
            }    
        }
        if (!find) System.out.println("Такой человек не найден.");
    }
}
