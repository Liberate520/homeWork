package faminly_tree.view.add_human;

import java.time.LocalDate;

public interface ContentionFields {
    String getName();
    void setName(String name);
    String getSurname();
    void setSurname(String surname);
    String getPatronymic();
    void setPatronymic(String patronymic);
    String getSex();
    LocalDate getBirth();
    void setBirth(LocalDate birth);
    LocalDate getDeath();
    void setDeath(LocalDate death);
}
