
public class Main {
    public static void main(String[] args) {
        ListNumbers number = new ListNumbers();
        number.addElement(1548);
        number.addElement(3231);
        number.addElement(897);
        number.addElement(4885);
        number.addElement(419);
        System.out.println("Original array");
        for (Number num : number) {
            System.out.println(num);
        }
        number.sortNumbers();
        System.out.println("--------------------------------");
        System.out.println("Sort array");
        for (Number num : number) {
            System.out.println(num);
        }
    }
}
