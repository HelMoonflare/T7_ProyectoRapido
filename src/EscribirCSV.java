package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class EscribirCSV {
    static String ruta = "src/Ficheros/archivoEscrito.csv";

    public void escribirCSV(ArrayList<HashMap<String, String>> csv) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(ruta));
            HashMap<String, String> primeraFila = csv.get(0);
            int c = 0;
            for (String key : primeraFila.keySet()) {
                bw.write(key);
                if (c < primeraFila.size() - 1) {
                    bw.write(", ");
                }
                c++;
            }
            bw.write("\n");

            for (HashMap<String, String> fila : csv) {
                c = 0;
                for (String value : fila.values()) {
                    bw.write(value);
                    if (c < fila.size() - 1) {
                        bw.write(", ");
                    }
                    c++;
                }
                bw.write("\n");
            }

        } catch (IOException e) {
            System.err.println("Error al escribir " + e.getMessage());
        } finally {
            if (bw != null)
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
