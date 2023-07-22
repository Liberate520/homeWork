package human;

public enum Gender {
    Female("Женский"),
    Male("Мужской");

    private String title;

    Gender (String title){
        this.title = title;
    }

    @Override
    public String toString() {
       return title;
    }
}
