public class Human {
    private String name;
    private String date_of_birth;
    private String mom_name;
    private String father_name;
    private String wife_name;
    private String child_name;
    

    public Human(String name, String date_of_birth, String mom_name, String father_name, String wife_name, String child_name){
        
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.mom_name = mom_name;
        this.father_name = father_name;
        this.wife_name = wife_name;
        this.child_name = child_name;;

    }

       
    public String getName() {
        return name;
    }


    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getMom() {
        return mom_name;
    }

    public String getFather() {
        return father_name;
    }

    public String getWife() {
        return wife_name;
    }

    public String getChild() {
        return child_name;
    }


    @Override
    public String toString(){
        return name + " " + date_of_birth + " " + mom_name + " "  + father_name + "  " + wife_name + "  " + child_name + "  ";
    }

}
    


