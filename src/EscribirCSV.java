package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class EscribirCSV {
    static String ruta = "src/Ficheros/archivoEscrito.csv";

    public static void escribirCSV(ArrayList<HashMap<String, String>> csv) {
        FileWriter fw;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(ruta);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < csv.size(); i++) {
                HashMap<String, String> mapa = csv.get(i);

                for (Entry<String, String> entry : mapa.entrySet()) {
                    if (i == 0) {
                        System.out.println(entry.getKey() + entry.getValue() + ",");
                    }
                    System.out.println(entry.getValue() + ",");
                }
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
