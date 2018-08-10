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
    public static boolean resultadoAtaque(String pAtaque){
        int resultadoX = mandarAtaqueX(pAtaque);
        int resultadoY = mandarAtaqueY(pAtaque);
        boolean resultadoAtaque = true;
        valorEnemigo = obtenerPoscicionEnemigo10x10(resultadoY, resultadoX);
        //System.out.println("Valor " + valorEnemigo + " [" + resultadoX + "," + resultadoY + "]");
        int[][] valorAtaque = capaDatos.obtenerTableroBlank10x10();
        
        if (valorEnemigo!=0){
            resultadoAtaque = true;
            valorAtaque[resultadoY][resultadoX] = valorEnemigo;
        } else {
            resultadoAtaque = false;
            valorAtaque[resultadoY][resultadoX] = 8;
        }
        return resultadoAtaque;
    }
}
