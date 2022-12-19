package model;

public class RatioCalc implements CalcMethods {



    private int [] user_input1 = new int [2];
    private int [] user_input2 = new int [2];
    private int [] res = new int[2];

    public RatioCalc(int [] user_input1, int [] user_input2) {
        this.user_input1 = user_input1;
        this.user_input2 = user_input2;
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
    public int[] Sum(){
        res[0] = user_input1[0]*user_input2[1] + user_input2[0]*user_input1[1];
        res[1] = user_input1[1] * user_input2[1];
        return castNOD(res);
    }
    @Override
    public int[] Extract(){
        res[0] = user_input1[0]*user_input2[1] - user_input2[0]*user_input1[1];
        res[1] = user_input1[1] * user_input2[1];
        return castNOD(res);
    }

    @Override
    public int[] Mult(){
        res[0] = user_input1[0] * user_input2[0];
        res[1] = user_input1[1] * user_input2[1];
        return castNOD(res);
    }


    @Override
    public int[] Divide(){
        res[0] = user_input1[0] * user_input2[1];
        res[1] = user_input1[1] * user_input2[0];
        return castNOD(res);
    }


    @Override
    public int [] getRes() {
        return res;
    }
    @Override
    public int[] getUser_input1() {
        return user_input1;
    }
    @Override
    public int[] getUser_input2() {
        return user_input2;
    }
}
