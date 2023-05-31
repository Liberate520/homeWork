package FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human olga = new Human("Ольга","Петрова", LocalDate.of(1992, 10, 16), Gender.жен );
        Human tamara = new Human("Тамара","Иванова", LocalDate.of(1997, 02, 14), Gender.жен );
        Human anna = new Human("Анна","Силаева", LocalDate.of(1971, 02, 25), Gender.жен );
        Human kirill = new Human("Кирилл","Силаев", LocalDate.of(1970, 04, 27), Gender.муж );

        olga.setFather(kirill);
        tamara.setFather(kirill);
        olga.setMother(anna);
        tamara.setMother(anna);
        kirill.addChildrens(olga);
        kirill.addChildrens(tamara);
        anna.addChildrens(olga);
        anna.addChildrens(tamara);

        FamilyTree family = new FamilyTree();
        family.addToFamily(olga);
        family.addToFamily(tamara);
        family.addToFamily(anna);
        family.addToFamily(kirill);

        System.out.println(family.findChildrens("Кирилл"));
    }
}