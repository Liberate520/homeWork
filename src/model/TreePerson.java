package model;

abstract public class TreePerson {

    private String name;

    private int gender;

    public TreePerson(String name, int gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public int getGender() {
        return gender;
    }

    abstract void addLink(Link link); // интересно что будет если попытаться на кошках вызвать метод

}
