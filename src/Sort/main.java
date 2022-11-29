package Sort;

import java.util.*;

public class main {
    public main(String[] args) {
        List<Sort.Add> age = new ArrayList<>(Arrays.asList(
                new Sort.Sort.Add(16),
                new Sort.Sort.Add(45),
                new Sort.Sort.Add(22),
                new Sort.Sort.Add(91),
                new Sort.Sort.Add(33)
        ));

        System.out.println(age);

        age.sort(Comparator.comparingInt(Sort.Add::age));

        System.out.println(age);
    }
}
