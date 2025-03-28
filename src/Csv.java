package src;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Csv {

    public ArrayList<HashMap<String, String>>LecturaFicheroCSV(File ficheroCSV) {

        ArrayList<HashMap<String, String>> listaInfoFichero = new ArrayList<HashMap<String, String>>();
        try (BufferedReader br = new BufferedReader(new FileReader(ficheroCSV))) {
            String[] columna = br.readLine().split(",");
            String linea;
            while ((linea = br.readLine()) != null) {
                HashMap<String, String> infoFichero = new HashMap<String, String>();
                String[] palabras = linea.split(",");
                for (int i = 0; i < palabras.length; i++) {
                    infoFichero.put(columna[i], palabras[i]);
                }
                listaInfoFichero.add(infoFichero);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaInfoFichero;
    }
}
