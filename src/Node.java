import java.time.LocalDate;

public interface Node<T>
{
   int getId();
   String getLastName();
   String getFirstName();
   Gender getGender();
   LocalDate getDataBirth();
   LocalDate getDataDeath();
   T getFather();
   T getMother();
   T getChildren();



}
