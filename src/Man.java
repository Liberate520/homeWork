public class Man extends Human {
    
    private CONST.Sex sex;

    public Man(String first_name, String second_name, int age, int height, int weight, CONST.Sex sex) {
        super(first_name, second_name, age, height, weight);
        this.sex = sex;
    }
    
    protected CONST.Sex getSex() {
        return sex;
    }

    protected void setSex(CONST.Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return String.format("-> %s %s %d %s"
                            , this.getSecond_name()
                            , this.getFirst_name()
                            , this.getAge()
                            ,this.getSex().toString());
    }
}
