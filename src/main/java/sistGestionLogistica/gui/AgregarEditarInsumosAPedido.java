package sistGestionLogistica.gui;

import java.awt.EventQueue;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.*;

import sistGestionLogistica.dao.StockInsumoDao;
import sistGestionLogistica.dao.StockInsumoDaoMysql;
import sistGestionLogistica.dominio.Insumo;
import sistGestionLogistica.dominio.InsumoLiquido;
import sistGestionLogistica.enums.UnidadMedida;
import sistGestionLogistica.servicios.ServiceInsumo;

public class AgregarEditarInsumosAPedido extends JFrame{

	private JPanel panel;
	private Integer alto;
	private Integer ancho;
	private JComboBox<String> insumo;
	private JTextField cantidad;

	public static void main(String[] args) throws SQLException {
		
		AgregarEditarInsumosAPedido window = new AgregarEditarInsumosAPedido();
		window.setVisible(true);
	}

	public AgregarEditarInsumosAPedido() throws SQLException {
		super();
		inicializar();
	}
	
	private void inicializar() throws SQLException{
		
		alto = 100;
		ancho = 100;
		
		this.setBounds(ancho, alto, 4*ancho, 2*alto);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 4*ancho, 2*alto);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(true);

		this.setTitle("Agregar Items a pedido");
		//this.setVisible(true);
		
		//----------string para el combo box-------
		
		Insumo in = new InsumoLiquido(-1,"",-1.0,-1.0,UnidadMedida.KG,-1.0);
		ServiceInsumo ser = new ServiceInsumo();
		
		ArrayList<Insumo> lista =  (ArrayList<Insumo>) ser.buscarInsumo(in);
		Vector<Integer> insumoID= new Vector<>();
		Vector<String> insumoLbl= new Vector<>();
		StockInsumoDao sid = new StockInsumoDaoMysql();
		
		for(int i = 0; i < lista.size(); i++){
			
			insumoLbl.add(lista.get(i).getIdInsumo()+" - "+lista.get(i).getDescripcion());
			insumoID.add(lista.get(i).getIdInsumo());
			
		}
		System.out.print("\n");
		//--------------
		
		insumo = new JComboBox<String>(insumoLbl);
		insumo.setBounds(200, 25, 120, 20);
		cantidad = new JTextField();
		cantidad.setBounds(200, 50, 120, 20);
		JLabel lblInsumo = new JLabel("Insumo");
		lblInsumo.setBounds(25, 25, 150, 20);
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(25, 50, 150, 20);
		
		panel.add(insumo);
		panel.add(cantidad);
		panel.add(lblInsumo);
		panel.add(lblCantidad);
		
		//-------------------
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(75, 85, 150, 20);
		panel.add(btnAgregar);
		
		/*btnAgregar.addActionListener(new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
		StockInsumoController ic= new StockInsumoController();
						
		try {
			ic.agregarStockInsumo(idPlanta.toString(), insumoID.get(comboBox_Insumo.getSelectedIndex()).toString(), textField_Cantidad.getText(), textField_PtoRep.getText());
			JOptionPane.showMessageDialog(frame,"Insumo agregado correctamente", "Reposicion exitosa",JOptionPane.INFORMATION_MESSAGE);
			
		} catch (DateTimeParseException | NumberFormatException | DatosInvalidosException e1) {
			e1.printStackTrace();
			
		} catch (SQLException e1) {
			//TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}				
	});*/
		
}
	
}