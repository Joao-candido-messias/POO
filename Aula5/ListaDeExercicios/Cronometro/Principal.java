public class Principal {
    public static void main(String[] args) {
        Cronometro c = new Cronometro();

        c.passarTempo();
        c.passarTempo();

        System.out.println(c.getSegundos());
    }
}
