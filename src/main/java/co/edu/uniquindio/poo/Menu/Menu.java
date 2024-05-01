package co.edu.uniquindio.poo.Menu;

import co.edu.uniquindio.poo.Parqueadero.ParqueaderoController;
import co.edu.uniquindio.poo.Vehiculo.Carro.CarroDao;
import co.edu.uniquindio.poo.Espacio.EspacioDao;

import java.util.Scanner;
import java.util.logging.Logger;


import static co.edu.uniquindio.poo.Parqueadero.ParqueaderoDao.*;
import static co.edu.uniquindio.poo.Vehiculo.Carro.CarroDao.carro1;

public class Menu {
    private static final Logger LOG = Logger.getLogger(Menu.class.getName());
    private static final Scanner scanner = new Scanner(System.in);
    String opcion;



    public static void seleccionarMenu(String opcion){

        switch (opcion) {
                case "Parqueadero":
                    System.out.println("--------Matriz de parqueadero--------");
                    configuracionDefecto();
                    verMatrizConsola();

                    //EspacioDao espacioPrueba = crearEspacio("D1", true, true, CarroDao.carro1, null);
                    //LOG.info("Nuevo espacio creado: " + espacioPrueba.toString());
                    //System.out.println(Arrays.stream(configuracionDefecto()).count());
                    System.out.println("El dato de la posicion 0, 0 es: " + espacios[1][1]);

                    System.out.println("Finalizando");

                    System.out.println("---------Nuevo espacio registrado----------");

                    ParqueaderoController.crearIngreso(1,1,espacios[1][1].getId(), espacios[1][1].getEspacioHabilitado(), espacios[1][1].getOcupado(), carro1);


                    System.out.println("El dato de la posicion 1, 1 es: " + espacios[1][1]);
                    verMatrizConsola();


                    break;
                case "Configuracion":
                    System.out.println("Ir a la configuracion");
                    break;

            }
    }


}
