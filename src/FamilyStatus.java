
public enum FamilyStatus {
    AUNT("Тётя"),
    BROTHER("Брат"),
    CHILD("Ребёнок"),
    GRANDCHILD("Внук(-чка)"),
    GRAND_MOTHER("Бабушка"),
    GRAND_FATHER("Дедушка"),
    FATHER("Отец"),
    MOTHER("Мать"),
    SISTER("Сестра"),
    SPOUSE("Супруг(-а)"),
    UNCLE("Дядя"),
    UNKNOWN("Неизвестно");

    private final String description;

    private FamilyStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
