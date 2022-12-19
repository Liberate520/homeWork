

public class CalcModel extends Number{
    double res;
    public CalcModel() {}

    @Override
    public double calc(int value) {
        if (value == 1) {
            res = x + y;
        }
        else if (value == 2) {
            res = x - y;
        }
        else if (value == 3) {
            res = x * y;
        }
        else if (value == 4) {
            res =  x / y;
        }
        else if (value == 5) {
            res =  Math.pow(x, y);
        }
        else if (value == 6) {
            res =  x % y;
        }
        else {
            System.out.println("Вы ввели неверный знак!");
        }
        return res;
    }

    @Override
    public void setX(double value) {
        super.x = value;
    }

    @Override
    public void setY(double value) {
        super.y = value;
    }

    @Override
    public void setC(int value) {
        super.c = value;
    }
}

