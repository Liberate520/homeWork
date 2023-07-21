package tree;
class Child extends Person {
    public Person mother;
    public Person father;

    public Child(String n, char g, String d) {
        super(n, g, d);
    }

    public void setMother(Person m) {
        mother = m;
    }

    public void setFather(Person f) {
        father = f;
    }
}