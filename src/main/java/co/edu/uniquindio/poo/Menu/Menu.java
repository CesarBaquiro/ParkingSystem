package co.edu.uniquindio.poo.Menu;

import co.edu.uniquindio.poo.Parqueadero.ParqueaderoController;
import co.edu.uniquindio.poo.Parqueadero.ParqueaderoDao;
import co.edu.uniquindio.poo.Vehiculo.Carro.CarroDao;
import co.edu.uniquindio.poo.Espacio.EspacioDao;
import co.edu.uniquindio.poo.Vehiculo.Moto.TipoMoto;
import co.edu.uniquindio.poo.Vehiculo.VehiculoDao;

import java.util.Scanner;
import java.util.logging.Logger;


import static co.edu.uniquindio.poo.Informe.Informe.listadoInformes;
import static co.edu.uniquindio.poo.Parqueadero.ParqueaderoController.*;
import static co.edu.uniquindio.poo.Parqueadero.ParqueaderoDao.*;
import static co.edu.uniquindio.poo.Vehiculo.Carro.CarroDao.crearCarro;
import static co.edu.uniquindio.poo.Vehiculo.Moto.MotoDao.crearMoto;

/**
 * Clase Menu para el control de la aplicacion y sus procesos
 */

public class Menu {
    private static final Logger LOG = Logger.getLogger(Menu.class.getName());
    private static final Scanner scanner = new Scanner(System.in);
    public static void seleccionarMenu() {

        Integer opcion = 0;

        do {
            // Mostrar el menú
            System.out.println("----------------Menú:--------------");
            System.out.println("1. Parqueadero");
            System.out.println("2. Registrar ingreso");
            System.out.println("3. Registrar salida");
            System.out.println("4. Informes");
            System.out.println("5. Configuracion");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("--------Matriz de parqueadero--------");
                    //System.out.println(Arrays.stream(configuracionDefecto()).count());
                    verMatrizConsola();
                    System.out.println("La hora actual es: "+ tiempoRealFormateadoRegistro);
                    break;
                case 2:
                    System.out.println("--------Seleccione que desea ingrear:-------");
                    System.out.println("1. Carro");
                    System.out.println("2. Moto");
                    Integer seleccionarVehiculo = scanner.nextInt();
                    registrar(seleccionarVehiculo);
                    //El scanner esta en el metodo
                    
                    break;
                case 3:
                    System.out.println("--------Ingrese que espacio va a registrar la salida:-------");
                    registrarSalida();
                    System.out.println("----------------Se registro la salida--------------");
                    break;
                case 4:
                    System.out.println(listadoInformes);
                    break;
                case 5:

                    System.out.println("1. Nueva configuracion de parqueadero");
                    System.out.println("2. Habilitar o deshabilitar espacio");
                    Integer opcionConfiguracion = scanner.nextInt();
                    if(opcionConfiguracion==1){
                        System.out.println("Ingrese el numero de filas: ");
                        FILAS = scanner.nextInt();
                        System.out.println("Ingrese el numero de columnas: ");
                        COLUMNAS = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("--------ADVERTENCIA--------");
                        System.out.println("Esta seguro de realizar este cambio? Todos los espacios seran reiniciados ");
                        System.out.println("1. Guardar nueva configuracion");
                        System.out.println("2. Cancelar");
                        Integer confirmacion = scanner.nextInt();
                        if(confirmacion == 1){
                            configuracionDefecto(FILAS, COLUMNAS);
                        }
                    }else{
                        actualizarHabilitado();
                    }

                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }

        } while (opcion != 6);
        scanner.close();

    }



}




