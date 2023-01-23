package relationFamilyTree;

import enums.Gender;
import models.Human;

public class Relationships {
    static String getRelationships(Human a, Human b) {
        if (
            (a.getSpouse() != null && a.getSpouse().equals(b))
            || (b.getSpouse() != null && b.getSpouse().equals(a))
        ) {
            return a.getGender() == Gender.MAN ? "Муж" : "Жена";
        }

        if (a.getParentMother() != null && a.getParentMother().equals(b.getParentMother())) {
            return a.getGender() == Gender.MAN ? "Брат" : "Сестра";
        }

        if (
            (
                a.getParentMother() != null
                &&  (
                    (
                        a.getParentMother().getParentMother() != null
                        && a.getParentMother().getParentMother().equals(b)
                    )
                    || (
                        a.getParentMother().getParentFather() != null
                        && a.getParentMother().getParentFather().equals(b)
                    )
                )
            ) 
            || (
                a.getParentFather() != null
                &&  (
                    (
                        a.getParentFather().getParentMother() != null
                        && a.getParentFather().getParentMother().equals(b)
                    )
                    || (
                        a.getParentFather().getParentFather() != null
                        && a.getParentFather().getParentFather().equals(b)
                    )
                )
            )
        ) {
            return a.getGender() == Gender.MAN ? "Внук" : "Внучка";
        } else if (
            (
                b.getParentMother() != null
                &&  (
                    (
                        b.getParentMother().getParentMother() != null
                        && b.getParentMother().getParentMother().equals(a)
                    )
                    || (
                        b.getParentMother().getParentFather() != null
                        && b.getParentMother().getParentFather().equals(a)
                    )
                )
            ) 
            || (
                b.getParentFather() != null
                &&  (
                    (
                        b.getParentFather().getParentMother() != null
                        && b.getParentFather().getParentMother().equals(a)
                    )
                    || (
                        b.getParentFather().getParentFather() != null
                        && b.getParentFather().getParentFather().equals(a)
                    )
                )
            )
        ) {
            return b.getGender() == Gender.MAN ? "Дедушка" : "Бабушка";
        }
  
        if (
            a.getChildren() != null
            && b.getChildren() != null
            && a.getChildren().size() > 0
            && b.getChildren().size() > 0
        ) {
            for (Human ch1 : a.getChildren()) {
                for (Human ch2 : b.getChildren()) {
                    if (
                        (ch1.getSpouse() != null && ch1.getSpouse().equals(ch2))
                        || (ch2.getSpouse() != null && ch2.getSpouse().equals(ch1))
                    ) {
                            return a.getGender() == Gender.MAN ? "Сват" : "Сваха";
                    }  
                }
            }
        }
        
        if (a.getChildren() != null && a.getChildren().size() > 0) {
            for (Human ch : a.getChildren()) {
                if (
                    (ch.getSpouse() != null && ch.getSpouse().equals(b))
                    || (b.getSpouse() != null && b.getSpouse().equals(ch))
                ) {
                    return a.getGender() == Gender.MAN ? "Тесть" : "Теща";
                }
            }
        }
        
        if (b.getChildren() != null && b.getChildren().size() > 0) {
            for (Human ch : b.getChildren()) {
                if (
                    (ch.getSpouse() != null && ch.getSpouse().equals(a))
                    || (a.getSpouse() != null && a.getSpouse().equals(ch))
                ) {
                    return b.getGender() == Gender.MAN ? "Зять" : "Невестка";
                }
            }
        }
        
        return "";
    }
}
