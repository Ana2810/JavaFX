package modelo;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	private String usuario;
	private String contrasenia;
	private String baseDatos;
	private String driver;
	private Connection con;
	
	public Conexion(){
		 usuario="postgres";
		 contrasenia="282610";
		 baseDatos="jdbc:postgresql://127.0.0.1:5432/SHDAnaGabrielaPerezAguilar";
		 driver="org.postgresql.Driver";
	 }
	 public boolean conectar(){
		 try{
			 Class.forName(driver);
			 con= DriverManager.getConnection(baseDatos,usuario,contrasenia);
			 System.out.println("Conectado");
			 return true;
		 }catch (Exception e){
			 System.out.print(e.getMessage());
			 return false;
		 }
	 }
	 public boolean desconectar(){
		 try{
			 con.close();
			 System.out.println("Desconectado");
			 return true;
		 }catch(Exception e){
			 System.out.print(e.getMessage());
			 return false;
		 }
	 }
	 public Connection getConexion(){
		 return con;
	 }
}
