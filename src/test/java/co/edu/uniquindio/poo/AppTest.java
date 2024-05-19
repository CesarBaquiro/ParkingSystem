/**
 * @author Cesar Baquiro Área de programación UQ
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.Vehiculo.Carro.CarroDao;
import co.edu.uniquindio.poo.Vehiculo.Moto.MotoDao;
import co.edu.uniquindio.poo.Vehiculo.Moto.TipoMoto;

/**
 * Clase base de pruebas unitarias 
 */
public class AppTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    public void shouldAnswerWithTrue() {
        LOG.info("Iniciado test shouldAnswerWithTrue");
        assertTrue(true);
        LOG.info("Finalizando test shouldAnswerWithTrue");
    }

      //Test de datos completos para Moto clasica

      @Test
      public void testMotoClasica (){
          LOG.info("Iniciando testMotoClasica");
          MotoDao moto = new MotoDao("Andres", "HGD658", "2020", 250, TipoMoto.CLASICA);
  
          assertEquals("Andres", moto.getNombre());
          assertEquals("HGD658", moto.getPlaca());
          assertEquals("2020", moto.getModelo());
          assertEquals(250, moto.getVelocidadMaxima());
          assertEquals(TipoMoto.CLASICA, moto.getTipoMoto());
          LOG.info("Finalizando testMotoClasica");
  
      }
  
  
      //Test de datos completos para Moto hibrida
  
      @Test
      public void testMotoHibrida (){
          LOG.info("Iniciando testMotoHibrida");
          MotoDao moto = new MotoDao("carol", "KFJ565", "2012", 300, TipoMoto.HIBRIDA);
  
          assertEquals("carol", moto.getNombre());
          assertEquals("KFJ565", moto.getPlaca());
          assertEquals("2012", moto.getModelo());
          assertEquals(300, moto.getVelocidadMaxima());
          assertEquals(TipoMoto.HIBRIDA, moto.getTipoMoto());
          LOG.info("Finalizando testMotoHibrida");
  
      }
  
  
      //Test de datos completos para carro
  
      @Test
      public void testCarro (){
          LOG.info("Iniciando testCarro");
          CarroDao moto = new CarroDao("juan", "JDH985", "2000");
  
          assertEquals("juan", moto.getNombre());
          assertEquals("JDH985", moto.getPlaca());
          assertEquals("2000", moto.getModelo());
          LOG.info("Finalizando testCarro");
  
      }
}
