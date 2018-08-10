
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gavilan
 */
public class datos {
    /***********************************************************************************************
     * Array del enemigo Nivel 1 : 9 barcos
     * 3 barcos grandes(4 casillas), 3 barcos medianos(3 casillas), 3 pequenos(2 casillas)
     * *********************************************************************************************/
    
    static int [][] tableroJugador10x10;
    static void importarTableroJugador10x10CSV(){
        tableroJugador10x10 = new int[10][10];
        
        Scanner scanIn = null;
        int rowC = 0;
        int row = 0;
        int colC = 0;
        int col = 0;
        String inputLine = "";
        int xNum = 0;
        String xFileLocation;
        
        xFileLocation = "/Users/Gavilan/Desktop/projectoFinalINF02/jugador10x10.csv";
        
        try {
            //setup a scanner
            scanIn = new Scanner (new BufferedReader(new FileReader(xFileLocation)));
            
            while(scanIn.hasNextLine()){
                //Read line in from file
                inputLine = scanIn.nextLine();
                //Split the inputLine into an array at the commas
                String[] inArray = inputLine.split(",");
                
                //Copy  the content  of the inArray to the tableroEnemigo
                for(int x=0; x<inArray.length; x++){
                    tableroJugador10x10[rowC][x]=Integer.parseInt(inArray[x]);
                }
                //Increment the row in the array
                rowC++;
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    public static int obtenerPosicionJugador10x10(int rowC, int colC){
        return tableroJugador10x10[rowC][colC];
    }
    
    
    
    /***********************************************************************************************
     * Array del enemigo Nivel 2 : 18 barcos
     * 6 barcos grandes(4 casillas), 6 barcos medianos(3 casillas), 6 pequenos(2 casillas)
     ***********************************************************************************************/
    static int[][] tableroJugador20x20 = new int[20][20];
    static void importarTableroJugador20x20CSV(){
        tableroJugador20x20 = new int[20][20];
        
        Scanner scanIn = null;
        int rowC = 0;
        int row = 0;
        int colC = 0;
        int col = 0;
        String inputLine = "";
        int xNum = 0;
        String xFileLocation;
        
        xFileLocation = "/Users/Gavilan/Desktop/projectoFinalINF02/jugador20x20.csv";
        
        try {
            //setup a scanner
            scanIn = new Scanner (new BufferedReader(new FileReader(xFileLocation)));
            
            while(scanIn.hasNextLine()){
                //Read line in from file
                inputLine = scanIn.nextLine();
                //Split the inputLine into an array at the commas
                String[] inArray = inputLine.split(",");
                
                //Copy  the content  of the inArray to the tableroEnemigo
                for(int x=0; x<inArray.length; x++){
                    tableroJugador20x20[rowC][x]=Integer.parseInt(inArray[x]);
                }
                //Increment the row in the array
                rowC++;
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    public static int obtenerPosicionJugador20x20(int rowC, int colC){
        return tableroJugador20x20[rowC][colC];
    }
    
    /***********************************************************************************************
     * Array del jugador Nivel 1 : 9 barcos
     * 3 barcos grandes(4 casillas), 3 barcos medianos(3 casillas), 3 pequenos(2 casillas) 
     ***********************************************************************************************/
    static int[][] tableroEnemigo10x10 = new int[10][10];
    static void importarTableroEnemigo10x10CSV(){
        tableroEnemigo10x10 = new int[10][10];
        
        Scanner scanIn = null;
        int rowC = 0;
        int row = 0;
        int colC = 0;
        int col = 0;
        String inputLine = "";
        int xNum = 0;
        String xFileLocation;
        
        xFileLocation = "/Users/Gavilan/Desktop/projectoFinalINF02/enemigo10x10.csv";
        
        try {
            //setup a scanner
            scanIn = new Scanner (new BufferedReader(new FileReader(xFileLocation)));
            
            while(scanIn.hasNextLine()){
                //Read line in from file
                inputLine = scanIn.nextLine();
                //Split the inputLine into an array at the commas
                String[] inArray = inputLine.split(",");
                
                //Copy  the content  of the inArray to the tableroEnemigo
                for(int x=0; x<inArray.length; x++){
                    tableroEnemigo10x10[rowC][x]=Integer.parseInt(inArray[x]);
                }
                //Increment the row in the array
                rowC++;
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    public static int obtenerPosicionEnemigo10x10(int rowC, int colC){
        return tableroEnemigo10x10[rowC][colC];
    }
    
    /***********************************************************************************************
     * Array del jugador Nivel 2 : 18 barcos
     * 6 barcos grandes(4 casillas), 6 barcos medianos(3 casillas), 6 pequenos(2 casillas)
     ***********************************************************************************************/
    static int[][] tableroEnemigo20x20 = new int[20][20];
    static void importarTableroEnemigo20x20CSV(){
        tableroEnemigo20x20 = new int[20][20];
        
        Scanner scanIn = null;
        int rowC = 0;
        int row = 0;
        int colC = 0;
        int col = 0;
        String inputLine = "";
        int xNum = 0;
        String xFileLocation;
        
        xFileLocation = "/Users/Gavilan/Desktop/projectoFinalINF02/enemigo20x20.csv";
        
        try {
            //setup a scanner
            scanIn = new Scanner (new BufferedReader(new FileReader(xFileLocation)));
            
            while(scanIn.hasNextLine()){
                //Read line in from file
                inputLine = scanIn.nextLine();
                //Split the inputLine into an array at the commas
                String[] inArray = inputLine.split(",");
                
                //Copy  the content  of the inArray to the tableroEnemigo
                for(int x=0; x<inArray.length; x++){
                    tableroEnemigo20x20[rowC][x]=Integer.parseInt(inArray[x]);
                }
                //Increment the row in the array
                rowC++;
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    public static int obtenerPosicionEnemigo20x20(int rowC, int colC){
        return tableroEnemigo20x20[rowC][colC];
    }
    
    /***********************************************************************************************
     * Array sin ver los barcos para el 10x10 y 20x20
     * todo se ve en 0's
     ***********************************************************************************************/
    static int[][] tableroBlank10x10 = new int[][]{
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
    };
    public static int[][] obtenerTableroBlank10x10(){
        return tableroBlank10x10;
    }
    static int[][] tableroBlank20x20 = new int[][]{
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    };
    
    /***********************************************************************************************
     * Llave para determinar que son los numeros en los tableros
     * 0 = agua
     * 1 = barco pequeño
     * 2 = barco mediano
     * 3 = barco grande
     * 8 = barco destruido
     * 5 = Tiro fallido
     ***********************************************************************************************/
    
    
}
