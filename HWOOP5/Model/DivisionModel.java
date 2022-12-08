package Model;
public class DivisionModel extends Calculate{

    @Override
    public Double result(Double x, Double y) {
            return x / y;
    }

    @Override
    public String getOperand() {
        return "/";
    }
    
}
