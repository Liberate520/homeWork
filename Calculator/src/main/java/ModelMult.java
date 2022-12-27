public class ModelMult<T extends Number> extends ModelCalc<T> {
    @Override
    public T result() {
        return x * y;
    }

    @Override
    public void setX(T value) {
        super.x = value;
    }

    @Override
    public void setY(T value) {
        super.y = value;

    }
}