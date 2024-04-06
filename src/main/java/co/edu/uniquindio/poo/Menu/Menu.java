package co.edu.uniquindio.poo.Menu;

import co.edu.uniquindio.poo.App;

import java.util.Scanner;
import java.util.logging.Logger;

import static co.edu.uniquindio.poo.Parqueadero.ParqueaderoDao.configuracionDefecto;
import static co.edu.uniquindio.poo.Parqueadero.ParqueaderoDao.espacios;

public class Menu {
    private static final Logger LOG = Logger.getLogger(Menu.class.getName());
    private static final Scanner scanner = new Scanner(System.in);
    String opcion;



    public static void seleccionarMenu(String opcion){



        switch (opcion) {
                case "Parqueadero":
                    System.out.println("--------Matriz de parqueadero--------");
                    configuracionDefecto();
                    System.out.println("El dato de la posicion 0, 0 es: " + espacios[0][0]);

                    System.out.println("Finalizando");
                    break;
                case "Configuracion":
                    System.out.println("Ir a la configuracion");
                    break;

            }
    }


}
