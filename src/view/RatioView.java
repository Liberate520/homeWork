package view;

import model.RatioCalc;

import java.util.Scanner;

public class RatioView implements View{


    private String oper = "?";

    public void setOper(String oper) {
        this.oper = oper;
    }
    public String getOper() {
        return oper;
    }
    Scanner inp = new Scanner(System.in);

    @Override
    public int menu() {
        System.out.println("Choose operation: \n1 - sum + \n2 - extraction -\n3 - multiplying *\n4 - divide /");
        Scanner sc = new Scanner(System.in);
        int oper = sc.nextInt();
        return oper;

    }

    @Override
    public int[] input() {
        int [] user_input = new int [2];
        System.out.println("Input numerator: ");
        user_input[0] = inp.nextInt();
        System.out.println("Input denominator: ");
        user_input[1] = inp.nextInt();
        if (user_input[1] == 0 ) user_input[1] = 1;
        return user_input;
    }

    @Override
    public void output(int[] answer) {

        if (answer[0] % answer[1] == 0) {
            System.out.print(answer[0]/answer[1]);}
        else
            if (answer[0] > answer[1]) System.out.print(answer[0]/answer[1] + " " + answer[0]%answer[1] + "/" + answer[1]);
        else System.out.print(answer[0] + "/" + answer[1]);
    }
}
