package view;

@SuppressWarnings("ALL")
public class TextsMenu {
    protected static String inviteMenu = """
             1 - посмотреть всех\s
             2 - добавить человека \s
             3 - удалить человека по id\s
             4 - показать детей по id\s
             5 - добавить человеку связь\s
             6 - Записать человека в файл txt\s
             7 - Записать человека в файл csv\s
             q - выход
             \
            """;
    protected static String inviteName = "Введите имя ";
    protected static String inviteAge = "Введите возраст ";
    protected static String inviteId = "Введите id ";
    protected static String inviteRelationId = """
            Введите тип связи:
            1 - муж/жена
            2 - ребенок\s""";
    protected static String inviteIdTo = "Введите id к кому эта связь относится ";


}
