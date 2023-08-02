package view;

public class TextUI {
    protected String promptName;
    protected String promptSurname;
    protected String promptPatronymic;
    protected String promptGender;
    protected String promptDateBirth;
    protected String promptDateDeath;

    public TextUI() {
        this.promptName = "Введите имя:\n";
        this.promptSurname = "Введите фамилию:\n";
        this.promptPatronymic = "Введите отчество:\n";
        this.promptGender = """
            Выберите пол (1 или 2):
            1) муж
            2) жен
            
            """;
        this.promptDateBirth = "Введите дату рождения в формате dd-MM-yy:\n";
        this.promptDateDeath = "Введите дату смерти в формате dd-MM-yy или пустую строку:\n";
    }
}
