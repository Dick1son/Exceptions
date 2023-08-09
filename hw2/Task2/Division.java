package hw2.Task2;

public class Division {
    private float division() throws DivisionByZeroException {
        float result;
        Input input = new Input();
        result = input.getinputDivisible() / input.getinputDivisor();

        return result;
    }

    public float getDivision() throws DivisionByZeroException {
        return division();
    }
}
