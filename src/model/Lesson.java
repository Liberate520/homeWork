package model;

public class Lesson {
    // ПОЛЯ КЛАССА Lesson
    private final String subject;
    private final String lessonType;
    private final String teacherName;
    private final String lessonTopic;
    private final String lessonData;
    private final String beginningTime;
    private final String description;

    // КОНСТРУКТОР
    public Lesson(String subject, String lessonType, String teacherName, String lessonTopic, String lessonData,
                  String beginningTime, String description) {
        this.subject = subject;
        this.lessonType = lessonType;
        this.teacherName = teacherName;
        this.lessonTopic = lessonTopic;
        this.lessonData = lessonData;
        this.beginningTime = beginningTime;
        this.description = description;
    }

    // ПЕРЕОПРЕДЕЛЕНИЕ ПОРЯДКА ВЫВОДА ДАННЫХ НА ПЕЧАТЬ
    @Override
    public String toString() {
        return "\nНаименование предмета: " + subject +
                "\nТип занятия:           " + lessonType +
                "\nПреподаватель:         " + teacherName +
                "\nТема урока:            " + lessonTopic +
                "\nДата проведения:       " + lessonData +
                "\nВремя начала:          " + beginningTime +
                "\nПримечание:            " + description;
    }
}