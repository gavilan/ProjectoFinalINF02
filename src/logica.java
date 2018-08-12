
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gavilan
 */
public class logica {
    static datos capaDatos;
    static InterfazPF interfaz;
    public static char xAxis;
    public static int yAxis;
    public static int newXAxis;
    public static int newYAxis;
    public static int valorEnemigo;
    public static int valorJugador;
    public static int totalBarcosEnemigo;
    public static int totalBarcosJugador;
    public static int [] numRand;
    public static void logica(){
        capaDatos = new datos();
        interfaz = new InterfazPF();
    }
    
    /*****************************************************************
    * Rutina: crearTableroJugador
    * Propósito: crear el tablero enemigo
    * Parámetro: dimension
    *			   10x10 o 20x20
    * Retorna: matriz de 10x10 o 20x20
    *****************************************************************/
    
    public static int obtenerPoscicionJugador10x10(int rowC, int colC){
        return capaDatos.obtenerPosicionJugador10x10(rowC, colC);
    }
    
    public static void importarTableroJugador10x10CSV(){
        capaDatos.importarTableroJugador10x10CSV();
    }
    
    public static int obtenerPoscicionJugador20x20(int rowC, int colC){
        return capaDatos.obtenerPosicionJugador20x20(rowC, colC);
    }
    
    public static void importarTableroJugador20x20CSV(){
        capaDatos.importarTableroJugador20x20CSV();
    }
    
    public static int obtenerPoscicionEnemigo10x10(int rowC, int colC){
        return capaDatos.obtenerPosicionEnemigo10x10(rowC, colC);
    }
    
    public static void importarTableroEnemigo10x10CSV(){
        capaDatos.importarTableroEnemigo10x10CSV();
    }
    
    public static int obtenerPoscicionEnemigo20x20(int rowC, int colC){
        return capaDatos.obtenerPosicionJugador10x10(rowC, colC);
    }
    
    public static void importarTableroEnemigo20x20CSV(){
        capaDatos.importarTableroEnemigo20x20CSV();
    }
    public static int[][] importarTableroBlank10x10(){
        return capaDatos.obtenerTableroBlank10x10();
    }
    
    //Guarda las variables del ataque en strign y las covierte a int
    public static int mandarAtaqueX(String ataque){
        int yAxis = Character.getNumericValue(ataque.charAt(1));
        int newYAxis = yAxis-1;
        return newYAxis;
    }
    public static int mandarAtaqueY(String ataque){
        char xAxis = ataque.charAt(0);
        int newXAxis = xAxis - 'A';
        return newXAxis;
    }
    
    //guarda el valor del ataque y lo compara para ver si pego o no un barco
    public static boolean resultadoAtaqueJugador(String pAtaque){
        int resultadoX = mandarAtaqueX(pAtaque);
        int resultadoY = mandarAtaqueY(pAtaque);
        boolean resultadoAtaque = true;
        valorEnemigo = obtenerPoscicionEnemigo10x10(resultadoY, resultadoX);
        int valorEnemigo1R = obtenerPoscicionEnemigo10x10(resultadoY,(resultadoX)+1);
        int valorEnemigo1L = obtenerPoscicionEnemigo10x10(resultadoY,((resultadoX)-1));
        int valorEnemigo1D = obtenerPoscicionEnemigo10x10(((resultadoY)+1),resultadoX);
        int valorEnemigo1U = obtenerPoscicionEnemigo10x10(((resultadoY)-1),resultadoX);
        //System.out.println("Valor " + valorEnemigo + " [" + resultadoX + "," + resultadoY + "]");
        System.out.println(valorEnemigo1D + " "+ valorEnemigo1U + " "+ valorEnemigo1L + " "+ valorEnemigo1R);
        int[][] valorAtaque = capaDatos.obtenerTableroBlank10x10();
        
        if (valorEnemigo!=0){
            resultadoAtaque = true;
            valorAtaque[resultadoY][resultadoX] = valorEnemigo;
            
//            valorAtaque[resultadoY][resultadoX+1] = 11;
//            valorAtaque[resultadoY][resultadoX-1] = 22;
//            valorAtaque[resultadoY+1][resultadoX] = 33;
//            valorAtaque[resultadoY-1][resultadoX] = 44;
            //ensenar el resto del barco
            if(valorEnemigo1R==valorEnemigo){
                valorAtaque[resultadoY][resultadoX+1] = valorEnemigo;
            }
            if (valorEnemigo1L==valorEnemigo) {
                valorAtaque[resultadoY][resultadoX-1] = valorEnemigo;
            }
            if (valorEnemigo1D==valorEnemigo) {
                valorAtaque[resultadoY+1][resultadoX] = valorEnemigo;
            }
            if (valorEnemigo1U==valorEnemigo){
                valorAtaque[resultadoY-1][resultadoX] = valorEnemigo;
            }
            totalBarcosEnemigo++;
            
        } else {
            resultadoAtaque = false;
            valorAtaque[resultadoY][resultadoX] = 8;
        }
        return resultadoAtaque;
    }
    
    //Generaor de ataque Random
    static int randomNumbers(){
        Random randomNum = new Random();
        int num = 0 + randomNum.nextInt(10);

        //Conversion de int a Array de Int
        String temp = Integer.toString(num);
        int numArr = temp.charAt(0) - '0';
        return numArr;
    }
    
    public static boolean resultadoAtaqueComputadora(){
        int resultadoX = randomNumbers();
        int resultadoY = randomNumbers();
        boolean resultadoAtaqueComputadora = true;
        valorJugador = obtenerPoscicionJugador10x10(resultadoY, resultadoX);
        //System.out.println("Valor " + valorJugador + " [" + resultadoX + "," + resultadoY + "]");
        int[][] valorAtaque = capaDatos.tableroJugador10x10;
        
        if (valorJugador!=0){
            resultadoAtaqueComputadora = true;
            valorAtaque[resultadoY][resultadoX] = 5;
            totalBarcosJugador++;
        } else {
            resultadoAtaqueComputadora = false;
            valorAtaque[resultadoY][resultadoX] = 8;
        }
        return resultadoAtaqueComputadora;
    }
}
