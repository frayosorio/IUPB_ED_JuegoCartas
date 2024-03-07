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

    public String getGrupos() {
        String mensaje = "No se encontraron grupos";

        if (cartas[0] != null) {
            int[] contadores = new int[13];

            // for(int i = 0; i < cartas.length; i++) {
            // Carta c=cartas[i];
            for (Carta c : cartas) {
                contadores[c.getNombre().ordinal()]++;
            }

            int totalGrupos = 0;
            for (int c : contadores) {
                if (c >= 2)
                    totalGrupos++;
            }
            if (totalGrupos > 0) {
                mensaje = "Se encontraron los siguientes grupos:\n";
                for (int i = 0; i < contadores.length; i++) {
                    if (contadores[i] >= 2) {
                        mensaje += Grupo.values()[contadores[i]] + " de " + NombreCarta.values()[i] + "\n";
                    }
                }
            }
        } else {
            mensaje = "No hay cartas repartidas";
        }
        return mensaje;
    }

}
