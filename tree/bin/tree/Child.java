class Child implements ChildInterface {
    private String name;
    private char gender;
    private String dob;
    private Person mother;
    private Person father;
    public Child(String n, char g, String d) {
        name = n;
        gender = g;
        dob = d;
    }
    
    public String getName() {
        return name;
    }
    
    public char getGender() {
        return gender;
    }
    
    public String getDOB() {
        return dob;
    }
    
    public Person getMother() {
        return mother;
    }
    
    public void setMother(Person m) {
        mother = m;
    }
    
    public Person getFather() {
        return father;
    }
    
    public void setFather(Person f) {
        father = f;
    }
    }
