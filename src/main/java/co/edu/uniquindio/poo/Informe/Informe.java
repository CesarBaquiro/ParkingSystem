package co.edu.uniquindio.poo.Informe;

import co.edu.uniquindio.poo.Vehiculo.VehiculoDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Informe para el registro de los procesos registrados en el sistema
 */

public record Informe(String detalle, VehiculoDao vehiculo){

    //Listado de informes
    public static List<Informe> listadoInformes = new ArrayList<>();

    //Metodo para instanciar un nuevo informe
    public static void registrarInfome(String detalle, VehiculoDao vehiculo){
        Informe registro = new Informe(detalle, vehiculo);
        listadoInformes.add(registro);
    }

    //Metodo para visualizar cada informe como cadena de caracteres
    @Override
    public String toString() {
        return " Detalle: " + detalle +
        " Vehiculo: " + vehiculo +
        "]";
    }
}
