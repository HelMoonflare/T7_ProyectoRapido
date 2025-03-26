package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Xml {

    public static ArrayList<HashMap<String, String>> LecturaFicheroXML(File fileXML) {
        ArrayList<HashMap<String, String>> listaInfoFichero = new ArrayList<HashMap<String, String>>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileXML))) {
            String linea;
            linea = br.readLine();
            linea = br.readLine();
            String objeto = linea;
            HashMap<String, String> infoFichero = new HashMap<String, String>();
            do {
                if (linea.equals(objeto)) {
                    infoFichero = new HashMap<String, String>();
                }
                if (!linea.equals("/" + objeto)) {
                    String[] palabras = linea.split("<[^>]+>");
                    
                        infoFichero.put(palabras[0], palabras[1]);
                    
                } else
                    listaInfoFichero.add(infoFichero);
            } while ((linea = br.readLine()) != null);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaInfoFichero;
    }
}
