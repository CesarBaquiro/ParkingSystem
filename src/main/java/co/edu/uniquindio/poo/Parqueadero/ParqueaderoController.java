package co.edu.uniquindio.poo.Parqueadero;
import co.edu.uniquindio.poo.Vehiculo.Carro.CarroDao;
import co.edu.uniquindio.poo.Espacio.EspacioDao;
import co.edu.uniquindio.poo.Vehiculo.Moto.MotoDao;
import co.edu.uniquindio.poo.Vehiculo.VehiculoDao;

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


    public static void registrar(Integer seleccionarVehiculo){
        if(seleccionarVehiculo != null){
            //Si es 1 se crea un carro
            if (seleccionarVehiculo == 1) {
                actualizarEspacio(0, 0, ParqueaderoDao.getEspacio(0,0).getId(), ParqueaderoDao.getEspacio(0,0).getEspacioHabilitado(), ParqueaderoDao.getEspacio(0,0).getOcupado(), crearCarro("Camila", "GQQ689", 2000));
            }else if(seleccionarVehiculo == 2){
                //crearIngreso(1, 1, "Adasd", true, true, crearMoto());
            }
        }
    }

    public static void actualizarEspacio(int fila, int columna, String id, boolean espacioHabilitado, boolean ocupado, VehiculoDao vehiculo) {
        if (fila >= 0 && fila < FILAS && columna >= 0 && columna < COLUMNAS) {
            if(espacioHabilitado == true && ocupado == false){
                espacios[fila][columna] = new EspacioDao(id, espacioHabilitado, true, vehiculo);
                System.out.println("Se registro un carro el espacio:" + id);


            }else{
                LOG.warning("El espacio esta deshabilitado o ocupado");
            }
        } else {
            LOG.warning("La posición especificada está fuera de los límites de la matriz.");
        }
    }
}
