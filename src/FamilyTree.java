import java.util.ArrayList;
import java.util.Scanner;


public class FamilyTree {

    private ArrayList<Human> famyliTree = new ArrayList<>();

    public void addHuman(Human human) {
        famyliTree.add(human);
        if (human.getMother() != null)
            human.getMother().addChildren(human);

        if (human.getFather() != null)
            human.getFather().addChildren(human);
    }

    @Override
    public String toString() {
        return famyliTree.toString();
    }

    public void findHuman(){
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