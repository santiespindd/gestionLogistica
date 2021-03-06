package sistGestionLogistica.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.awt.EventQueue;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.format.DateTimeParseException;

import excepciones.DatosInvalidosException;
import sistGestionLogistica.controller.PlantaController;


public class AgregarEditarPlanta {

	private JFrame frame;
	private JTextField textField_id;
	private JTextField textField_Nombre;
	private JPanel panel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarEditarPlanta window = new AgregarEditarPlanta();
					window.frame.setVisible(true);
					window.editarPlanta(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AgregarEditarPlanta() {
		//super();
		inicializar();
	}
	
	private void inicializar(){
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	}

	public void agregar(){
		
		//this.inicializar();
		frame.setTitle("Agregar Planta");
		frame.setVisible(true);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(130, 25, 86, 20);
		textField_Nombre.setColumns(10);	
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(25, 25, 46, 14);
		
		panel.add(lblNombre);
		panel.add(textField_Nombre);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(252, 105, 89, 23);
		panel.add(btnAgregar);

		
		btnAgregar.addActionListener(new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
				PlantaController pc= new PlantaController();
				
				try {
					pc.registrarPlanta(textField_Nombre.getText());
					JOptionPane.showMessageDialog(frame,"La planta fue creada exitosamente.", "Alta Exitosa",JOptionPane.INFORMATION_MESSAGE);
					
				} catch (DateTimeParseException | NumberFormatException | DatosInvalidosException e1) {
					//e1.printStackTrace();
					
				}
			}				
		});
		
		
	}
	
	public void editarPlanta(Integer id) {
		this.textField_id = new JTextField();
		this.textField_id.setText(id.toString());
		editar();
	}
	
	public void editar(){
		
		//this.inicializar();	
		frame.setTitle("Editar Planta");
		frame.setVisible(true);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(130, 25, 86, 20);
		textField_Nombre.setColumns(10);	
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(25, 25, 46, 14);
		
		panel.add(lblNombre);
		panel.add(textField_Nombre);
		
		JButton btnEditar= new JButton("Editar");
		btnEditar.setBounds(252, 105, 89, 23);
		panel.add(btnEditar);
		
		
		
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("accion editar");
				
				PlantaController pc= new PlantaController();
				
				try {
					pc.editarPlanta(textField_id.getText(), textField_Nombre.getText());
					
					JOptionPane.showMessageDialog(frame,"La planta fue editada con exito.", "Edicion Exitosa",JOptionPane.INFORMATION_MESSAGE);
				
				} catch (DateTimeParseException | DatosInvalidosException | NumberFormatException e1) {
					//Mensaje de error
					JOptionPane.showMessageDialog(frame,"Por favor verifique sus datos.","Datos Invalidos",JOptionPane.ERROR_MESSAGE);
					//e1.printStackTrace();
				} catch (SQLException e1) {
					//e1.printStackTrace();
				}
			}
		});

		
	}
	
	
}

