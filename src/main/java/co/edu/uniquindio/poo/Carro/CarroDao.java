package co.edu.uniquindio.poo.Carro;

import co.edu.uniquindio.poo.Moto.MotoDao;
import co.edu.uniquindio.poo.Moto.TipoMoto;

/**
 * Clase para el vehiculo carro, contiene sus atributos
 * y metodos
 * */
public class CarroDao {

    private String placa;

    public CarroDao(String placa) {
        this.placa = placa;
    }

    public static CarroDao carro1 = new CarroDao("GQQ689");

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Carro{" +
                ", placa="+carro1.getPlaca()+
                "}";
    }
}
