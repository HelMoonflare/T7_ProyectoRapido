package src.Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BucleMenu {
    static boolean salir = false;
    static boolean volver = false;
    static Scanner sc = new Scanner(System.in);
    static String ruta = "\\GitHub\\T7_ProyectoRapido\\src\\Ficheros";

    public static void bucle() {
        do {
            mostrarMenu();
        } while (!salir);
    }

    public static void mostrarMenu() {
        System.out.println("---------Menú Principal---------");
        System.out.println("1. Seleccionar una carpeta");
        System.out.println("2. Leer un fichero");
        System.out.println("3. Convertir a ...");
        System.out.println("4. Salir");
        System.out.println("--------------------------------");
        System.out.print("Elige una opción: ");

        int a = sc.nextInt();
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

    public static void convertirA() {
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

    public static void seleccionarCarpeta() {
        // System.out.println("Escribe la ruta de la carpeta que quieras mostrar:");
        File ruta = new File("\\GitHub\\T7_ProyectoRapido\\src\\Ficheros");

        if (ruta.exists() && ruta.isDirectory()) {
            System.out.println("--------Información de la carpeta---------");
            System.out.println("Nombre: " + ruta.getName());
            System.out.println("Contenido: " + ruta.listFiles());
            System.out.println("------------------------------------------");
            System.out.println();
        } else {
            System.out.println("La carpeta no existe");
            System.out.println();
        }

    }

    public static void leerArchivo() {
        File ruta = new File("\\GitHub\\T7_ProyectoRapido\\src\\Ficheros");

        System.out.println("----Leyendo el archivo----");
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        System.out.println("----Lectura finalizada----");

        if (ruta.exists() && ruta.isFile()) {
            System.out.println("Nombre del archivo: " + ruta.getName());
            System.out.println("Tamaño: " + ruta.length());
            System.out.println("Lectura: " + ruta.canWrite());
            System.out.println("Escritura: " + ruta.canRead());
        } else {
            System.out.println("El archivo no existe");
            System.out.println();
        }
    }

}
