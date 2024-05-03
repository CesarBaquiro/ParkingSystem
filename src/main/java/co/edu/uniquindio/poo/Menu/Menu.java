package co.edu.uniquindio.poo.Menu;

import co.edu.uniquindio.poo.Parqueadero.ParqueaderoController;
import co.edu.uniquindio.poo.Vehiculo.Carro.CarroDao;
import co.edu.uniquindio.poo.Espacio.EspacioDao;

import java.util.Scanner;
import java.util.logging.Logger;



import static co.edu.uniquindio.poo.Parqueadero.ParqueaderoController.registrar;
import static co.edu.uniquindio.poo.Parqueadero.ParqueaderoDao.*;


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
                    System.out.println("El dato de la posicion 0, 0 es: " + espacios[1][1]);

                    System.out.println("Finalizando");




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

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");

            }

        } while (opcion != 3);
        scanner.close();

    }



}




