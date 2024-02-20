import java.util.Random;

import javax.swing.JPanel;

public class Jugador {
    private int TOTAL_CARTAS = 10;
    private int DISTANCIA = 40;
    private int MARGEN = 5;
    private Random r = new Random();

    private Carta[] cartas = new Carta[TOTAL_CARTAS];

    public void repartir() {
        for (int i = 0; i < TOTAL_CARTAS; i++) {
            cartas[i] = new Carta(r);
        }
    }

    public void mostrar(JPanel pnl) {
        pnl.removeAll();
        for (int i = 0; i < cartas.length; i++) {
            cartas[i].mostrar(pnl,
                    MARGEN + TOTAL_CARTAS * DISTANCIA - i * DISTANCIA,
                    MARGEN);
        }
        pnl.repaint();
    }

}
