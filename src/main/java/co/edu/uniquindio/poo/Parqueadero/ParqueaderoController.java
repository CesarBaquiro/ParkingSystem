package co.edu.uniquindio.poo.Parqueadero;
import co.edu.uniquindio.poo.Vehiculo.Carro.CarroDao;
import co.edu.uniquindio.poo.Espacio.EspacioDao;
import co.edu.uniquindio.poo.Vehiculo.Moto.MotoDao;
import co.edu.uniquindio.poo.Vehiculo.VehiculoDao;

import java.util.Scanner;
import java.util.logging.Logger;

import static co.edu.uniquindio.poo.Parqueadero.ParqueaderoDao.*;


public class ParqueaderoController {


    private static final Logger LOG = Logger.getLogger(ParqueaderoController.class.getName());;
    private static final Scanner scanner = new Scanner(System.in);



    // Método para crear y guardar un nuevo espacio en la matriz
    public static void crearIngreso(int fila, int columna, String id, boolean espacioHabilitado, boolean ocupado, VehiculoDao vehiculo) {
        if (fila >= 0 && fila < FILAS && columna >= 0 && columna < COLUMNAS) {
            if(espacioHabilitado == true && ocupado == false){
                System.out.println("Que quiere ingresar carro o moto: ");
                String seleccionarVehiculo = scanner.nextLine();

                if (seleccionarVehiculo == "Carro"){
                    espacios[fila][columna] = new EspacioDao(id, espacioHabilitado, ocupado, vehiculo);
                    LOG.info("Espacio creado en fila " + fila + ", columna " + columna);
                }else{
                    espacios[fila][columna] = new EspacioDao(id, espacioHabilitado, ocupado, vehiculo);
                    LOG.info("Espacio creado en fila " + fila + ", columna " + columna);
                }

            }else{
                LOG.warning("El espacio esta deshabilitado o ocupado");
            }
        } else {
            LOG.warning("La posición especificada está fuera de los límites de la matriz.");
        }
    }
}
