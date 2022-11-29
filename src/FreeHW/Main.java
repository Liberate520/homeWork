package FreeHW;

//import java.util.*;

import java.util.ArrayList;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        Numbers age = new Numbers();
        age.addNumbers(16);
        age.addNumbers(45);
        age.addNumbers(22);
        age.addNumbers(33);
        age.addNumbers(47);
        age.addNumbers(51);
        age.addNumbers(328);
        age.addNumbers(174);
        for (Num num : age) {
            System.out.printf(" "+num + " ");
        }
        System.out.println();
        age.sortNumEnd(); //сортировка
        System.out.println(age.getMyNumbers());
    }
}

class Numbers implements Iterable<Num> {
    private final ArrayList<Num> myNumbers;

    public Numbers() {
        myNumbers = new ArrayList<>();
    }

    public ArrayList<Num> getMyNumbers() {
        return myNumbers;
    }

    public void addNumbers(Integer number) {
        Num n = new Num(number);
        myNumbers.add(n);
    }

    public void sortNumEnd() { //метод сортировки по последней цифре
        myNumbers.sort(new SortComparator());
    }

    @Override
    public Iterator<Num> iterator() {
        return myNumbers.iterator();
    }
}

class Num {
    private final Integer myNum;

    public Num(Integer number) {
        myNum = number;
    }

    public String toString() {
        return Integer.toString(myNum);
    }

    public Integer selenium() {
        return myNum;
    }
}