package sistGestionLogistica.gui;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;

import javax.swing.*;

import excepciones.DatosInvalidosException;
import sistGestionLogistica.controller.CamionController;

public class AgregarEditarInsumo {

	private JFrame frame;
	private JPanel panel;
	private JTextField textField_id;
	private JTextField textField_Descipcion;
	private JTextField textField_UnidadMedida;
	private JTextField textField_Costo;
	private JTextField textField_Precio;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarEditarInsumo window = new AgregarEditarInsumo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AgregarEditarInsumo() {
		//super();
		inicializar();
	}

	public void inicializar() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		textField_Descipcion = new JTextField();
		textField_Descipcion.setBounds(140, 25, 100, 20);
		textField_UnidadMedida = new JTextField();
		textField_UnidadMedida.setBounds(140, 50, 100, 20);
		textField_Costo = new JTextField();
		textField_Costo.setBounds(140, 75, 100, 20);
		textField_Precio = new JTextField();
		textField_Precio.setBounds(140, 100, 100, 20);

		textField_Descipcion.setColumns(10);
		textField_UnidadMedida.setColumns(10);
		textField_Costo.setColumns(10);
		textField_Precio.setColumns(10);

		JLabel lblDescipcion = new JLabel("Descipcion");
		lblDescipcion.setBounds(30, 25, 100, 14);
		JLabel lblUnidadMedida = new JLabel("Unidad de Medida");
		lblUnidadMedida.setBounds(30, 50, 100, 14);
		JLabel lblCosto = new JLabel("textField_Costo");
		lblCosto.setBounds(30, 75, 100, 14);
		JLabel lblPrecio = new JLabel("Km Recorrido");
		lblPrecio.setBounds(30, 100, 100, 14);		
		
		panel.add(lblDescipcion);
		panel.add(lblUnidadMedida);		
		panel.add(lblCosto);
		panel.add(lblPrecio);		
		panel.add(textField_Descipcion);
		panel.add(textField_UnidadMedida);
		panel.add(textField_Costo);
		panel.add(textField_Precio);
		
	}
	
	public void agregar() {
		
		frame.setTitle("Agregar Insumo");
		frame.setVisible(true);
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(290, 100, 90, 25);
		panel.add(btnAgregar);
		
		/*
		btnAgregar.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e) {
				
				CamionController cc= new CamionController();
				
				try {
					cc.agregarCamion(textField_Patente.getText(), textField_Marca.getText(), textField_Modelo.getText(), textField_CostoKm.getText(), textField_CostoHs.getText(), textField_KmRec.getText(), textField_Fecha.getText());
					JOptionPane.showMessageDialog(frame,"El camion fue dado de alta con exito.", "Alta Exitosa",JOptionPane.INFORMATION_MESSAGE);
					
				} catch (DateTimeParseException | DatosInvalidosException | NumberFormatException e1) {
					//Mensaje de error
					//e1.printStackTrace();
				} catch (SQLException e1) {
					//Mensaje de error
					//System.out.println("Oops!");
					JOptionPane.showMessageDialog(frame,"Verifique su conexion a la Base de Datos.","Error en la Base de Datos",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} 
			}				
		});*/
		
	}
	
	public void editarCamion(Integer id) {
		this.textField_id = new JTextField();
		this.textField_id.setText(id.toString());
		editar();
	}
	
	public void editar() {
		this.inicializar();
		frame.setTitle("Editar Insumo");
		frame.setVisible(true);
		
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(290, 100, 90, 25);
		panel.add(btnEditar);
		
		/*
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CamionController cc= new CamionController();
				try {
					cc.editarCamion(textField_id.getText(),textField_Patente.getText(), textField_Marca.getText(), textField_Modelo.getText(), textField_CostoKm.getText(), textField_CostoHs.getText(), textField_KmRec.getText(), textField_Fecha.getText());
					JOptionPane.showMessageDialog(
							frame,"El camion fue editado con exito.", "Edicion Exitosa",JOptionPane.INFORMATION_MESSAGE);
				} catch (DateTimeParseException | DatosInvalidosException | NumberFormatException e1) {
					//Mensaje de error
					JOptionPane.showMessageDialog(
							frame,"Por favor verifique sus datos.","Datos Invalidos",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (SQLException e1) {
					//Mensaje de error
					JOptionPane.showMessageDialog(
							frame,"Verifique su conexion a la Base de Datos.","Error en la Base de Datos",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});*/
			
	}
	
}