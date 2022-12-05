package Tree1.Pet;

import Tree1.Person.Person;

public class CatLover extends Person implements CallPet {
    /**
     *  Класс, наследник от `Person`, описывающий людей любящих кошек. Имплементируют интерфейс `CallPet`.
     *   Переопределяет метод `CallPet` в соответствии с поведением кошатника.
     */

    public CatLover(String name, int age) {
        super(name, age);
    }

    @Override
    public void callPet(Pet pet) {
        if (pet instanceof Dog) {
            System.out.printf("%s call %s with a \"Kitty-Kitty-Kitty\", but it don`t reacts\n", super.getName(),
                    pet.getNickName());
        }

        if (pet instanceof Cat) {
            System.out.printf("%s call %s with a \"Kitty-Kitty-Kitty\", and it say:\n", super.getName(),
                    pet.getNickName());
            pet.Respond();
        }
    }
}
