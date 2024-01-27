package ru.gb.general_methods;


public class IsValidTreeNum {
    private int treesAmount;
    public IsValidTreeNum(int amountOfTrees) {
        this.treesAmount = amountOfTrees;
    }

    public boolean isValidTreeNum(int checkNumber) {
        return checkNumber >= 0 && checkNumber <= treesAmount;
    }

    public void error() {
        System.out.println("Неверный индекс древа");
    }
}
