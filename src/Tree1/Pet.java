package Tree1;

abstract public class Pet {
    /**
     * Абстрактный класс, для определения животных имеющий общие для всех:
     *  Поля,
     *  Конструктор,
     *  Геттеры;
     */
    private final String nickName;
    private final int age;

    public Pet(String nickName, int age) {
        this.nickName = nickName;
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public int getAge() {
        return age;
    }

    abstract public void respond();

    @Override
    public String toString() {
        return ("Nickname: " + getNickName() + "; age:" + getAge());
    }
}
