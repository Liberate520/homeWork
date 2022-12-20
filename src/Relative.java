
public class Relative {

    private Human member1;
    private Human member2;
    private Recitation relative;

    public Relative(Human member1, Human member2, Recitation relative) {
        this.member1 = member1;
        this.member2 = member2;
        this.relative = relative;

    }

    public Human getMember1() {
        return member1;
    }

    public Human getMember2() {
        return member2;
    }

    public Recitation getRelative() {
        return relative;
    }

    public String getStringRecitation(Recitation relative) {
        String string;
        switch (relative) {
            case son:
                string = " сын";
                break;
            case daughter:
                string = " дочь";
                break;
            case father:
                string = " отец";
                break;
            case mother:
                string = " мать";
                break;
            case brother:
                string = " брат";
                break;
            case sister:
                string = " сестра";
                break;
            case spouse:
                string = " муж";
                break;
            case lady:
                string = " жена";
                break;
            default:
                string = " не является родствеником";
        }
        return string;
    }
}
