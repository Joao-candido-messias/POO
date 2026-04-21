public class Principal {
    public static void main(String[] args) {
        Termometro t = new Termometro();

        t.setFahrenheit(68);
        System.out.println(t.getCelsius());
        System.out.println(t.getFahrenheit());
    }
}
