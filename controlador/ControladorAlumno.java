package controlador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import dao.DAOalumno;
import modelo.alumno;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import vistas.VistasAlumno;

@SuppressWarnings("unused")
public class ControladorAlumno {
	
	//Carga los elementos a la tabla
	public static void cargar(JTable tblData, ArrayList<Object[]> data, DefaultTableModel model, DAOalumno dao, String columnas[]) {
		data = dao.consultar();
		model.setRowCount(0);
		for(Object [] dato : data) {
			model.addRow(dato);
		}
		tblData.setModel(model);
		
	}
	
	
	//Botón Modificar
	public static void modificar(JTable tblData, ArrayList<Object[]> data, DefaultTableModel model, DAOalumno dao, String columnas[]) {
		VistasAlumno.btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int newLegajo = Integer.parseInt(VistasAlumno.textLegajo.getText());
					int newAnio = Integer.parseInt(VistasAlumno.textAnioIngreso.getText());
					alumno alumno1 = new alumno(newLegajo, VistasAlumno.textApellido.getText(),VistasAlumno.textNombre.getText(), newAnio);
					
					if(dao.modificar(alumno1)) {
						JOptionPane.showMessageDialog(null, "Se ha modificado con éxito");
					}else {
						JOptionPane.showMessageDialog(null, "Ha habido un error: "+e);
					}
					cargar(tblData, data, model, dao, columnas);
					
				} catch (NumberFormatException ex) {
					//Mensaje de error si se ingresa otra cosa que no sea un numero en legajo o año de ingreso
					JOptionPane.showMessageDialog(null, "Ingrese valores válidos");;
				}
			}
		});
	}
	
	//Botón Agregar
	public static void agregar(JTable tblData, ArrayList<Object[]> data, DefaultTableModel model, DAOalumno dao, String columnas[]) {
		VistasAlumno.btnAgregar.addActionListener(new ActionListener() {
			//What button does when pressed
			public void actionPerformed(ActionEvent e) {
				try {
					int newLegajo = Integer.parseInt(VistasAlumno.textLegajo.getText());
					int newAnio = Integer.parseInt(VistasAlumno.textAnioIngreso.getText());
					alumno alumno1 = new alumno(newLegajo, VistasAlumno.textApellido.getText(),VistasAlumno.textNombre.getText(), newAnio);
					
					if(dao.insertar(alumno1)) {
						JOptionPane.showMessageDialog(null, "Se ha agregado con éxito");
					}else {
						JOptionPane.showMessageDialog(null, "Ha habido un error: "+e);
					}
					cargar(tblData, data, model, dao, columnas);
					
				} catch (NumberFormatException ex) {
					//Mensaje de error si se ingresa otra cosa que no sea un numero en legajo o año de ingreso
					JOptionPane.showMessageDialog(null, "Ingrese valores válidos");;
				}
			}
		});	
	}
	
	//Botón Eliminar
	public static void eliminar(JTable tblData, ArrayList<Object[]> data, DefaultTableModel model, DAOalumno dao, String columnas[]) {
		VistasAlumno.btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int newLegajo = Integer.parseInt(VistasAlumno.textLegajo.getText());
					int newAnio = Integer.parseInt(VistasAlumno.textAnioIngreso.getText());
					alumno alumno1 = new alumno(newLegajo, VistasAlumno.textApellido.getText(),VistasAlumno.textNombre.getText(), newAnio);
					
					if(dao.eliminar(alumno1)) {
						JOptionPane.showMessageDialog(null, "Se ha eliminado con éxito");
					}else {
						JOptionPane.showMessageDialog(null, "Ha habido un error: "+e);
					}
					System.out.println("0");
					cargar(tblData, data, model, dao, columnas);
					
				} catch (NumberFormatException ex) {
					//Mensaje de error si se ingresa otra cosa que no sea un numero en legajo o año de ingreso
					JOptionPane.showMessageDialog(null, "Ingrese valores válidos");;
				}
				
			}
		});
	}
	
	//Selección en tabla
	public static void seleccionar(JTable tblData) {
		tblData.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				 if (!e.getValueIsAdjusting() && tblData.getSelectedRow() != -1) { //al dar click, se selecciona 2 veces (raro). esto lo corrige. sin esto, al seleccionar y refrescar la tabla explota el codigo
					 	VistasAlumno.textLegajo.setText(tblData.getValueAt(tblData.getSelectedRow(), 0).toString());
					 	VistasAlumno.textApellido.setText(tblData.getValueAt(tblData.getSelectedRow(), 1).toString());
					 	VistasAlumno.textNombre.setText(tblData.getValueAt(tblData.getSelectedRow(), 2).toString());
					 	VistasAlumno.textAnioIngreso.setText(tblData.getValueAt(tblData.getSelectedRow(), 3).toString()); 
				 }
			}
		});
	}
}
