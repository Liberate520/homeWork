class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    // Переопределение метода toString()
    @Override
    public String toString() {
        return name;
    }
}

