package view.consoleUI.notifications;

/**
 * Класс уведомлений для пользователя
 */
public class Notice {
    private final String text;
    private final int type;

    public Notice(String text, int type) {
        this.text = text;
        this.type = type;
    }

    public String toString() {
        return String.format("%s: %s", NoticeType.getTypeName(type), text);
    }
}
