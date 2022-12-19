package model;

public class SimpleCalc implements CalcMethods{
    private int user_input1;
    private int user_input2;
    private int [] res = new int[2];
    public SimpleCalc(int user_input1, int user_input2) {
        this.user_input1 = user_input1;
        this.user_input2 = user_input2;
    }
    @Override
    public int [] Sum(){
        this.res[0] = user_input1 + user_input2;
        this.res[1] = 1;
        return res;
    }

    @Override
    public int [] Extract() {
        res[0] = user_input1 - user_input2;
        res[1] = 1;
        return res;
    }

    @Override
    public int [] Divide() {
        res[0] = user_input1;
        res[1] = user_input2;
        return castNOD(res);
    }

    @Override
    public int [] Mult(){
        res[0] = user_input1 * user_input2;
        res[1] = 1;
        return res;
    }
    public int [] castNOD(int[] answer){
        int max = answer[1];
        int min = answer[0];
        int swap;
        if (max < 0) max = -max;
        if (min < 0) min = -min;
        while (max != min){
            if (max < min) {
                swap = min;
                min = max;
                max = swap;
            }
            max = max - min;
        }
        if (max != 0) {
            answer[0] = answer[0] / max;
            answer[1] = answer[1] /max;}
        return answer;
    }

    @Override
    public int[] getUser_input1() {
        int [] inp1 = new int [2];
        inp1[0] = user_input1;
        inp1[1] = 1;
        return inp1;
    }
    @Override
    public int[] getUser_input2() {
        int [] inp2 = new int [2];
        inp2[0] = user_input2;
        inp2[1] = 1;
        return inp2;
    }

    @Override
    public int [] getRes() {
        return res;
    }
}
