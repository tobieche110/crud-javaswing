package controlador;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.alumno;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import vistas.VistasAlumno;

//el controlador maneja todo, escucha la vista y opera sobre ella. el controlador si necesita algo, se lo pide al modelo. modelo se comunica con dao y controlador.

public class ControladorAlumno implements ActionListener, ListSelectionListener {
	public alumno m1 = new alumno();
	public VistasAlumno window;
	
	//TABLA
	String columnas[] = {"Legajo","Apellido","Nombre","Año de Ingreso"};
	DefaultTableModel model = new DefaultTableModel(columnas, 0);
	ArrayList<Object[]> data = new ArrayList<>();
	
	//crear constructor del anclaje modelo y vista
	public ControladorAlumno() {
		window = new VistasAlumno(); //VistasAlumno al principio
		window.frame.setVisible(true);
		
		//Agregamos event listeners
		window.btnModificar.addActionListener(this);
		window.btnEliminar.addActionListener(this);
		window.btnAgregar.addActionListener(this);
		window.tblData.getSelectionModel().addListSelectionListener(this);
		
		cargar();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource().equals(window.btnModificar)){
			modificar(ae);
		}
		else if(ae.getSource().equals(window.btnEliminar)){
			eliminar(ae);
		}
		else if(ae.getSource().equals(window.btnAgregar)) {
			agregar(ae);
		}
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		//Seleccion de tabla
		if (!e.getValueIsAdjusting() && window.tblData.getSelectedRow() != -1) { //al dar click, se selecciona 2 veces (raro). esto lo corrige. sin esto, al seleccionar y refrescar la tabla explota el codigo
		 	window.textLegajo.setText(window.tblData.getValueAt(window.tblData.getSelectedRow(), 0).toString());
		 	window.textApellido.setText(window.tblData.getValueAt(window.tblData.getSelectedRow(), 1).toString());
		 	window.textNombre.setText(window.tblData.getValueAt(window.tblData.getSelectedRow(), 2).toString());
		 	window.textAnioIngreso.setText(window.tblData.getValueAt(window.tblData.getSelectedRow(), 3).toString()); 
		}
	}
	
	//Carga los elementos a la tabla
	public void cargar() {
		data = m1.consultarDAO(); //el modelo se comunica con el controlador
		model.setRowCount(0);
		for(Object [] dato : data) {
			model.addRow(dato);
		}
		window.tblData.setModel(model);
		
	}
	
	
	//Botón Modificar
	public void modificar(ActionEvent ae) {
		try {
			int newLegajo = Integer.parseInt(window.textLegajo.getText());
			int newAnio = Integer.parseInt(window.textAnioIngreso.getText());
			alumno alumno1 = new alumno(newLegajo, window.textApellido.getText(),window.textNombre.getText(), newAnio);
					
			if(m1.modificarDAO(alumno1)) {
				JOptionPane.showMessageDialog(null, "Se ha modificado con éxito");
			}else {
				JOptionPane.showMessageDialog(null, "Ha habido un error");
			}
			cargar();
					
		} catch (NumberFormatException ex) {
			//Mensaje de error si se ingresa otra cosa que no sea un numero en legajo o año de ingreso
			JOptionPane.showMessageDialog(null, "Ingrese valores válidos");;
		}
	}
	
	
	//Botón Agregar
	public void agregar(ActionEvent ae) {
		try {
			int newLegajo = Integer.parseInt(window.textLegajo.getText());
			int newAnio = Integer.parseInt(window.textAnioIngreso.getText());
			alumno alumno1 = new alumno(newLegajo, window.textApellido.getText(),window.textNombre.getText(), newAnio);
					
			if(m1.insertarDAO(alumno1)) {
				JOptionPane.showMessageDialog(null, "Se ha agregado con éxito");
			}else {
				JOptionPane.showMessageDialog(null, "Ha habido un error");
			}
			cargar();
					
		} catch (NumberFormatException ex) {
			//Mensaje de error si se ingresa otra cosa que no sea un numero en legajo o año de ingreso
			JOptionPane.showMessageDialog(null, "Ingrese valores válidos");;
		}
	}
	
	//Botón Eliminar
	public void eliminar(ActionEvent ae) {
		try {
			int newLegajo = Integer.parseInt(window.textLegajo.getText());
			int newAnio = Integer.parseInt(window.textAnioIngreso.getText());
			alumno alumno1 = new alumno(newLegajo, window.textApellido.getText(),window.textNombre.getText(), newAnio);
					
			if(m1.eliminarDAO(alumno1)) {
				JOptionPane.showMessageDialog(null, "Se ha eliminado con éxito");
			}else {
				JOptionPane.showMessageDialog(null, "Ha habido un error");
			}
			cargar();
					
		} catch (NumberFormatException ex) {
			//Mensaje de error si se ingresa otra cosa que no sea un numero en legajo o año de ingreso
			JOptionPane.showMessageDialog(null, "Ingrese valores válidos");;
		}
				
	}

}
