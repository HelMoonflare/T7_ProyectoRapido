package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class EscribirXML {
    static String ruta = "src/Ficheros/archivoEscrito.xml";

    public void escribirXML(ArrayList<HashMap<String, String>> xml) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(ruta));
            bw.write("<coches>\n");
            for (int i = 0; i < xml.size(); i++) {
                HashMap<String, String> mapa = xml.get(i);
                bw.write("\t<coche>\n");
                for (Entry<String, String> entry : mapa.entrySet()) {
                    bw.write("\t\t<" + entry.getKey() + ">" + entry.getValue() + "</" + entry.getKey() + ">\n");
                }
                bw.write("\t</coche>\n");
            }
            bw.write("</coches>");

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
