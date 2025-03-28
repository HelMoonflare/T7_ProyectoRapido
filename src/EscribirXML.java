package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class EscribirXML {
    static String ruta = "src/Ficheros/archivoEscrito.xml";

    public static void escribirXML(ArrayList<HashMap<String, String>> xml) {
        FileWriter fw;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(ruta);
            bw = new BufferedWriter(fw);
            System.out.println("<elementos>");
            for (int i = 0; i < xml.size(); i++) {
                HashMap<String, String> mapa = xml.get(i);
                System.out.println("<elemento>");
                for (Entry<String, String> entry : mapa.entrySet()) {
                    System.out.println("<" + entry.getKey() + ">" + entry.getValue() + "</" + entry.getKey() + ">");
                }
                System.out.println("</elemento>");
            }
            System.out.println("</elementos>");

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
