// Используйте предыдущие задачи из прошлого домашнего задания. Необходимо гарантированно продумать
// иерархию компонент и взаимодействия их между собой.
// Обеспечить переход от использования явных классов в сторону использования абстрактных типов.
// Т е работаем не с:
// конкретным экземпляром генеалогического древа, а с интерфейсом “ генеалогическое древо”
// конкретным экземпляром котика, а с интерфейсом “котик”, лучше уйти от взаимодействия с
// конкретными питомцами и повысить уровень абстракции до взаимодействия с котиком, собачкой 
// или хомяком т е с интерфейсом “животное”

enum TypeAnimal {
    Dog, Cat, Hamster, Minipig
}

public abstract class Animal {

    private String name;
    private String color;
    private TypeAnimal typeAnimal;

        public Animal(String name, String color, TypeAnimal typeAnimal) {
        this.name = name;
        this.color = color;
        this.typeAnimal = typeAnimal;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public TypeAnimal getTypeAnimal() {
        return typeAnimal;
    }
    public void setTypeAnimal(TypeAnimal typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

    @Override
    public String toString() {
        return String.format("name: %s, color: %s, type: %s",
        name, color, typeAnimal);
    }

}
