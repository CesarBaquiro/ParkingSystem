package co.edu.uniquindio.poo.Menu;

import co.edu.uniquindio.poo.Parqueadero.ParqueaderoController;
import co.edu.uniquindio.poo.Parqueadero.ParqueaderoDao;
import co.edu.uniquindio.poo.Vehiculo.Carro.CarroDao;
import co.edu.uniquindio.poo.Espacio.EspacioDao;
import co.edu.uniquindio.poo.Vehiculo.Moto.TipoMoto;
import co.edu.uniquindio.poo.Vehiculo.VehiculoDao;

import java.util.Scanner;
import java.util.logging.Logger;


import static co.edu.uniquindio.poo.Parqueadero.ParqueaderoController.*;
import static co.edu.uniquindio.poo.Parqueadero.ParqueaderoDao.*;
import static co.edu.uniquindio.poo.Vehiculo.Carro.CarroDao.crearCarro;
import static co.edu.uniquindio.poo.Vehiculo.Moto.MotoDao.crearMoto;


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
            System.out.println("4. Configuracion");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("--------Matriz de parqueadero--------");
                    //System.out.println(Arrays.stream(configuracionDefecto()).count());

                    espacios[0][0] = new EspacioDao("A1", true, false, crearCarro("Cesar", "GGG555", "2000"), tiempoReal);
                    espacios[1][0] = new EspacioDao("A1", true, false, crearMoto("Cesar", "GGG555", "2000", 200, TipoMoto.HIBRIDA), tiempoReal);

                    verMatrizConsola();
                    System.out.println("La hora actual es: "+ tiempoRealFormateadoRegistro);
                    System.out.println(ParqueaderoDao.getEspacio(1, 0).getVehiculo().getTipoMoto());

                    break;
                case 2:
                    System.out.println("--------Seleccione que desea ingrear:-------");
                    System.out.println("1. Carro");
                    System.out.println("2. Moto");
                    Integer seleccionarVehiculo = scanner.nextInt();
                    registrar(seleccionarVehiculo);
                    //El scanner esta en el metodo

                    System.out.println("----------------Se registro--------------");
                    break;
                case 3:
                    System.out.println("--------Ingrese que espacio va a registrar la salida:-------");
                    registrarSalida();
                    System.out.println("----------------Se registro la salida--------------");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");

            }

        } while (opcion != 5);
        scanner.close();

    }



}




