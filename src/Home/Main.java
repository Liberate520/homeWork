package Home;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human igor = new Human("Igor",35);
        Human lida = new Human("Lida",35);
        Human max = new Human("Max",15);
        Human irina = new Human("Irina", 10);
        Human victoriya = new Human("Victoriya",65);
        Human vyacceslav = new Human("Vyacceslav",65);
        Human sergey = new Human("Sergey",65);
        Human liza = new Human("Liza",65);
        List<Human> latest_generation = new ArrayList<>();
        List<Human> latest_generation_sisters = new ArrayList<>();
        List<Human> latest_generation_brothers = new ArrayList<>();
//        lida.setMother(victoriya);
//        lida.setFather(vyacceslav);
//        igor.setFather(sergey);
//        igor.setMother(liza);
//        max.setFather(igor);
//        max.setMother(lida);
//        irina.setMother(lida);
//        irina.setFather(igor);
//        latest_generation.add(max);
//        latest_generation_brothers.add(max);
//        max.setSisters(latest_generation_sisters);
//        irina.setBrothers(latest_generation_brothers);
//        latest_generation.add(irina);
//        latest_generation_sisters.add(irina);
//        igor.setChildrens(latest_generation);
        FamilyTree familyTree = new FamilyTree();
//        System.out.println(irina.getFatherDetails());
//        System.out.println(irina.getMotherDetails());
//        System.out.println(irina.getSisterDetails());
//        System.out.println(irina.getBrothersDetails());
//        System.out.println(lida.getGrandfatherDetails());
//        familyTree.FamilyTreeSave(liza);

        familyTree.FamilyTreeload(irina);

//        familyTree.FamilyTreeload(irina);
//        familyTree.getHumanInfo(irina);
//        System.out.println(igor.getChildrenDetails());
//        System.out.println(lida.getName());

    }


}
