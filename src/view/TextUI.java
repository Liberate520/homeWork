package view;

public class TextUI {
    protected String goodbye;
    protected String promptName;
    protected String promptSurname;
    protected String promptPatronymic;
    protected String promptGender;
    protected String promptDateBirth;
    protected String promptDateDeath;
    protected String promptListNumber;
    protected String promptConnectFrom;
    protected String promptConnectTo;
    protected String promptConnectionType;
    protected String inputError;
    protected String promptShowConnections;

    public TextUI() {
        this.goodbye = "Программа завершает работу.";
        this.promptName = "Введите имя:";
        this.promptSurname = "Введите фамилию:";
        this.promptPatronymic = "Введите отчество:";
        this.promptGender = """
                Выберите пол:
                1. муж
                2. жен
                """;
        this.promptDateBirth = "Введите дату рождения в формате dd-MM-yyyy:";
        this.promptDateDeath = "Введите дату смерти в формате dd-MM-yyyy или пустую строку:";
        this.promptListNumber = "Выберите пункт списка по номеру:";
        this.promptConnectFrom = "От кого создать родственную связь?";
        this.promptConnectionType = """
                Тип родственной связи:
                1. Родитель
                2. Ребенок
                3. Брат/Сестра
                4. Муж/Жена
                """;
        this.promptConnectTo = "К кому создать родственную связь?";
        this.inputError = "Ошибка ввода, попробуйте еще раз.";
        this.promptShowConnections = "Чьи родственные связи вы хотите посмотреть?";
    }
}
