package presenter;

import model.CalcMethods;
import model.RatioCalc;
import model.SimpleCalc;
import view.RatioView;
import view.SimpleView;
import view.View;

import java.util.Scanner;

public class Presenter {
    private View view;
    private CalcMethods methods;


public void start() {
        while (true) {
            calcTypeChoice();
            operandChoice();
            calculation();
        }
    }
    public void calcTypeChoice(){
        System.out.println("\nChoose type of numbers: \n1 - Ratio \n2 - Simple \n3 - Exit");
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        switch (type){
            case 1:
                System.out.println("Selected rational type of numbers");
                this.view = new RatioView();
                int [] ui1 = view.input();
                int [] ui2 = view.input();
                System.out.println("Initialization here!!!");
                this.methods = new RatioCalc(ui1, ui2);
                break;
            case 2:
                System.out.println("Selected simple numbers...");
                this.view = new SimpleView();
                int [] ui11 = view.input();
                int [] ui12 = view.input();
                this.methods = new SimpleCalc(ui11[0], ui12[0]);
                break;
            case 3:
                System.out.println("Bye...");
                System.exit(0);
            default:
                System.out.println("Selected rational type of numbers by default");
                ui1 = view.input();
                ui2 = view.input();
                this.view = new RatioView();
                this.methods = new RatioCalc(ui1, ui2);
                break;
        }
    }
    public void operandChoice(){
        int oper = view.menu();
        switch (oper) {
            case 1: {
                methods.Sum();
                view.setOper(" + ");
                break;
            }
            case 2: {
                methods.Extract();
                view.setOper(" - ");
                break;
            }
            case 3: {
                methods.Mult();
                view.setOper(" * ");
                break;
            }
            case 4: {
                methods.Divide();
                view.setOper(" / ");
                break;
            }
        }
    }
    public void calculation(){
        view.output(methods.getUser_input1());
        System.out.print(view.getOper());
        view.output(methods.getUser_input2());
        System.out.print(" = ");
        view.output(methods.getRes());
    }

}
