package Home;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FamilyTree Igor = new FamilyTree("Igor",35);
        FamilyTree Lida = new FamilyTree("Lida",35);
        FamilyTree Max = new FamilyTree("Max",15);
        FamilyTree Irina = new FamilyTree("Irina", 10);
        List<Human> latest_generation = new ArrayList<>();
        List<Human> latest_generation_sisters = new ArrayList<>();
        List<Human> latest_generation_brothers = new ArrayList<>();
        Max.setFather(Igor);
        Max.setMother(Lida);
        Irina.setMother(Lida);
        Irina.setFather(Igor);
        latest_generation.add(Max);
        latest_generation_brothers.add(Max);
        Max.setSisters(latest_generation_sisters);
        Irina.setBrothers(latest_generation_brothers);
        latest_generation.add(Irina);
        latest_generation_sisters.add(Irina);
        Igor.setChildrens(latest_generation);

//        System.out.println(Irina.getFatherDetails());
//        System.out.println(Irina.getMotherDetails());
//        System.out.println(Irina.getSisterDetails());
//        System.out.println(Irina.getBrothersDetails());
//        System.out.println(Irina);
//        System.out.println(Igor);
//        System.out.println(Igor.getChildrenDetails());
//        System.out.println(Lida.getName());

    }
}
