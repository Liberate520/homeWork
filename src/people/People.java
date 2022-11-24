package people;

public class People {

        private String name;
        int age;
        private People mather;
        private People father;
        private People baby;

    public People(String name, int age, People mather, People father, People baby) {
        this.name = name;
        this.age = age;
        this.mather = mather;
        this.father = father;
        this.baby = baby;
    }
    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public People(String name, int age, People mather) {
        this.name = name;
        this.age = age;
        this.mather = mather.mather;
    }
    public People(String name, int age, People mather,People father) {
        this.name = name;
        this.age = age;
        this.mather = mather;
        this.father = father;
    }



    @Override
    public String toString() {
            return "Имя: " + name + " Возраст: " + age + " Мама: "
                    + mather +" Папа: "+ father + " Ребенок: " + baby;
    }
}
