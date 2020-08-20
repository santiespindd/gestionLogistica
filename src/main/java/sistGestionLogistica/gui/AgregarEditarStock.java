package sistGestionLogistica.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.awt.EventQueue;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.Vector;

import excepciones.DatosInvalidosException;
import sistGestionLogistica.controller.PlantaController;
import sistGestionLogistica.controller.StockInsumoController;


public class AgregarEditarStock {

	private JFrame frame;
	private JComboBox  comboBox_Insumo;
	private JTextField textField_Cantidad;
	private JTextField textField_PtoRep;
	private JPanel panel;
	private Integer idPlanta;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarEditarStock window = new AgregarEditarStock();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AgregarEditarStock() {
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
	
	public void agregarStock(Integer id) {
		
		this.idPlanta = id;
		agregar();
	}

	public void agregar(){
		
		frame.setTitle("Agregar Insumo a Stock");
		frame.setVisible(true);
		
		//----------string para el combo box-------
		
		StockInsumoController ic = new StockInsumoController();
		String[][] insumos = ic.faltante(idPlanta.toString(), "");
		Vector<String> insumoID= new Vector<>();
		for(int i = 0; i< insumos.length; i++){
			System.out.print(insumos[i][0]);
			insumoID.add(insumos[i][0]) ;
		}
		System.out.print("\n");
		//--------------
		
		comboBox_Insumo = new JComboBox<String>(insumoID);
		comboBox_Insumo.setBounds(130, 25, 86, 20);
		textField_Cantidad = new JTextField();
		textField_Cantidad.setBounds(130, 50, 86, 20);
		textField_PtoRep = new JTextField();
		textField_PtoRep.setBounds(130, 75, 86, 20);
		
		JLabel lblInsumo = new JLabel("ID Insumo");
		lblInsumo.setBounds(25, 25, 46, 14);
		JLabel lblCant = new JLabel("Cantidad");
		lblCant.setBounds(25, 50, 46, 14);
		JLabel lblPtoRep = new JLabel("Punto de reposicion");
		lblPtoRep.setBounds(25, 75, 46, 14);
		
		panel.add(lblInsumo);
		panel.add(lblCant);
		panel.add(lblPtoRep);
		panel.add(comboBox_Insumo);
		panel.add(textField_Cantidad);
		panel.add(textField_PtoRep);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(252, 105, 89, 23);
		panel.add(btnAgregar);

		
		btnAgregar.addActionListener(new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
				StockInsumoController ic= new StockInsumoController();
								
				try {
					ic.agregarStockInsumo(idPlanta.toString(), comboBox_Insumo.getSelectedItem().toString(), textField_Cantidad.getText(), textField_PtoRep.getText());
					JOptionPane.showMessageDialog(frame,"La planta fue creada exitosamente.", "Alta Exitosa",JOptionPane.INFORMATION_MESSAGE);
					
				} catch (DateTimeParseException | NumberFormatException | DatosInvalidosException e1) {
					//e1.printStackTrace();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}				
		});
		
		
	}
	
	public void editarStock(Integer id) {
		
		this.idPlanta = id;
		editar();
	}
	
	public void editar(){
		
		//this.inicializar();	
		frame.setTitle("Editar Insumo en Stock");
		frame.setVisible(true);
		
		textField_Cantidad = new JTextField();
		textField_Cantidad.setBounds(130, 50, 86, 20);
		textField_Cantidad.setColumns(10);	
		textField_PtoRep = new JTextField();
		textField_PtoRep.setBounds(130, 75, 86, 20);
		textField_PtoRep.setColumns(10);
		
		JLabel lblInsumo = new JLabel("ID Insumo");
		lblInsumo.setBounds(25, 25, 46, 14);
		JLabel lblCant = new JLabel("Cantidad");
		lblCant.setBounds(25, 25, 46, 14);
		JLabel lblPtoRep = new JLabel("Punto de reposicion");
		lblPtoRep.setBounds(25, 25, 46, 14);
		
		panel.add(lblInsumo);
		panel.add(lblCant);
		panel.add(lblPtoRep);
		panel.add(comboBox_Insumo);
		panel.add(textField_Cantidad);
		panel.add(textField_PtoRep);
		
		JButton btnAgregar = new JButton("Editar");
		btnAgregar.setBounds(252, 105, 89, 23);
		panel.add(btnAgregar);
		
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StockInsumoController ic= new StockInsumoController();
				
				//try {
					//pc.registrarPlanta(textField_Nombre.getText());
					
					JOptionPane.showMessageDialog(frame,"La planta fue editada con exito.", "Edicion Exitosa",JOptionPane.INFORMATION_MESSAGE);
				
				//} catch (DateTimeParseException | DatosInvalidosException | NumberFormatException e1) {
					//Mensaje de error
					//JOptionPane.showMessageDialog(frame,"Por favor verifique sus datos.","Datos Invalidos",JOptionPane.ERROR_MESSAGE);
					//e1.printStackTrace();
				//}
			}
		});

		
	}
	
	
}

