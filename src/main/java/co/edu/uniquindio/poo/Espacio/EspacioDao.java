package co.edu.uniquindio.poo.Espacio;

import co.edu.uniquindio.poo.Vehiculo.Carro.CarroDao;
import co.edu.uniquindio.poo.Vehiculo.Moto.MotoDao;
import co.edu.uniquindio.poo.Vehiculo.VehiculoDao;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import static co.edu.uniquindio.poo.Parqueadero.ParqueaderoController.formatoPresentacion;
import static co.edu.uniquindio.poo.Vehiculo.Moto.MotoDao.crearMoto;

public class EspacioDao {
    private String id;
    private Boolean espacioHabilitado;
    private Boolean ocupado;
    private VehiculoDao vehiculo;
    private LocalDateTime fechaHoraEntrada;

    private static final Logger LOG = Logger.getLogger(EspacioDao.class.getName());

    // Constructor sin los objetos carro y moto
    public EspacioDao(String id, boolean espacioHabilitado, boolean ocupado) {
        this.id = id;
        this.espacioHabilitado = espacioHabilitado;
        this.ocupado = ocupado;
    }


    // Constructor con todos los parámetros
    public EspacioDao(String id, boolean espacioHabilitado, boolean ocupado, VehiculoDao vehiculo, LocalDateTime fechaHoraEntrada) {
        this.id = id;
        this.espacioHabilitado = espacioHabilitado;
        this.ocupado = ocupado;
        this.vehiculo = vehiculo;
        this.fechaHoraEntrada = fechaHoraEntrada;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getEspacioHabilitado() {
        return espacioHabilitado;
    }

    public void setEspacioHabilitado(Boolean espacioHabilitado) {
        this.espacioHabilitado = espacioHabilitado;
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }

    public VehiculoDao getVehiculo() {
        return vehiculo;
    }

    public LocalDateTime getFechaHoraEntrada() {return fechaHoraEntrada;}

    public void setFechaHoraEntrada(LocalDateTime fechaHoraEntrada) {
        this.fechaHoraEntrada = fechaHoraEntrada;
    }


    // Método para crear un nuevo espacio


    // Método toString para representar el objeto como cadena de caracteres
    @Override
    public String toString() {

        if (vehiculo != null) {
            return "EspacioDao{" +
                    "id='" + id + '\'' +
                    ", espacioHabilitado=" + espacioHabilitado +
                    ", ocupado=" + ocupado +
                    ", fechaHoraEntrada= " + fechaHoraEntrada.format(formatoPresentacion) +
                    ", " + vehiculo.toString() +
                    "} | ";
        } else {
            return "EspacioDao{" +
                    "id='" + id + '\'' +
                    ", espacioHabilitado=" + espacioHabilitado +
                    ", ocupado=" + ocupado +
                    "} | ";
        }
    }


}