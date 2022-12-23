public class ModelAmount extends ModelCalc {

    public ModelAmount() {

    }
    @Override
    public Float result() {
        return x + y;
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