package HW2;

public class DogLover extends Person implements CallPet {
    public DogLover(String name, int age) {
        super(name, age);
    }

    @Override
    public void callPet(Pet pet) {
        if(pet instanceof Cat){
            System.out.printf("%s call %s with a whistle, but it don`t reacts\n",super.getName(),pet.getNickName());
        }

        if(pet instanceof Dog){
            System.out.printf("%s call %s with a whistle, and it wags its tail and say:\n",super.getName(),pet.getNickName());
            pet.respond();
        }
    }
}
