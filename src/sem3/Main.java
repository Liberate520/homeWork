
public class Main {
    public static void main(String[] args) {
        Numbers num1 = new Numbers();
        num1.addNumbers(123);
        num1.addNumbers(125);
        num1.addNumbers(921);
        for (Num num: num1){
            System.out.println(num);
        }
        num1.sortNumEnd(); //сортировка
        System.out.println(num1.getMyNumbers());
    }
}     