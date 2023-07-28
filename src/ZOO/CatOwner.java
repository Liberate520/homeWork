package ZOO;

public class CatOwner {
    private String name;
    private String status;

    public CatOwner(String name, String status){
        this.name = name;
        this.status = status;
    }

    public void CatCall(String name){
        System.out.println(name + "call cat: kitty");
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }
}
