/**
 * @author Cesar Baquiro Área de programación UQ
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.Espacio.EspacioDao;
import co.edu.uniquindio.poo.Parqueadero.ParqueaderoDao;
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
            CarroDao carro = new CarroDao("juan", "JDH985", "2000");
    
            assertEquals("juan", carro.getNombre());
            assertEquals("JDH985", carro.getPlaca());
            assertEquals("2000", carro.getModelo());
            LOG.info("Finalizando testCarro");
        }

        //Test para crear un espacio vacio correctamente
        @Test
        void testCrearEspacioVacio() {
            LOG.info("Iniciando testCrearEspacioVacio");
            EspacioDao espacio = new EspacioDao("1-1", true, false);

            assertEquals("1-1", espacio.getId());
            assertTrue(espacio.getEspacioHabilitado());
            assertFalse(espacio.getOcupado());
            LOG.info("Finalizando testCrearEspacioVacio");
        }

        //Test para obtener el espacio 
        @Test
        void testGetEspacio() {
            LOG.info("Iniciando testGetEspacio");
            EspacioDao[][] espacios = ParqueaderoDao.configuracionDefecto(3, 3);
            EspacioDao espacio = ParqueaderoDao.getEspacio(0, 0);

            assertNotNull(espacio); //Verifica que "espacio", no sea nulo
            assertEquals("A-1", espacio.getId());
            LOG.info("Finalizando testGetEspacio");
        }

}
