package co.edu.uniquindio.poo.Vehiculo.Moto;

import co.edu.uniquindio.poo.Vehiculo.VehiculoDao;

/**
 * Clase para el vehiculo moto, contiene sus atributos
 * y metodos
 * */
public class MotoDao extends VehiculoDao {

    //La velocidad maxima se toma como km/h
    private Integer velocidadMaxima;
    private TipoMoto tipoMoto;

    //Constructor del objeto moto
    public MotoDao(String nombre, String placa, String modelo, Integer velocidadMaxima, TipoMoto tipoMoto ) {
        super(nombre, placa, modelo);
        this.velocidadMaxima = velocidadMaxima;
        this.tipoMoto = tipoMoto;

    }

    //Metodo para instanciar una nueva moto
    public static MotoDao crearMoto(String nombre, String placa, String modelo, Integer velocidadMaxima, TipoMoto tipoMoto){
        return new MotoDao(nombre, placa, modelo, velocidadMaxima, tipoMoto);
    }

    @Override
    public Integer getVelocidadMaxima() {
        return velocidadMaxima;
    }

    @Override
    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getPlaca() {
        return placa;
    }

    @Override
    public String getModelo() {
        return modelo;
    }

    @Override
    public VehiculoDao getVehiculo() {
        return new MotoDao(getNombre(), getPlaca(), getModelo(), getVelocidadMaxima(), getTipoMoto());
    }

    // Método toString para representar el objeto string
    @Override
    public String toString() {
        return "Moto{" +
                " nombre="+nombre+
                ", placa="+placa+
                ", modelo="+modelo+
                ", tipo de moto="+tipoMoto+
                ", velocidad maxima="+velocidadMaxima+
                "}";
    }


}
