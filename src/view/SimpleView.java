package view;

import view.View;

import java.util.Scanner;

public class SimpleView implements View {
    private String oper = "?";

    public void setOper(String oper) {
        this.oper = oper;
    }
    public String getOper() {
        return oper;
    }
    @Override
    public int menu() {
        System.out.println("Choose operation: \n1 - sum + \n2 - extraction -\n3 - multiplying *\n4 - divide /");
        Scanner sc = new Scanner(System.in);
        int oper = sc.nextInt();
        return oper;

    }

    @Override
    public int[] input() {
        Scanner inp = new Scanner(System.in);
        int [] user_input = new int [2];
        System.out.println("Input numerator: ");
        user_input[0] = inp.nextInt();
        user_input[1] = 1;
        return user_input;
    }

    @Override
    public void output(int[] answer) {
        if (answer[1] == 1) {
            System.out.print(answer[0]);
        }
        else
            if (answer[0] > answer[1]) System.out.print(answer[0]/answer[1] + " " + answer[0]%answer[1] + "/" + answer[1]);
        else System.out.print(answer[0] + "/" + answer[1]);
    }
}
