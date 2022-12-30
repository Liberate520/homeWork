public class ModelAmount extends ModelCalc {

    public ModelAmount() {

    }
    @Override
    public double result() {
        return x + y;
    }

//    @Override
//    public void setX(double value) {
//
//    }
//
//    @Override
//    public void setY(double value) {
//
//    }

    @Override
    public void setX(double value) {
        super.x = value;
    }

    @Override
    public void setY(double value) {
        super.y = value;

    }
}