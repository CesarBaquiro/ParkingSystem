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

import static co.edu.uniquindio.poo.Informe.Informe.registrarInfome;
import static co.edu.uniquindio.poo.Parqueadero.ParqueaderoDao.*;
import static co.edu.uniquindio.poo.Vehiculo.Carro.CarroDao.crearCarro;
import static co.edu.uniquindio.poo.Vehiculo.Moto.MotoDao.crearMoto;

/**
 * Clase ParqueaderoController controlar todos los procesos relacionados el parqueadero y sus espacios
 */
public class ParqueaderoController {


    private static final Logger LOG = Logger.getLogger(ParqueaderoController.class.getName());
    ;
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
    public static Duration duracion;
    public static long horas;
    public static long minutos;
    public static double tarifaCarro = 3000;
    public static double tarifaMotoClasica = 2000;
    public static double tarifaMotoHibrida = 2500;

    public static void registrar(Integer seleccionarVehiculo) {
        System.out.println("---Ingrese la posicion donde quiere el registro---");
        System.out.println("Ingrese la fila: ");
        selectFila = scanner.nextInt();

        System.out.println("Ingrese la columna: ");
        selectColumna = scanner.nextInt();
        scanner.nextLine();

        if (seleccionarVehiculo != null) {
            System.out.println("---Ingrese los datos del vehiculo---");
            System.out.println("Ingrese el nombre del propietario: ");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese la placa: ");
            String placa = scanner.nextLine();

            System.out.println("Ingrese el modelo: ");
            String modelo = scanner.nextLine();

            //Se evalua si se va a registrar un carro (opcion 1) o una moto (opcion 2)
            if (seleccionarVehiculo == 1) {
                //Se registra el carro en el espacio
                actualizarEspacio(selectFila, selectColumna, ParqueaderoDao.getEspacio(selectFila, selectColumna).getId(), ParqueaderoDao.getEspacio(selectFila, selectColumna).getEspacioHabilitado(), ParqueaderoDao.getEspacio(selectFila, selectColumna).getOcupado(), crearCarro(nombre, placa, modelo), fechaHoraEntrada);

            } else if (seleccionarVehiculo == 2) {
                System.out.println("Ingrese la velocidad maxima que alcanza la moto: ");
                Integer velocidadMaxima = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Seleccione el tipo de moto: ");
                System.out.println("1. Clasica");
                System.out.println("2. Hibrida");
                Integer seleccionTipoMoto = scanner.nextInt();
                scanner.nextLine();

                //Se inicializa el tipo de moto
                TipoMoto tipoMoto;

                //Se verifica el tipo de moto a registrar
                if (seleccionTipoMoto == 1) {
                    tipoMoto = TipoMoto.CLASICA;
                } else {
                    tipoMoto = TipoMoto.HIBRIDA;
                }
                //Se registra la moto en el espacio
                actualizarEspacio(selectFila, selectColumna, ParqueaderoDao.getEspacio(selectFila, selectColumna).getId(), ParqueaderoDao.getEspacio(selectFila, selectColumna).getEspacioHabilitado(), ParqueaderoDao.getEspacio(selectFila, selectColumna).getOcupado(), crearMoto(nombre, placa, modelo, velocidadMaxima, tipoMoto), fechaHoraEntrada);
            }
        }
    }

    public static void actualizarEspacio(int fila, int columna, String id, boolean espacioHabilitado, boolean ocupado, VehiculoDao vehiculo, LocalDateTime fechaHoraEntrada) {
        if (fila >= 0 && fila < FILAS && columna >= 0 && columna < COLUMNAS) {
            if (espacioHabilitado == true && ocupado == false) {
                fechaHoraEntrada = tiempoReal;
                espacios[fila][columna] = new EspacioDao(id, espacioHabilitado, true, vehiculo, fechaHoraEntrada);
                System.out.println(fechaHoraEntrada.format(formatoPresentacion) + "| Ingreso un vehiculo al espacio: " + id);
                registrarInfome( fechaHoraEntrada.format(formatoPresentacion) + "| Ingreso un vehiculo al espacio: " + id, vehiculo);

            } else {
                LOG.warning("El espacio esta deshabilitado o ocupado");
            }
        } else {
            LOG.warning("La posición especificada está fuera de los límites de la matriz.");
        }
    }


