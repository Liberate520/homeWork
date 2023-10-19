package model.human;

import java.util.Date;

//  Браки
public class Marriage {
    private double id;
    private Date dateMarriage;
    private Date dateDivorce;
    private Human firstHuman;
    private Human secondHuman;

    public Marriage(
            double id,
            Date dateMarriage,
            Human firstHuman,
            Human secondHuman,
            Date dateDivorce
    )
    {
        this.id = id;
        this.dateMarriage = dateMarriage;
        this.firstHuman = firstHuman;
        this.secondHuman = secondHuman;
        this.dateDivorce = dateDivorce;
    }
    public void setDateDivorce(Date dateDivorce) {
        this.dateDivorce = dateDivorce;
    }
}
