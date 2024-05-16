package co.edu.uniquindio.poo;

import co.edu.uniquindio.poo.Espacio.EspacioDao;
import co.edu.uniquindio.poo.Parqueadero.ParqueaderoDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class ParkingController {

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
        int rows = espacios.length;
        int cols = espacios[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                EspacioDao espacio = espacios[row][col];
                Button button = new Button(espacio.getId());
                button.getStyleClass().add("button-grid"); // Añade la clase CSS a los botones
                GridPane.setRowIndex(button, row);
                GridPane.setColumnIndex(button, col);
                gridPane.getChildren().add(button);
            }
        }
    }

    @FXML
    private void nuevoIngreso() {
        // Acción para el botón Nuevo Ingreso
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
