import java.util.List;

public class Human {

    private String motherS;
    private String fatherS;
    private Spisok mother;
    private Spisok father;
    private Spisok childe;
    private Spisok childe2;
    private Spisok childe3;

    public Human(Spisok mother, Spisok father, Spisok childe, Spisok childe2, Spisok childe3) {
        this.mother = mother;
        this.father = father;
        this.childe = childe;
        this.childe2 = childe2;
        this.childe3 = childe3;
    }

    public Human(Spisok mother, Spisok father, Spisok childe, Spisok childe2) {
        this.mother = mother;
        this.father = father;
        this.childe = childe;
        this.childe2 = childe2;
    }

    public Human(Spisok mother, Spisok father, Spisok childe) {
        this.mother = mother;
        this.father = father;
        this.childe = childe;
    }

    public Human(Spisok mother, Spisok father) {
        this.mother = mother;
        this.father = father;
    }
    public Human(String mother, String father, Spisok childe, Spisok childe2, Spisok childe3) {
        this.motherS = mother;
        this.fatherS = father;
        this.childe = childe;
        this.childe2 = childe2;
        this.childe3 = childe3;
    }

    public Human(String motherS, String fatherS, Spisok childe, Spisok childe2) {
        this.motherS = motherS;
        this.fatherS = fatherS;
        this.childe = childe;
        this.childe2 = childe2;
    }

    public Human(String motherS, String fatherS, Spisok childe) {
        this.motherS = motherS;
        this.fatherS = fatherS;
        this.childe = childe;
    }

    public Human(String motherS, String fatherS) {
        this.motherS = motherS;
        this.fatherS = fatherS;
    }

    @Override
    public String toString() {
        if(motherS != null && fatherS !=null) {
            return "Мать: " + motherS + " " +
                    "Отец: " + fatherS  + " " +
                    "Ребенок1: " + childe +
                    "Ребенок2: " + childe2 +
                    "Ребенок3: " + childe3;
        } else if (childe2 == null && childe3 ==null) {
            return "Мать: " + mother +
                    "Отец: " + father +
                    "Ребенок1: " + childe;

        } else if (childe3 ==null) {
            return  "Мать: " + mother +
                    "Отец: " + father +
                    "Ребенок1: " + childe +
                    "Ребенок2: " + childe2;


        } else return

                "Мать: " + mother +
                        "Отец: " + father +
                        "Ребенок1: " + childe +
                        "Ребенок2: " + childe2 +
                        "Ребенок3: " + childe3;
    }
}