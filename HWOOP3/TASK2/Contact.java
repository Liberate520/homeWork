package TASK2;

public class Contact implements Comparable<Contact>{
    private String name;
    private int phone;
    
    public Contact(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
    
        return "Name: " + name + " | " + "Phone " + phone;
    }
    @Override
    public int compareTo(Contact o) {
        return name.compareTo(o.getName());
    }

}
