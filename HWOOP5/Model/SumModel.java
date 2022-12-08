package Model;
public class SumModel extends Calculate {

    @Override
    public Double result(Double x, Double y) {
        return x + y;
    }

    @Override
    public String getOperand() {
        return "+";
    }
    
}
