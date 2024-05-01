package co.edu.uniquindio.poo.Parqueadero;

import co.edu.uniquindio.poo.Espacio.EspacioDao;
import co.edu.uniquindio.poo.Vehiculo.Carro.CarroDao;

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
    public static EspacioDao[][] espacios = new EspacioDao[0][0];


    //Asignacion de espacio 5x5 por defecto
    public static EspacioDao[][] configuracionDefecto(){

        int letraCodigoAscii = 65;
        espacios = new EspacioDao[3][3];
        int numId = 0;

        //Rellenar la matriz
        for(int i=0; i< espacios.length; i++){
                char caracter = (char) letraCodigoAscii;
                letraCodigoAscii = letraCodigoAscii+1;
            for(int j=0; j< espacios.length; j++) {
                numId = numId +1;
                String id = caracter + "-"+numId;
                espacios[i][j] = new EspacioDao(id,true, false);
            }
        }




    return espacios;
    }

    public static void verMatrizConsola(){
        //Mostrar la matriz en pantalla
        for(int i=0; i< espacios.length; i++){
            for(int j=0; j< espacios.length; j++) {
                System.out.print(espacios[i][j]+" ");
            }
            System.out.println();
        }
    }



}
