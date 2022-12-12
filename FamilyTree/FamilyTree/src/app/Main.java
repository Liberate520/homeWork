package app;

import people.*;
import research.Research;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FamilyTree humans= new FamilyTree(); // создала пустой список

        List<Humans> humans1;
        humans1 = new ArrayList<Humans>();

        humans1.add(new Kinship("Jon","Robert","brothers"));
        humans1.add(new Kinship("Kristina","Alisa","sisters"));
        humans1.add(new Kinship("Elvira","Diana","sisters"));
        humans1.add(new Kinship("Andrey","Anton","Andrey father and Anton"));

        System.out.println(humans1);
}
}