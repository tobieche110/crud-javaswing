package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.*;

public class DAOalumno implements Operaciones{
	
	Database db = new Database();
	alumno alumno = new alumno();
	
	@Override
	public boolean insertar(Object obj) {
		alumno = (alumno) obj;
		Connection con;
		PreparedStatement pst;
		String sql = "INSERT INTO alumno VALUES(?,?,?,?)";
		
		try {
			//Nos conectamos a la BDD
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPwd());
			
			//cambiamos los valores de "?" de la String sql
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, alumno.getLegajo());
			pst.setString(2,alumno.getApellido());
			pst.setString(3, alumno.getNombre());
			pst.setInt(4, alumno.getAnioIngreso());
			
			int filas = pst.executeUpdate(); //representa la cantidad de filas que fueron afectadas
			if (filas > 0) {
				con.close();
				return true; //significa que hubieron filas afectadas (todo salio OK)
			}else {
				con.close();
				return false; //significa que no hubieron filas afectadas
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "ERROR: "+e.getMessage());
			return false;
		}
	}

	@Override
	public boolean eliminar(Object obj) {
		alumno = (alumno) obj;
		Connection con;
		PreparedStatement pst;
		String sql = "DELETE FROM alumno WHERE legajo = ?";
		
		try {
			//Nos conectamos a la BDD
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPwd());
			
			//cambiamos los valores de "?" de la String sql
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, alumno.getLegajo());
			
			int filas = pst.executeUpdate(); //representa la cantidad de filas que fueron afectadas
			if (filas > 0) {
				con.close();
				return true; //significa que hubieron filas afectadas (todo salio OK)
			}else {
				con.close();
				return false; //significa que no hubieron filas afectadas
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "ERROR: "+e.getMessage());
			return false;
		}
	}

	@Override
	public boolean modificar(Object obj) {
		alumno = (alumno) obj;
		Connection con;
		PreparedStatement pst;
		String sql = "UPDATE alumno SET apellido=?, nombre=?, anioIngreso=? WHERE carnet=?";
		
		try {
			//Nos conectamos a la BDD
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPwd());
			
			//cambiamos los valores de "?" de la String sql
			pst = con.prepareStatement(sql);
			
			pst.setString(1,alumno.getApellido());
			pst.setString(2, alumno.getNombre());
			pst.setInt(3, alumno.getAnioIngreso());
			pst.setInt(4, alumno.getLegajo());
			
			int filas = pst.executeUpdate(); //representa la cantidad de filas que fueron afectadas
			if (filas > 0) {
				con.close();
				return true; //significa que hubieron filas afectadas (todo salio OK)
			}else {
				con.close();
				return false; //significa que no hubieron filas afectadas
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "ERROR: "+e.getMessage());
			return false;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public ArrayList<Object[]> consultar() {
		ArrayList<Object[]> data = new ArrayList<>();
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		String sql = "SELECT * FROM alumno";
		
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPwd());
			
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			//convertimos rs a ArrayList[]
			while(rs.next()) {
				Object[] fila = new Object[4];
				for(int i=0; i<=3; i++) {
					fila[i] = rs.getObject(i+1);
				}
				data.add(fila);
			}
			con.close();
			
		} catch (SQLException | ClassNotFoundException e){
			JOptionPane.showMessageDialog(null, "ERROR: "+e.getMessage());
		} finally {
			return data;
		}

	}

}
