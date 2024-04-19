package co.edu.uniquindio.poo.Parqueadero;

import co.edu.uniquindio.poo.Espacio.EspacioDao;

import java.util.logging.Logger;

/**
 * Clase para el parqueadero, contiene sus atributos
 * y metodos
 * */
public class ParqueaderoDao {

    private EspacioDao[][] matrizEspacios;
    public static int FILAS = 5;
    public static int COLUMNAS = 5;
    private Boolean espacioHabilitado;
    private Boolean espacioProhibido;
    private Boolean estado;

    //Implementacion del logger
    private static final Logger LOG = Logger.getLogger(ParqueaderoDao.class.getName());

    public ParqueaderoDao() {
        matrizEspacios = new EspacioDao[FILAS][COLUMNAS];
    }

    //Matriz que define los espacios del parqueadero
    public static boolean[][] espacios = new boolean[0][0];


    //Asignacion de espacio 5x5 por defecto
    public static boolean[][] configuracionDefecto(){
        espacios = new boolean[5][5];

        //Rellenar la matriz
        for(int i=0; i< espacios.length; i++){
            for(int j=0; j< espacios.length; j++) {
                espacios[i][j] = false;
            }
        }
        //espacios[0][0] = true;

        //Mostrar la matriz en pantalla
        for(int i=0; i< espacios.length; i++){
            for(int j=0; j< espacios.length; j++) {
               System.out.print(espacios[i][j]+" ");
            }
            System.out.println();
        }

    return espacios;
    }

}
