package Tree2;

public class CatLover extends Person implements CallPet {

    public CatLover(String name, int age) {
        super(name, age);
    }

    @Override
    public void callPet(Pet pet) {
        if (pet instanceof Dog) {
            System.out.printf("%s call %s with a \"Kitty-Kitty-Kitty\", but it don`t reacts\n", super.getName(), pet.getNickName());
        }

        if (pet instanceof Cat) {
            System.out.printf("%s call %s with a \"Kitty-Kitty-Kitty\", and it say:\n", super.getName(), pet.getNickName());
            pet.respond();
        }
    }
}
