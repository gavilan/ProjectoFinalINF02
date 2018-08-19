
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
    public static int valorAtaqueBlank;
    public static int valorAtaqueJugador;
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
        return capaDatos.obtenerPosicionJugador20x20(rowC, colC);
    }
    
    public static void importarTableroEnemigo20x20CSV(){
        capaDatos.importarTableroEnemigo20x20CSV();
    }
    public static int[][] importarTableroBlank10x10(){
        return capaDatos.obtenerTableroBlank10x10();
    }
    public static int[][] importarTableroBlank20x20(){
        return capaDatos.obtenerTableroBlank20x20();
    }
    
    //Guarda las variables del ataque en string y las covierte a int
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
        
        //Este valor se usa para validar en Interfaz si esta repitiendo ataque
        valorAtaqueBlank = capaDatos.obtenerAtaqueBlank10x10(resultadoY, resultadoX);
        
        if (valorEnemigo!=0){
            resultadoAtaque = true;
            capaDatos.escribirAtaqueBlank10x10(resultadoY, resultadoX, valorEnemigo);

            //ensenar el resto del barco
            int next = 0;
            obtenerPoscicionEnemigo10x10(resultadoY,resultadoX);
            //Izquierda: descubre area de barco
            for(int i=0;i<(resultadoX+1);i++){
                if(obtenerPoscicionEnemigo10x10(resultadoY,resultadoX-i)==valorEnemigo){
                    capaDatos.escribirAtaqueBlank10x10(resultadoY, resultadoX-i, valorEnemigo);
                } else {
                    break;
                }
            }
            //Derecha: descubre area de barco
            for(int i=0;i<(11-resultadoX);i++){
                if(obtenerPoscicionEnemigo10x10(resultadoY,resultadoX+i)==valorEnemigo){
                    capaDatos.escribirAtaqueBlank10x10(resultadoY, resultadoX+i, valorEnemigo);
                } else {
                    break;
                }
            }
            //Abajo: descubre area de barco
            for(int i=0;i<(resultadoY+1);i++){
                if(obtenerPoscicionEnemigo10x10(resultadoY-i,resultadoX)==valorEnemigo){
                    capaDatos.escribirAtaqueBlank10x10(resultadoY-i, resultadoX, valorEnemigo);
                } else {
                    break;
                }
            }
            //Arriba: descubre area de barco
            for(int i=0;i<(11-resultadoY);i++){
                if(obtenerPoscicionEnemigo10x10(resultadoY+i,resultadoX)==valorEnemigo){
                    capaDatos.escribirAtaqueBlank10x10(resultadoY+i, resultadoX, valorEnemigo);
                } else {
                    break;
                }
            }
            if(valorAtaqueBlank==0){
                totalBarcosEnemigo++; 
            }
             
        } else {
            resultadoAtaque = false;
            capaDatos.escribirAtaqueBlank10x10(resultadoY, resultadoX, 8);
        }
        return resultadoAtaque;
    }
    
    public static int mandarAtaqueX20x20(String ataque){
        
        if(ataque.length() > 2){
            int yAxis1 = Character.getNumericValue(ataque.charAt(1));
            int yAxis2 = Character.getNumericValue(ataque.charAt(2));
            int yAxis = yAxis1*10+yAxis2;
            int newYAxis = yAxis-1;
            return newYAxis;
        } else {
            int yAxis = Character.getNumericValue(ataque.charAt(1));
            int newYAxis = yAxis-1;
            return newYAxis;
        }
        
    }
    public static int mandarAtaqueY20x20(String ataque){
        char xAxis = ataque.charAt(0);
        int newXAxis = xAxis - 'A';
        return newXAxis;
    }
    
    //guarda el valor del ataque y lo compara para ver si pego o no un barco 20x20
    public static boolean resultadoAtaqueJugador20x20(String pAtaque){
        int resultadoX = mandarAtaqueX20x20(pAtaque);
        int resultadoY = mandarAtaqueY20x20(pAtaque);
        boolean resultadoAtaque = true;
        valorEnemigo = obtenerPoscicionEnemigo20x20(resultadoY, resultadoX);
        System.out.println(resultadoY+" "+resultadoX);
        System.out.println(mandarAtaqueY(pAtaque)+" "+mandarAtaqueY(pAtaque));
        
        //Este valor se usa para validar en Interfaz si esta repitiendo ataque
        valorAtaqueBlank = capaDatos.obtenerAtaqueBlank20x20(resultadoY, resultadoX);
        
        if (valorEnemigo!=0){
            resultadoAtaque = true;
            capaDatos.escribirAtaqueBlank20x20(resultadoY, resultadoX, valorEnemigo);

            //ensenar el resto del barco
            int next = 0;
            obtenerPoscicionEnemigo20x20(resultadoY,resultadoX);
            //Izquierda: descubre area de barco
            for(int i=0;i<(resultadoX+1);i++){
                if(obtenerPoscicionEnemigo20x20(resultadoY,resultadoX-i)==valorEnemigo){
                    capaDatos.escribirAtaqueBlank20x20(resultadoY, resultadoX-i, valorEnemigo);
                } else {
                    break;
                }
            }
            //Derecha: descubre area de barco
            for(int i=0;i<(21-resultadoX);i++){
                if(obtenerPoscicionEnemigo20x20(resultadoY,resultadoX+i)==valorEnemigo){
                    capaDatos.escribirAtaqueBlank20x20(resultadoY, resultadoX+i, valorEnemigo);
                } else {
                    break;
                }
            }
            //Abajo: descubre area de barco
            for(int i=0;i<(resultadoY+1);i++){
                if(obtenerPoscicionEnemigo20x20(resultadoY-i,resultadoX)==valorEnemigo){
                    capaDatos.escribirAtaqueBlank20x20(resultadoY-i, resultadoX, valorEnemigo);
                } else {
                    break;
                }
            }
            //Arriba: descubre area de barco
            for(int i=0;i<(21-resultadoY);i++){
                if(obtenerPoscicionEnemigo20x20(resultadoY+i,resultadoX)==valorEnemigo){
                    capaDatos.escribirAtaqueBlank20x20(resultadoY+i, resultadoX, valorEnemigo);
                } else {
                    break;
                }
            }
            if(valorAtaqueBlank==0){
                totalBarcosEnemigo++; 
            }
             
        } else {
            resultadoAtaque = false;
            capaDatos.escribirAtaqueBlank20x20(resultadoY, resultadoX, 8);
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
        //int[][] valorAtaque = capaDatos.tableroJugador10x10;
        int valorPosAtaqueJugador=capaDatos.obtenerPosicionJugador10x10(resultadoY,resultadoX);
        //
        if (valorJugador!=0){
            resultadoAtaqueComputadora = true;
            totalBarcosJugador++;
            valorAtaqueJugador = 5;
            capaDatos.obtenerPosicionJugador10x10(resultadoY,resultadoX);
            //Izquierda: descubre area de barco
            for(int i=0;i<(resultadoX+1);i++){
                if(capaDatos.obtenerPosicionJugador10x10(resultadoY,resultadoX-i)==valorPosAtaqueJugador){
                    capaDatos.escribirAtaqueJugador10x10(resultadoY, resultadoX-i, valorAtaqueJugador);
                } else {
                    break;
                }
            }
            //Derecha: descubre area de barco
            for(int i=0;i<(11-resultadoX);i++){
                if(capaDatos.obtenerPosicionJugador10x10(resultadoY,resultadoX+i)==valorPosAtaqueJugador){
                    capaDatos.escribirAtaqueJugador10x10(resultadoY, resultadoX+i, valorAtaqueJugador);
                } else {
                    break;
                }
            }
            //Abajo: descubre area de barco
            for(int i=0;i<(resultadoY+1);i++){
                if(capaDatos.obtenerPosicionJugador10x10(resultadoY-i,resultadoX)==valorPosAtaqueJugador){
                    capaDatos.escribirAtaqueJugador10x10(resultadoY-i, resultadoX, valorAtaqueJugador);
                } else {
                    break;
                }
            }
            //Arriba: descubre area de barco
            for(int i=0;i<(11-resultadoY);i++){
                if(capaDatos.obtenerPosicionJugador10x10(resultadoY+i,resultadoX)==valorPosAtaqueJugador){
                    capaDatos.escribirAtaqueJugador10x10(resultadoY+i, resultadoX, valorAtaqueJugador);
                } else {
                    break;
                }
            }
        }else{
            valorAtaqueJugador = 8;
            capaDatos.escribirAtaqueJugador10x10(resultadoY, resultadoX, valorAtaqueJugador);
            
        }
        return resultadoAtaqueComputadora;
    }
    
    //Generaor de ataque Random 20x20
    static int randomNumbers20x20(){
        Random randomNum = new Random();
        int num = 0 + randomNum.nextInt(20);

        //Conversion de int a Array de Int
        String temp = Integer.toString(num);
        int numArr = temp.charAt(0) - '0';
        return numArr;
    }
    
    public static boolean resultadoAtaqueComputadora20x20(){
        int resultadoX = randomNumbers20x20();
        int resultadoY = randomNumbers20x20();
        boolean resultadoAtaqueComputadora = true;
        valorJugador = obtenerPoscicionJugador20x20(resultadoY, resultadoX);
        //System.out.println("Valor " + valorJugador + " [" + resultadoX + "," + resultadoY + "]");
        //int[][] valorAtaque = capaDatos.tableroJugador10x10;
        int valorPosAtaqueJugador=capaDatos.obtenerPosicionJugador20x20(resultadoY,resultadoX);
        //
        if (valorJugador!=0){
            resultadoAtaqueComputadora = true;
            totalBarcosJugador++;
            valorAtaqueJugador = 5;
            capaDatos.obtenerPosicionJugador20x20(resultadoY,resultadoX);
            //Izquierda: descubre area de barco
            for(int i=0;i<(resultadoX+1);i++){
                if(capaDatos.obtenerPosicionJugador20x20(resultadoY,resultadoX-i)==valorPosAtaqueJugador){
                    capaDatos.escribirAtaqueJugador20x20(resultadoY, resultadoX-i, valorAtaqueJugador);
                } else {
                    break;
                }
            }
            //Derecha: descubre area de barco
            for(int i=0;i<(11-resultadoX);i++){
                if(capaDatos.obtenerPosicionJugador20x20(resultadoY,resultadoX+i)==valorPosAtaqueJugador){
                    capaDatos.escribirAtaqueJugador20x20(resultadoY, resultadoX+i, valorAtaqueJugador);
                } else {
                    break;
                }
            }
            //Abajo: descubre area de barco
            for(int i=0;i<(resultadoY+1);i++){
                if(capaDatos.obtenerPosicionJugador20x20(resultadoY-i,resultadoX)==valorPosAtaqueJugador){
                    capaDatos.escribirAtaqueJugador20x20(resultadoY-i, resultadoX, valorAtaqueJugador);
                } else {
                    break;
                }
            }
            //Arriba: descubre area de barco
            for(int i=0;i<(11-resultadoY);i++){
                if(capaDatos.obtenerPosicionJugador20x20(resultadoY+i,resultadoX)==valorPosAtaqueJugador){
                    capaDatos.escribirAtaqueJugador20x20(resultadoY+i, resultadoX, valorAtaqueJugador);
                } else {
                    break;
                }
            }
        }else{
            valorAtaqueJugador = 8;
            capaDatos.escribirAtaqueJugador20x20(resultadoY, resultadoX, valorAtaqueJugador);
            
        }
        return resultadoAtaqueComputadora;
    }
        //
        
//        if (valorJugador!=0){
//            resultadoAtaqueComputadora = true;
//            valorAtaque[resultadoY][resultadoX] = 5;
//            totalBarcosJugador++;
//        } else {
//            resultadoAtaqueComputadora = false;
//            valorAtaque[resultadoY][resultadoX] = 8;
//        }
//        
//        return resultadoAtaqueComputadora;
//    }
}
