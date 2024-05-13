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

                    System.out.println("----------------Se registro--------------");
                    break;
                case 3:
                    System.out.println("--------Ingrese que espacio va a registrar la salida:-------");
                    registrarSalida();
                    System.out.println("----------------Se registro la salida--------------");
                    break;

                case 4:
                    espacios[0][0] = new EspacioDao("PRUEBA1", true, true, crearCarro("Cesar", "GGG555", "2015"), tiempoReal);
                    espacios[1][1] = new EspacioDao("PRUEBA2", true, true, crearMoto("Argemiro", "ZZZ111", "2000", 100, TipoMoto.CLASICA), tiempoReal);
                    espacios[2][2] = new EspacioDao("PRUEBA3", true, true, crearMoto("Damian", "QQQ333", "2030", 200, TipoMoto.HIBRIDA), tiempoReal);
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");

            }

        } while (opcion != 5);
        scanner.close();

    }



}




