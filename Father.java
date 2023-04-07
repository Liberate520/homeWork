public class Father extends Human{
    private String child_name;
    private String father_name;
    private String mom_name;
    private String wife_name;

    public Father(String name, String date_of_birth, String mom_name, String father_name, String husband_name, String child_name){
        super(name, date_of_birth, child_name, child_name, child_name, child_name);
        this.mom_name = mom_name;
        this.father_name = father_name;
        this.wife_name = husband_name;
        this.child_name = child_name;
    }

    public String getChild_name(){
        return child_name;
    }

    @Override
    public String toString(){
        return super.toString() + " " + mom_name + " " + father_name + " " + wife_name + " " + child_name + " ";
    }
    
}

