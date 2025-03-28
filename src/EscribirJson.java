package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class EscribirJson {
    static String ruta = "src/Ficheros/archivoEscrito.json";

    public static void escribirJson(ArrayList<HashMap<String, String>> json) {
        FileWriter fw;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(ruta);
            bw = new BufferedWriter(fw);
            System.out.println("[");
            for (int i = 0; i < json.size(); i++) {
                HashMap<String, String> mapa = json.get(i);
                System.out.println("{");
                for (Entry<String, String> entry : mapa.entrySet()) {
                    System.out.println(entry.getKey() + ":" + entry.getValue());
                }
                System.out.println("}");

            }
            System.out.println("]");


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
