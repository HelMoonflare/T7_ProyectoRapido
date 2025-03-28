package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Json {

    public ArrayList<HashMap<String, String>> LecturaFicheroJSON(File fileJSON) {
        ArrayList<HashMap<String, String>> listaInfoFichero = new ArrayList<HashMap<String, String>>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileJSON))) {
            String linea;
            linea = br.readLine();
            linea = br.readLine();
            String objeto = linea;
            HashMap<String, String> infoFichero = new HashMap<String, String>();
            do {
                if (linea.equals(objeto)) {
                    infoFichero = new HashMap<String, String>();
                } else if (!linea.contains("}") && !linea.contains("]")) {
                    String[] palabras = linea.split(":");

                    infoFichero.put(palabras[0].trim().replace("[\",]", ""), palabras[1].trim().replace("[\",]", ""));

                } else
                    listaInfoFichero.add(infoFichero);
            } while ((linea = br.readLine()) != null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaInfoFichero;
    }
}
