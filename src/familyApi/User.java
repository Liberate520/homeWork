package familyApi;
import java.util.Calendar;

public interface User {
    public String getFirstname();
    public Calendar getBirthdate();
    public String getLastname();
    public Human getFather();
    public Human getMother();
    
} 
