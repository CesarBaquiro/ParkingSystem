package co.edu.uniquindio.poo.Parqueadero;
import co.edu.uniquindio.poo.Espacio.EspacioDao;
import co.edu.uniquindio.poo.Vehiculo.Moto.TipoMoto;
import co.edu.uniquindio.poo.Vehiculo.VehiculoDao;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Logger;

import static co.edu.uniquindio.poo.Parqueadero.ParqueaderoDao.*;
import static co.edu.uniquindio.poo.Vehiculo.Carro.CarroDao.crearCarro;
import static co.edu.uniquindio.poo.Vehiculo.Moto.MotoDao.crearMoto;


public class ParqueaderoController {


    private static final Logger LOG = Logger.getLogger(ParqueaderoController.class.getName());;
    private static final Scanner scanner = new Scanner(System.in);



    // Método para crear y guardar un nuevo espacio en la matriz
    static Integer seleccionarVehiculo = null;

    static Integer selectFila;
    static Integer selectColumna;

    public static LocalDateTime tiempoReal = LocalDateTime.now().withSecond(0).withNano(0);
    //Formato de hora para registros
    static DateTimeFormatter formatoRegistro = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    //Formato de hora para visualizacion del usuario
    public static DateTimeFormatter formatoPresentacion = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm");
    public static String tiempoRealFormateadoRegistro = tiempoReal.format(formatoRegistro);


    public static LocalDateTime fechaHoraEntrada;
    public static LocalDateTime fechaHoraSalida;

    //A partir de 14 minutos extra a la hora, cuenta 1 hora mas al tiempo estacionado

    public static Duration duracion;

    public static long horas;
    public static long minutos;





    public static void registrar(Integer seleccionarVehiculo){
        System.out.println("---Ingrese la posicion donde quiere el registro---");
        System.out.println("Ingrese la fila: ");
        selectFila = scanner.nextInt();

        System.out.println("Ingrese la columna: ");
        selectColumna = scanner.nextInt();
        scanner.nextLine();

        if(seleccionarVehiculo != null){
            System.out.println("---Ingrese los datos del vehiculo---");
            System.out.println("Ingrese el nombre del propietario: ");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese la placa: ");
            String placa = scanner.nextLine();

            System.out.println("Ingrese el modelo: ");
            String modelo = scanner.nextLine();


            //Si es 1 se crea un carro
            if (seleccionarVehiculo == 1) {

                actualizarEspacio(selectFila, selectColumna, ParqueaderoDao.getEspacio(selectFila,selectColumna).getId(), ParqueaderoDao.getEspacio(selectFila,selectColumna).getEspacioHabilitado(), ParqueaderoDao.getEspacio(selectFila,selectColumna).getOcupado(), crearCarro(nombre, placa, modelo), fechaHoraEntrada);

            }else if(seleccionarVehiculo == 2){
                System.out.println("Ingrese la velocidad maxima que alcanza la moto: ");
                Integer velocidadMaxima = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Seleccione el tipo de moto: ");
                System.out.println("1. Clasica");
                System.out.println("2. Hibrida");
                Integer seleccionTipoMoto = scanner.nextInt();
                scanner.nextLine();

                TipoMoto tipoMoto = TipoMoto.CLASICA;

                if(seleccionTipoMoto == 1){
                    tipoMoto = TipoMoto.CLASICA;
                }else{
                    tipoMoto = TipoMoto.HIBRIDA;
                }

                actualizarEspacio(selectFila, selectColumna, ParqueaderoDao.getEspacio(selectFila,selectColumna).getId(), ParqueaderoDao.getEspacio(selectFila,selectColumna).getEspacioHabilitado(), ParqueaderoDao.getEspacio(selectFila,selectColumna).getOcupado(), crearMoto(nombre, placa, modelo, velocidadMaxima, tipoMoto), fechaHoraEntrada);
            }
        }
    }

    public static void actualizarEspacio(int fila, int columna, String id, boolean espacioHabilitado, boolean ocupado, VehiculoDao vehiculo, LocalDateTime fechaHoraEntrada) {
        if (fila >= 0 && fila < FILAS && columna >= 0 && columna < COLUMNAS) {
            if(espacioHabilitado == true && ocupado == false){
                fechaHoraEntrada = tiempoReal;
                espacios[fila][columna] = new EspacioDao(id, espacioHabilitado, true, vehiculo, fechaHoraEntrada);
                System.out.println(fechaHoraEntrada.format(formatoPresentacion) + "| Ingreso un vehiculo al espacio: " + id);




            }else{
                LOG.warning("El espacio esta deshabilitado o ocupado");
            }
        } else {
            LOG.warning("La posición especificada está fuera de los límites de la matriz.");
        }
    }


    public static void registrarSalida() {



        System.out.println("Ingrese la fila: ");
        selectFila = scanner.nextInt();
        System.out.println("Ingrese la columna: ");
        selectColumna = scanner.nextInt();
        scanner.nextLine();

        if (ParqueaderoDao.getEspacio(selectFila,selectColumna).getFechaHoraEntrada() != null){

            fechaHoraSalida = tiempoReal;
            System.out.println(ParqueaderoDao.getEspacio(selectFila,selectColumna).getFechaHoraEntrada());
            System.out.println(fechaHoraSalida);


            duracion = Duration.between(ParqueaderoDao.getEspacio(selectFila,selectColumna).getFechaHoraEntrada().minusMinutes(35), fechaHoraSalida);
            horas = duracion.toHours();
            minutos = duracion.toMinutes() % 60;

            espacios[selectFila][selectColumna] = new EspacioDao(ParqueaderoDao.getEspacio(selectFila,selectColumna).getId(),ParqueaderoDao.getEspacio(selectFila,selectColumna).getEspacioHabilitado(), false);

            System.out.println(fechaHoraEntrada.format(formatoPresentacion) + "| Salio un vehiculo del espacio: " + ParqueaderoDao.getEspacio(selectFila, selectColumna).getId());
            System.out.println("El espacio "+ ParqueaderoDao.getEspacio(selectFila,selectColumna).getId() +" se ha liberado");

            System.out.println("La duracion del vehiculo fue de " + horas + " horas y " + minutos + " minutos.");
        }else{
            LOG.warning("El espacio ingresado esta vacio");
        }


    }

}