    public static void registrarSalida() {
        Double valorPagar;

        System.out.println("Ingrese la fila: ");
        selectFila = scanner.nextInt();
        System.out.println("Ingrese la columna: ");
        selectColumna = scanner.nextInt();
        scanner.nextLine();

        if (ParqueaderoDao.getEspacio(selectFila, selectColumna).getFechaHoraEntrada() != null) {

            fechaHoraSalida = tiempoReal;

            duracion = Duration.between(ParqueaderoDao.getEspacio(selectFila, selectColumna).getFechaHoraEntrada(), fechaHoraSalida);
            horas = duracion.toHours();
            minutos = duracion.toMinutes() % 60;

            //Definir el valor total a pagar
            if (ParqueaderoDao.getEspacio(selectFila, selectColumna).getVehiculo().getTipoMoto() != null) {
                if (ParqueaderoDao.getEspacio(selectFila, selectColumna).getVehiculo().getTipoMoto() == TipoMoto.CLASICA) {
                    valorPagar = tarifaMotoClasica;
                } else {
                    valorPagar = tarifaMotoHibrida;
                }
            }else{
                valorPagar = tarifaCarro;
            }


            //Si los minutos no exceden 15 minutos, no se debera realizar el pago de la hora
            if(minutos>15){
                System.out.println("--------------El valor a pagar es " + (horas+1) * valorPagar );
            }else{
                System.out.println("--------------El valor a pagar es " + horas * valorPagar );
            }


            System.out.println(fechaHoraSalida.format(formatoPresentacion) + "| Salio un vehiculo del espacio: " + ParqueaderoDao.getEspacio(selectFila, selectColumna).getId());
            registrarInfome( fechaHoraSalida.format(formatoPresentacion) + "| Salio un vehiculo del espacio: " + ParqueaderoDao.getEspacio(selectFila, selectColumna).getId(), ParqueaderoDao.getEspacio(selectFila, selectColumna).getVehiculo());

            //Se reinicia el espacio a su estado vacio
            espacios[selectFila][selectColumna] = new EspacioDao(ParqueaderoDao.getEspacio(selectFila, selectColumna).getId(), ParqueaderoDao.getEspacio(selectFila, selectColumna).getEspacioHabilitado(), false);


            System.out.println("El espacio " + ParqueaderoDao.getEspacio(selectFila, selectColumna).getId() + " se ha liberado");

            System.out.println("La duracion del vehiculo fue de " + horas + " horas y " + minutos + " minutos.");
        } else {
            LOG.warning("El espacio ingresado esta vacio");
        }
    }

    public static void actualizarHabilitado(){
        System.out.println("---Ingrese la posicion donde quiere el registro---");
        System.out.println("Ingrese la fila: ");
        selectFila = scanner.nextInt();
        System.out.println("Ingrese la columna: ");
        selectColumna = scanner.nextInt();
        scanner.nextLine();

        if (selectFila >= 0 && selectFila < FILAS && selectColumna >= 0 && selectColumna < COLUMNAS) {
            if (ParqueaderoDao.getEspacio(selectFila, selectColumna).getOcupado() == false) {
                if(ParqueaderoDao.getEspacio(selectFila, selectColumna).getEspacioHabilitado() == true){
                    espacios[selectFila][selectColumna] = new EspacioDao(ParqueaderoDao.getEspacio(selectFila, selectColumna).getId(), false, false);
                    LOG.warning("El espacio "+ ParqueaderoDao.getEspacio(selectFila, selectColumna).getId() + "se ha deshabilitado");
                }else{
                    espacios[selectFila][selectColumna] = new EspacioDao(ParqueaderoDao.getEspacio(selectFila, selectColumna).getId(), true, false);
                    LOG.warning("El espacio "+ ParqueaderoDao.getEspacio(selectFila, selectColumna).getId() + "se ha habilitado");
                }
            } else {
                LOG.warning("El espacio esta ocupado");
            }
        } else {
            LOG.warning("La posición especificada está fuera de los límites de la matriz.");
        }
    }

}
