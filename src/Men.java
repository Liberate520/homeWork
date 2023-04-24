package Tree.homeWork.src;

public class Men extends Human {
    public Men(String name, int age, int DateOfBirth, int DateOfDeath, Gender gender, TypeCommunication typeCommunication) {
        super(name, age, DateOfBirth, DateOfDeath, gender, typeCommunication);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
}
