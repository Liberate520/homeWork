public class Num {
    private Integer myNum;

    public Num(Integer number) {
        myNum = number;
    }
    public String toString() {
        return Integer.toString(myNum);
    }

    public Integer getMynum() {
        return myNum;
    }
    public void setMynum(Integer myNum) {
        this.myNum = myNum;
    }
}
