import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Main {
    public static void main (String[] args) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
// start = sdf.parse("2013-09-18T20:40:00+0000");
        Person person = new Person("Baiden", "M",sdf.parse("1947-09-20"));
        System.out.println(person);
    }
}
