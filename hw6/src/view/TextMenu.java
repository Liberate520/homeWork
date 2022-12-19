package view;

public class TextMenu {
    public static String menu = """
            1 - посмотреть всех\\s
            2 - добавить человека \\s
            3 - удалить человека по id\\s
            4 - показать детей по id\\s
            5 - добавить человеку связь\\s
            
            q - выход
             \
                       
            """;

    public static String choiceName = "Enter Name: ";
    public static String choiceAge = "Enter Age: ";
    public static String choiceId = "Enter Id: ";
    public static String choiceRelationId = """
            Enter relation type:
            1 - Married
            2 - Parant\s
            """;
    public static String choiceIdFor = "Enter Id relation: ";
}
