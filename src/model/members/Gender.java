package model.members;

/**
 * Перечисление Gender представляет пол члена семьи.
 * <p>
 * Поддерживаемые значения: Мужчина (Man) и Женщина (Woman).
 */
public enum Gender {
    MAN("Man"),
    WOMAN("Woman"),
    ;

    private String gender;

    /**
     * Конструктор перечисления Gender.
     *
     * @param gender Пол члена семьи.
     */
    Gender(String gender) {
        this.gender = gender;
    }

    /**
     * Возвращает пол члена семьи в виде строки.
     *
     * @return Пол члена семьи.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Возвращает экземпляр Gender на основе заданного значения строки.
     * Если переданное значение не соответствует ни одному из поддерживаемых полов, возвращает null.
     *
     * @param value Значение строки для поиска соответствующего пола.
     * @return Экземпляр Gender или null, если значение не найдено.
     */
    public static Gender fromStringValue(String value) {
        for (Gender enumValue : Gender.values()) {
            if (enumValue.getGender().equalsIgnoreCase(value)) {
                return enumValue;
            }
        }
        return null;
    }
}
