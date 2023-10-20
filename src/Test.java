import java.util.Formatter;

public class Test {
    public static void main(String[] args) {
        String str = "hello";
        Formatter f = new Formatter();
        f.format("%s, asdas", str);
        System.out.println(f);
    }
}
