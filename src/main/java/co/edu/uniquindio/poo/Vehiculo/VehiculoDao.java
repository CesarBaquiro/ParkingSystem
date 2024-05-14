package co.edu.uniquindio.poo.Vehiculo;

import co.edu.uniquindio.poo.Vehiculo.Moto.TipoMoto;

/**
 * Clase padre VehiculoDao para estructurar los atributos y metodos de sus hijos
 */
public abstract class VehiculoDao {
    protected String nombre;
    protected String placa;
    protected String modelo;

    //Constructor de vehiculo
    public VehiculoDao(String nombre, String placa, String modelo){
        this.nombre = nombre;
        this.placa = placa;
        this.modelo = modelo;
    }

    public abstract VehiculoDao getVehiculo();
    public abstract String getNombre();
    public abstract String getPlaca();
    public abstract String getModelo();

    public TipoMoto getTipoMoto() {
        return null;
    }

    public Integer getVelocidadMaxima() {
        return null;
    }


}
