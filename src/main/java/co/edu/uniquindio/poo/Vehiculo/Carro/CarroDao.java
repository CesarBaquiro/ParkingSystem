package co.edu.uniquindio.poo.Vehiculo.Carro;

import co.edu.uniquindio.poo.Vehiculo.VehiculoDao;

/**
 * Clase para el vehiculo carro, contiene sus atributos
 * y metodos
 * */
public class CarroDao extends VehiculoDao {

    public CarroDao(String nombre, String placa, String modelo) {
        super(nombre, placa, modelo);
    }

    public static CarroDao crearCarro(String nombre, String placa, String modelo){
        return new CarroDao(nombre, placa, modelo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }



    @Override
    public String toString() {
        return "Carro{" +
                ", nombre="+nombre+
                ", placa="+placa+
                ", modelo="+modelo+
                "}";
    }
}
