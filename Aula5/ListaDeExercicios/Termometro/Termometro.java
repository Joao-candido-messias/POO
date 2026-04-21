public class Termometro {
    private double celsius;

    public double getFahrenheit() {
        return (celsius * 9/5) + 32;
    }

    public void setFahrenheit(double f) {
        this.celsius = (f - 32) * 5/9;
    }

    public double getCelsius() {
        return celsius;
    }
}