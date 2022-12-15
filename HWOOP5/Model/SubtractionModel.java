package Model;
public class SubtractionModel extends Calculate{

    @Override
    public Double result(Double x, Double y) {
        return x - y;
    }

    @Override
    public String getOperand() {
        return "-";
    }
    
}
