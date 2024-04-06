package co.edu.uniquindio.poo.Parqueadero;

import java.util.logging.Logger;

/**
 * Clase para el parqueadero, contiene sus atributos
 * y metodos
 * */
public class ParqueaderoDao {

    //Implementacion del logger
    private static final Logger LOG = Logger.getLogger(ParqueaderoDao.class.getName());


    private Boolean espacioHabilitado;
    private Boolean espacioProhibido;
    private Boolean estado;

    //Matriz que define los espacios del parqueadero
    public static boolean[][] espacios = new boolean[0][0];


    //Asignacion de espacio 5x5 por defecto
    public static void configuracionDefecto(){
        espacios = new boolean[5][5];
        espacios[0][0] = true;

        //Rellenar la matriz
        for(int i=0; i< espacios.length; i++){
            for(int j=0; j< espacios.length; j++) {
                espacios[i][j] = false;
            }
        }

        //Mostrar la matriz en pantalla
        for(int i=0; i< espacios.length; i++){
            for(int j=0; j< espacios.length; j++) {
               System.out.print(espacios[i][j]+" ");
            }
            System.out.println();
        }

    }

}
