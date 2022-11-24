import people.People;

public class TreeFamily extends People {
    private People mather;
    private People father;
    private People baby;
    public TreeFamily(String name, int age, People mather, People father) {
        super(name, age);
        this.mather = mather;
        this.father = father;

    }
    public TreeFamily(String name, int age, People mather, People father, People baby) {
        super(name, age);
        this.mather = mather;
        this.father = father;
        this.baby = baby;
    }
    public TreeFamily(String name, int age,  People baby) {
        super(name, age);
        this.baby = baby;
    }
    @Override
    public String toString() {

        return super.toString() + "\n" + " Мама: " + mather +  "\n" + " Папа: " + father + "\n" + " Ребенок: " + baby;
    }

}
