import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pets {
    private String name;
    private String type;
    private Human master;
    private int idPets;


    public Pets(String name, String type, Human master) {
        this.name = name;
        this.type = type;
        this.master = master;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdPets() {
        return idPets;
    }

    public void setIdPets(int idPets) {
        this.idPets = idPets;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Human getMaster() {
        return master;
    }

    public void setMaster(Human master) {
        this.master = master;
    }

//    private void setPets(ArrayList<Pets> pets) {
//        this.pets = pets;
//    }
//
//    public List<Pets> getPets() {
//        return pets;
//    }

//    public void addPets(Pets pets) {
//        if (this.getPets() == null) {this.setPets(new ArrayList<Pets>());}
//        this.getPets().add(pets);
//    }

    public String toString() {
        return "Питомец[id=" + idPets + ", name=" + name + ", тип=" + type + "]";
    }
}