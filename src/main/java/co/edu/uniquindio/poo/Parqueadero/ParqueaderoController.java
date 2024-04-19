package co.edu.uniquindio.poo.Parqueadero;
import co.edu.uniquindio.poo.Vehiculo.Carro.CarroDao;
import co.edu.uniquindio.poo.Espacio.EspacioDao;
import co.edu.uniquindio.poo.Vehiculo.Moto.MotoDao;
import static co.edu.uniquindio.poo.Parqueadero.ParqueaderoDao.COLUMNAS;
import static co.edu.uniquindio.poo.Parqueadero.ParqueaderoDao.FILAS;

import java.util.logging.Logger;


public class ParqueaderoController {


    private static final Logger LOG = Logger.getLogger(ParqueaderoController.class.getName());;


    // Método para crear y guardar un nuevo espacio en la matriz
    public void crearEspacio(EspacioDao[][] matrizEspacios, int fila, int columna, String id, boolean espacioHabilitado, boolean ocupado, CarroDao carro, MotoDao moto) {
        if (fila >= 0 && fila < FILAS && columna >= 0 && columna < COLUMNAS) {
            if(espacioHabilitado == true && ocupado == false){
                matrizEspacios[fila][columna] = new EspacioDao(id, espacioHabilitado, ocupado, carro, moto);
                LOG.info("Espacio creado en fila " + fila + ", columna " + columna);
            }else{
                LOG.warning("El espacio esta deshabilitado o ocupado");
            }
        } else {
            LOG.warning("La posición especificada está fuera de los límites de la matriz.");
        }
    }
}
