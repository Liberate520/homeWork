public class ModelDiv extends ModelCalc {

    public ModelDiv() {

    }
    @Override
    public double result() {
        double result = -1;
        try {
            result = x / y;
        } catch(ArithmeticException e){
            System.out.println("на ноль делить нельзя");
        }
        return result;
    }

    @Override
    public void setX(double value) {
        super.x = value;
    }

    @Override
    public void setY(double value) {
        super.y = value;

    }
}