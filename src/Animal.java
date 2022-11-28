/*
Тут будут животные так или иначе относящиеся к семье
 */
abstract class Animal extends Tree {
    // животным обычно дают имя, если нет, то будет по умолчанию
    private String name;
    // у животного есть вид (кошка, собака, лошадь, корова) (в виде классов будут)

    // хозяин, так как это животные семьи
    private Human keeper;

    private int gender = 0;

    public Animal(String name, Human keeper) {
        this.name = name;
        this.keeper = keeper;
    }

    @Override
    public int getGender() {
        return gender;
    }
}
