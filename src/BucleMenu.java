package src;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class BucleMenu {
    ArrayList<HashMap<String, String>> listaInfoFichero;
    static boolean salir = false;
    static boolean volver = false;
    static Scanner sc = new Scanner(System.in);
    static Csv csv = new Csv();
    static Json json = new Json();
    static Xml xml = new Xml();

    public void bucle() {
        do {
            mostrarMenu();
        } while (!salir);
    }

    public void mostrarMenu() {
        System.out.println("---------Menú Principal---------");
        System.out.println("1. Seleccionar una carpeta");
        System.out.println("2. Leer un fichero");
        System.out.println("3. Convertir a ...");
        System.out.println("4. Salir");
        System.out.println("--------------------------------");
        System.out.print("Elige una opción: ");

        int a = Integer.parseInt(sc.nextLine());
        switch (a) {
            case 1 -> seleccionarCarpeta();
            case 2 -> leerArchivo();
            case 3 -> {
                while (!volver) {
                    convertirA();
                }
                if (volver) {
                    System.out.println();
                    mostrarMenu();
                }

            }
            case 4 -> salir = true;
            default -> System.out.println("Opción no válida");
        }
    }

    public void convertirA() {
        System.out.println("-------------------");
        System.out.println("1. .csv");
        System.out.println("2. .json");
        System.out.println("3. .xml");
        System.out.println("4. Volver atrás");
        System.out.println("-------------------");
        System.out.print("¿A qué extensión quieres convertir?: ");

        int b = sc.nextInt();
        switch (b) {
            case 1 -> {
                System.out.println("Convirtiendo a .csv");
                System.out.println();
            }

            case 2 -> {
                System.out.println("Convirtiendo a .json");
                System.out.println();
            }
            case 3 -> {
                System.out.println("Convirtiendo a .xml");
                System.out.println();
            }
            case 4 -> volver = true;
            default -> System.out.println("Opción no válida");
        }
    }

    public void seleccionarCarpeta() {
        // System.out.println("Escribe la ruta de la carpeta que quieras mostrar:");
        File ruta = new File("src/Ficheros/");

        if (ruta.exists() && ruta.isDirectory()) {
            System.out.println("--------Información de la carpeta---------");
            System.out.println("Nombre: " + ruta.getName());
            System.out.println("Contenido: " + ruta.listFiles());
            System.out.println("------------------------------------------");
        } else {
            System.out.println("La carpeta no existe");
        }

    }

    public ArrayList<HashMap<String, String>> leerArchivo() {
        File ruta = new File("");
        System.out.println("Escribe la ruta del fichero que quieras leer:");
        System.out.println("Que fichero quieres leer?");
        System.out.println("1. .csv");
        System.out.println("2. .json");
        System.out.println("3. .xml");
        int value = Integer.parseInt(sc.nextLine());
        switch (value) {
            case 1:
                ruta = new File("src/Ficheros/coches.csv");
                if (ruta.exists() && ruta.isFile()) {
                    System.out.println("Leyendo fichero .csv");
                    listaInfoFichero = csv.LecturaFicheroCSV(ruta);
                    System.out.println("--------Información del fichero---------");
                    for (HashMap<String, String> info : listaInfoFichero) {
                        for (Entry<String, String> entry : info.entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }
                    }
                    System.out.println("------------------------------------------");
                } else {
                    System.out.println("El archivo no existe");
                }
                return listaInfoFichero;
            case 2:
                ruta = new File("src/Ficheros/coches.json");
                if (ruta.exists() && ruta.isFile()) {
                    System.out.println("Leyendo fichero .json");
                    listaInfoFichero = json.LecturaFicheroJSON(ruta);
                    System.out.println("--------Información del fichero---------");
                    for (HashMap<String, String> info : listaInfoFichero) {
                        for (Entry<String, String> entry : info.entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }
                        System.out.println("------------------------------------------");
                    }
                    System.out.println("------------------------------------------");
                } else {
                    System.out.println("El archivo no existe");
                }
                return listaInfoFichero;
            case 3:
                ruta = new File("src/Ficheros/coches.xml");
                if (ruta.exists() && ruta.isFile()) {
                    System.out.println("Leyendo fichero .xml");
                    listaInfoFichero = xml.LecturaFicheroXML(ruta);
                    System.out.println("--------Información del fichero---------");
                    for (HashMap<String, String> info : listaInfoFichero) {
                        for (Entry<String, String> entry : info.entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }
                        System.out.println("------------------------------------------");
                    }
                    System.out.println("------------------------------------------");
                } else {
                    System.out.println("El archivo no existe");
                }
                return listaInfoFichero;
            default:
                System.out.println("Opción inválida");
                return null;
        }

    }

}
