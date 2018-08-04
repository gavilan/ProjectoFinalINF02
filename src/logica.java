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
    public static void logica(){
        capaDatos = new datos();
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
}
