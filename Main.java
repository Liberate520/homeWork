import java.time.LocalDate;

// import java.util.List;
public class Main {
    public static void main(String[] args) {
        FamilyTree tr = new FamilyTree();
        // Создание объектов Human
        Human Alexander = new Human( "Alexander", Gender.MALE, LocalDate.of(1987, 9, 20));
        Human Ekaterina = new Human("Ekaterina", Gender.FEMALE, LocalDate.of(1988, 12, 23));
        tr.add(Alexander);
        tr.add(Ekaterina);
        tr.setWedding(Alexander.getId(), Ekaterina.getId());

        Human Timofei = new Human( "Timofei", Gender.MALE, LocalDate.of(2013, 9, 10), Alexander,Ekaterina);
        Human Zahar = new Human("Zahar", Gender.MALE, LocalDate.of(2018, 9, 18),Alexander, Ekaterina);
        tr.add(Timofei);
        tr.add(Zahar);
        System.out.println(tr);

        

        
    }
}