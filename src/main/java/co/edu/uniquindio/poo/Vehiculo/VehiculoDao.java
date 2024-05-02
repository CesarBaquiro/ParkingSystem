package co.edu.uniquindio.poo.Vehiculo;

public abstract class VehiculoDao {

    protected String nombre;
    protected String placa;
    protected String modelo;


    public VehiculoDao(String nombre, String placa, String modelo){
        this.nombre = nombre;
        this.placa = placa;
        this.modelo = modelo;
    }


}
