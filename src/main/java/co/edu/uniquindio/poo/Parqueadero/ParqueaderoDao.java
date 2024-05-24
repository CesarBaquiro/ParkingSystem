package co.edu.uniquindio.poo.Parqueadero;

import co.edu.uniquindio.poo.Espacio.EspacioDao;
import co.edu.uniquindio.poo.Vehiculo.VehiculoDao;

import java.time.LocalDateTime;
import java.util.Scanner;

import static co.edu.uniquindio.poo.Parqueadero.ParqueaderoController.*;

/**
 * Clase ParqueaderoDao contiene sus atributos y metodos para la configuracion del parqueadero
 * */
public class ParqueaderoDao {

    private EspacioDao[][] matrizEspacios;
    public static int FILAS = 3;
    public static int COLUMNAS = 3;
    private Boolean espacioHabilitado;
    private Boolean espacioProhibido;
    private Boolean estado;


    public static double costoHoraCarro = 3000;
    public static double costoHoraMoto = 3000;

    //Implementacion del logger

    //Matriz que define los espacios del parqueadero
    public static EspacioDao[][] espacios = new EspacioDao[0][0];

    private static final Scanner scanner = new Scanner(System.in);


    //Asignacion de espacio 5x5 por defecto
    public static EspacioDao[][] configuracionDefecto(Integer FILAS, Integer COLUMNAS){

        int letraCodigoAscii = 65;
        espacios = new EspacioDao[FILAS][COLUMNAS];
        int numId = 0;

        //Rellenar la matriz
        for(int i=0; i< espacios.length; i++){
                numId = 0;
                char caracter = (char) letraCodigoAscii;
                letraCodigoAscii = letraCodigoAscii+1;
            for(int j=0; j< espacios.length; j++) {
                numId = numId +1;
                String id = caracter + "-" +numId;
                espacios[i][j] = new EspacioDao(id,true, false);
            }
        }
    return espacios;
    }

    public static void actualizarTarifas(){
        System.out.println("---Ingrese el costo por hora del carro---");
        int nuevaTarifaCarro = scanner.nextInt();
        scanner.nextLine();
        tarifaCarro = nuevaTarifaCarro;

        System.out.println("---Ingrese el costo por hora de la moto clasica---");
        int nuevaTarifaMotoClasica = scanner.nextInt();
        scanner.nextLine();
        tarifaMotoClasica = nuevaTarifaMotoClasica;

        System.out.println("---Ingrese el costo por hora de la moto hibrida---");
        int nuevaTarifaMotoHibrida = scanner.nextInt();
        scanner.nextLine();
        tarifaMotoHibrida = nuevaTarifaMotoHibrida;

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


    public EspacioDao getMatrizEspacios(EspacioDao espacios) {
        return espacios;
    }

    public void setMatrizEspacios(EspacioDao[][] matrizEspacios) {
        this.matrizEspacios = matrizEspacios;
    }


    public Boolean getEspacioHabilitado() {
        return espacioHabilitado;
    }

    public void setEspacioHabilitado(Boolean espacioHabilitado) {
        this.espacioHabilitado = espacioHabilitado;
    }

    public Boolean getEspacioProhibido() {
        return espacioProhibido;
    }

    public void setEspacioProhibido(Boolean espacioProhibido) {
        this.espacioProhibido = espacioProhibido;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


    public static EspacioDao[][] getEspacios() {
        return espacios;
    }

    public static void setEspacios(EspacioDao[][] espacios) {
        ParqueaderoDao.espacios = espacios;
    }

    public static EspacioDao getEspacio(Integer fila, Integer columna) {
        return espacios[fila][columna];
    }




}
