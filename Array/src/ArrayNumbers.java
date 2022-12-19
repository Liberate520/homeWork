public class ArrayNumbers implements Comparable<ArrayNumbers>{
    private int number;

    public ArrayNumbers(Integer numbers) {
         this.number = numbers;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number%10;
    }

    @Override
    public String toString() {
        return "" + number;
    }

    @Override
    public int compareTo(ArrayNumbers o) {
     return number;
    }
}

