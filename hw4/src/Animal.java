public class Animal extends Essence {
    private String color;
    private TypeAnimal typeAnimal;

    public Animal(String name, String color, TypeAnimal typeAnimal) {
        super(name);
        this.color = color;
        this.typeAnimal = typeAnimal;
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


}
