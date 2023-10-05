import human.Gender;
import human.Human;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat( "dd.MM.yyyy" );
        Date birthday = new Date();
        Date deathday = new Date();
        try {
            birthday = formatter.parse("01.01.1900");
            deathday = formatter.parse("01.01.1990");
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        Human human1 = new Human(
                Gender.male,
                "Прадед 1",
                "Прадедов",
                "Прадедович",
                birthday,
                deathday,
                null,
                null
        );
    }
}
