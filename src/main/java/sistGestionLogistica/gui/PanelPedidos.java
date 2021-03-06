package sistGestionLogistica.gui;

import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import excepciones.DatosInvalidosException;
import sistGestionLogistica.controller.PedidoController;
import sistGestionLogistica.controller.PlantaController;
import sistGestionLogistica.dominio.Pedido;
import sistGestionLogistica.enums.EstadoPedido;
import sistGestionLogistica.servicios.ServicePedido;
import sistGestionLogistica.sistema.App;

public class PanelPedidos extends JPanel {

	private JTable table_Plantas;
	private JComboBox<String> comboEstado;
	private String[] estadospedido = {"CREADA","PROCESADA","ENTREGADA","CANCELADA"};
	private Integer nroAux;
	private JButton btnAlta;
	//private JButton btnBaja;
	//private JButton btnEditar;
	private JButton btnAgregarEnvio;
	private JButton btnDetalles;
	private JButton btnFinalizar;

	public PanelPedidos() {

	}
	
	public void inicializar(App aplicacion) {
		aplicacion.setTitle("Sistema de Gestion Logistica - Pedidos");		
		
		PanelPedidos panel = new PanelPedidos();
		panel.setLayout(null);
		panel.setBackground(Color.orange);
		
		Integer altoP = aplicacion.getHeight()/10;
		Integer anchoP = aplicacion.getWidth()/8;
		
		aplicacion.pedidosActivated();
		aplicacion.setContentPane(panel);
		aplicacion.revalidate();
		aplicacion.repaint();
		
		//---------Botones-----------------
		
		btnAlta = new JButton("Crear Pedido");
		btnAlta.setBounds((anchoP), (altoP/5), 130, 25);
		/*btnBaja = new JButton("Baja");
		btnBaja.setBounds((anchoP+110), (altoP/5), 90, 25);
		btnEditar = new JButton("Editar");
		btnEditar.setBounds((anchoP+2*110), (altoP/5), 90, 25);*/
		btnAgregarEnvio = new JButton("Agregar envio");
		btnAgregarEnvio.setBounds((anchoP+1*140), (altoP/5), 130, 25);
		btnDetalles = new JButton("Ver detalles");
		btnDetalles.setBounds((anchoP+2*140), (altoP/5), 130, 25);
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds((anchoP+3*140), (altoP/5), 130, 25);
		
		panel.add(btnAlta);
		//panel.add(btnBaja);
		//panel.add(btnEditar);
		panel.add(btnAgregarEnvio);
		panel.add(btnDetalles);
		panel.add(btnFinalizar);
		
		btnFinalizar.setEnabled(false);
		btnAgregarEnvio.setEnabled(false);
		btnDetalles.setEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds((anchoP), (4*altoP), (6*anchoP), (4*altoP));
		panel.add(scrollPane);
		
		//-------tabla-------
		
		table_Plantas = new JTable();
		scrollPane.setViewportView(table_Plantas);
		table_Plantas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_Plantas.setToolTipText("");
		
		table_Plantas.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Nro. Orden", "Planta Destino", "Fecha Solicitud", "Fecha Entrega", "Estado"}) {
			
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		//--------------------
		
		//----------panel buscar----------
		
		JPanel panelBuscar = new JPanel(new GridBagLayout());
		panelBuscar.setBounds((anchoP), (altoP), (6*anchoP), (2*altoP));
		
		GridBagConstraints p = new GridBagConstraints();
		p.gridheight = 1;
		p.gridwidth = 1;
		p.weightx = (anchoP);
		p.weighty = (altoP);
		
		//----------------------
		
		p.fill = GridBagConstraints.HORIZONTAL;
		
		comboEstado = new JComboBox<String>(estadospedido);
		p.gridx = 1;
		p.gridy = 0;
		panelBuscar.add(comboEstado, p);
		
		//-------------------------
		
		p.fill = GridBagConstraints.CENTER;
		
		JLabel lblEstado = new JLabel("Estado del pedido");
		p.gridx = 0;
		p.gridy = 0;
		panelBuscar.add(lblEstado, p);
		
		//---------------------
		
		p.fill = GridBagConstraints.CENTER;
		
		JButton btnBuscar = new JButton("Buscar"+"\n"+"Actualizar");
		p.gridx = 3;
		p.gridy = 0;
		panelBuscar.add(btnBuscar, p);
		
		panelBuscar.setVisible(true);
		panel.add(panelBuscar);
		
		//--------------------
	
		table_Plantas.getColumnModel().getColumn(0).setPreferredWidth(35);
		
		
		//--------Acciones Botones--------------	
		
		btnAlta.addActionListener(e-> {	//AccionAlta
			
			System.out.println("Pedidos -> Alta");
			
			AgregarEditarPedido pedido = new AgregarEditarPedido();
			try {
				pedido.agregar();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		});
		/*btnBaja.addActionListener(e-> { //AccionBaja
			
			System.out.println("Pedidos -> Baja");
			

		});
		btnEditar.addActionListener(e-> {	//AccionEditar
		
			System.out.println("Pedidos -> Editar Pedido");
			//nuevo pedidos controller
			//llamar a metodo editar

		});*/
		btnDetalles.addActionListener(e-> {	//Acciondetalles
		
			System.out.println("Pedidos -> Editar Pedido");
			
			ServicePedido sp = new ServicePedido();
			AgregarEditarPedido pedido = new AgregarEditarPedido();
			
			try {
				Pedido pedidoAux = sp.buscarPorNumOrden(nroAux);
				pedido.verDetalle(pedidoAux);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			

		});
		btnAgregarEnvio.addActionListener(e-> {	//AccionAgregarDetEnvio
		
			System.out.println("Pedidos -> Editar Pedido");

			AgregarEditarDetallesEnvio ade = new AgregarEditarDetallesEnvio(nroAux);
			btnBuscar.doClick();

		});
		btnFinalizar.addActionListener(e-> {	//
			
			System.out.println("Pedidos -> Editar Pedido");

			PedidoController fp = new PedidoController();
			try {
				fp.finalizarPedido(nroAux.toString());
				JOptionPane.showMessageDialog(null,"El pedido fue entregado correctamente", "Pedido Finalizado",JOptionPane.INFORMATION_MESSAGE);
			} catch (NumberFormatException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
		btnBuscar.addActionListener(new AccionBuscar());
	
	//---------accion click-------
	
	table_Plantas.addMouseListener(new MouseAdapter() { //
		
		public void mouseClicked(MouseEvent e) {
			System.out.println("Pedidos -> click Seleccionar");
			int fila = table_Plantas.rowAtPoint(e.getPoint());
			
			if(fila>-1) {
				nroAux = Integer.valueOf((String) table_Plantas.getValueAt(fila,0));
				
				if(comboEstado.getSelectedItem().toString()=="CREADA") {
					btnAgregarEnvio.setEnabled(true);
				}
				if(comboEstado.getSelectedItem().toString()=="PROCESADA") {
					btnFinalizar.setEnabled(true);
				}				
				btnDetalles.setEnabled(true);
			}
			
		}
	});
	
	}
	
	//-----------------buscar-actualizar----------------
	
	class AccionBuscar implements ActionListener {
		 
		@Override
		 public void actionPerformed(ActionEvent e) {
			 
			 System.out.println("Pedido -> Buscar-Actualizar");
			 
			 btnAgregarEnvio.setEnabled(false);
			 btnDetalles.setEnabled(false);
			 btnFinalizar.setEnabled(false);
			 
			 PedidoController pc= new PedidoController();
			 
			 try {
				this.actualizarTabla(pc.buscarPedido(comboEstado.getSelectedItem().toString()));
				//this.actualizarTabla(pc.buscarPedido("CREADA"));
				
				//System.out.println(pc.buscarPedido("CREADA").length);
				System.out.println("Buscar OK");
			
			//} catch ( SQLException e1) {
			} catch ( DatosInvalidosException | SQLException e1) {
				//e1.printStackTrace();
			}
		 }	

		private void actualizarTabla(String[][] aMostrar) throws NumberFormatException, DatosInvalidosException, SQLException {
			
			table_Plantas.setModel(new DefaultTableModel(aMostrar,	new String[] {"Nro. Orden", "Planta Destino", "Fecha Solicitud", "Fecha Entrega", "Estado"}) 
			{
				Class[] columnTypes = new Class[] {
					Object.class, String.class, String.class, String.class, String.class, String.class
				};
					
				public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
				}
			});
			
		}
	}
	
}
