package co.edu.uniquindio.poo;

import java.util.Scanner;
import java.util.logging.Logger;

import static co.edu.uniquindio.poo.Menu.Menu.seleccionarMenu;
import static co.edu.uniquindio.poo.Parqueadero.ParqueaderoDao.*;

/**
 * Hello world! 
 *
 */
public class App {
    private static final Logger LOG = Logger.getLogger(App.class.getName());
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        LOG.info("Hello World!");

        configuracionDefecto(FILAS, COLUMNAS);
        seleccionarMenu();

    }
}
