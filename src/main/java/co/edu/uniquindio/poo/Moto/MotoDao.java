package co.edu.uniquindio.poo.Moto;

/**
 * Clase para el vehiculo carro, contiene sus atributos
 * y metodos
 * */
public class MotoDao {

    //Se toman como km/h
    private Integer velocidadMaxima;
    private TipoMoto tipoMoto;

    private String placa;


    public MotoDao(Integer velocidadMaxima, TipoMoto tipoMoto, String placa) {
        this.velocidadMaxima = velocidadMaxima;
        this.tipoMoto = tipoMoto;
        this.placa = placa;
    }


    public static MotoDao moto1 = new MotoDao(60, TipoMoto.CLASICA, "GQQ689");


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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public static MotoDao getMoto1() {
        return moto1;
    }

    public static void setMoto1(MotoDao moto1) {
        MotoDao.moto1 = moto1;
    }

}
