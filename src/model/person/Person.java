package model.person;

import java.util.Date;

public interface Person {
    String getPersonName();

    String getPersonSurname();

    Integer getID();

    Integer getFatherID();

    Integer getMotherID();

    Integer getPartnerID();

    String getHumanFullName();

    Date getDateOfBirth();

    Date getDateOfDeath();

    void setID(Integer ID);

    void setPersonName(String personName);

    void setPersonSurname(String personSurname);

    void setDateOfBirth(Date dateOfBirth);

    void setDateOfDeath(Date dateOfDeath);

    void setMotherID(Integer motherID);

    void setFatherID(Integer fatherID);

    void setPartnerID(Integer partnerID);

}
