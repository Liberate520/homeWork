public abstract class Human {
    private int age;
    private int height;
    private int weight;
    private String first_name;
    private String second_name;
    
    protected Human(String first_name, String second_name, int age, int height, int weight) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.age = age;
        this.height = height;
        this.weight = weight;        
    }

    protected int getAge() {
        return age;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    protected int getHeight() {
        return height;
    }

    protected void setHeight(int height) {
        this.height = height;
    }

    protected int getWeight() {
        return weight;
    }

    protected void setWeight(int weight) {
        this.weight = weight;
    }

    protected String getFirst_name() {
        return first_name;
    }

    protected void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    protected String getSecond_name() {
        return second_name;
    }

    protected void setSecond_name(String second_name) {
        this.second_name = second_name;
    }    
}
