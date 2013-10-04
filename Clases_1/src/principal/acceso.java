package principal;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class acceso extends Application {
	
	@FXML private Button btnPersona;
	
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/window.fxml"));
		Scene escena = new Scene(root);
		primaryStage.setTitle("Clase Persona");
		primaryStage.setScene(escena);
		
		primaryStage.show();
	}
	
@FXML protected void clickPersona(ActionEvent e) throws IOException{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/ventana.fxml"));
		Scene escena = new Scene(root);
		primaryStage.setTitle("Clase Persona");
		primaryStage.setScene(escena);
		primaryStage.initModality(Modality.WINDOW_MODAL);
		primaryStage.initOwner(((Node)e.getSource()).getScene().getWindow());
		primaryStage.show();
		primaryStage.show();
		
		}
	
		
	public static void main(String[] args) {
		launch(args);
	}
	
				
}
	

