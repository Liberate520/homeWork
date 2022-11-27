import java.util.List;

public abstract class Console {
    public static void writeln(List<Human> list) {

        for (Human item : list) {
            System.out.println(
                    String.format("-> %s %s %d %s"
                            , item.getSecond_name()
                            , item.getFirst_name()
                            , item.getAge()
                   ,item.getSex().toString()));
        }
    }    
}
