/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
import java.util.Scanner;

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
                    tablerosIniciales10x10();
                    do {
                        ataqueJugador();
                        ataqueCompu();
                        resultadoAtaqueJugador(ataque);
                        imprimirMarcador();
                    } while ((capaLogica.totalBarcosEnemigo != 9) && (capaLogica.totalBarcosJugador != 9));
                    break;
                case 2:
                    tablerosIniciales20x20();
                    do {
                        ataqueJugador();
                        ataqueCompu20x20();
                        resultadoAtaqueJugador20x20(ataque);
                        imprimirMarcador20x20();
                    } while ((capaLogica.totalBarcosEnemigo != 18) && (capaLogica.totalBarcosJugador != 18));
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
    
    //metodo para importar el tablero en blanco del 10x10
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
    
    //metodo para importar el tablero en blanco del 20x20
    public static void importarTableroBlank20x20(){
        capaLogica.importarTableroBlank20x20();
    }
    static int[][] tableroBlank20x20 = capaLogica.importarTableroBlank20x20();
    public static void printTableroBlank20x20(){
        for(int i=0;i<20;i++){
            System.out.print("["+((char) ('A' + i))+"]" + " ");
            for(int j=0;j<20;j++){
                System.out.print(tableroBlank20x20[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("****************************************************************");
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
        System.out.println("****************************************************************");
        return;
    }
    public static void importarTableroEnemigo20x20(int rowC, int colC){
        capaLogica.obtenerPoscicionEnemigo20x20(rowC,colC);
    }
    
    //Metodo que imprime tableros iniciales 10x10
    public static void tablerosIniciales10x10(){
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
    }
    
    //metodo tableros iniciales 20x20
    public static void tablerosIniciales20x20(){
        capaLogica.importarTableroJugador20x20CSV();
        capaLogica.importarTableroEnemigo20x20CSV();
        System.out.println();
        System.out.println("Este es tu tablero");
        System.out.println("**************************************************************");
        System.out.println("********************** Tablero Jugador ***********************");
        System.out.println("**************************************************************");
        System.out.println("    1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20");
        printTableroJugador20x20();
        System.out.println();
        System.out.println("Este es el tablero del enemigo");
        System.out.println("**************************************************************");
        System.out.println("********************** Tablero Enemigo ***********************");
        System.out.println("**************************************************************");
        System.out.println("    1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20");
        printTableroBlank20x20();
    }
    //Metodo para el ataque del jugador
    public static void ataqueJugador(){
        System.out.println();
        System.out.print("Cual es tu ataque: ");
        ataque = leer.next();
    }
        
    //Metodo para el ataque de la compu
    public static void ataqueCompu(){
        System.out.println();
        System.out.println("Ataque de la computadora");
        System.out.println("Este es el tablero del jugador");
        System.out.println("********************************");
        System.out.println("******* Tablero Jugador ********");
        System.out.println("********************************");
        System.out.println("    1  2  3  4  5  6  7  8  9 10");
        resultadoAtaqueComputadora();
    }
    
    //Metodo para el ataque de la compu 20x20
    public static void ataqueCompu20x20(){
        System.out.println();
        System.out.println("Ataque de la computadora");
        System.out.println("Este es tu tablero");
        System.out.println("**************************************************************");
        System.out.println("********************** Tablero Jugador ***********************");
        System.out.println("**************************************************************");
        System.out.println("    1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20");
        resultadoAtaqueComputadora20x20();
    }
    
    //Metodo para imprimir marcador
    public static void imprimirMarcador(){
        System.out.println();
        System.out.println("MARCADOR");
        System.out.println("**********");
        System.out.println("Jugador: "+capaLogica.totalBarcosEnemigo);
        System.out.println("Enemigo: "+capaLogica.totalBarcosJugador);
        System.out.println("**********");
        if(capaLogica.totalBarcosEnemigo == 9){
            System.out.println();
            System.out.println("*****************************************");
            System.out.println("************** FELICIDADES **************");
            System.out.println("* HAS HUNDIDO TODOS LOS BARCOS ENEMIGOS *");
            System.out.println("*********** GANASTE EL JUEGO ************");
            System.out.println("*****************************************");
        } else if(capaLogica.totalBarcosJugador == 9){
            System.out.println();
            System.out.println("******************************************");
            System.out.println("*************** MALA SUERTE **************");
            System.out.println("* EL ENEMIGO HA HUNDIDO TODOS TUS BARCOS *");
            System.out.println("*********** PERDISTE EL JUEGO ************");
            System.out.println("******************************************");
        }
    }
    
    //Metodo para imprimir marcador
    public static void imprimirMarcador20x20(){
        System.out.println();
        System.out.println("MARCADOR");
        System.out.println("**********");
        System.out.println("Jugador: "+capaLogica.totalBarcosEnemigo);
        System.out.println("Enemigo: "+capaLogica.totalBarcosJugador);
        System.out.println("**********");
        if(capaLogica.totalBarcosEnemigo == 18){
            System.out.println();
            System.out.println("*****************************************");
            System.out.println("************** FELICIDADES **************");
            System.out.println("* HAS HUNDIDO TODOS LOS BARCOS ENEMIGOS *");
            System.out.println("*********** GANASTE EL JUEGO ************");
            System.out.println("*****************************************");
        } else if(capaLogica.totalBarcosJugador == 18){
            System.out.println();
            System.out.println("******************************************");
            System.out.println("*************** MALA SUERTE **************");
            System.out.println("* EL ENEMIGO HA HUNDIDO TODOS TUS BARCOS *");
            System.out.println("*********** PERDISTE EL JUEGO ************");
            System.out.println("******************************************");
        }
    }
    
    //Resultado del ataque del Jugador 10x10
    public static void resultadoAtaqueJugador(String pAtaque){
        capaLogica.resultadoAtaqueJugador(pAtaque.toUpperCase());
        System.out.println();
        System.out.println("Este es el tablero del enemigo");
        System.out.println("********************************");
        System.out.println("******* Tablero Enemigo ********");
        System.out.println("********************************");
        System.out.println("    1  2  3  4  5  6  7  8  9 10");
        printTableroBlank10x10();
        
//        if(capaLogica.valorAtaqueBlank == 1 || capaLogica.valorAtaqueBlank == 2 || capaLogica.valorAtaqueBlank == 3){
//            System.out.println();
//            System.out.print("Ya ese barco esta undido, intenta una posicion nueva: ");
//            String ataque = leer.next();
//        } else if(capaLogica.valorAtaqueBlank == 8){
//            System.out.println();
//            System.out.print("Ya habias atacado en esa posicion y habias fallado, intenta una nueva: ");
//            String ataque = leer.next();
//        }
        if(capaLogica.valorEnemigo!=0){
            System.out.println();
            System.out.println("Buen ataque! Has hundido un barco.");
            System.out.println("Total barcos hundidos: " + capaLogica.totalBarcosEnemigo + " faltan " + (9-capaLogica.totalBarcosEnemigo) + " barcos por hundir.");        
        }else {
            System.out.println();
            System.out.println("Tu bala se hundio en lo profundo del oceano, sigue intentando.");
            System.out.println("Total barcos hundidos: " + capaLogica.totalBarcosEnemigo + " faltan " + (9-capaLogica.totalBarcosEnemigo) + " barcos por hundir.");
        }
    }
    
    //Resultado ataque jugador 20x20
    public static void resultadoAtaqueJugador20x20(String pAtaque){
        capaLogica.resultadoAtaqueJugador20x20(pAtaque.toUpperCase());
        System.out.println();
        System.out.println("Este es el tablero del enemigo");
        System.out.println("**************************************************************");
        System.out.println("********************** Tablero Enemigo ***********************");
        System.out.println("**************************************************************");
        System.out.println("    1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20");
        printTableroBlank20x20();
        
//        if(capaLogica.valorAtaqueBlank == 1 || capaLogica.valorAtaqueBlank == 2 || capaLogica.valorAtaqueBlank == 3){
//            System.out.println();
//            System.out.print("Ya ese barco esta undido, intenta una posicion nueva: ");
//            String ataque = leer.next();
//        } else if(capaLogica.valorAtaqueBlank == 8){
//            System.out.println();
//            System.out.print("Ya habias atacado en esa posicion y habias fallado, intenta una nueva: ");
//            String ataque = leer.next();
//        }
        if(capaLogica.valorEnemigo!=0){
            System.out.println();
            System.out.println("Buen ataque! Has hundido un barco.");
            System.out.println("Total barcos hundidos: " + capaLogica.totalBarcosEnemigo + " faltan " + (18-capaLogica.totalBarcosEnemigo) + " barcos por hundir.");        
        }else {
            System.out.println();
            System.out.println("Tu bala se hundio en lo profundo del oceano, sigue intentando.");
            System.out.println("Total barcos hundidos: " + capaLogica.totalBarcosEnemigo + " faltan " + (18-capaLogica.totalBarcosEnemigo) + " barcos por hundir.");
        }
    }
    
    //Resultado del ataque de la computadora
    public static void resultadoAtaqueComputadora(){
        capaLogica.resultadoAtaqueComputadora();
        printTableroJugador10x10();
        if(capaLogica.valorJugador!=0){
            System.out.println();
            System.out.println("La computadora ha atacado y hundio uno de sus barcos!");
            System.out.println("Total barcos hundidos: " + capaLogica.totalBarcosJugador + " faltan " + (9-capaLogica.totalBarcosJugador) + " barcos por hundir.");
        } else {
            System.out.println();
            System.out.println("La computadora ha atacado... viste la bala pasar cerca ");
            System.out.println("pero no ha pegado ningun barco, te salvaste de esta!");
            System.out.println("Total barcos hundidos: " + capaLogica.totalBarcosJugador + " faltan " + (9-capaLogica.totalBarcosJugador) + " barcos por hundir.");
        }
    }
    
    //Resultado del ataque de la computadora 20x20
    public static void resultadoAtaqueComputadora20x20(){
        capaLogica.resultadoAtaqueComputadora20x20();
        printTableroJugador20x20();
        if(capaLogica.valorJugador!=0){
            System.out.println();
            System.out.println("La computadora ha atacado y hundio uno de sus barcos!");
            System.out.println("Total barcos hundidos: " + capaLogica.totalBarcosJugador + " faltan " + (18-capaLogica.totalBarcosJugador) + " barcos por hundir.");
        } else {
            System.out.println();
            System.out.println("La computadora ha atacado... viste la bala pasar cerca ");
            System.out.println("pero no ha pegado ningun barco, te salvaste de esta!");
            System.out.println("Total barcos hundidos: " + capaLogica.totalBarcosJugador + " faltan " + (18-capaLogica.totalBarcosJugador) + " barcos por hundir.");
        }
    }
    
    
}
