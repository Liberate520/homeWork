public class Man extends Human {
    
    public Man(String first_name, String second_name, int age, int height, int weight) {
        super(first_name, second_name, age, height, weight, CONST.Sex.MAN);
    }

    public int getAge() {
        return super.getAge();
    }

    public void setAge(int age) {
        super.setAge(age);
    }

    public CONST.Sex getSex() {
        return super.getSex();
    }

    public void setSex(CONST.Sex sex) {
        super.setSex(sex);
    }

    public int getHeight() {
        return super.getHeight();
    }

    public void setHeight(int height) {
        super.setHeight(height);
    }

    public int getWeight() {
        return super.getWeight();
    }

    public void setWeight(int weight) {
        super.setWeight(weight);
    }

    public String getFirst_name() {
        return super.getFirst_name();
    }

    public void setFirst_name(String first_name) {
        super.setFirst_name(first_name);
    }

    public String getSecond_name() {
        return super.getSecond_name();
    }

    public void setSecond_name(String second_name) {
        super.setSecond_name(second_name);
    }
}
