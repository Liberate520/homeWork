public class Human {
    private String name;
    private Human mom;
    private Human dad;


    public Human(String name) {
        this.name = name;
    }

    public Human(String name, Human mom, Human dad) {
        this.name = name;
        this.mom = mom;
        this.dad = dad;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setMom(Human mom){
        this.mom = mom;
    }

    public Human getMom(){
        return mom;
    }

    public void setDad(Human dad){
        this.dad = dad;
    }

    public Human getDad(){
        return dad;
    }



    public String toPrint() {
        return "name:" + name + ", mom:" + mom + ", dad:" + dad;
    }





}


