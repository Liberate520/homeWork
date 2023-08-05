import java.time.LocalDate;

public interface Buffer<T> {
    String getName();

    LocalDate getBirthDate();

    LocalDate getDeathDate();

    Gender getGender();
}