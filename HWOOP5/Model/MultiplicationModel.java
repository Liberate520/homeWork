package Model;
public class MultiplicationModel extends Calculate{

    @Override
    public Double result(Double x, Double y) {
        return x * y;
    }

    @Override
    public String getOperand() {
        return "*";
    }
    
}
