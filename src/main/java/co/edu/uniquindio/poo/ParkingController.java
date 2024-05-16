package co.edu.uniquindio.poo;

import co.edu.uniquindio.poo.Espacio.EspacioDao;
import co.edu.uniquindio.poo.Parqueadero.ParqueaderoDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import java.util.logging.Logger;


public class ParkingController {
    private static final Logger LOG = Logger.getLogger(EspacioDao.class.getName());

    @FXML
    private GridPane gridPane;

    @FXML
    public void initialize() {
        // Configurar la matriz de espacios usando la configuración por defecto
        int filas = ParqueaderoDao.FILAS;
        int columnas = ParqueaderoDao.COLUMNAS;
        EspacioDao[][] espacios = ParqueaderoDao.configuracionDefecto(filas, columnas);

        // Crear botones en el GridPane basado en la matriz de espacios
        createButtonGrid(espacios);
    }

    private void createButtonGrid(EspacioDao[][] espacios) {
        gridPane.getChildren().clear(); // Limpiar los elementos existentes en el GridPane
        int rows = espacios.length;
        int cols = espacios[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                EspacioDao espacio = espacios[row][col];
                Button button = new Button(espacio.getId());
                button.getStyleClass().add("button-grid"); // Añade la clase CSS a los botones

                // Comprueba si el espacio no está habilitado y aplica el estilo correspondiente


                if (!espacio.getOcupado()) {
                    button.setStyle("-fx-background-color: #00ff00;"); // Verde si está ocupado
                } else if (espacio.getOcupado()) {
                    button.setStyle("-fx-background-color: red;"); // Rojo si no está ocupado
                }

                if (!espacio.getEspacioHabilitado()) {
                    button.setDisable(true);
                    button.setStyle("-fx-background-color: #A9A9A9;"); // Gris oscuro
                }

                // Agregar un manejador de eventos de clic a cada botón
                button.setOnAction(event -> handleParkingButtonClic(espacio));

                GridPane.setRowIndex(button, row);
                GridPane.setColumnIndex(button, col);
                gridPane.getChildren().add(button);
            }
        }
    }

    private void handleParkingButtonClic(EspacioDao espacio) {
        // Ejecuta el método nuevoIngreso
        nuevoIngreso(espacio);


    }



    // Método para actualizar la matriz y los botones en el GridPane
    public void actualizarMatriz(EspacioDao[][] nuevosEspacios) {
        createButtonGrid(nuevosEspacios);
    }

    @FXML
    private void nuevoIngreso(EspacioDao espacio) {
        // Acción para el botón Nuevo Ingreso
        // Actualizar la matriz con el nuevo estado y refrescar la vista
        // Ejemplo de actualización de la matriz:
        espacio.setOcupado(espacio.getOcupado()); // Actualiza un espacio como ejemplo
        if(espacio.getOcupado()){
            LOG.info("El espacio "+ espacio.getId() + " se ha ocupado");
        }else{
            LOG.info("El espacio "+ espacio.getId() + " se ha liberado");
        }
        actualizarMatriz(ParqueaderoDao.espacios);
    }


    @FXML
    private void informes() {
        // Acción para el botón Informes
    }

    @FXML
    private void configuracion() {
        // Acción para el botón Configuración
    }
}
