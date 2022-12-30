class Person<T> implements Human<T> {

    private T id;

    public T getId(){
        return id;
    }

    private String name;

    public String getName() {
        return name;
    }

    public Person(String name, T id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return getName();
    }
}