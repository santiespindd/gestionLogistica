package sistGestionLogistica.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import excepciones.DatosInvalidosException;
import sistGestionLogistica.controller.PlantaController;
import sistGestionLogistica.servicios.ServiceCamion;


public class BajaPlanta extends JFrame {

	private JPanel contentPane;
	private JTextField textField_id;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BajaPlanta frame = new BajaPlanta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BajaPlanta() {
		
		setTitle("Borrar Plantas");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 256);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingresar ID de la Planta a dar de Baja");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(90, 29, 247, 44);
		panel.add(lblNewLabel);
		
		textField_id = new JTextField();
		textField_id.setBounds(159, 84, 86, 20);
		panel.add(textField_id);
		textField_id.setColumns(10);
		
		JButton btnNewButton = new JButton("DAR DE BAJA");
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				PlantaController pc = new PlantaController();
				
				try {
					pc.borrarPlanta(textField_id.getText());
					
					JOptionPane.showMessageDialog(contentPane,
						    "La planta fue dado de baja con exito.", "Baja Exitosa",JOptionPane.INFORMATION_MESSAGE);
					
				} catch (DatosInvalidosException e1) {
					//Mensaje de error
					JOptionPane.showMessageDialog(contentPane,
						    "El id ingresado no es valido.",
						    "Error al Ingresar datos",
						    JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (SQLException e1) {
					
					//Mensaje de error
					JOptionPane.showMessageDialog(contentPane,
						    "Verifique su conexion a la Base de Datos.",
						    "Error en la Base de Datos",
						    JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(146, 148, 119, 31);
		panel.add(btnNewButton);
	}
	
}
