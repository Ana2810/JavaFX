package entidades;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import modelo.conexion;

public class persona {

		private String nombre,apaterno,amaterno,sexo;
		private Integer edad,idpersona;
		private conexion con;
		
		
		public persona(){
			this.nombre = "";
			this.apaterno=amaterno=sexo="";
			this.edad = 0;
			this.con = new conexion();
		}
		
		public persona(String _nombre,String _apaterno,
						String _amaterno,String _sexo,Integer _edad){
			this.nombre=_nombre;
			this.apaterno= _apaterno;
			this.amaterno= _amaterno;
			this.sexo= _sexo;
			this.edad= _edad;
			this.con = new conexion();
		}
		
		//GET
		public String getnombre(){
			return this.nombre;
		}
		
		public String getapaterno(){
			return this.apaterno;
		}
		
		public String getamaterno(){
			return this.amaterno;
		}
		
		public String getsexo(){
			return this.sexo;
		}
		
		public Integer getedad(){
			return this.edad;
		}
		
		//SET
		public void setnombre(String _nombre){
			this.nombre= _nombre;
		}
		
		public void setapaterno(String _apaterno){
			this.apaterno= _apaterno;
		}
		
		public void setamaterno(String _amaterno){
			this.amaterno= _amaterno;
		}
		
		public void setsexo(String _sexo){
			this.sexo= _sexo;
		}
		
		public void setedad(Integer _edad){
			this.edad= _edad;
		}
		
		public Integer getIdpersona() {
			return idpersona;
		}

		public void setIdpersona(Integer idpersona) {
			this.idpersona = idpersona;
		}
		
		
		public String toString(){
			return this.nombre + " " +
						this.apaterno + " "+
						this.amaterno + " "+
						this.sexo + " "+
						this.edad;
		}
		
		public String guardar(){
			String mensaje="";
			try{
				if(con.conectar()==true){
					String query="insert into persona values(default,?,?,?,?,?)";
					PreparedStatement comando = con.getConexion().prepareStatement(query);
						comando.setString(1, this.nombre);
						comando.setString(2, this.apaterno);
						comando.setString(3, this.amaterno);
						comando.setString(4, this.sexo);
						comando.setInt(5, this.edad);
						comando.executeUpdate();
						mensaje="Datos insertados con exito";
					}
				}catch (Exception e) {
					
					mensaje="No se insertaron los datos";
			}finally{
				con.desconectar();
			}
			return mensaje;
		}
		
		public String borrar(){
			String mensaje="";
			try{
				if(con.conectar()==true){
					String query="delete from persona where nombre=?";
					PreparedStatement comando = con.getConexion().prepareStatement(query);
					comando.setString(1, this.nombre);
					comando.executeUpdate();
					mensaje="Datos borrados con exito";
				}
			}catch (Exception e){
				mensaje="No fue borrado el dato";
			}finally{
				con.desconectar();
			}
			return mensaje;
		}
		
		public String modificar(){
			String mensaje="";
			try{
				if(con.conectar()==true){
					String query="update persona set paterno=?,materno=?,sexo=?,edad=? where nombre='"+this.nombre+"'";
					PreparedStatement comando = con.getConexion().prepareStatement(query);
						//comando.setString(1, this.nombre);
						comando.setString(1, this.apaterno);
						comando.setString(2, this.amaterno);
						comando.setString(3, this.sexo);
						comando.setInt(4, this.edad);
						comando.executeUpdate();
						mensaje="Datos insertados con exito";
					}
				}catch (Exception e) {
					mensaje="No se insertaron los datos";
			}finally{
				con.desconectar();
			}
			return mensaje;
		}
		
		public ObservableList<persona> getDatos() throws SQLException{
			ResultSet rs = null;
			ObservableList<persona> tabla=FXCollections.observableArrayList();
			persona p=null;
			try{
				if(con.conectar()==true){
					String query="select * from persona";
					PreparedStatement comando = con.getConexion().prepareStatement(query);
					rs=comando.executeQuery();
					while(rs.next()){
						p=new persona();
						p.setIdpersona(rs.getInt("idpersona"));
						p.setnombre(rs.getString("nombre"));
						p.setamaterno(rs.getString("amaterno"));
						p.setapaterno(rs.getString("apaterno"));
						p.setsexo(rs.getString("sexo"));
						p.setedad(rs.getInt("edad"));					
						tabla.add(p);					
					}
					
				}
				
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			finally{
				rs.close();
				con.desconectar();
			}
			return tabla;
			
		}

	
		
		
}
