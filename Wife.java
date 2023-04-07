public class Wife extends Human{
    private String child_name;
    private String father_name;
    private String mom_name;
    private String husband_name;

    public Wife(String name, String date_of_birth, String mom_name, String father_name, String husband_name, String child_name){
        super(name, date_of_birth, child_name, child_name, child_name, child_name);
        this.mom_name = mom_name;
        this.father_name = father_name;
        this.husband_name = husband_name;
        this.child_name = child_name;
    }

    public String getChild_name(){
        return child_name;
    }

    @Override
    public String toString(){
        return super.toString() + " " + mom_name + " " + father_name + " " + husband_name + " " + child_name + " ";
    }
    
}

