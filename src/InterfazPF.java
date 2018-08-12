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

//Variables Globales
public class InterfazPF {
    public static Scanner leer;
    //Declaración y conexión con la capa de lógica (Archivo logica.java).
    static logica capaLogica;
    public static String nombre;
    public static String ataque;
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
        System.out.println("1. Si deseas iniciar el jugar en un tablero de 10x10");
        System.out.println("   Obtiene 9 barcos: 3 de 2 espacios, 3 de 3 espacios y 3 de 4 espacios");
        System.out.println("2. Si deseas iniciar el juego en un tablero de 20x20");
        System.out.println("   Obtiene 18 barcos: 6 de 2 espacios, 6 de 3 espacios y 6 de 4 espacios");
        System.out.println("3. Si deseas SALIR");
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
            System.out.print("Selecciona tu opción: ");
            opc = leer.nextInt();
            switch(opc){
                case 1: 
                    capaLogica.importarTableroJugador10x10CSV();
                    capaLogica.importarTableroEnemigo10x10CSV();
                    System.out.println();
                    System.out.println("Este es tu tablero");
                    System.out.println("********************************");
                    System.out.println("******* Tablero Jugador ********");
                    System.out.println("********************************");
                    System.out.println("    1  2  3  4  5  6  7  8  9 10");
                    printTableroJugador10x10();
                    System.out.println();
                    System.out.println("Este es el tablero del enemigo");
                    System.out.println("********************************");
                    System.out.println("******* Tablero Enemigo ********");
                    System.out.println("********************************");
                    System.out.println("    1  2  3  4  5  6  7  8  9 10");
                    printTableroBlank10x10();
                    int count = 1;
                    do {
                        System.out.println();
                        System.out.print("Cual es tu ataque #" + (count) + " ? ");
                        String ataque = leer.next();
                        System.out.println("Este es el tablero del enemigo");
                        System.out.println("********************************");
                        System.out.println("******* Tablero Enemigo ********");
                        System.out.println("********************************");
                        System.out.println("    1  2  3  4  5  6  7  8  9 10");
                        resultadoAtaqueJugador(ataque);
                        System.out.println();
                        System.out.println("Ataque de la computadora");
                        System.out.println("Este es el tablero del jugador");
                        System.out.println("********************************");
                        System.out.println("******* Tablero Jugador ********");
                        System.out.println("********************************");
                        System.out.println("    1  2  3  4  5  6  7  8  9 10");
                        resultadoAtaqueComputadora();
                        count++;
                        System.out.println();
                        System.out.println("MARCADOR");
                        System.out.println("**********");
                        System.out.println("Jugador: "+capaLogica.totalBarcosEnemigo);
                        System.out.println("Enemigo: "+capaLogica.totalBarcosJugador);
                        System.out.println("**********");
                        if(capaLogica.totalBarcosEnemigo == 9){
                            System.out.println();
                            System.out.println("****************************************");
                            System.out.println("************** FELICIDADES *************");
                            System.out.println("* HAS UNDIDO TODOS LOS BARCOS ENEMIGOS *");
                            System.out.println("*********** GANASTE EL JUEGO ***********");
                            System.out.println("****************************************");
                        } else if(capaLogica.totalBarcosJugador == 9){
                            System.out.println();
                            System.out.println("*****************************************");
                            System.out.println("*************** MALA SUERTE *************");
                            System.out.println("* EL ENEMIGO HA UNDIDO TODOS TUS BARCOS *");
                            System.out.println("*********** PERDISTE EL JUEGO ***********");
                            System.out.println("*****************************************");
                        }
                    } while ((capaLogica.totalBarcosEnemigo != 9) && (capaLogica.totalBarcosJugador != 9));
                    
                    break;
                case 2:
                    capaLogica.importarTableroJugador20x20CSV();
                    System.out.println();
                    System.out.println("Este es tu tablero");
                    System.out.println("**************************************************************");
                    System.out.println("********************** Tablero Jugador ***********************");
                    System.out.println("**************************************************************");
                    System.out.println("    1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20");
                    printTableroJugador20x20();
                    break;
                case 3:
                    System.out.println("Estas seguro? (s/n)");
                    char opcion = leer.next().charAt(0);
                    if (opcion == 's'){
                        System.out.println("¡Vuelve pronto!");
                    }
                    else{
                        opc = 0;
                    }
                    break;
                default:
                    System.out.println();
                    System.out.println("Opcion invalida!");
                    System.out.println();
                    opc = 0;
                    break;
            }
        }while ((opc !=1) && (opc !=3) && (opc !=2));
    }
    public static void importarTableroBlank10x10(){
        capaLogica.importarTableroBlank10x10();
    }
    static int[][] tableroBlank10x10 = capaLogica.importarTableroBlank10x10();
    public static void printTableroBlank10x10(){
        for(int i=0;i<10;i++){
            System.out.print("["+((char) ('A' + i))+"]" + " ");
            for(int j=0;j<10;j++){
                System.out.print(tableroBlank10x10[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("********************************");
    }
    
    //importar el tablero del jugador 10x10
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
    
    //importar el tablero del jugador 20x20
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
    
    //importar el tablero enemigo de 10x10
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
    
    //importar el tablero enemigo de 20x20
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
    
    //Resultado del ataque del Jugador
    public static void resultadoAtaqueJugador(String pAtaque){
        capaLogica.resultadoAtaqueJugador(pAtaque.toUpperCase());
        printTableroBlank10x10();
        if(capaLogica.valorEnemigo!=0){
            System.out.println("Buen ataque! Has undido un barco.");
            System.out.println("Total Barcos Undidos: " + capaLogica.totalBarcosEnemigo + " Faltan " + (9-capaLogica.totalBarcosEnemigo) + " Barcos por Undir.");
        } else {
            System.out.println("Tu bala se undio en lo profundo del oceano, sigue intentando.");
            System.out.println("Total Barcos Undidos: " + capaLogica.totalBarcosEnemigo + " Faltan " + (9-capaLogica.totalBarcosEnemigo) + " Barcos por Undir.");
        }
    }
    
    //Resultado del ataque de la computadora
    public static void resultadoAtaqueComputadora(){
        capaLogica.resultadoAtaqueComputadora();
        printTableroJugador10x10();
        if(capaLogica.valorJugador!=0){
            System.out.println("La computadora ha atacado y undio uno de sus barcos!");
            System.out.println("Total Barcos Undidos: " + capaLogica.totalBarcosJugador + " Faltan " + (9-capaLogica.totalBarcosJugador) + " Barcos por Undir.");
        } else {
            System.out.println("La computadora ha atacado... viste la bala pasar cerca ");
            System.out.println("pero no ha pegado ningun barco, te salvaste de esta!");
            System.out.println("Total Barcos Undidos: " + capaLogica.totalBarcosJugador + " Faltan " + (9-capaLogica.totalBarcosJugador) + " Barcos por Undir.");
        }
    }
    
    
}
