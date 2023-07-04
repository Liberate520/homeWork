public class Human {
    public Human(Gender male) {
    }
    private int id;
    private String name;    
    public Human(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString(){
        return "id: " + id + ",name: " + name;
    }
}