import java.time.LocalDate;

import ru.gb.family_tree.*;
import ru.gb.vending_machine.*;

public class Main {
    
    public static void main(String[] args) {
        FamilyTree ft = new FamilyTree();
        Human im  = new Human("Хаустов", "Евгений", "Владимирович", Gender.Male.toString(), LocalDate.of(1996, 05, 06));
        Human mom = new Human("Хаустова", "Юлия", "Юрьевна", Gender.Female.toString(), LocalDate.of(1976, 02, 03));
        Human grandMom = new Human("Хаустова", "Александра", "Владимировна", Gender.Female.toString(), LocalDate.of(1955, 10, 11));

        mom.addChildrenInfo(im);
        grandMom.addChildrenInfo(mom);

        ft.addHuman(im);
        ft.addHuman(mom);
        ft.addHuman(grandMom);

        ft.getHumans();

        System.out.println(mom.childrens());
        System.out.println(grandMom.childrens());
    }

    public void vendingMachine() {
        VendingMachine vm1 = new VendingMachine(1);
        System.out.println(vm1);
    }

}
