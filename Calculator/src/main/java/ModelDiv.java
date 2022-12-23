public class ModelDiv extends ModelCalc {

    public ModelDiv() {

    }
    @Override
    public Float result() {
        return x / y;
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