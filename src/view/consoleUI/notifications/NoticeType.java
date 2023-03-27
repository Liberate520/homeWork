package view.consoleUI.notifications;

/**
 * Абстрактный класс, содержащий статичные идентификаторы типов уведомлений
 */
public abstract class NoticeType {
    public static int INFO = 1;
    public static int OK = 2;
    public static int ERROR = 3;

    public static String getTypeName(int typeNum){
        if (typeNum == 1) return "INFO";
        if (typeNum == 2) return "OK";
        if (typeNum == 3) return "ERROR";
        return null;
    }
}
