package ZOO;

public class Cat {
    private String name;

    public Cat(String name){
        this.name = name;
    }
    public void CatSays(String name){
        System.out.println("cat" + name + " says: miu");
    }
    public void CatNotHearing(String name){
        System.out.println("cat"+ name + " not hearing");
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
