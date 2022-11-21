package org.lesson01;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Person pa = new Person("Sergei","Pavshin","06/07/1979",Gender.Male);
        Person ma = new Person("Natalia","Pavshina","22/11/1976",Gender.Female);
        Person so = new Person("Egor","Pavshin","25/02/2013",Gender.Male);
        Person dot = new Person("Lada","Pavshina","14/05/2019",Gender.Female);
        Person vi = new Person("Viktoriya","Danilova","08/12/2003",Gender.Female);

        tree.addLink(pa,ma,Relations.Husband,Relations.Wife);
        tree.addLink(pa,so,Relations.Father,Relations.Son);
        tree.addLink(pa,dot,Relations.Father,Relations.Daughter);
        tree.addLink(pa,vi,Relations.Stepfather,Relations.Stepdaughter);

        tree.addLink(ma,so,Relations.Mother,Relations.Son);
        tree.addLink(ma,dot,Relations.Mother,Relations.Daughter);
        tree.addLink(ma,vi,Relations.Mother,Relations.Daughter);

        tree.addLink(so,dot,Relations.Brother,Relations.Sister);
        tree.addLink(so,vi,Relations.Brother,Relations.Sister);

        tree.addLink(dot,vi,Relations.Sister,Relations.Sister);

        System.out.println("-------------------\n");
        //System.out.println(tree);
        Research.getRelation(pa,tree);
    }
}