package view.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import entidades.persona;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class controladorVentana implements Initializable{
		@FXML private TextField nombre, paterno, materno, edad;
		@FXML private ComboBox<String>sexo;
		@FXML private Label mensaje;
		@FXML private TableView<persona> tablePersona;
		ObservableList<persona> listPersona;

		
		@FXML protected void guardar(ActionEvent EVENTO){
			try{
				if(nombre.getText().trim().isEmpty()|paterno.getText().trim().isEmpty()|
						materno.getText().trim().isEmpty()|edad.getText().trim().isEmpty()){
					mensaje.setText("Faltan datos por ingresar");	
				}else{
					persona p = new persona(nombre.getText(),
							paterno.getText(),
							materno.getText(),
							sexo.getValue(),
							Integer.valueOf(edad.getText()));
					mensaje.setText(p.guardar());
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		
		@FXML protected void modificar(ActionEvent EVENTO){
			try{
				if(nombre.getText().trim().isEmpty()|paterno.getText().trim().isEmpty()|
						materno.getText().trim().isEmpty()|edad.getText().trim().isEmpty()){
					mensaje.setText("Faltan datos por ingresar");	
				}else{
					persona p = new persona(nombre.getText(),
							paterno.getText(),
							materno.getText(),
							sexo.getValue(),
							Integer.valueOf(edad.getText()));
					mensaje.setText(p.modificar());
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	@FXML protected void borrar(ActionEvent EVENTO){
			try {
				if(nombre.getText().trim().isEmpty()){
					mensaje.setText("Faltan datos");
				}else{
					persona p = new persona();
					p.setnombre(nombre.getText());
					mensaje.setText(p.borrar());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	@FXML protected void salir(ActionEvent s){
		System.exit(0);
	}
	
	public void llenarTabla(){
		persona p= new persona();
		try {
			listPersona=p.getDatos();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tablePersona.setItems(listPersona);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		llenarTabla();
	}
}
