package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import controlador.ControladorAlumno;


public class VistasAlumno {
	
	//all were only private
	public JFrame frame;
	public JTextField textLegajo;
	public JTextField textApellido;
	public JTextField textNombre;
	public JTextField textAnioIngreso;
	public JTable tblData; //es la informacion de la tabla que se muestra en pantalla
	
	//added by me
	public JButton btnModificar;
	public JButton btnAgregar;
	public JButton btnEliminar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { //
				try {
					@SuppressWarnings("unused")
					ControladorAlumno c1 = new ControladorAlumno();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistasAlumno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 874, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alumnos de la carrera");
		lblNewLabel.setBounds(322, 5, 214, 27);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		frame.getContentPane().add(lblNewLabel);
		
		textLegajo = new JTextField();
		textLegajo.setBounds(21, 344, 86, 20);
		frame.getContentPane().add(textLegajo);
		textLegajo.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(150, 344, 86, 20);
		frame.getContentPane().add(textApellido);
		textApellido.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(284, 344, 86, 20);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textAnioIngreso = new JTextField();
		textAnioIngreso.setBounds(413, 344, 86, 20);
		frame.getContentPane().add(textAnioIngreso);
		textAnioIngreso.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("LEGAJO");
		lblNewLabel_1.setBounds(43, 319, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("APELLIDO");
		lblNewLabel_2.setBounds(173, 319, 63, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("NOMBRE");
		lblNewLabel_3.setBounds(304, 319, 78, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("AÑO DE INGRESO");
		lblNewLabel_4.setBounds(413, 316, 141, 20);
		frame.getContentPane().add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 40, 815, 265);
		frame.getContentPane().add(scrollPane);
		
		tblData = new JTable();
		tblData.setDefaultEditor(Object.class, null); //hace la tabla no editable
		scrollPane.setViewportView(tblData);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(524, 343, 103, 23);
		frame.getContentPane().add(btnModificar);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBounds(637, 343, 89, 23);
		frame.getContentPane().add(btnAgregar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(736, 343, 89, 23);
		frame.getContentPane().add(btnEliminar);
		
		
		JLabel lblNewLabel_5 = new JLabel("Nota: No se puede editar el Legajo al ser una clave primaria.");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_5.setBounds(19, 367, 804, 26);
		frame.getContentPane().add(lblNewLabel_5);
	
	}
	
}
