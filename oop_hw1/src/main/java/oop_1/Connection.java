package oop_1;

import java.io.Serializable;

public class Connection implements Serializable {
    private Person p1;
    private Status st;
    private Person p2;

    public Connection(Person p1, Status st, Person p2) {
        this.p1 = p1;
        this.st = st;
        this.p2 = p2;
    }

    public Person getP1() {
        return p1;
    }

    public void setP1(Person p1) {
        this.p1 = p1;
    }

    public Status getSt() {
        return st;
    }

    public void setSt(Status st) {
        this.st = st;
    }

    public Person getP2() {
        return p2;
    }

    public void setP2(Person p2) {
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return p1.printInfoPerson() + " is the " + st + " " + p2.getFull_name();
    }


}
