package HW2;

abstract public class Pet {
    private final String  nickName;
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
        return ("Nickname: "+this.nickName+"; age:"+this.age);
    }
}
