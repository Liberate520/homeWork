/*
Тут будут животные так или иначе относящиеся к семье
 */
abstract class Animal implements FamiliesI {
    // животным обычно дают имя, если нет, то будет по умолчанию
    private String name;
    // у животного есть вид (кошка, собака, лошадь, корова) (в виде классов будут)

    // хозяин, так как это животные семьи
    private Human keeper;

    public Animal(String name, Human keeper) {
        this.name = name;
        this.keeper = keeper;
    }

    @Override
    public void addTree(Tree tree) {
        tree.addTree(this);
    }
}
