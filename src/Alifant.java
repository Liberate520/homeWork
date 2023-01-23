public class Alifant extends LiveBeing<Alifant> {

    public Alifant(String name, int date, String sex) {
        super(name, date, sex);
    }

    public Alifant(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("Вид: Слон белый\n%s", super.toString());
    }
}
