package Tree;

public class CatLover extends Human implements CallPet {
    

    public CatLover(String name, int age) {
        super(name, age);
    }

    @Override
    public void callPet(Pet pet) {
        if (pet instanceof Dog) {
            System.out.printf("%s зовёт %s  \"кис - кис -кис\",  не реагирует\n", super.getName(),
                    pet.getNickName());
        }

        if (pet instanceof Cat) {
            System.out.printf("%s зовёт %s  \"кис - кис -кис\", отвечает:\n", super.getName(),
                    pet.getNickName());
            pet.respond();
        }
    }
}