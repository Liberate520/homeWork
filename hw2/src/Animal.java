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

