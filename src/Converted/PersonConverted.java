package Converted;

public class PersonConverted implements IConverted{
    @Override
    public Comparable<String> personСonvertedUpper_Lower(String person) {
        return Character.toUpperCase(person.charAt(0)) + person.substring(1).toLowerCase();
    }
}
