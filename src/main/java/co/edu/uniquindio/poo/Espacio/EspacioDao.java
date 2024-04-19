package co.edu.uniquindio.poo.Espacio;

import co.edu.uniquindio.poo.Vehiculo.Carro.CarroDao;
import co.edu.uniquindio.poo.Vehiculo.Moto.MotoDao;

import java.util.logging.Logger;

public class EspacioDao {
    private String id;
    private Boolean espacioHabilitado;
    private Boolean ocupado;
    private CarroDao carro;
    private MotoDao moto;

    private static final Logger LOG = Logger.getLogger(EspacioDao.class.getName());

    // Constructor con todos los parámetros
    public EspacioDao(String id, boolean espacioHabilitado, boolean ocupado, CarroDao carro, MotoDao moto) {
        this.id = id;
        this.espacioHabilitado = espacioHabilitado;
        this.ocupado = ocupado;
        this.carro = carro;
        this.moto = moto;
    }

    // Constructor sin los objetos carro y moto
    public EspacioDao(String id, boolean espacioHabilitado, boolean ocupado) {
        this.id = id;
        this.espacioHabilitado = espacioHabilitado;
        this.ocupado = ocupado;
    }

    // Método para crear un nuevo espacio
    public static EspacioDao crearEspacio(String id, boolean espacioHabilitado, boolean ocupado, CarroDao carro, MotoDao moto) {
        return new EspacioDao(id, espacioHabilitado, ocupado, carro, moto);
    }

    // Método toString para representar el objeto como cadena de caracteres
    @Override
    public String toString() {
        return "EspacioDao{" +
                "id='" + id + '\'' +
                ", espacioHabilitado=" + espacioHabilitado +
                ", ocupado=" + ocupado +
                ", "+ carro.toString()+
                "}";
    }
}
