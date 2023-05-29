public class Product {
    private static int global_ıd;
    private int id;
    private String name;
    private double price;
    public Product(String name, double price){
        this.name = name;
        this.price = price;
        id = global_ıd++;

    }
    //public Product обе вариянта вместе называется Прегрузка
    public Product(){
        this("default",-1);  //alt+insert(Constructor)

    }


    public double getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "id: "+ id + ", name: " + name + ", price: " + price; //alt+insert (toString)
    }
}
