package family;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    //поля
    private int id;
    private String name;
    private int birn;
    private int die;
    private List<Human> parent;
    private List<Human> child;
    private Human pair;
//***********************************конструкторы

    public Human(String name, int birn, int die) {
        this.id=0;
        this.name = name;
        this.birn = birn;
        this.die = die;
        this.child = new ArrayList<Human>();
        this.parent = new ArrayList<Human>();
        pair=null;
    }

    public Human(String name, int birn) {
        this(name,birn,0);
    }

    public Human(String name) {
        this(name,0,0);
    }

//*************************************GET
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<Human> getParent() {
        return parent;
    }
    public List<Human> getChild() {
        return child;
    }
    public int getBirn() {
        return birn;
    }
    public int getDie() {
        return die;
    }
    public Human getPair() {
        return pair;
    }


    //******************SET//add
    public void setId(int id) {
        this.id = id;
    }
    public void setBirn(int birn) {
        this.birn = birn;
    }
    public void setDie(int die) {
        this.die = die;
    }

    public void setPair(Human partner) {
        this.pair=partner;
        partner.pair=this;
    }

    public void addChild(Human ch) {
        if (!this.child.contains(ch)){
            this.child.add(ch);
            ch.parent.add(this);
        }
    }

    public void addParent(Human pa) {
        if (!this.parent.contains(pa)){
            this.parent.add(pa);
            pa.child.add(this);
        }
    }
    //*************************************************ВЫВОД ИНФОРМАЦИИ
    @Override
    public String toString() {
        return outputHuman();
    }

    public String outputHuman(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(" имя: ");
        sb.append(name);
        if (getBirn()>0){
            sb.append(" родился : "+birn);
        }

        if (getDie()>0){
            sb.append(" умер: "+die);
        }

        if (child.size()!= 0){
            sb.append(" дети: ");
            sb.append(child.get(0).getName());
            for (int i = 1; i < child.size(); i++) {
                sb.append(", "+child.get(i).getName());
            }
        }

        if (parent.size()!= 0){
            sb.append(" родители: ");
            sb.append(parent.get(0).getName());
            for (int i = 1; i < parent.size(); i++) {
                sb.append(", "+parent.get(i).getName());
            }
        }

        if (pair!=null){
            sb.append(" в браке с: ");
            sb.append(pair.getName());
        }
        return sb.toString();
    }



}

