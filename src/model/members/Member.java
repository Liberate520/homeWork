package model.members;

import java.io.Serializable;
import java.time.Year;
import java.util.List;

/**
 * Интерфейс Member представляет члена семьи в семейном древе.
 * <p>
 * Член семьи имеет имя, год рождения, пол, отца, мать, детей и может быть сериализуемым.
 */
public interface Member extends Serializable {
    /**
     * Возвращает имя члена семьи.
     *
     * @return Имя члена семьи.
     */
    public String getName();

    /**
     * Возвращает год рождения члена семьи.
     *
     * @return Год рождения члена семьи.
     */
    public Year getYearOfBirth();

    /**
     * Возвращает пол члена семьи.
     *
     * @return Пол члена семьи.
     */
    public Gender getGender();

    /**
     * Возвращает отца члена семьи.
     *
     * @return Отец члена семьи.
     */
    public Member getFather();

    /**
     * Устанавливает отца члена семьи.
     *
     * @param father Отец члена семьи.
     */
    public void setFather(Member father);

    /**
     * Возвращает мать члена семьи.
     *
     * @return Мать члена семьи.
     */
    public Member getMother();

    /**
     * Устанавливает мать члена семьи.
     *
     * @param mother Мать члена семьи.
     */
    public void setMother(Member mother);

    /**
     * Добавляет ребенка в список детей члена семьи.
     *
     * @param child Ребенок члена семьи.
     */
    public void addChild(Member child);

    /**
     * Возвращает список детей члена семьи.
     *
     * @return Список детей члена семьи.
     */
    public List<Member> getChildren();

    public int hashCode();
}
