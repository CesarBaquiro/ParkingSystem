package co.edu.uniquindio.poo.Vehiculo.Moto;

import co.edu.uniquindio.poo.Vehiculo.Carro.CarroDao;
import co.edu.uniquindio.poo.Vehiculo.VehiculoDao;

/**
 * Clase para el vehiculo carro, contiene sus atributos
 * y metodos
 * */
public class MotoDao extends VehiculoDao {

    //Se toman como km/h
    private Integer velocidadMaxima;
    private TipoMoto tipoMoto;


    public MotoDao(String nombre, String placa, String modelo, Integer velocidadMaxima, TipoMoto tipoMoto ) {
        super(nombre, placa, modelo);
        this.velocidadMaxima = velocidadMaxima;
        this.tipoMoto = tipoMoto;

    }


    public static MotoDao crearMoto(String nombre, String placa, String modelo, Integer velocidadMaxima, TipoMoto tipoMoto){
        return new MotoDao(nombre, placa, modelo, velocidadMaxima, tipoMoto);
    }
    public static MotoDao moto1 = new MotoDao("Roberto", "BWL123", "2000", 100,  TipoMoto.CLASICA );


    public Integer getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(Integer velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }

    public void setTipoMoto(TipoMoto tipoMoto) {
        this.tipoMoto = tipoMoto;
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

    // Método toString para representar el objeto como cadena de caracteres
    @Override
    public String toString() {
        return "Moto{" +
                " nombre="+moto1.getNombre()+
                ", placa="+moto1.getPlaca()+
                ", modelo="+moto1.getModelo()+
                ", tipo de moto="+moto1.getTipoMoto()+
                ", velocidad maxima="+moto1.getVelocidadMaxima()+
                "}";
    }
}
