/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Gavilan
 */
public class InterfazPF {
    public static Scanner leer;
    //Declaración y conexión con la capa de lógica (Archivo logica.java).
    static logica capaLogica;
    public static String nombre;
    //    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    //    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    //    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    //    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    //    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    /******************************************************************
    * Método principal.
    *******************************************************************/
    public static void main(String[] args) {
        leer = new Scanner(System.in);
        capaLogica = new logica();
        capaLogica.logica();
        pedirNombre();
        leerOpcion();
    }
    /*****************************************************************
    * Rutina: pedirNombre
    * Propósito: Solicita el nombre del jugador
    * Parámetros: 
    *			   
    * Retorna: 
    *****************************************************************/
    public static void pedirNombre(){
        System.out.println();
        System.out.println("************************************************************************");
        System.out.println("BIENVENID A LA BATALLA NAVAL");
        System.out.println("************************************************************************");
        System.out.print("Cual es su nombre? ");
        nombre = leer.next();        
    }
    
    /*****************************************************************
    * Rutina: mostrarMenu
    * Propósito: Imprimir las opciones del menu del juego
    * Parámetros: 
    *			   
    * Retorna: 
    *****************************************************************/
    public static void mostrarInstrucciones(){
        System.out.println();
        System.out.println("************************************************************************");
        System.out.println("Hola " + nombre + " hoy tendremos una batalla de titanes. Suerte!");
        System.out.println("INSTRUCCIONES DEL JUEGO");
        System.out.println("************************************************************************");
        System.out.println("El objetivo del juego es descubrir, las celdas que contienen los barcos");
        System.out.println("del enemigo. Para ello, debe de ingresar las coordenadas (letra, numero)");
        System.out.println("de donde ud piensa que hay un barco enemigo. El sistema le dira si fallo");
        System.out.println("o pego un barco. Despues de su primer tiro, la computadora tendra su");
        System.out.println("opotunidad de hacer un tiro. Así sucesivamente, hasta que alguno de los");
        System.out.println("dos la computadora o el usuario destruya por completo los barcos uno del");
        System.out.println("otro. Ganará el que destruya los barcos de su enemigo primero.");
        System.out.println();
    }
    public static void mostrarMenu(){
        System.out.println("************************************************************************");
        System.out.println("MENU PRINCIPAL");
        System.out.println("************************************************************************");
        System.out.println("1. Si desea iniciar el jugar en un tablero de 10x10");
        System.out.println("   Obtiene 9 barcos: 3 de 2 espacios, 3 de 3 espacios y 3 de 4 espacios");
        System.out.println("2. Si desea iniciar el juego en un tablero de 20x20");
        System.out.println("   Obtiene 18 barcos: 6 de 2 espacios, 6 de 3 espacios y 6 de 4 espacios");
        System.out.println("3. Si desea SALIR");
        System.out.println("************************************************************************");
    }
    
    /*****************************************************************
    * Rutina: imprimirTableroEnemigo10x10
    * Propósito: Imprimir el tablero del enemigo que mide 10x10
    * Parámetros: 
    *			   
    * Retorna: 
    *****************************************************************/
//    public static void imprimirTableroEnemigo10x10(){
//        capaLogica.importarTableroJugador10x10();
//        capaLogica.printTableroJugador10x10();
//    }
    
    /*****************************************************************
    * Rutina: leerOpcion
    * Propósito: Obtener del usuario la opcíón escogida y ejecuta el método 
    * según lo seleccionado.
    * Parámetros: 
    *			   
    * Retorna: 
    *****************************************************************/
    public static void leerOpcion(){
        int opc = 0;
        mostrarInstrucciones();
        do {
            mostrarMenu();
            System.out.print("Seleccione su opción: ");
            opc = leer.nextInt();
            switch(opc){
                case 1: 
                    capaLogica.importarTableroJugador10x10CSV();
                    System.out.println();
                    System.out.println("Este es su tablero");
                    System.out.println("********************************");
                    System.out.println("******* Tablero Jugador ********");
                    System.out.println("********************************");
                    System.out.println("    1  2  3  4  5  6  7  8  9 10");
                    printTableroJugador10x10();
                    break;
                case 2:
                    capaLogica.importarTableroJugador20x20CSV();
                    System.out.println();
                    System.out.println("Este es su tablero");
                    System.out.println("**************************************************************");
                    System.out.println("********************** Tablero Jugador ***********************");
                    System.out.println("**************************************************************");
                    System.out.println("    1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20");
                    printTableroJugador20x20();
                    break;
                case 3:
                    System.out.println("Está seguro? (s/n)");
                    char opcion = leer.next().charAt(0);
                    if (opcion == 's'){
                        System.out.println("¡Vuelva pronto!");
                    }
                    else{
                        opc = 0;
                    }
                    break;
                default:
                    System.out.println();
                    System.out.println("Opción inválida!");
                    System.out.println();
                    opc = 0;
                    break;
            }
        }while ((opc !=1) && (opc !=3) && (opc !=2));
    }
    public static void printTableroJugador10x10(){       
        //imprimir el array
        for (int rowC = 0; rowC<10; rowC++){
            System.out.print("["+((char) ('A' + rowC))+"]" + " ");
            for(int colC=0; colC<10; colC++){
                System.out.print(capaLogica.obtenerPoscicionJugador10x10(rowC, colC)+"  ");
            }
            System.out.println();
        }
        System.out.println("********************************");
        return;
    }
    public static void importarTableroJugador10x10(int rowC, int colC){
        capaLogica.obtenerPoscicionJugador10x10(rowC,colC);
    }
    public static void printTableroJugador20x20(){       
        //imprimir el array
        for (int rowC = 0; rowC<20; rowC++){
            System.out.print("["+((char) ('A' + rowC))+"]" + " ");
            for(int colC=0; colC<20; colC++){
                System.out.print(capaLogica.obtenerPoscicionJugador20x20(rowC, colC)+"  ");
            }
            System.out.println();
        }
        System.out.println("**************************************************************");
        return;
    }
    public static void importarTableroJugador20x20(int rowC, int colC){
        capaLogica.obtenerPoscicionJugador20x20(rowC,colC);
    }
    public static void printTableroEnemigo10x10(){       
        //imprimir el array
        for (int rowC = 0; rowC<10; rowC++){
            System.out.print("["+((char) ('A' + rowC))+"]" + " ");
            for(int colC=0; colC<10; colC++){
                System.out.print(capaLogica.obtenerPoscicionEnemigo10x10(rowC, colC)+"  ");
            }
            System.out.println();
        }
        System.out.println("********************************");
        return;
    }
    public static void importarTableroEnemigo10x10(int rowC, int colC){
        capaLogica.obtenerPoscicionEnemigo10x10(rowC,colC);
    }
    public static void printTableroEnemigo20x20(){       
        //imprimir el array
        for (int rowC = 0; rowC<10; rowC++){
            System.out.print("["+((char) ('A' + rowC))+"]" + " ");
            for(int colC=0; colC<10; colC++){
                System.out.print(capaLogica.obtenerPoscicionEnemigo20x20(rowC, colC)+"  ");
            }
            System.out.println();
        }
        System.out.println("********************************");
        return;
    }
    public static void importarTableroEnemigo20x20(int rowC, int colC){
        capaLogica.obtenerPoscicionEnemigo20x20(rowC,colC);
    }
}
