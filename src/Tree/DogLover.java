package Tree;

public class DogLover extends Human implements CallPet {
    
   
    public DogLover(String name, int age) {
        super(name, age);
    }

    @Override
    public void callPet(Pet pet) {
        if(pet instanceof Cat){
            System.out.printf("%s зовёт %s свистом - не реагирует\n",super.getName(),pet.getNickName());
        }

        if(pet instanceof Dog){
            System.out.printf("%s зовёт %s свистом - виляет хвостом:\n",super.getName(),pet.getNickName());
            pet.respond();
        }
    }
}
