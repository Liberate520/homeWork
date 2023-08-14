import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class test {
    public static void main(String[] args) {
        enum K {
            ASD, QWE
        }

        System.out.println(K.ASD);
        System.out.println(K.ASD);
        System.out.println(K.values()[1]);

        if (LocalDate.parse("111111111").parse(null, null) != null) {
            LocalDate localDate = LocalDate.parse("111111111");
        }
        

    }
}
