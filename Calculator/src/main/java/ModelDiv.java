public class ModelDiv extends ModelCalc {

    public ModelDiv() {

    }
    @Override
    public Float result() {
        int result = -1;
        try {
            result = x / y;
        } catch(ArithmeticException e){
            System.out.println("на ноль делить нельзя");
        }
        return result;
    }

    @Override
    public void setX(Float value) {
        super.x = value;
    }

    @Override
    public void setY(Float value) {
        super.y = value;

    }
}