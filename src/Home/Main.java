package Home;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FamilyTree igor = new FamilyTree("Igor",35);
        FamilyTree lida = new FamilyTree("Lida",35);
        FamilyTree max = new FamilyTree("Max",15);
        FamilyTree irina = new FamilyTree("Irina", 10);
        FamilyTree victoriya = new FamilyTree("Victoriya",65);
        FamilyTree vyacceslav = new FamilyTree("Vyacceslav",65);
        FamilyTree sergey = new FamilyTree("Sergey",65);
        FamilyTree liza = new FamilyTree("Liza",65);
        List<Human> latest_generation = new ArrayList<>();
        List<Human> latest_generation_sisters = new ArrayList<>();
        List<Human> latest_generation_brothers = new ArrayList<>();
        lida.setMother(victoriya);
        lida.setFather(vyacceslav);
        igor.setFather(sergey);
        igor.setMother(liza);
        max.setFather(igor);
        max.setMother(lida);
        irina.setMother(lida);
        irina.setFather(igor);
        latest_generation.add(max);
        latest_generation_brothers.add(max);
        max.setSisters(latest_generation_sisters);
        irina.setBrothers(latest_generation_brothers);
        latest_generation.add(irina);
        latest_generation_sisters.add(irina);
        igor.setChildrens(latest_generation);

//        System.out.println(irina.getFatherDetails());
//        System.out.println(irina.getMotherDetails());
//        System.out.println(irina.getSisterDetails());
//        System.out.println(irina.getBrothersDetails());
//        System.out.println(lida.getGrandfatherDetails());
        System.out.println(max);
//        System.out.println(igor.getChildrenDetails());
//        System.out.println(lida.getName());

    }
}
