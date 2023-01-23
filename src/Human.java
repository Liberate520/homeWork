public class Human extends LiveBeing<Human> {

    public Human(String name, int date, String sex) {
        super(name, date, sex);
    }

    public Human(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("Вид: Человек разумный\n%s", super.toString());
    }
}
