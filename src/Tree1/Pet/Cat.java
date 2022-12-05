package Tree1.Pet;

public class Cat extends Pet {
    /**
     * Класс для создания экземпляров кошек. Имеет переопределенный метод описывающий реакцию отзыва в
     * соответствии с типом.
     */
    public Cat(String nickName, int age) {
        super(nickName, age);
    }

    @Override
    public void Respond() {
        System.out.println("meow-meow-meow");
    }

}
