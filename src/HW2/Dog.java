package HW2;

public class Dog extends Pet {
    /**
     * Класс для создания экземпляров собак. Имеет переопределенный метод
     * описывающий реакцию отзыва в соответствии с типом.
     */

    public Dog(String nickName, int age) {
        super(nickName, age);
    }

    @Override
    public void respond() {
        System.out.println("woof-woof-woof");
    }

}
