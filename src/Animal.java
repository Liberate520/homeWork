public abstract class Animal implements Printable{
    private String name;
    private Animal mom;
    private Animal dad;
    private int breed;
    public String toPrint(){
        return "name:" + name + ", breed:" +
                ", mom:" + mom + ", dad:" + dad;
    }
}
