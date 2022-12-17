public class ActionModel:CalcModel{
    public ActionModel() {

    }
  
    double resultSum() {
        return x + y;
    }

    double resultSub() {
        return x - y;
    }
    double resultMult() {
        return x * y;
    }

    double resultDiv() {
        return x/y;
    }

    void setX(double value) {
        super.x = value;
    }

    void setY(double value) {
        super.y = value;
    }

    void setAction(String value) {
        super.action = value;
    }




}
