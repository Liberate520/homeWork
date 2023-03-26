package oop_1;

public class Connection {
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


    public void printInfo() {
        System.out.printf("%s, является %s %s", p1.printInfoPerson(), st, p2.getFull_name());
    }

}
