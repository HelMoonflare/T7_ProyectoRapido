package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EscribirJson {
    static String ruta = "src/Ficheros/archivoEscrito.json";

    public void escribirJson(ArrayList<HashMap<String, String>> json) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(ruta));
            bw.write("[\n");

            for (int i = 0; i < json.size(); i++) {
                HashMap<String, String> mapa = json.get(i);
                bw.write("\t{\n");

                int c = 0;
                int size = mapa.size();
                for (Map.Entry<String, String> entry : mapa.entrySet()) {
                    bw.write("\t\t\"" + entry.getKey() + "\": \"" + entry.getValue() + "\"");
                    if (c < size - 1) {
                        bw.write(",");
                    }
                    bw.write("\n");
                    c++;
                }

                bw.write("\t}");
                if (i < json.size() - 1) {
                    bw.write(",");
                }
                bw.write("\n");
            }

            bw.write("]");


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
