package co.edu.uniquindio.poo.Informe;

import co.edu.uniquindio.poo.Vehiculo.VehiculoDao;

import java.util.ArrayList;
import java.util.List;

public record Informe(String detalle, VehiculoDao vehiculo){

    public static List<Informe> listadoInformes = new ArrayList<>();


    public static void registrarInfome(String detalle, VehiculoDao vehiculo){
        Informe registro = new Informe(detalle, vehiculo);
        listadoInformes.add(registro);
    }

    @Override
    public String toString() {
        return " Detalle: " + detalle +
        " Vehiculo: " + vehiculo +
        "]";
    }
}
