package co.edu.uniquindio.poo.Vehiculo.Carro;

import co.edu.uniquindio.poo.Vehiculo.VehiculoDao;

/**
 * Clase para el vehiculo carro, contiene sus atributos
 * y metodos
 * */
public class CarroDao extends VehiculoDao {

    public CarroDao(String nombre, String placa, Integer modelo) {
        super(nombre, placa, modelo);


    }

    public static CarroDao carro1 = new CarroDao("Camila", "GQQ689", 2000);

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

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }



    @Override
    public String toString() {
        return "Carro{" +
                ", nombre="+carro1.getNombre()+
                ", placa="+carro1.getPlaca()+
                ", modelo="+carro1.getModelo()+
                "}";
    }
}
