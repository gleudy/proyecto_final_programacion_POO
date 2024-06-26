package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import file.Guardar;
import logico.Cliente;
import logico.Combo;
import logico.Componente;
import logico.Disco;
import logico.Empleado;
import logico.Factura;
import logico.Micro;
import logico.MotherBoard;
import logico.Ram;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtClienteNombre;
	private JTextField txtClienteTelefono;
	private JTextField txtClienteCedula;
	private JTextField txtTrabajadorNombre;
	private JTextField txtTrabajadorTelefono;
	private JTextField txtTrabajadorCedula;
	private JTextField txtTrabajadorCargo;
	private JTextField txtTrabajadorSueldo;
	private JTextField txtRamNum;
	private JTextField txtRamPrecio;
	private JTextField txtRamCantidad;
	private JTextField txtRamMarca;
	private JTextField txtRamMemoria;
	private JTextField txtRamTipo;
	private JTextField txtDiscoNum;
	private JTextField txtDiscoPrecio;
	private JTextField txtDiscoCant;
	private JTextField txtDiscoMarca;
	private JTextField txtDiscoAlmacenamiento;
	private JTextField txtDiscoConexion;
	private JTextField txtDiscoModelo;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField txtMotherNum;
	private JTextField txtMotherPrecio;
	private JTextField txtMotherCant;
	private JTextField txtMotherMarca;
	private JTextField txtMotherRam;
	private JTextField txtMotherConector;
	private JTextField txtMotherModelo;
	private JTextField txtMotherConexiones;
	private JTextField txtMicroNum;
	private JTextField txtMicroPrecio;
	private JTextField txtMicroCant;
	private JTextField txtMicroMarca;
	private JTextField txtMicroConexion;
	private JTextField txtMicroVelocidad;
	private JTextField txtMicroModelo;
	private String nombreUsuario = Login.usuario;
	public boolean Rol = true;
	private JTable tableClientes;
	private DefaultTableModel model;
	private JTable tableTrabajadores;
	private JTable tableDisco;
	private JTable tableMother;
	private JTable tableMicro;
	private JTable tableRam;
	private JComboBox<String> cbmTipocliente = new JComboBox<>();;
	private JButton btnEliminarClientes = new JButton("Eliminar");
	private JButton btnModificarClientes = new JButton("Modificar");
	private JTable tableFacturacion;
	private JTextField txtCantMemoria;
	private JTextField txtCantidad;
	private JTextField txtMarca;
	private JTextField txtTipoCone;
	private JTextField txtModelo;
	private JTextField txtTipoMemoria;
	private JTextField txtAlmacenamiento;
	private JTextField txtTipoRam;
	private JTextField txtPrecio;
	private JTextField txtVelocidad;
	private JComboBox<String> cbProductos;
	private JComboBox<String> cbTipos;
	private HashMap<String, String> productoClaseMap;
	private Guardar guardar;
	private JComboBox<String> cbClientes;
	private JTextField txtCantidadCompra;
	private DefaultTableModel modelFacturacion;
	private JCheckBox checkCombo;
	private JLabel lblTotal;
	private JLabel lblSubTotal;
	private JLabel lblTotalDescuento;
	private JLabel lblTotalItbis;
	private static final int COLUMNA_COMPONENTE = 0;
	private JButton btnActualizarCliente = new JButton("Actualizar");
	private JTextPane txtClienteDireccion = new JTextPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 754);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		cbClientes = new JComboBox<>();
		checkCombo = new JCheckBox("Activar Combo");
		lblTotal = new JLabel("0");
		lblSubTotal = new JLabel("0");
		lblTotalItbis = new JLabel("0");
		lblTotalDescuento = new JLabel("0");
		checkCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		checkCombo.setEnabled(false);

		productoClaseMap = new HashMap<>();
		productoClaseMap.put("Disco Duro", "Disco");
		productoClaseMap.put("Memoria Ram", "Ram");
		productoClaseMap.put("Mother Board", "MotherBoard");
		productoClaseMap.put("Microprocesador", "Micro");

		ArrayList<String> nombresClientes = new ArrayList<>();

		// Obtener la lista de objetos de clientes desde el archivo binario
		ArrayList<Object> clientes1 = Guardar.getInstance().recuperarObjetos(Guardar.getGuardar().getCliente());

		// Verificar si la lista de clientes no es nula
		if (clientes1 != null) {
			// Recorrer la lista de clientes y agregar los nombres al ArrayList
			for (Object obj : clientes1) {
				if (obj instanceof Cliente) {
					Cliente cliente = (Cliente) obj;
					// Agregar el nombre del cliente al ArrayList
					nombresClientes.add(cliente.getNombre());
				}
			}
		}

		// Crear un modelo de ComboBox con los nombres de los clientes
		DefaultComboBoxModel<String> modeloClientes = new DefaultComboBoxModel<>(
				nombresClientes.toArray(new String[0]));

		// Asignar el modelo de ComboBox al JComboBox
		cbClientes.setModel(modeloClientes);

		guardar = Guardar.getInstance();

		cbTipos = new JComboBox<>();
		cbTipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtener el número de serie seleccionado en cbTipos
				String numeroSerieSeleccionado = (String) cbTipos.getSelectedItem();
				ArrayList<Object> componentes = guardar.recuperarObjetos(guardar.getComponente());
				// Buscar el componente correspondiente en la lista de componentes
				for (Object componente : componentes) {
					if (componente instanceof Disco) {
						Disco disco = (Disco) componente;
						if (disco.getNumeroSerie().equals(numeroSerieSeleccionado)) {
							txtPrecio.setText(String.valueOf(disco.getPrecio()));
							txtCantidad.setText(String.valueOf(disco.getCantidadDispo()));
							txtMarca.setText(disco.getMarca());
							txtAlmacenamiento.setText(String.valueOf(disco.getAlmacenamiento()));
							txtTipoCone.setText(disco.getTipoConexion());
							txtModelo.setText(disco.getModelo());

							break;
						}
					} else if (componente instanceof Ram) {
						Ram ram = (Ram) componente;
						if (ram.getNumeroSerie().equals(numeroSerieSeleccionado)) {
							txtPrecio.setText(String.valueOf(ram.getPrecio()));
							txtCantidad.setText(String.valueOf(ram.getCantidadDispo()));
							txtMarca.setText(ram.getMarca());
							txtCantMemoria.setText(String.valueOf(ram.getCantMemoria()));
							txtTipoMemoria.setText(ram.getTipoMemoria());

							break;
						} else if (componente instanceof Micro) {
							Micro micro = (Micro) componente;
							if (micro.getNumeroSerie().equals(numeroSerieSeleccionado)) {
								txtPrecio.setText(String.valueOf(micro.getPrecio()));
								txtCantidad.setText(String.valueOf(micro.getCantidadDispo()));
								txtMarca.setText(micro.getMarca());
								txtVelocidad.setText(String.valueOf(micro.getVelocidadProc()));
								txtTipoCone.setText(micro.getTipoConexion());
								txtModelo.setText(micro.getModelo());

								break;
							}
						} else if (componente instanceof MotherBoard) {
							MotherBoard mother = (MotherBoard) componente;
							if (mother.getNumeroSerie().equals(numeroSerieSeleccionado)) {
								txtPrecio.setText(String.valueOf(mother.getPrecio()));
								txtCantidad.setText(String.valueOf(mother.getCantidadDispo()));
								txtMarca.setText(mother.getMarca());
								txtModelo.setText(mother.getModelo());
								txtTipoRam.setText(mother.getTipoRam());
								txtTipoCone.setText(mother.getTipoConector());
								break;
							}
						}
					}
				}

			}
		});
		cbTipos.setBounds(535, 65, 168, 29);

		cbProductos = new JComboBox<>();
		cbProductos.setModel(new DefaultComboBoxModel<>(new String[] { "-- Elige una opcion", "Disco Duro",
				"Memoria Ram", "Mother Board", "Microprocesador" }));
		cbProductos.setBounds(307, 65, 191, 29);

		cbProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtener el producto seleccionado
				String productoSeleccionado = (String) cbProductos.getSelectedItem();

				// Limpiar el modelo actual de cbTipos
				DefaultComboBoxModel<String> modeloTipos = new DefaultComboBoxModel<>();

				// Obtener la lista de componentes desde el archivo binario
				ArrayList<Object> componentes = guardar.recuperarObjetos(guardar.getComponente());

				// Verificar si la lista de componentes no es nula
				if (componentes != null) {
					// Filtrar los componentes por tipo
					for (Object componente : componentes) {
						if (componente instanceof Disco && productoSeleccionado.equals("Disco Duro")) {
							Disco disco = (Disco) componente;
							modeloTipos.addElement(disco.getNumeroSerie());
						} else if (componente instanceof Ram && productoSeleccionado.equals("Memoria Ram")) {
							Ram ram = (Ram) componente;
							modeloTipos.addElement(ram.getNumeroSerie());
						} else if (componente instanceof MotherBoard && productoSeleccionado.equals("Mother Board")) {
							MotherBoard motherBoard = (MotherBoard) componente;
							modeloTipos.addElement(motherBoard.getNumeroSerie());
						} else if (componente instanceof Micro && productoSeleccionado.equals("Microprocesador")) {
							Micro microprocesador = (Micro) componente;
							modeloTipos.addElement(microprocesador.getNumeroSerie());
						}
					}
				}

				// Asignar el nuevo modelo al cbTipos
				cbTipos.setModel(modeloTipos);
			}

		});

		setContentPane(contentPane);
		contentPane.setLayout(null);
		Login l = new Login();

		if (nombreUsuario.equalsIgnoreCase("Vendedor")) {
			Rol = false;
		} else {
			Rol = true;
		}

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 48, 203, 677);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 1071, 49);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("PC Componenentes");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(28, 11, 209, 27);
		panel_1.add(lblNewLabel);

		JButton btnNewButton = new JButton("Cerrar Sesion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres cerrar la sesión?",
						"Cerrar Sesión", JOptionPane.YES_NO_OPTION);
				if (confirmacion == JOptionPane.YES_OPTION) {

					JOptionPane.showMessageDialog(null, "Sesión cerrada exitosamente.", "Cerrar Sesión",
							JOptionPane.INFORMATION_MESSAGE);

					dispose();
					Login l = new Login();
					l.setVisible(true);
					l.setModal(true);
					l.setLocationRelativeTo(null);
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(204, 0, 0));
		btnNewButton.setBounds(911, 11, 131, 31);
		panel_1.add(btnNewButton);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(203, 30, 858, 685);
		contentPane.add(tabbedPane);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(80, 11, 713, 532);
		panel_2.add(panel_1_1);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 128, 255), 1, true));
		panel_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1.setBounds(34, 49, 196, 158);
		panel_1_1.add(panel_1_1_1);

		JLabel lblDisco = new JLabel("New label");
		lblDisco.setBounds(10, 11, 183, 144);
		panel_1_1_1.add(lblDisco);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setForeground(new Color(0, 64, 128));
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1.setBackground(new Color(0, 128, 255));
		panel_2_1.setBounds(34, 206, 196, 74);
		panel_1_1.add(panel_2_1);

		JLabel lblNewLabel_1_9 = new JLabel("Discos Duro");
		lblNewLabel_1_9.setForeground(Color.WHITE);
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_9.setBounds(10, 0, 186, 28);
		panel_2_1.add(lblNewLabel_1_9);

		JTextPane txtDisco = new JTextPane();
		txtDisco.setText("Los mejores discos duros del \r\nmercado en calidad precio del pais");
		txtDisco.setBackground(new Color(0, 128, 255));
		txtDisco.setBounds(10, 25, 176, 34);
		panel_2_1.add(txtDisco);

		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBorder(new LineBorder(new Color(0, 128, 255), 1, true));
		panel_1_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1_1.setBounds(256, 49, 204, 158);
		panel_1_1.add(panel_1_1_1_1);

		JLabel lblMemoria = new JLabel("New label");
		lblMemoria.setBounds(10, 11, 184, 135);
		panel_1_1_1_1.add(lblMemoria);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1_1.setBackground(new Color(0, 128, 255));
		panel_2_1_1.setBounds(256, 206, 204, 74);
		panel_1_1.add(panel_2_1_1);

		JTextPane txtRam = new JTextPane();
		txtRam.setText("La mejor calidad en memoria \r\npara que tu equipo sea top ");
		txtRam.setBackground(new Color(0, 128, 255));
		txtRam.setBounds(10, 29, 176, 34);
		panel_2_1_1.add(txtRam);

		JLabel lblNewLabel_1_1_7 = new JLabel("Memoria Ram");
		lblNewLabel_1_1_7.setForeground(Color.WHITE);
		lblNewLabel_1_1_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_7.setBounds(10, 0, 186, 28);
		panel_2_1_1.add(lblNewLabel_1_1_7);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new LineBorder(new Color(0, 128, 255), 1, true));
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setBounds(484, 49, 196, 158);
		panel_1_1.add(panel_1_2);

		JLabel lblMicro = new JLabel("New label");
		lblMicro.setBounds(10, 11, 183, 144);
		panel_1_2.add(lblMicro);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_2.setBackground(new Color(0, 128, 255));
		panel_2_2.setBounds(484, 206, 196, 74);
		panel_1_1.add(panel_2_2);

		JLabel lblNewLabel_1_2_7 = new JLabel("Micro Procesadores");
		lblNewLabel_1_2_7.setForeground(Color.WHITE);
		lblNewLabel_1_2_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_7.setBounds(10, 0, 186, 28);
		panel_2_2.add(lblNewLabel_1_2_7);

		JTextPane txtMicro = new JTextPane();
		txtMicro.setText("Los mejores micro procesadores\r\na el mejor precio posible para tu PC");
		txtMicro.setBackground(new Color(0, 128, 255));
		txtMicro.setBounds(10, 25, 176, 34);
		panel_2_2.add(txtMicro);

		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBorder(new LineBorder(new Color(0, 128, 255), 1, true));
		panel_1_3.setBackground(Color.WHITE);
		panel_1_3.setBounds(151, 291, 196, 158);
		panel_1_1.add(panel_1_3);

		JLabel lblTarjeta = new JLabel("New label");
		lblTarjeta.setBounds(10, 11, 183, 144);
		panel_1_3.add(lblTarjeta);

		JPanel panel_2_3 = new JPanel();
		panel_2_3.setLayout(null);
		panel_2_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_3.setBackground(new Color(0, 128, 255));
		panel_2_3.setBounds(151, 445, 196, 74);
		panel_1_1.add(panel_2_3);

		JLabel lblNewLabel_1_3_6 = new JLabel("Mother Board");
		lblNewLabel_1_3_6.setForeground(Color.WHITE);
		lblNewLabel_1_3_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3_6.setBounds(10, 0, 186, 28);
		panel_2_3.add(lblNewLabel_1_3_6);

		JTextPane txtTarjeta = new JTextPane();
		txtTarjeta.setText("No encuentras la mother board\r\npara tu pc, aqui la tenemos");
		txtTarjeta.setBackground(new Color(0, 128, 255));
		txtTarjeta.setBounds(10, 25, 176, 34);
		panel_2_3.add(txtTarjeta);

		JPanel panel_1_4 = new JPanel();
		panel_1_4.setLayout(null);
		panel_1_4.setBorder(new LineBorder(new Color(0, 128, 255), 1, true));
		panel_1_4.setBackground(Color.WHITE);
		panel_1_4.setBounds(371, 291, 196, 158);
		panel_1_1.add(panel_1_4);

		JLabel lblCombo = new JLabel("New label");
		lblCombo.setBounds(10, 11, 176, 144);
		panel_1_4.add(lblCombo);

		JPanel panel_2_4 = new JPanel();
		panel_2_4.setLayout(null);
		panel_2_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_4.setBackground(new Color(0, 128, 255));
		panel_2_4.setBounds(371, 445, 196, 74);
		panel_1_1.add(panel_2_4);

		JLabel lblNewLabel_1_4_5 = new JLabel("PC combo");
		lblNewLabel_1_4_5.setForeground(Color.WHITE);
		lblNewLabel_1_4_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4_5.setBounds(10, 0, 186, 28);
		panel_2_4.add(lblNewLabel_1_4_5);
		l.setImageLabel(lblCombo, "src/imagenes/pc2.jpg");
		l.setImageLabel(lblMicro, "src/imagenes/microprocesador6.jpg");
		l.setImageLabel(lblMemoria, "src/imagenes/memoriaRam.jpeg");
		l.setImageLabel(lblTarjeta, "src/imagenes/motherBoard.jpg");
		l.setImageLabel(lblDisco, "src/imagenes/Disco.jpg");

		JTextPane txtCombo = new JTextPane();
		txtCombo.setText("Te quieres llevar tu combo\r\ncompleto con el mejor descuento");
		txtCombo.setBackground(new Color(0, 128, 255));
		txtCombo.setBounds(10, 25, 164, 38);
		panel_2_4.add(txtCombo);

		JLabel lblNewLabel_3 = new JLabel("Nuestros productos");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setBounds(272, 0, 169, 30);
		panel_1_1.add(lblNewLabel_3);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab(" tab", null, panel_3, null);
		panel_3.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClientes.clearSelection(); // Limpiar la selección de la tabla al hacer clic fuera de ella
				btnEliminarClientes.setEnabled(false);
				btnModificarClientes.setEnabled(false);
				btnActualizarCliente.setEnabled(false);
			}
		});
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(0, 128, 255)));
		panel_4.setBounds(10, 43, 833, 587);
		panel_3.add(panel_4);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(348, 24, 234, 15);
		panel_4.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Telefono:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(31, 108, 234, 15);
		panel_4.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Direccion:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(348, 108, 234, 15);
		panel_4.add(lblNewLabel_1_2);

		txtClienteNombre = new JTextField();
		txtClienteNombre.setColumns(10);
		txtClienteNombre.setBounds(348, 50, 468, 30);
		panel_4.add(txtClienteNombre);

		txtClienteTelefono = new JTextField();
		txtClienteTelefono.setColumns(10);
		txtClienteTelefono.setBounds(31, 134, 234, 30);
		panel_4.add(txtClienteTelefono);

		txtClienteDireccion.setBackground(new Color(245, 245, 245));
		txtClienteDireccion.setBounds(348, 134, 468, 49);
		panel_4.add(txtClienteDireccion);

		JLabel lblNewLabel_1_3 = new JLabel("Cedula");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(31, 21, 234, 15);
		panel_4.add(lblNewLabel_1_3);

		txtClienteCedula = new JTextField();

		txtClienteCedula.setColumns(10);
		txtClienteCedula.setBounds(31, 50, 234, 30);
		panel_4.add(txtClienteCedula);

		JLabel lblNewLabel_1_2_1 = new JLabel("Tipo de cliente");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(31, 190, 234, 15);
		panel_4.add(lblNewLabel_1_2_1);

		JButton btnGuardarCliente = new JButton("Guardar");
		btnGuardarCliente.setForeground(new Color(255, 255, 255));
		btnGuardarCliente.setBackground(new Color(30, 144, 255));
		btnGuardarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula = txtClienteCedula.getText();
				String nombre = txtClienteNombre.getText();
				String telefono = txtClienteTelefono.getText();
				String direccion = txtClienteDireccion.getText();
				String tipoCliente = (String) cbmTipocliente.getSelectedItem();

				// Crear un nuevo objeto Cliente con los datos ingresados por el usuario
				Cliente nuevoCliente = new Cliente(cedula, nombre, telefono, direccion, tipoCliente);

				// Obtener la instancia de Guardar
				Guardar guardar = Guardar.getInstance();

				// Obtener la lista actual de clientes desde el archivo binario
				ArrayList<Object> clientes = guardar.recuperarObjetos(guardar.getCliente());

				// Verificar si la lista de clientes es nula y, si es así, crear una nueva lista
				if (clientes == null) {
					clientes = new ArrayList<>();
				}
				// ==============GLEUDY
				// GOMEZ==============================================================================================
				// Agregar el nuevo cliente a la lista
				if (nuevoCliente.getCedula().equals(null) || nuevoCliente.getCedula().equals("")) {
					JOptionPane.showMessageDialog(null, "Debe llenar el campo cedula. ", "Aviso",
							JOptionPane.WARNING_MESSAGE);

				} else if (!validadOnceDigitos(txtClienteCedula)) {
					JOptionPane.showMessageDialog(null, "En campo cedula debe tener 11 digitos numericos. ", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				} else if (!validadOnceDigitos(txtClienteTelefono)) {
					JOptionPane.showMessageDialog(null, "En campo telefono debe tener 11 digitos numericos. ", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				} else if (nuevoCliente.getNombre().equals(null) || nuevoCliente.getNombre().equals("")) {
					JOptionPane.showMessageDialog(null, "Debe llenar el campo nombre. ", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				} else if (cbmTipocliente.getSelectedItem().equals("--Seleccione")) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de cliente. ", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				} else {
					clientes.add(nuevoCliente);

					// Guardar la lista actualizada de clientes en el archivo binario
					guardar.guardarObjetos(clientes, guardar.getCliente());

					// Actualizar la tabla de clientes para reflejar el nuevo cliente
					refrescarTablaClientes(clientes);
					txtClienteCedula.setText("");
					txtClienteNombre.setText("");
					txtClienteTelefono.setText("");
					txtClienteDireccion.setText("");
					cbmTipocliente.setSelectedIndex(0);
				}
			}

			private void refrescarTablaClientes(ArrayList<Object> clientes) {
				DefaultTableModel modelClientes = (DefaultTableModel) tableClientes.getModel();
				modelClientes.setRowCount(0); // Limpiar la tabla antes de agregar los clientes nuevamente

				// Verificar si la lista de clientes no es nula
				if (clientes != null) {
					// Agregar todos los clientes al modelo de la tabla
					for (Object obj : clientes) {
						if (obj instanceof Cliente) {
							Cliente cliente = (Cliente) obj;
							modelClientes.addRow(new Object[] { cliente.getCedula(), cliente.getNombre(),
									cliente.getDireccion(), cliente.getTelefono(), cliente.getTipoCliente() });
						}
					}
				}
			}
		});
		btnGuardarCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuardarCliente.setBounds(348, 194, 99, 49);
		panel_4.add(btnGuardarCliente);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedrow = tableClientes.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) tableClientes.getModel();
				txtClienteCedula.setText(model.getValueAt(selectedrow, 0).toString());
				txtClienteNombre.setText(model.getValueAt(selectedrow, 1).toString());
				txtClienteTelefono.setText(model.getValueAt(selectedrow, 2).toString());
				txtClienteDireccion.setText(model.getValueAt(selectedrow, 3).toString());
				String valorEncontrado = model.getValueAt(selectedrow, 3).toString();
				for (int i = 0; i < cbmTipocliente.getItemCount(); i++) {
					String articulo = cbmTipocliente.getItemAt(i);
					if (articulo.equals(valorEncontrado)) {
						cbmTipocliente.setSelectedIndex(i);
						break;
					}
				}
			}
		});
		scrollPane.setBounds(31, 270, 785, 241);
		panel_4.add(scrollPane);

		tableClientes = new JTable();
		tableClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) { // Si el usuario hace un solo clic
					int selectedRow = tableClientes.rowAtPoint(e.getPoint()); // Obtener la fila seleccionada
					if (selectedRow != -1) { // Si se hizo clic en una fila válida
						tableClientes.setRowSelectionInterval(selectedRow, selectedRow); // Seleccionar la fila
						btnEliminarClientes.setEnabled(true);
						btnModificarClientes.setEnabled(true);

					}
				}
			}
		});
		model = new DefaultTableModel();
		tableClientes.setModel(model);

		model.addColumn("Cedula");
		model.addColumn("Nombre");
		model.addColumn("Telefono");
		model.addColumn("Direccion");
		model.addColumn("Tipo de cliente");
		DefaultTableModel model = (DefaultTableModel) tableClientes.getModel();

		// Leer los clientes del archivo binario y cargarlos en el modelo de la tabla
		ArrayList<Object> clientes = Guardar.getInstance().recuperarObjetos(Guardar.getGuardar().getCliente());
		if (clientes != null) {
			for (Object obj : clientes) {
				if (obj instanceof Cliente) {
					Cliente cliente = (Cliente) obj;
					model.addRow(new Object[] { cliente.getCedula(), cliente.getNombre(), cliente.getTelefono(),
							cliente.getDireccion(), cliente.getTipoCliente() });
				}
			}
		}

		scrollPane.setViewportView(tableClientes);
		btnModificarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tableClientes.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) tableClientes.getModel();
				if (i != -1) {
					guardarDatosFilaSeleccionada(model, tableClientes);
				} else {
					// Mostrar un mensaje indicando que no se ha seleccionado ninguna fila
					JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para modificar.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				btnActualizarCliente.setEnabled(true);
			}
		});

		btnModificarClientes.setEnabled(false);
		btnModificarClientes.setForeground(Color.WHITE);
		btnModificarClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarClientes.setBackground(new Color(0, 139, 139));
		btnModificarClientes.setBounds(471, 194, 99, 49);
		panel_4.add(btnModificarClientes);
		// GLEUDY GOMEZ

		btnEliminarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el cliente?", "Aviso",
						JOptionPane.INFORMATION_MESSAGE);
				if (respuesta == JOptionPane.YES_OPTION) {
					eliminarFilaTabla();
				}

			}
		});
		btnEliminarClientes.setEnabled(false);
		btnEliminarClientes.setForeground(Color.WHITE);
		btnEliminarClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminarClientes.setBackground(new Color(139, 0, 0));
		btnEliminarClientes.setBounds(590, 194, 99, 49);
		panel_4.add(btnEliminarClientes);

		JLabel lblNewLabel_4 = new JLabel("Ej: 13100099536");
		lblNewLabel_4.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setForeground(Color.GRAY);
		lblNewLabel_4.setBounds(60, 80, 153, 14);
		panel_4.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Ej: 18095642314");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setForeground(Color.GRAY);
		lblNewLabel_5.setBounds(60, 163, 148, 14);
		panel_4.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Ej: Juan Garcia");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setForeground(Color.GRAY);
		lblNewLabel_6.setBounds(348, 83, 87, 14);
		panel_4.add(lblNewLabel_6);

		// JComboBox cbmTipocliente = new JComboBox();
		cbmTipocliente.setBackground(new Color(255, 255, 255));
		cbmTipocliente.setForeground(Color.BLACK);
		cbmTipocliente.setModel(
				new DefaultComboBoxModel(new String[] { "--Seleccione", "Regular", "Revendedor", "Mayorista" }));
		cbmTipocliente.setBounds(31, 209, 234, 34);
		panel_4.add(cbmTipocliente);
		btnActualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea actualizar el cliente?", "Aviso",
						JOptionPane.INFORMATION_MESSAGE);

				if (respuesta == JOptionPane.YES_OPTION) {

					if (respuesta == JOptionPane.YES_OPTION) {
						if (txtClienteCedula.getText().equals(null) || txtClienteCedula.getText().equals("")) {

							JOptionPane.showMessageDialog(null, "Debe llenar el campo cedula. ", "Aviso",

									JOptionPane.WARNING_MESSAGE);

						} else if (!validadOnceDigitos(txtClienteCedula)) {

							JOptionPane.showMessageDialog(null, "En campo cedula debe tener 11 digitos numericos. ",
									"Aviso",

									JOptionPane.WARNING_MESSAGE);

						} else if (!validadOnceDigitos(txtClienteTelefono)) {

							JOptionPane.showMessageDialog(null, "En campo telefono debe tener 11 digitos numericos. ",
									"Aviso",

									JOptionPane.WARNING_MESSAGE);

						} else if (txtClienteNombre.getText().equals(null) || txtClienteNombre.getText().equals("")) {

							JOptionPane.showMessageDialog(null, "Debe llenar el campo nombre. ", "Aviso",

									JOptionPane.WARNING_MESSAGE);

						} else if (cbmTipocliente.getSelectedItem().equals("--Seleccione")) {

							JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de cliente. ", "Aviso",

									JOptionPane.WARNING_MESSAGE);

						} else {
							actualizarDatosCliente();
							txtClienteCedula.setText("");
							txtClienteNombre.setText("");
							txtClienteTelefono.setText("");
							txtClienteDireccion.setText("");
							cbmTipocliente.setSelectedIndex(0);

							btnActualizarCliente.setEnabled(false);
						}

					}

				}

			}
		});

		btnActualizarCliente.setEnabled(false);
		btnActualizarCliente.setForeground(Color.WHITE);
		btnActualizarCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnActualizarCliente.setBackground(new Color(30, 144, 255));
		btnActualizarCliente.setBounds(699, 194, 117, 49);
		panel_4.add(btnActualizarCliente);

		JLabel lblCrearCliente = new JLabel("Crear Cliente");
		lblCrearCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblCrearCliente.setBounds(360, 12, 160, 20);
		panel_3.add(lblCrearCliente);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_5, null);
		panel_5.setLayout(null);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(new Color(255, 255, 255));
		panel_4_1.setLayout(null);
		panel_4_1.setBorder(new LineBorder(new Color(0, 128, 255)));
		panel_4_1.setBounds(48, 30, 757, 535);
		panel_5.add(panel_4_1);

		JLabel lblNewLabel_1_4 = new JLabel("Nombre:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(60, 90, 234, 15);
		panel_4_1.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_1_1 = new JLabel("Telefono:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(60, 157, 234, 15);
		panel_4_1.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("Direccion:");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_2.setBounds(397, 157, 234, 15);
		panel_4_1.add(lblNewLabel_1_2_2);

		txtTrabajadorNombre = new JTextField();
		txtTrabajadorNombre.setColumns(10);
		txtTrabajadorNombre.setBounds(60, 116, 253, 30);
		panel_4_1.add(txtTrabajadorNombre);

		txtTrabajadorTelefono = new JTextField();
		txtTrabajadorTelefono.setColumns(10);
		txtTrabajadorTelefono.setBounds(60, 183, 253, 30);
		panel_4_1.add(txtTrabajadorTelefono);

		JTextPane txtTrabajadorDireccion = new JTextPane();
		txtTrabajadorDireccion.setBackground(new Color(245, 245, 245));
		txtTrabajadorDireccion.setBounds(397, 183, 292, 49);
		panel_4_1.add(txtTrabajadorDireccion);

		JLabel lblNewLabel_1_3_1 = new JLabel("Cedula");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3_1.setBounds(60, 23, 234, 15);
		panel_4_1.add(lblNewLabel_1_3_1);

		txtTrabajadorCedula = new JTextField();
		txtTrabajadorCedula.setColumns(10);
		txtTrabajadorCedula.setBounds(60, 49, 201, 30);
		panel_4_1.add(txtTrabajadorCedula);

		JButton btnGuardarTrabajador = new JButton("Guardar");
		btnGuardarTrabajador.setForeground(new Color(255, 255, 255));
		btnGuardarTrabajador.setBackground(new Color(0, 0, 255));
		btnGuardarTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate fechaActual = LocalDate.now();
				// Formatear la fecha actual como String

				// Obtener los otros datos ingresados por el usuario desde los campos de texto u
				// otros componentes
				String cedula = txtTrabajadorCedula.getText();
				String nombre = txtTrabajadorNombre.getText();
				String direccion = txtTrabajadorDireccion.getText();
				String telefono = txtTrabajadorTelefono.getText();
				String cargo = txtTrabajadorCargo.getText();
				double sueldo = Double.parseDouble(txtTrabajadorSueldo.getText());

				// Crear un nuevo objeto Empleado con los datos ingresados por el usuario
				Empleado nuevoEmpleado = new Empleado(cedula, nombre, direccion, telefono, fechaActual, cargo, sueldo);

				Guardar guardar = Guardar.getInstance();

				// Obtener la lista actual de empleados desde el archivo binario
				ArrayList<Object> empleados = guardar.recuperarObjetos(guardar.getEmpleado());

				// Verificar si la lista de empleados es nula y, si es así, crear una nueva
				// lista
				if (empleados == null) {
					empleados = new ArrayList<>();
				}

				// Agregar el nuevo empleado a la lista
				empleados.add(nuevoEmpleado);

				// Guardar la lista actualizada de empleados en el archivo binario
				guardar.guardarObjetos(empleados, guardar.getEmpleado());

				refrescarTabla(empleados);
			}

			private void refrescarTabla(ArrayList<Object> empleados) {
				DefaultTableModel modelTrabajadores = (DefaultTableModel) tableTrabajadores.getModel();
				modelTrabajadores.setRowCount(0); // Limpiar la tabla antes de agregar los empleados nuevamente

				// Verificar si la lista de empleados no es nula
				if (empleados != null) {
					// Agregar todos los empleados al modelo de la tabla
					for (Object obj : empleados) {
						if (obj instanceof Empleado) {
							Empleado empleado = (Empleado) obj;
							modelTrabajadores.addRow(new Object[] { empleado.getCedula(), empleado.getNombre(),
									empleado.getDireccion(), empleado.getTelefono(), empleado.getFechaIngreso(),
									empleado.getCargo(), empleado.getSueldo() });
						}
					}
				}
			}
		});
		btnGuardarTrabajador.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGuardarTrabajador.setBounds(236, 234, 234, 38);
		panel_4_1.add(btnGuardarTrabajador);

		JLabel lblNewLabel_1_3_1_1_1 = new JLabel("Cargo");
		lblNewLabel_1_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3_1_1_1.setBounds(397, 23, 234, 15);
		panel_4_1.add(lblNewLabel_1_3_1_1_1);

		JLabel lblNewLabel_1_3_1_1_2 = new JLabel("Sueldo");
		lblNewLabel_1_3_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3_1_1_2.setBounds(397, 90, 234, 15);
		panel_4_1.add(lblNewLabel_1_3_1_1_2);

		txtTrabajadorCargo = new JTextField();
		txtTrabajadorCargo.setColumns(10);
		txtTrabajadorCargo.setBounds(398, 49, 292, 30);
		panel_4_1.add(txtTrabajadorCargo);

		txtTrabajadorSueldo = new JTextField();
		txtTrabajadorSueldo.setColumns(10);
		txtTrabajadorSueldo.setBounds(398, 116, 292, 30);
		panel_4_1.add(txtTrabajadorSueldo);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(60, 283, 630, 241);
		panel_4_1.add(scrollPane_1);

		DefaultTableModel modelTrabajadores = new DefaultTableModel();
		modelTrabajadores.addColumn("Cedula");
		modelTrabajadores.addColumn("Nombre");
		modelTrabajadores.addColumn("Direccion");
		modelTrabajadores.addColumn("Telefono");
		modelTrabajadores.addColumn("Fecha ingreso");
		modelTrabajadores.addColumn("Cargo");
		modelTrabajadores.addColumn("Sueldo");

		// Crear la tabla para los trabajadores
		tableTrabajadores = new JTable();
		tableTrabajadores.setModel(modelTrabajadores);

		// Leer los empleados del archivo binario y cargarlos en el modelo de la tabla
		ArrayList<Object> empleados = Guardar.getInstance().recuperarObjetos(Guardar.getGuardar().getEmpleado());
		if (empleados != null) {
			for (Object obj : empleados) {
				if (obj instanceof Empleado) {
					Empleado empleado = (Empleado) obj;
					modelTrabajadores.addRow(new Object[] { empleado.getCedula(), empleado.getNombre(),
							empleado.getDireccion(), empleado.getTelefono(), empleado.getFechaIngreso(),
							empleado.getCargo(), empleado.getSueldo() });
				}
			}
		}

		scrollPane_1.setViewportView(tableTrabajadores);

		JLabel lblCrearTrabajador = new JLabel("Crear trabajador");
		lblCrearTrabajador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblCrearTrabajador.setBounds(335, -1, 160, 20);
		panel_5.add(lblCrearTrabajador);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_6, null);
		panel_6.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new LineBorder(new Color(0, 128, 192)));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(67, 43, 656, 465);
		panel_6.add(panel_7);

		JLabel lblNewLabel_1_5 = new JLabel("Numero de serie");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_5.setBounds(117, 31, 107, 14);
		panel_7.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_1_2 = new JLabel("Precio");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_2.setBounds(117, 73, 56, 14);
		panel_7.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_2_3 = new JLabel("Cantidad disponible");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2_3.setBounds(117, 116, 130, 14);
		panel_7.add(lblNewLabel_1_2_3);

		JLabel lblNewLabel_1_3_2 = new JLabel("Marca");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3_2.setBounds(346, 31, 88, 14);
		panel_7.add(lblNewLabel_1_3_2);

		JLabel lblNewLabel_1_4_1 = new JLabel("Cantidad de memoria");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4_1.setBounds(346, 73, 130, 14);
		panel_7.add(lblNewLabel_1_4_1);

		JLabel lblNewLabel_1_5_1 = new JLabel("Tipo de memoria");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_5_1.setBounds(346, 116, 108, 14);
		panel_7.add(lblNewLabel_1_5_1);

		txtRamNum = new JTextField();
		txtRamNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRamNum.setColumns(10);
		txtRamNum.setBounds(221, 29, 86, 20);
		panel_7.add(txtRamNum);

		txtRamPrecio = new JTextField();
		txtRamPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRamPrecio.setColumns(10);
		txtRamPrecio.setBounds(167, 71, 140, 20);
		panel_7.add(txtRamPrecio);

		txtRamCantidad = new JTextField();
		txtRamCantidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRamCantidad.setColumns(10);
		txtRamCantidad.setBounds(250, 114, 57, 20);
		panel_7.add(txtRamCantidad);

		txtRamMarca = new JTextField();
		txtRamMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRamMarca.setColumns(10);
		txtRamMarca.setBounds(400, 28, 172, 20);
		panel_7.add(txtRamMarca);

		txtRamMemoria = new JTextField();
		txtRamMemoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRamMemoria.setColumns(10);
		txtRamMemoria.setBounds(486, 71, 86, 20);
		panel_7.add(txtRamMemoria);

		txtRamTipo = new JTextField();
		txtRamTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRamTipo.setColumns(10);
		txtRamTipo.setBounds(464, 114, 108, 20);
		panel_7.add(txtRamTipo);

		JButton btnGuardarRam = new JButton("Guardar");
		btnGuardarRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtRamNum.getText();
				double precio = Double.parseDouble(txtRamPrecio.getText());
				int cantidad = Integer.parseInt(txtRamCantidad.getText());
				String marca = txtRamMarca.getText();
				int capacidad = Integer.parseInt(txtRamMemoria.getText());
				String tipo = txtRamTipo.getText();

				// Crear un nuevo objeto Ram con los datos ingresados por el usuario
				Ram nuevaRam = new Ram(id, precio, cantidad, marca, capacidad, tipo);

				// Obtener la instancia de Guardar
				Guardar guardar = Guardar.getInstance();

				// Obtener la lista actual de componentes desde el archivo binario
				ArrayList<Object> componentes = guardar.recuperarObjetos(guardar.getComponente());

				// Verificar si la lista de componentes es nula y, si es así, crear una nueva
				// lista
				if (componentes == null) {
					componentes = new ArrayList<>();
				}

				// Agregar la nueva RAM a la lista de componentes
				componentes.add(nuevaRam);

				// Guardar la lista actualizada de componentes en el archivo binario
				guardar.guardarObjetos(componentes, guardar.getComponente());

				// Actualizar la tabla de RAM para reflejar los cambios
				refrescarTablaRam(componentes);

			}

			private void refrescarTablaRam(ArrayList<Object> componentes) {
				DefaultTableModel modelRam = (DefaultTableModel) tableRam.getModel();
				modelRam.setRowCount(0); // Limpiar la tabla antes de agregar los componentes nuevamente

				// Verificar si la lista de componentes no es nula
				if (componentes != null) {
					// Agregar todas las RAM al modelo de la tabla
					for (Object obj : componentes) {
						if (obj instanceof Ram) {
							Ram ram = (Ram) obj;
							modelRam.addRow(
									new Object[] { ram.getNumeroSerie(), ram.getPrecio(), ram.getCantidadDispo(),
											ram.getMarca(), ram.getCantMemoria(), ram.getTipoMemoria() });
						}
					}
				}
			}
		});
		btnGuardarRam.setForeground(Color.WHITE);
		btnGuardarRam.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardarRam.setBackground(new Color(0, 128, 255));
		btnGuardarRam.setBounds(263, 159, 107, 29);
		panel_7.add(btnGuardarRam);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(16, 210, 630, 241);
		panel_7.add(scrollPane_1_1);

		// Crear el modelo de tabla para las RAM
		DefaultTableModel modelRam = new DefaultTableModel();
		modelRam.addColumn("ID");
		modelRam.addColumn("Precio");
		modelRam.addColumn("Cantidad");
		modelRam.addColumn("Marca");
		modelRam.addColumn("Capacidad");
		modelRam.addColumn("Tipo");

		// Obtener la instancia de Guardar
		Guardar guardar = Guardar.getInstance();

		// Obtener la lista de todos los componentes del archivo binario
		ArrayList<Object> componentes = guardar.recuperarObjetos(guardar.getComponente());

		// Crear la tabla para las RAM con el modelo de datos
		tableRam = new JTable(modelRam);
		tableRam.setModel(modelRam);

		// Verificar si la lista de componentes no es nula
		if (componentes != null) {
			// Recorrer la lista de componentes y agregar las RAM al modelo de la tabla
			for (Object obj : componentes) {
				if (obj instanceof Ram) {
					Ram ram = (Ram) obj;
					modelRam.addRow(new Object[] { ram.getNumeroSerie(), ram.getPrecio(), ram.getCantidadDispo(),
							ram.getMarca(), ram.getCantMemoria(), ram.getTipoMemoria() });
				}
			}
		}

		// Crear la tabla para las RAM con el modelo de datos
		tableRam = new JTable(modelRam);

		scrollPane_1_1.setViewportView(tableRam);

		JLabel lblNewLabel_2 = new JLabel("Crear Memoria Ram");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setBounds(323, 2, 172, 30);
		panel_6.add(lblNewLabel_2);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_8, null);
		panel_8.setLayout(null);

		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new LineBorder(new Color(0, 128, 192)));
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(91, 41, 654, 505);
		panel_8.add(panel_9);

		JLabel lblNewLabel_1_6 = new JLabel("Numero de serie");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_6.setBounds(137, 33, 107, 14);
		panel_9.add(lblNewLabel_1_6);

		JLabel lblNewLabel_1_1_3 = new JLabel("Precio");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_3.setBounds(137, 75, 56, 14);
		panel_9.add(lblNewLabel_1_1_3);

		JLabel lblNewLabel_1_2_4 = new JLabel("Cantidad disponible");
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2_4.setBounds(137, 118, 130, 14);
		panel_9.add(lblNewLabel_1_2_4);

		JLabel lblNewLabel_1_3_3 = new JLabel("Marca");
		lblNewLabel_1_3_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3_3.setBounds(366, 33, 56, 14);
		panel_9.add(lblNewLabel_1_3_3);

		JLabel lblNewLabel_1_4_2 = new JLabel("Almacenamiento");
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4_2.setBounds(366, 75, 107, 14);
		panel_9.add(lblNewLabel_1_4_2);

		JLabel lblNewLabel_1_5_2 = new JLabel("Tipo de conexion");
		lblNewLabel_1_5_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_5_2.setBounds(366, 118, 108, 14);
		panel_9.add(lblNewLabel_1_5_2);

		txtDiscoNum = new JTextField();
		txtDiscoNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDiscoNum.setColumns(10);
		txtDiscoNum.setBounds(241, 31, 76, 20);
		panel_9.add(txtDiscoNum);

		txtDiscoPrecio = new JTextField();
		txtDiscoPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDiscoPrecio.setColumns(10);
		txtDiscoPrecio.setBounds(187, 73, 130, 20);
		panel_9.add(txtDiscoPrecio);

		txtDiscoCant = new JTextField();
		txtDiscoCant.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDiscoCant.setColumns(10);
		txtDiscoCant.setBounds(270, 116, 47, 20);
		panel_9.add(txtDiscoCant);

		txtDiscoMarca = new JTextField();
		txtDiscoMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDiscoMarca.setColumns(10);
		txtDiscoMarca.setBounds(420, 30, 138, 20);
		panel_9.add(txtDiscoMarca);

		txtDiscoAlmacenamiento = new JTextField();
		txtDiscoAlmacenamiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDiscoAlmacenamiento.setColumns(10);
		txtDiscoAlmacenamiento.setBounds(472, 72, 86, 20);
		panel_9.add(txtDiscoAlmacenamiento);

		txtDiscoConexion = new JTextField();
		txtDiscoConexion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDiscoConexion.setColumns(10);
		txtDiscoConexion.setBounds(484, 116, 74, 20);
		panel_9.add(txtDiscoConexion);

		JButton brnDiscoGuardar = new JButton("Guardar");
		brnDiscoGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtener los datos ingresados por el usuario desde los campos de texto u otros
				// componentes
				String id = txtDiscoNum.getText();
				double precio = Double.parseDouble(txtDiscoPrecio.getText());
				int cantidad = Integer.parseInt(txtDiscoCant.getText());
				String marca = txtDiscoMarca.getText();
				int capacidad = Integer.parseInt(txtDiscoAlmacenamiento.getText());
				String tipoConexion = txtDiscoConexion.getText();
				String modelo = txtDiscoModelo.getText();

				// Crear un nuevo objeto Disco con los datos ingresados por el usuario
				Disco nuevoDisco = new Disco(id, precio, cantidad, marca, modelo, capacidad, tipoConexion);

				// Obtener la instancia de Guardar
				Guardar guardar = Guardar.getInstance();

				// Obtener la lista actual de componentes desde el archivo binario
				ArrayList<Object> componentes = guardar.recuperarObjetos(guardar.getComponente());

				// Verificar si la lista de componentes es nula y, si es así, crear una nueva
				// lista
				if (componentes == null) {
					componentes = new ArrayList<>();
				}

				// Agregar el nuevo Disco a la lista de componentes
				componentes.add(nuevoDisco);

				// Guardar la lista actualizada de componentes en el archivo binario
				guardar.guardarObjetos(componentes, guardar.getComponente());

				// Actualizar la tabla de Discos Duros para reflejar los cambios
				refrescarTablaDisco(componentes);

			}

			private void refrescarTablaDisco(ArrayList<Object> componentes) {
				DefaultTableModel modelDisco = (DefaultTableModel) tableDisco.getModel();
				modelDisco.setRowCount(0); // Limpiar la tabla antes de agregar los componentes nuevamente

				// Verificar si la lista de componentes no es nula
				if (componentes != null) {
					// Agregar todos los Discos Duros al modelo de la tabla
					for (Object obj : componentes) {
						if (obj instanceof Disco) {
							Disco disco = (Disco) obj;
							modelDisco.addRow(new Object[] { disco.getNumeroSerie(), disco.getPrecio(),
									disco.getCantidadDispo(), disco.getMarca(), disco.getModelo(),
									disco.getAlmacenamiento(), disco.getTipoConexion() });
						}
					}
				}
			}
		});
		brnDiscoGuardar.setForeground(Color.WHITE);
		brnDiscoGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		brnDiscoGuardar.setBackground(new Color(0, 128, 255));
		brnDiscoGuardar.setBounds(312, 196, 96, 29);
		panel_9.add(brnDiscoGuardar);

		JLabel lblNewLabel_1_1_4 = new JLabel("Modelo");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_4.setBounds(137, 158, 56, 14);
		panel_9.add(lblNewLabel_1_1_4);

		txtDiscoModelo = new JTextField();
		txtDiscoModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDiscoModelo.setColumns(10);
		txtDiscoModelo.setBounds(187, 156, 130, 20);
		panel_9.add(txtDiscoModelo);

		JScrollPane scrollPane_1_2 = new JScrollPane();
		scrollPane_1_2.setBounds(10, 253, 630, 241);
		panel_9.add(scrollPane_1_2);

		tableDisco = new JTable();

		DefaultTableModel modelDisco = new DefaultTableModel();
		modelDisco.addColumn("ID");
		modelDisco.addColumn("Precio");
		modelDisco.addColumn("Cantidad");
		modelDisco.addColumn("Marca");
		modelDisco.addColumn("Modelo");
		modelDisco.addColumn("Almacenamiento");
		modelDisco.addColumn("Tipo de conexión");

		// Obtener la instancia de Guardar
		Guardar guardar1 = Guardar.getInstance();

		// Obtener la lista de todos los componentes del archivo binario
		ArrayList<Object> componentes1 = guardar1.recuperarObjetos(guardar1.getComponente());

		// Crear la tabla para los discos duros con el modelo de datos
		tableDisco = new JTable(modelDisco);

		tableDisco.setModel(modelDisco);

		// Verificar si la lista de componentes no es nula
		if (componentes1 != null) {
			// Recorrer la lista de componentes y agregar los discos duros al modelo de la
			// tabla
			for (Object obj : componentes1) {
				if (obj instanceof Disco) {
					Disco disco = (Disco) obj;
					modelDisco.addRow(new Object[] { disco.getNumeroSerie(), disco.getPrecio(),
							disco.getCantidadDispo(), disco.getMarca(), disco.getModelo(), disco.getAlmacenamiento(),
							disco.getTipoConexion() });
				}
			}
		}

		// Asignar el modelo de datos a la tabla de discos duros
		tableDisco.setModel(modelDisco);

		scrollPane_1_2.setViewportView(tableDisco);

		JLabel lblCrearDiscoDuro = new JLabel("Crear Disco Duro");
		lblCrearDiscoDuro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblCrearDiscoDuro.setBounds(313, 0, 172, 30);
		panel_8.add(lblCrearDiscoDuro);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_10, null);
		panel_10.setLayout(null);

		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBorder(new LineBorder(new Color(0, 128, 192)));
		panel_14.setBackground(Color.WHITE);
		panel_14.setBounds(94, 46, 652, 513);
		panel_10.add(panel_14);

		JLabel lblNewLabel_1_10 = new JLabel("Numero de serie");
		lblNewLabel_1_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_10.setBounds(78, 33, 107, 14);
		panel_14.add(lblNewLabel_1_10);

		JLabel lblNewLabel_1_1_8 = new JLabel("Precio");
		lblNewLabel_1_1_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_8.setBounds(78, 75, 56, 14);
		panel_14.add(lblNewLabel_1_1_8);

		JLabel lblNewLabel_1_2_8 = new JLabel("Cantidad disponible");
		lblNewLabel_1_2_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2_8.setBounds(78, 118, 130, 14);
		panel_14.add(lblNewLabel_1_2_8);

		JLabel lblNewLabel_1_3_7 = new JLabel("Marca");
		lblNewLabel_1_3_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3_7.setBounds(307, 33, 88, 14);
		panel_14.add(lblNewLabel_1_3_7);

		JLabel lblNewLabel_1_4_6 = new JLabel("Tipo de conexion");
		lblNewLabel_1_4_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4_6.setBounds(307, 75, 130, 14);
		panel_14.add(lblNewLabel_1_4_6);

		JLabel lblNewLabel_1_5_9 = new JLabel("Velocidad de procesamiento");
		lblNewLabel_1_5_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_5_9.setBounds(307, 118, 171, 14);
		panel_14.add(lblNewLabel_1_5_9);

		txtMicroNum = new JTextField();
		txtMicroNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMicroNum.setColumns(10);
		txtMicroNum.setBounds(182, 31, 76, 20);
		panel_14.add(txtMicroNum);

		txtMicroPrecio = new JTextField();
		txtMicroPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMicroPrecio.setColumns(10);
		txtMicroPrecio.setBounds(128, 73, 130, 20);
		panel_14.add(txtMicroPrecio);

		txtMicroCant = new JTextField();
		txtMicroCant.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMicroCant.setColumns(10);
		txtMicroCant.setBounds(211, 116, 47, 20);
		panel_14.add(txtMicroCant);

		txtMicroMarca = new JTextField();
		txtMicroMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMicroMarca.setColumns(10);
		txtMicroMarca.setBounds(361, 30, 183, 20);
		panel_14.add(txtMicroMarca);

		txtMicroConexion = new JTextField();
		txtMicroConexion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMicroConexion.setColumns(10);
		txtMicroConexion.setBounds(427, 72, 117, 20);
		panel_14.add(txtMicroConexion);

		txtMicroVelocidad = new JTextField();
		txtMicroVelocidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMicroVelocidad.setColumns(10);
		txtMicroVelocidad.setBounds(488, 115, 56, 20);
		panel_14.add(txtMicroVelocidad);

		JButton btnMicroGuardar = new JButton("Guardar");
		btnMicroGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtMicroNum.getText();
				double precio = Double.parseDouble(txtMicroPrecio.getText());
				int cantidad = Integer.parseInt(txtMicroCant.getText());
				String marca = txtMicroMarca.getText();

				String tipoConexion = txtMicroConexion.getText();
				String modelo = txtMicroModelo.getText();
				int velocidad = Integer.parseInt(txtMicroVelocidad.getText());

				// Crear un nuevo objeto Disco con los datos ingresados por el usuario
				Micro nuevoMicro = new Micro(id, precio, cantidad, marca, modelo, tipoConexion, velocidad);

				// Obtener la instancia de Guardar
				Guardar guardar = Guardar.getInstance();

				// Obtener la lista actual de componentes desde el archivo binario
				ArrayList<Object> componentes = guardar.recuperarObjetos(guardar.getComponente());

				// Verificar si la lista de componentes es nula y, si es así, crear una nueva
				// lista
				if (componentes == null) {
					componentes = new ArrayList<>();
				}

				// Agregar el nuevo Disco a la lista de componentes
				componentes.add(nuevoMicro);

				// Guardar la lista actualizada de componentes en el archivo binario
				guardar.guardarObjetos(componentes, guardar.getComponente());

				// Actualizar la tabla de Discos Duros para reflejar los cambios
				refrescarTablaMicro(componentes);

			}

			private void refrescarTablaMicro(ArrayList<Object> componentes) {
				DefaultTableModel modelMicro = (DefaultTableModel) tableMicro.getModel();
				modelMicro.setRowCount(0); // Limpiar la tabla antes de agregar los componentes nuevamente

				// Verificar si la lista de componentes no es nula
				if (componentes != null) {
					// Agregar todos los Discos Duros al modelo de la tabla
					for (Object obj : componentes) {
						if (obj instanceof Micro) {
							Micro micro = (Micro) obj;
							modelMicro.addRow(new Object[] { micro.getNumeroSerie(), micro.getPrecio(),
									micro.getCantidadDispo(), micro.getMarca(), micro.getModelo(),
									micro.getVelocidadProc(), micro.getTipoConexion() });
						}
					}
				}

			}
		});
		btnMicroGuardar.setForeground(Color.WHITE);
		btnMicroGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMicroGuardar.setBackground(new Color(0, 128, 255));
		btnMicroGuardar.setBounds(256, 197, 96, 29);
		panel_14.add(btnMicroGuardar);

		JLabel lblNewLabel_1_3_8 = new JLabel("Modelo");
		lblNewLabel_1_3_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3_8.setBounds(78, 154, 56, 14);
		panel_14.add(lblNewLabel_1_3_8);

		txtMicroModelo = new JTextField();
		txtMicroModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMicroModelo.setColumns(10);
		txtMicroModelo.setBounds(128, 151, 130, 20);
		panel_14.add(txtMicroModelo);

		JScrollPane scrollPane_1_3 = new JScrollPane();
		scrollPane_1_3.setBounds(10, 261, 630, 241);
		panel_14.add(scrollPane_1_3);

		tableMicro = new JTable();

		DefaultTableModel modelMicro = new DefaultTableModel();
		modelMicro.addColumn("ID");
		modelMicro.addColumn("Precio");
		modelMicro.addColumn("Cantidad");
		modelMicro.addColumn("Marca");
		modelMicro.addColumn("Modelo");
		modelMicro.addColumn("Velocidad");
		modelMicro.addColumn("Tipo de conexión");

		// Obtener la instancia de Guardar
		Guardar guardar11 = Guardar.getInstance();

		// Obtener la lista de todos los componentes del archivo binario
		ArrayList<Object> componentes11 = guardar11.recuperarObjetos(guardar11.getComponente());

		// Crear la tabla para los discos duros con el modelo de datos
		tableMicro = new JTable(modelMicro);

		tableMicro.setModel(modelMicro);

		// Verificar si la lista de componentes no es nula
		if (componentes11 != null) {
			// Recorrer la lista de componentes y agregar los discos duros al modelo de la
			// tabla
			for (Object obj : componentes11) {
				if (obj instanceof Micro) {
					Micro micro = (Micro) obj;
					modelMicro.addRow(new Object[] { micro.getNumeroSerie(), micro.getPrecio(),
							micro.getCantidadDispo(), micro.getMarca(), micro.getModelo(), micro.getVelocidadProc(),
							micro.getTipoConexion() });
				}
			}
		}

		// Asignar el modelo de datos a la tabla de discos duros
		tableMicro.setModel(modelMicro);

		scrollPane_1_3.setViewportView(tableMicro);

		JLabel lblCrearMicroprocesador = new JLabel("Crear Microprocesador");
		lblCrearMicroprocesador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblCrearMicroprocesador.setBounds(319, 11, 197, 20);
		panel_10.add(lblCrearMicroprocesador);

		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_11, null);
		panel_11.setLayout(null);

		JPanel panel_12 = new JPanel();
		panel_12.setBounds(346, 5, 1, 1);
		panel_12.setLayout(null);
		panel_12.setBorder(new LineBorder(new Color(0, 128, 192)));
		panel_12.setBackground(Color.WHITE);
		panel_11.add(panel_12);

		JLabel lblNewLabel_1_7 = new JLabel("Numero de serie");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_7.setBounds(34, 33, 107, 14);
		panel_12.add(lblNewLabel_1_7);

		JLabel lblNewLabel_1_1_5 = new JLabel("Precio");
		lblNewLabel_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_5.setBounds(34, 75, 56, 14);
		panel_12.add(lblNewLabel_1_1_5);

		JLabel lblNewLabel_1_2_5 = new JLabel("Cantidad disponible");
		lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2_5.setBounds(34, 118, 130, 14);
		panel_12.add(lblNewLabel_1_2_5);

		JLabel lblNewLabel_1_3_4 = new JLabel("Marca");
		lblNewLabel_1_3_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3_4.setBounds(263, 33, 88, 14);
		panel_12.add(lblNewLabel_1_3_4);

		JLabel lblNewLabel_1_4_3 = new JLabel("Tipo de Ram");
		lblNewLabel_1_4_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4_3.setBounds(263, 75, 88, 14);
		panel_12.add(lblNewLabel_1_4_3);

		JLabel lblNewLabel_1_5_3 = new JLabel("Tipo de conector");
		lblNewLabel_1_5_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_5_3.setBounds(263, 118, 108, 14);
		panel_12.add(lblNewLabel_1_5_3);

		textField_23 = new JTextField();
		textField_23.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_23.setColumns(10);
		textField_23.setBounds(138, 31, 76, 20);
		panel_12.add(textField_23);

		textField_24 = new JTextField();
		textField_24.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_24.setColumns(10);
		textField_24.setBounds(84, 73, 130, 20);
		panel_12.add(textField_24);

		textField_25 = new JTextField();
		textField_25.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_25.setColumns(10);
		textField_25.setBounds(167, 116, 47, 20);
		panel_12.add(textField_25);

		textField_26 = new JTextField();
		textField_26.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_26.setColumns(10);
		textField_26.setBounds(317, 30, 150, 20);
		panel_12.add(textField_26);

		textField_27 = new JTextField();
		textField_27.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_27.setColumns(10);
		textField_27.setBounds(347, 72, 120, 20);
		panel_12.add(textField_27);

		textField_28 = new JTextField();
		textField_28.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_28.setColumns(10);
		textField_28.setBounds(381, 116, 86, 20);
		panel_12.add(textField_28);

		JButton btnGuardar_2 = new JButton("Guardar");
		btnGuardar_2.setForeground(Color.WHITE);
		btnGuardar_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar_2.setBackground(new Color(0, 128, 255));
		btnGuardar_2.setBounds(193, 199, 96, 29);
		panel_12.add(btnGuardar_2);

		JLabel lblNewLabel_1_5_4 = new JLabel("Conexiones");
		lblNewLabel_1_5_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_5_4.setBounds(263, 164, 88, 14);
		panel_12.add(lblNewLabel_1_5_4);

		JLabel lblNewLabel_1_5_5 = new JLabel("Modelo");
		lblNewLabel_1_5_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_5_5.setBounds(34, 164, 65, 14);
		panel_12.add(lblNewLabel_1_5_5);

		textField_29 = new JTextField();
		textField_29.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_29.setColumns(10);
		textField_29.setBounds(93, 161, 121, 20);
		panel_12.add(textField_29);

		textField_30 = new JTextField();
		textField_30.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_30.setColumns(10);
		textField_30.setBounds(347, 161, 120, 20);
		panel_12.add(textField_30);

		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBorder(new LineBorder(new Color(0, 128, 192)));
		panel_13.setBackground(Color.WHITE);
		panel_13.setBounds(100, 38, 654, 521);
		panel_11.add(panel_13);

		JLabel lblNewLabel_1_8 = new JLabel("Numero de serie");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_8.setBounds(117, 34, 107, 14);
		panel_13.add(lblNewLabel_1_8);

		JLabel lblNewLabel_1_1_6 = new JLabel("Precio");
		lblNewLabel_1_1_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_6.setBounds(117, 76, 56, 14);
		panel_13.add(lblNewLabel_1_1_6);

		JLabel lblNewLabel_1_2_6 = new JLabel("Cantidad disponible");
		lblNewLabel_1_2_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2_6.setBounds(117, 119, 130, 14);
		panel_13.add(lblNewLabel_1_2_6);

		JLabel lblNewLabel_1_3_5 = new JLabel("Marca");
		lblNewLabel_1_3_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3_5.setBounds(346, 34, 88, 14);
		panel_13.add(lblNewLabel_1_3_5);

		JLabel lblNewLabel_1_4_4 = new JLabel("Tipo de Ram");
		lblNewLabel_1_4_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4_4.setBounds(346, 76, 88, 14);
		panel_13.add(lblNewLabel_1_4_4);

		JLabel lblNewLabel_1_5_6 = new JLabel("Tipo de conector");
		lblNewLabel_1_5_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_5_6.setBounds(346, 119, 108, 14);
		panel_13.add(lblNewLabel_1_5_6);

		txtMotherNum = new JTextField();
		txtMotherNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMotherNum.setColumns(10);
		txtMotherNum.setBounds(221, 32, 76, 20);
		panel_13.add(txtMotherNum);

		txtMotherPrecio = new JTextField();
		txtMotherPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMotherPrecio.setColumns(10);
		txtMotherPrecio.setBounds(167, 74, 130, 20);
		panel_13.add(txtMotherPrecio);

		txtMotherCant = new JTextField();
		txtMotherCant.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMotherCant.setColumns(10);
		txtMotherCant.setBounds(250, 117, 47, 20);
		panel_13.add(txtMotherCant);

		txtMotherMarca = new JTextField();
		txtMotherMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMotherMarca.setColumns(10);
		txtMotherMarca.setBounds(400, 31, 150, 20);
		panel_13.add(txtMotherMarca);

		txtMotherRam = new JTextField();
		txtMotherRam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMotherRam.setColumns(10);
		txtMotherRam.setBounds(430, 73, 120, 20);
		panel_13.add(txtMotherRam);

		txtMotherConector = new JTextField();
		txtMotherConector.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMotherConector.setColumns(10);
		txtMotherConector.setBounds(464, 117, 86, 20);
		panel_13.add(txtMotherConector);

		JButton btnMotherGuardar = new JButton("Guardar");
		btnMotherGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtMotherNum.getText();
				double precio = Double.parseDouble(txtMotherPrecio.getText());
				int cantidad = Integer.parseInt(txtMotherCant.getText());
				String marca = txtMotherMarca.getText();

				String tipoConector = txtMotherConector.getText();
				String modelo = txtMotherModelo.getText();
				String conexiones = txtMotherConexiones.getText();
				String tipoRam = txtMotherRam.getText();

				// Crear un nuevo objeto Disco con los datos ingresados por el usuario
				MotherBoard nuevoMother = new MotherBoard(id, precio, cantidad, marca, modelo, tipoConector, conexiones,
						tipoRam);

				// Obtener la instancia de Guardar
				Guardar guardar = Guardar.getInstance();

				// Obtener la lista actual de componentes desde el archivo binario
				ArrayList<Object> componentes = guardar.recuperarObjetos(guardar.getComponente());

				// Verificar si la lista de componentes es nula y, si es así, crear una nueva
				// lista
				if (componentes == null) {
					componentes = new ArrayList<>();
				}

				// Agregar el nuevo Disco a la lista de componentes
				componentes.add(nuevoMother);

				// Guardar la lista actualizada de componentes en el archivo binario
				guardar.guardarObjetos(componentes, guardar.getComponente());

				// Actualizar la tabla de Discos Duros para reflejar los cambios
				refrescarTablaMother(componentes);

			}

			private void refrescarTablaMother(ArrayList<Object> componentes) {
				DefaultTableModel modelMother = (DefaultTableModel) tableMother.getModel();
				modelMother.setRowCount(0); // Limpiar la tabla antes de agregar los componentes nuevamente

				// Verificar si la lista de componentes no es nula
				if (componentes != null) {
					// Agregar todos los Discos Duros al modelo de la tabla
					for (Object obj : componentes) {
						if (obj instanceof MotherBoard) {
							MotherBoard mother = (MotherBoard) obj;
							modelMother.addRow(new Object[] { mother.getNumeroSerie(), mother.getPrecio(),
									mother.getCantidadDispo(), mother.getMarca(), mother.getModelo(),
									mother.getTipoRam(), mother.getTipoConector(), mother.getConexiones() });
						}
					}
				}

			}
		});
		btnMotherGuardar.setForeground(Color.WHITE);
		btnMotherGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMotherGuardar.setBackground(new Color(0, 128, 255));
		btnMotherGuardar.setBounds(276, 200, 96, 29);
		panel_13.add(btnMotherGuardar);

		JLabel lblNewLabel_1_5_7 = new JLabel("Conexiones");
		lblNewLabel_1_5_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_5_7.setBounds(346, 165, 88, 14);
		panel_13.add(lblNewLabel_1_5_7);

		JLabel lblNewLabel_1_5_8 = new JLabel("Modelo");
		lblNewLabel_1_5_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_5_8.setBounds(117, 165, 65, 14);
		panel_13.add(lblNewLabel_1_5_8);

		txtMotherModelo = new JTextField();
		txtMotherModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMotherModelo.setColumns(10);
		txtMotherModelo.setBounds(176, 162, 121, 20);
		panel_13.add(txtMotherModelo);

		txtMotherConexiones = new JTextField();
		txtMotherConexiones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMotherConexiones.setColumns(10);
		txtMotherConexiones.setBounds(430, 162, 120, 20);
		panel_13.add(txtMotherConexiones);

		JScrollPane scrollPane_1_4 = new JScrollPane();
		scrollPane_1_4.setBounds(10, 269, 630, 241);
		panel_13.add(scrollPane_1_4);

		tableMother = new JTable();

		DefaultTableModel modelMother = new DefaultTableModel();
		modelMother.addColumn("ID");
		modelMother.addColumn("Precio");
		modelMother.addColumn("Cantidad");
		modelMother.addColumn("Marca");
		modelMother.addColumn("Modelo");
		modelMother.addColumn("TipoRam");
		modelMother.addColumn("Tipo de conector");
		modelMother.addColumn("Conexiones");

		// Obtener la instancia de Guardar
		Guardar guardar111 = Guardar.getInstance();

		// Obtener la lista de todos los componentes del archivo binario
		ArrayList<Object> componentes111 = guardar111.recuperarObjetos(guardar111.getComponente());

		// Crear la tabla para los discos duros con el modelo de datos
		tableMother = new JTable(modelMother);

		tableMother.setModel(modelMother);

		// Verificar si la lista de componentes no es nula
		if (componentes111 != null) {
			// Recorrer la lista de componentes y agregar los discos duros al modelo de la
			// tabla
			for (Object obj : componentes111) {
				if (obj instanceof MotherBoard) {
					MotherBoard mother = (MotherBoard) obj;
					modelMother.addRow(new Object[] { mother.getNumeroSerie(), mother.getPrecio(),
							mother.getCantidadDispo(), mother.getMarca(), mother.getModelo(), mother.getTipoRam(),
							mother.getTipoConector(), mother.getConexiones() });
				}
			}
		}

		// Asignar el modelo de datos a la tabla de discos duros
		tableMother.setModel(modelMother);

		scrollPane_1_4.setViewportView(tableMother);

		JLabel lblCrearMotherBoard = new JLabel("Crear Mother board");
		lblCrearMotherBoard.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblCrearMotherBoard.setBounds(348, 5, 172, 30);
		panel_11.add(lblCrearMotherBoard);

		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_15, null);
		panel_15.setLayout(null);

		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(255, 255, 255));
		panel_16.setBorder(new LineBorder(new Color(0, 0, 255)));
		panel_16.setBounds(51, 61, 763, 593);
		panel_15.add(panel_16);
		panel_16.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Clientes");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(58, 22, 99, 36);
		panel_16.add(lblNewLabel_7);

		JLabel lblNewLabel_7_1 = new JLabel(" Cantidad disponible");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_1.setBounds(222, 236, 129, 36);
		panel_16.add(lblNewLabel_7_1);

		JLabel lblNewLabel_7_3 = new JLabel("Precio");
		lblNewLabel_7_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_3.setBounds(48, 236, 53, 36);
		panel_16.add(lblNewLabel_7_3);

		JButton btnFacturar = new JButton("Facturar");
		btnFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idCliente = "0001";
				String idEmpleado = "0001";

				// Crear una nueva instancia de Factura sin pasar la lista de componentes
				Factura nuevaFactura = new Factura(idCliente, idEmpleado);
				ArrayList<Componente> componentesParaCombo = new ArrayList<>();

				// Variables para almacenar los valores de los componentes y del combo
				String valorDelComponente1 = "";
				String valorDelComponente2 = "";
				String valorDelComponente3 = "";
				String valorDelComponente4 = "";
				String valorDelCombo = "";
				String detalle1 = "";
				String detalle2 = "";
				String detalle3 = "";
				String clienteSeleccionado = (String) cbClientes.getSelectedItem();

				DecimalFormat df = new DecimalFormat("#.##");

				double subTotal = 0;
				double totalItbis = 0;
				double totalDescuento = 0;
				double totalDelDescuento = 0;
				double total = 0;

				for (int i = 0; i < modelFacturacion.getRowCount(); i++) {
					double subTotalFila = (double) modelFacturacion.getValueAt(i, 4);
					double itbisFila = (double) modelFacturacion.getValueAt(i, 5);
					double descuentoFila = (double) modelFacturacion.getValueAt(i, 6);

					subTotal += subTotalFila;
					totalItbis += itbisFila;
					totalDescuento += descuentoFila;
				}

				// Redondear los valores a dos decimales
				subTotal = Double.parseDouble(df.format(subTotal));
				totalItbis = Double.parseDouble(df.format(totalItbis));
				totalDescuento = Double.parseDouble(df.format(totalDescuento));
				totalDelDescuento = Double.parseDouble(df.format(subTotal - totalDescuento));
				total = Double.parseDouble(df.format(subTotal + totalItbis - totalDescuento));

				// Recorrer todas las filas de tableFacturacion
				for (int i = 0; i < tableFacturacion.getRowCount(); i++) {
					// Obtener el número de serie del componente de la fila actual
					String numeroDeSerie = (String) tableFacturacion.getValueAt(i, 0);

					// Buscar el componente correspondiente en la lista de componentes disponibles
					Componente componente = null;
					for (Object comp : componentes) {
						if (((Componente) comp).getNumeroSerie().equals(numeroDeSerie)) {
							componente = (Componente) comp;
							break;
						}
					}

					// Si se encontró el componente, agregarlo al combo o a la factura según
					// corresponda
					if (componente != null) {
						if (checkCombo.isSelected()) {
							// Si el checkBox está seleccionado, agregar el componente a la lista de
							// componentes para el combo
							componentesParaCombo.add(componente);
						} else {
							// Si el checkBox no está seleccionado, agregar el componente a la factura
							nuevaFactura.agregarComponente(componente);
						}

						// Almacenar el valor del componente en la variable correspondiente
						if (i == 0) {
							valorDelComponente1 = componente.getNumeroSerie() + ", Precio: " + componente.getPrecio();
						} else if (i == 1) {
							valorDelComponente2 = componente.getNumeroSerie() + ", Precio: " + componente.getPrecio();
						} else if (i == 2) {
							valorDelComponente3 = componente.getNumeroSerie() + ", Precio: " + componente.getPrecio();
						} else if (i == 3) {
							valorDelComponente4 = componente.getNumeroSerie() + ", Precio: " + componente.getPrecio();
						}
					} else {
						// Manejar el caso cuando no se encuentra el componente
						JOptionPane.showMessageDialog(null,
								"No se encontró el componente correspondiente en la fila " + (i + 1), "Error",
								JOptionPane.ERROR_MESSAGE);
						return; // Salir del método
					}
				}

				// Si el checkBox está seleccionado y hay componentes suficientes para formar un
				// combo
				if (checkCombo.isSelected() && componentesParaCombo.size() >= 3) {
					// Crear una nueva instancia de Combo
					Combo nuevoCombo = new Combo();

					// Agregar los primeros 3 o 4 componentes a la instancia de Combo
					for (int i = 0; i < Math.min(4, componentesParaCombo.size()); i++) {
						nuevoCombo.agregarComponete(componentesParaCombo.get(i));
					}

					// Agregar el combo a la factura
					nuevaFactura.agregarCombo(nuevoCombo);

					// Establecer los valores de los combos en la ventana de impresión
					if (nuevaFactura.getCombos().size() == 1) {

						valorDelCombo = "- ID Combo: " + nuevoCombo.getId() + ", Precio: " + totalDelDescuento;
						for (int i = 0; i < nuevoCombo.getComponentes().size(); i++) {
							Componente comp = nuevoCombo.getComponentes().get(i);
							if (i == 0) {
								detalle1 = comp.getNumeroSerie() + ", Precio: " + comp.getPrecio();
							} else if (i == 1) {
								detalle2 = comp.getNumeroSerie() + ", Precio: " + comp.getPrecio();
							} else if (i == 2) {
								detalle3 = comp.getNumeroSerie() + ", Precio: " + comp.getPrecio();
							}
						}
					}

					// Agregar los componentes adicionales como componentes individuales
					for (int i = 4; i < componentesParaCombo.size(); i++) {
						nuevaFactura.agregarComponente(componentesParaCombo.get(i));
					}
				} else {
					// Si no se cumple la condición, agregar todos los componentes como componentes
					// individuales
					for (Componente comp : componentesParaCombo) {
						nuevaFactura.agregarComponente(comp);
					}
				}

				// Guardar la factura
				Guardar guardar = Guardar.getInstance();
				ArrayList<Object> facturas = guardar.recuperarObjetos(guardar.getFactura());
				if (facturas == null) {
					facturas = new ArrayList<>();
				}
				facturas.add(nuevaFactura);
				guardar.guardarObjetos(facturas, guardar.getFactura());

				// Limpiar la tabla de facturación después de crear la factura
				modelFacturacion.setRowCount(0);

				// Mostrar mensaje de éxito
				JOptionPane.showMessageDialog(null, "Factura creada exitosamente");

				String idFactura = nuevaFactura.getIdFactura();

				// Crear la instancia de Impresion y establecer los valores de los componentes y
				// del combo
				Impresion impresion = new Impresion();
				impresion.setComponente1(valorDelComponente1);
				impresion.setComponente2(valorDelComponente2);
				impresion.setComponente3(valorDelComponente3);
				impresion.setComponente4(valorDelComponente4);
				impresion.setCombo(valorDelCombo);
				impresion.setTextoCliente(clienteSeleccionado);
				impresion.setIdFactura(idFactura);
				impresion.setSubtotal(subTotal);
				impresion.setItbis(totalItbis);
				impresion.setTotal(total);

				// Mostrar la ventana de impresión
				impresion.setVisible(true);
				impresion.setLocationRelativeTo(null);
			}
		});

		btnFacturar.setForeground(Color.WHITE);
		btnFacturar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFacturar.setBackground(new Color(0, 128, 0));
		btnFacturar.setBounds(615, 553, 96, 29);
		panel_16.add(btnFacturar);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DecimalFormat df = new DecimalFormat("#.##");

				String tipo = (String) cbTipos.getSelectedItem();
				String producto = (String) cbProductos.getSelectedItem();
				String marca = txtMarca.getText();
				double precio = Double.parseDouble(txtPrecio.getText());
				int cantidad = Integer.parseInt(txtCantidadCompra.getText());

				double subTotal = precio * cantidad;
				subTotal = Double.parseDouble(df.format(subTotal));

				double itbis = subTotal * 0.18;
				itbis = Double.parseDouble(df.format(itbis));

				double descuento = 0;

				double total = subTotal + itbis - descuento;
				total = Double.parseDouble(df.format(total));

				// Crear un nuevo objeto con los valores obtenidos
				Object[] nuevoItem = { tipo, producto, marca, cantidad, subTotal, itbis, descuento, total };

				// Agregar el nuevo ítem al modelo de datos de la tabla
				modelFacturacion.addRow(nuevoItem);

				refrescarTabla();
				calcularYActualizarTotal();
			}

			public void refrescarTabla() {

				modelFacturacion.fireTableDataChanged();

				tableFacturacion.setRowHeight(25);

				// Desplazarse a la última fila agregada
				int rowCount = modelFacturacion.getRowCount();
				if (rowCount > 0) {
					tableFacturacion.scrollRectToVisible(tableFacturacion.getCellRect(rowCount - 1, 0, true));
				}
			}

			private void calcularYActualizarTotal() {
				DecimalFormat df = new DecimalFormat("#.##");

				double subTotal = 0;
				double totalItbis = 0;
				double totalDescuento = 0;
				double total = 0;

				for (int i = 0; i < modelFacturacion.getRowCount(); i++) {
					double subTotalFila = (double) modelFacturacion.getValueAt(i, 4);
					double itbisFila = (double) modelFacturacion.getValueAt(i, 5);
					double descuentoFila = (double) modelFacturacion.getValueAt(i, 6);

					subTotal += subTotalFila;
					totalItbis += itbisFila;
					totalDescuento += descuentoFila;
				}

				// Redondear los valores a dos decimales
				subTotal = Double.parseDouble(df.format(subTotal));
				totalItbis = Double.parseDouble(df.format(totalItbis));
				totalDescuento = Double.parseDouble(df.format(totalDescuento));
				total = subTotal + totalItbis - totalDescuento;

				// Actualizar los JLabels con los nuevos valores
				lblSubTotal.setText("$" + subTotal);
				lblTotalItbis.setText("$" + totalItbis);
				lblTotalDescuento.setText("$" + totalDescuento);
				lblTotal.setText("" + total);
			}
		});

		checkCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// Verificar si el checkbox está seleccionado
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// Obtener el número de filas en la tabla
					int rowCount = modelFacturacion.getRowCount();
					// Verificar si hay al menos tres filas
					if (rowCount >= 3 && rowCount <= 4 || rowCount >= 7 && rowCount <= 8) {
						// Calcular el nuevo descuento del 5%
						double nuevoDescuento = 0.05; // 5%
						// Actualizar el descuento en el modelo de datos
						for (int i = 0; i < rowCount; i++) {
							// Obtener el valor actual del descuento en la fila i
							double descuentoActual = (double) modelFacturacion.getValueAt(i, 6);
							// Calcular el nuevo descuento aplicando el 5% si no había otro descuento
							// aplicado previamente
							if (descuentoActual == 0) {
								DecimalFormat df = new DecimalFormat("#.##");
								double subTotalActual = (double) modelFacturacion.getValueAt(i, 4);

								double nuevoDescuentoTotal = subTotalActual * nuevoDescuento;

								nuevoDescuentoTotal = Double.parseDouble(df.format(nuevoDescuentoTotal));

								modelFacturacion.setValueAt(nuevoDescuentoTotal, i, 6);

								double itbisActual = (double) modelFacturacion.getValueAt(i, 5);
								double nuevoTotal = subTotalActual + itbisActual - nuevoDescuentoTotal;

								nuevoTotal = Double.parseDouble(df.format(nuevoTotal));

								modelFacturacion.setValueAt(nuevoTotal, i, 7);

								calcularYActualizarTotal();
							}
						}
						// Notificar a los oyentes que los datos de la tabla han cambiado
						modelFacturacion.fireTableDataChanged();

					}
				}
			}

			private void calcularYActualizarTotal() {

				DecimalFormat df = new DecimalFormat("#.##");

				double subTotal = 0;
				double totalItbis = 0;
				double totalDescuento = 0;
				double total = 0;

				for (int i = 0; i < modelFacturacion.getRowCount(); i++) {
					double subTotalFila = (double) modelFacturacion.getValueAt(i, 4);
					double itbisFila = (double) modelFacturacion.getValueAt(i, 5);
					double descuentoFila = (double) modelFacturacion.getValueAt(i, 6);

					subTotal += subTotalFila;
					totalItbis += itbisFila;
					totalDescuento += descuentoFila;
				}

				// Redondear los valores a dos decimales
				subTotal = Double.parseDouble(df.format(subTotal));
				totalItbis = Double.parseDouble(df.format(totalItbis));
				totalDescuento = Double.parseDouble(df.format(totalDescuento));
				total = subTotal + totalItbis - totalDescuento;

				// Actualizar los JLabels con los nuevos valores
				lblSubTotal.setText("$" + subTotal);
				lblTotalItbis.setText("$" + totalItbis);
				lblTotalDescuento.setText("$" + totalDescuento);
				lblTotal.setText("$" + total);
			}

		});
		checkCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// Verificar si el checkbox está desactivado
				if (e.getStateChange() == ItemEvent.DESELECTED) {
					// Actualizar el descuento y el total en la tabla
					actualizarDescuentoYTotal();
					calcularYActualizarTotal();
				} else {
					calcularYActualizarTotal();
				}
			}

			private void calcularYActualizarTotal() {

				DecimalFormat df = new DecimalFormat("#.##");

				double subTotal = 0;
				double totalItbis = 0;
				double totalDescuento = 0;
				double total = 0;

				for (int i = 0; i < modelFacturacion.getRowCount(); i++) {
					double subTotalFila = (double) modelFacturacion.getValueAt(i, 4);
					double itbisFila = (double) modelFacturacion.getValueAt(i, 5);
					double descuentoFila = (double) modelFacturacion.getValueAt(i, 6);

					subTotal += subTotalFila;
					totalItbis += itbisFila;
					totalDescuento += descuentoFila;
				}

				// Redondear los valores a dos decimales
				subTotal = Double.parseDouble(df.format(subTotal));
				totalItbis = Double.parseDouble(df.format(totalItbis));
				totalDescuento = Double.parseDouble(df.format(totalDescuento));
				total = subTotal + totalItbis - totalDescuento;

				// Actualizar los JLabels con los nuevos valores
				lblSubTotal.setText("$" + subTotal);
				lblTotalItbis.setText("$" + totalItbis);
				lblTotalDescuento.setText("$" + totalDescuento);
				lblTotal.setText("$" + total);
			}

			// Método para actualizar el descuento y el total en la tabla
			private void actualizarDescuentoYTotal() {
				DecimalFormat df = new DecimalFormat("#.##");
				for (int i = 0; i < modelFacturacion.getRowCount(); i++) {
					double subTotalActual = (double) modelFacturacion.getValueAt(i, 4);
					double itbisActual = (double) modelFacturacion.getValueAt(i, 5);

					double descuentoActual = (double) modelFacturacion.getValueAt(i, 6);
					double nuevoDescuentoTotal = 0;

					if (descuentoActual == 0 && checkCombo.isSelected()) {
						// Aplicar descuento del 5% si el checkbox está seleccionado
						nuevoDescuentoTotal = subTotalActual * 0.05;
					}

					// Redondear el nuevo descuento a dos decimales
					nuevoDescuentoTotal = Double.parseDouble(df.format(nuevoDescuentoTotal));

					// Actualizar el modelo de datos con el nuevo descuento
					modelFacturacion.setValueAt(nuevoDescuentoTotal, i, 6);

					// Calcular el nuevo total
					double nuevoTotal = subTotalActual + itbisActual - nuevoDescuentoTotal;
					// Redondear el nuevo total a dos decimales
					nuevoTotal = Double.parseDouble(df.format(nuevoTotal));
					// Actualizar el modelo de datos con el nuevo total
					modelFacturacion.setValueAt(nuevoTotal, i, 7);
				}
			}
		});

		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAgregar.setBackground(new Color(0, 128, 255));
		btnAgregar.setBounds(561, 270, 150, 29);
		panel_16.add(btnAgregar);

		panel_16.add(cbProductos);

		panel_16.add(cbTipos);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(48, 343, 663, 199);
		panel_16.add(scrollPane_2);

		tableFacturacion = new JTable();
		modelFacturacion = new DefaultTableModel();
		modelFacturacion.addColumn("Codigo");
		modelFacturacion.addColumn("Nombre");
		modelFacturacion.addColumn("Marca");
		modelFacturacion.addColumn("Cantidad");
		modelFacturacion.addColumn("Sub total");
		modelFacturacion.addColumn("ITBIS");
		modelFacturacion.addColumn("Descuento");
		modelFacturacion.addColumn("Total");

		tableFacturacion = new JTable();
		tableFacturacion.setModel(modelFacturacion);

		modelFacturacion.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				// Obtener el número de filas en la tabla
				int rowCount = modelFacturacion.getRowCount();

				// Verificar si hay al menos tres filas
				if (rowCount >= 3) {
					// Activar el checkbox
					checkCombo.setEnabled(true);
				} else {
					// Desactivar el checkbox
					checkCombo.setEnabled(false);
				}
			}
		});

		scrollPane_2.setViewportView(tableFacturacion);

		JLabel lblNewLabel_7_1_1 = new JLabel("Cantidad memoria");
		lblNewLabel_7_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_1_1.setBounds(48, 177, 124, 36);
		panel_16.add(lblNewLabel_7_1_1);

		txtCantMemoria = new JTextField();
		txtCantMemoria.setBackground(new Color(192, 192, 192));
		txtCantMemoria.setEditable(false);
		txtCantMemoria.setBounds(48, 211, 149, 25);
		panel_16.add(txtCantMemoria);
		txtCantMemoria.setColumns(10);

		txtCantidad = new JTextField();
		txtCantidad.setBackground(new Color(192, 192, 192));
		txtCantidad.setEditable(false);
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(222, 273, 149, 25);
		panel_16.add(txtCantidad);

		JLabel lblNewLabel_7_2 = new JLabel("Tipos de productos");
		lblNewLabel_7_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7_2.setBounds(535, 22, 168, 36);
		panel_16.add(lblNewLabel_7_2);

		JLabel lblNewLabel_7_1_1_1 = new JLabel("Marca");
		lblNewLabel_7_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_1_1_1.setBounds(48, 118, 53, 36);
		panel_16.add(lblNewLabel_7_1_1_1);

		JLabel lblNewLabel_7_1_1_2 = new JLabel("Tipo conexion");
		lblNewLabel_7_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_1_1_2.setBounds(222, 118, 102, 36);
		panel_16.add(lblNewLabel_7_1_1_2);

		JLabel lblNewLabel_7_1_1_3 = new JLabel("Modelo");
		lblNewLabel_7_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_1_1_3.setBounds(397, 118, 53, 36);
		panel_16.add(lblNewLabel_7_1_1_3);

		JLabel lblNewLabel_7_1_1_4 = new JLabel("Veloc procesamiento");
		lblNewLabel_7_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_1_1_4.setBounds(561, 118, 150, 36);
		panel_16.add(lblNewLabel_7_1_1_4);

		txtMarca = new JTextField();
		txtMarca.setEditable(false);
		txtMarca.setColumns(10);
		txtMarca.setBackground(Color.LIGHT_GRAY);
		txtMarca.setBounds(48, 152, 149, 25);
		panel_16.add(txtMarca);

		txtTipoCone = new JTextField();
		txtTipoCone.setEditable(false);
		txtTipoCone.setColumns(10);
		txtTipoCone.setBackground(Color.LIGHT_GRAY);
		txtTipoCone.setBounds(222, 152, 149, 25);
		panel_16.add(txtTipoCone);

		txtModelo = new JTextField();
		txtModelo.setEditable(false);
		txtModelo.setColumns(10);
		txtModelo.setBackground(Color.LIGHT_GRAY);
		txtModelo.setBounds(397, 154, 149, 25);
		panel_16.add(txtModelo);

		JLabel lblNewLabel_7_1_1_2_1 = new JLabel("Tipo memoria");
		lblNewLabel_7_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_1_1_2_1.setBounds(222, 177, 84, 36);
		panel_16.add(lblNewLabel_7_1_1_2_1);

		txtTipoMemoria = new JTextField();
		txtTipoMemoria.setEditable(false);
		txtTipoMemoria.setColumns(10);
		txtTipoMemoria.setBackground(Color.LIGHT_GRAY);
		txtTipoMemoria.setBounds(222, 211, 149, 25);
		panel_16.add(txtTipoMemoria);

		JLabel lblNewLabel_7_1_1_3_1 = new JLabel("Almacenamiento");
		lblNewLabel_7_1_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_1_1_3_1.setBounds(397, 177, 110, 36);
		panel_16.add(lblNewLabel_7_1_1_3_1);

		txtAlmacenamiento = new JTextField();
		txtAlmacenamiento.setEditable(false);
		txtAlmacenamiento.setColumns(10);
		txtAlmacenamiento.setBackground(Color.LIGHT_GRAY);
		txtAlmacenamiento.setBounds(397, 211, 149, 25);
		panel_16.add(txtAlmacenamiento);

		JLabel lblNewLabel_7_1_1_4_1 = new JLabel("Tipo Ram");
		lblNewLabel_7_1_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_1_1_4_1.setBounds(561, 177, 112, 36);
		panel_16.add(lblNewLabel_7_1_1_4_1);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(655, 152, 5, 22);
		panel_16.add(textArea);

		txtTipoRam = new JTextField();
		txtTipoRam.setEditable(false);
		txtTipoRam.setColumns(10);
		txtTipoRam.setBackground(Color.LIGHT_GRAY);
		txtTipoRam.setBounds(562, 211, 149, 25);
		panel_16.add(txtTipoRam);

		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBackground(Color.LIGHT_GRAY);
		txtPrecio.setBounds(48, 273, 149, 25);
		panel_16.add(txtPrecio);

		checkCombo.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkCombo.setBackground(new Color(255, 255, 255));
		checkCombo.setBounds(574, 305, 129, 23);
		panel_16.add(checkCombo);

		txtVelocidad = new JTextField();
		txtVelocidad.setEditable(false);
		txtVelocidad.setColumns(10);
		txtVelocidad.setBackground(Color.LIGHT_GRAY);
		txtVelocidad.setBounds(561, 154, 149, 25);
		panel_16.add(txtVelocidad);

		JLabel lblNewLabel_7_5 = new JLabel("Productos");
		lblNewLabel_7_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7_5.setBounds(307, 22, 99, 36);
		panel_16.add(lblNewLabel_7_5);

		cbClientes.setBounds(58, 65, 224, 29);
		panel_16.add(cbClientes);

		JLabel lblNewLabel_7_1_2 = new JLabel("Cantidad");
		lblNewLabel_7_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_1_2.setBounds(397, 236, 129, 36);
		panel_16.add(lblNewLabel_7_1_2);

		txtCantidadCompra = new JTextField();
		txtCantidadCompra.setText("1");
		txtCantidadCompra.setColumns(10);
		txtCantidadCompra.setBackground(new Color(255, 255, 255));
		txtCantidadCompra.setBounds(397, 273, 149, 25);
		panel_16.add(txtCantidadCompra);

		JLabel lblNewLabel_7_1_1_1_1 = new JLabel("Total de la factura:");
		lblNewLabel_7_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_1_1_1_1.setBounds(415, 549, 118, 36);
		panel_16.add(lblNewLabel_7_1_1_1_1);

		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotal.setBounds(535, 549, 65, 36);
		panel_16.add(lblTotal);

		JLabel lblNewLabel_7_1_1_1_1_1 = new JLabel("Sub Total:");
		lblNewLabel_7_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_1_1_1_1_1.setBounds(21, 549, 65, 36);
		panel_16.add(lblNewLabel_7_1_1_1_1_1);

		lblSubTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubTotal.setBounds(88, 549, 53, 36);
		panel_16.add(lblSubTotal);

		JLabel lblNewLabel_7_1_1_1_1_1_1 = new JLabel("Total ITBIS:");
		lblNewLabel_7_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_1_1_1_1_1_1.setBounds(140, 549, 74, 36);
		panel_16.add(lblNewLabel_7_1_1_1_1_1_1);

		lblTotalItbis.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalItbis.setBounds(212, 549, 45, 36);
		panel_16.add(lblTotalItbis);

		JLabel lblNewLabel_7_1_1_1_1_2 = new JLabel("Total Descuento:");
		lblNewLabel_7_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_1_1_1_1_2.setBounds(267, 549, 118, 36);
		panel_16.add(lblNewLabel_7_1_1_1_1_2);

		lblTotalDescuento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalDescuento.setBounds(372, 549, 45, 36);
		panel_16.add(lblTotalDescuento);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableFacturacion.getSelectedRow();

				// Verificar si se seleccionó una fila
				if (selectedRow != -1) {
					// Eliminar la fila seleccionada del modelo de la tabla
					modelFacturacion.removeRow(selectedRow);
					calcularYActualizarTotal();
				} else {
					// Mostrar un mensaje indicando que no se ha seleccionado ninguna fila
					JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para eliminar.",
							"Fila no seleccionada", JOptionPane.WARNING_MESSAGE);
				}
			}

			private void calcularYActualizarTotal() {
				DecimalFormat df = new DecimalFormat("#.##");

				double subTotal = 0;
				double totalItbis = 0;
				double totalDescuento = 0;
				double total = 0;

				for (int i = 0; i < modelFacturacion.getRowCount(); i++) {
					double subTotalFila = (double) modelFacturacion.getValueAt(i, 4);
					double itbisFila = (double) modelFacturacion.getValueAt(i, 5);
					double descuentoFila = (double) modelFacturacion.getValueAt(i, 6);

					subTotal += subTotalFila;
					totalItbis += itbisFila;
					totalDescuento += descuentoFila;
				}

				// Redondear los valores a dos decimales
				subTotal = Double.parseDouble(df.format(subTotal));
				totalItbis = Double.parseDouble(df.format(totalItbis));
				totalDescuento = Double.parseDouble(df.format(totalDescuento));
				total = subTotal + totalItbis - totalDescuento;

				// Actualizar los JLabels con los nuevos valores
				lblSubTotal.setText("$" + subTotal);
				lblTotalItbis.setText("$" + totalItbis);
				lblTotalDescuento.setText("$" + totalDescuento);
				lblTotal.setText("$" + total);
			}
		});
		tableFacturacion.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// Verificar si hay alguna fila seleccionada en la tabla
				boolean filaSeleccionada = tableFacturacion.getSelectedRow() != -1;

				// Habilitar o deshabilitar el botón según si hay una fila seleccionada
				btnEliminar.setEnabled(filaSeleccionada);
			}
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminar.setBackground(new Color(255, 0, 0));
		btnEliminar.setBounds(48, 309, 150, 29);
		panel_16.add(btnEliminar);

		JLabel lblNewLabel_7_4 = new JLabel("Facturacion");
		lblNewLabel_7_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7_4.setBounds(374, 22, 99, 36);
		panel_15.add(lblNewLabel_7_4);
		JButton btnTienda = new JButton("Tienda");
		btnTienda.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTienda.setForeground(new Color(255, 255, 255));
		btnTienda.setBackground(new Color(0, 0, 255));
		btnTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});

		JButton btnFacturacion = new JButton("Facturacion");
		btnFacturacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(7);
			}
		});
		btnFacturacion.setForeground(Color.WHITE);
		btnFacturacion.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFacturacion.setEnabled(true);
		btnFacturacion.setBackground(Color.BLUE);
		btnFacturacion.setBounds(0, 83, 203, 84);
		panel.add(btnFacturacion);
		btnTienda.setBounds(0, 0, 203, 84);
		panel.add(btnTienda);
		JButton btnCliente = new JButton("Crear clientes");
		btnCliente.setForeground(new Color(255, 255, 255));
		btnCliente.setBackground(new Color(0, 0, 255));
		btnCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnCliente.setBounds(0, 163, 203, 84);
		btnCliente.setEnabled(true);
		panel.add(btnCliente);

		JButton btnTrabajador = new JButton("Crear trabajador");
		btnTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnTrabajador.setForeground(Color.WHITE);
		btnTrabajador.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTrabajador.setBackground(Color.BLUE);
		btnTrabajador.setBounds(0, 246, 203, 84);
		btnTrabajador.setEnabled(Rol);
		panel.add(btnTrabajador);

		JButton btnMenu_2 = new JButton("Crear Ram");
		btnMenu_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnMenu_2.setForeground(Color.WHITE);
		btnMenu_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMenu_2.setBackground(Color.BLUE);
		btnMenu_2.setBounds(0, 328, 203, 96);
		btnMenu_2.setEnabled(Rol);

		panel.add(btnMenu_2);

		JButton btnMenu_3 = new JButton("Crear disco duro");
		btnMenu_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		btnMenu_3.setForeground(Color.WHITE);
		btnMenu_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMenu_3.setBackground(Color.BLUE);
		btnMenu_3.setBounds(0, 417, 203, 84);
		btnMenu_3.setEnabled(Rol);
		panel.add(btnMenu_3);

		JButton btnMenu_3_1 = new JButton("Crear m. procesador");
		btnMenu_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(5);
			}
		});
		btnMenu_3_1.setForeground(Color.WHITE);
		btnMenu_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMenu_3_1.setBackground(Color.BLUE);
		btnMenu_3_1.setBounds(0, 499, 203, 84);
		btnMenu_3_1.setEnabled(Rol);
		panel.add(btnMenu_3_1);

		JButton btnMenu_3_1_1 = new JButton("Crear t. madre");
		btnMenu_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(6);
			}
		});
		btnMenu_3_1_1.setForeground(Color.WHITE);
		btnMenu_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMenu_3_1_1.setBackground(Color.BLUE);
		btnMenu_3_1_1.setBounds(0, 582, 203, 84);
		btnMenu_3_1_1.setEnabled(Rol);
		panel.add(btnMenu_3_1_1);

	}

	// GLEUDY GOMEZ
	public void addPlacerHolder(JTextField textFiled) {
		Font font = textFiled.getFont();
		font = font.deriveFont(Font.ITALIC);
		textFiled.setFont(font);
		textFiled.setForeground(Color.gray);
	}

	public void removePlacerHolder(JTextField textFiled) {
		Font font = textFiled.getFont();
		font = font.deriveFont(Font.PLAIN | Font.BOLD);
		textFiled.setFont(font);
		textFiled.setForeground(Color.black);
	}

	private boolean validadOnceDigitos(JTextField txt) {
		String cedula = txt.getText().trim();
		return cedula.matches("^\\d{11}$");
	}

	// GLEUDY GOMEZ
	public void eliminarFilaTabla() {
		int fila = tableClientes.getSelectedRow();
		if (fila != -1) {
			DefaultTableModel model = (DefaultTableModel) tableClientes.getModel();
			model.removeRow(fila);

			// Obtener la instancia de Guardar
			Guardar guardar = Guardar.getInstance();

			// Obtener la lista actual de clientes desde el archivo binario
			ArrayList<Object> clientes = guardar.recuperarObjetos(guardar.getCliente());

			// Verificar si la lista de clientes no es nula
			if (clientes != null && fila < clientes.size()) {
				// Eliminar el objeto correspondiente a la fila seleccionada de la lista
				clientes.remove(fila);

				// Guardar la lista actualizada de clientes en el archivo binario
				guardar.guardarObjetos(clientes, guardar.getCliente());
			}
		}
	}

	// GLEUDY GOMEZ
	// Pasar los datos a los campos
	public void pasarDatosAFormulario(String[] rowData) {
		// Asignar los datos a los campos del formulario
		txtClienteCedula.setText(rowData[0]);
		txtClienteNombre.setText(rowData[1]);
		txtClienteTelefono.setText(rowData[2]);
		txtClienteDireccion.setText(rowData[3]);
		cbmTipocliente.setSelectedItem(rowData[4]);
	}

	// GLEUDY GOMEZ
	public void guardarDatosFilaSeleccionada(DefaultTableModel model, JTable tableClientes) {
		int selectedRowIndex = tableClientes.getSelectedRow();
		if (selectedRowIndex != -1) {
			int numColumns = model.getColumnCount();
			String[] rowData = new String[numColumns];

			for (int columnIndex = 0; columnIndex < numColumns; columnIndex++) {
				rowData[columnIndex] = model.getValueAt(selectedRowIndex, columnIndex).toString();
			}

			// Pasar los datos a los campos del formulario
			pasarDatosAFormulario(rowData);
		} else {
			// Mostrar un mensaje indicando que no se ha seleccionado ninguna fila
			JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para guardar los datos.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actualizarDatosCliente() {
		int fila = tableClientes.getSelectedRow();
		if (fila != -1) {
			DefaultTableModel model = (DefaultTableModel) tableClientes.getModel();

			// Obtener los datos de los campos del formulario
			String cedula = txtClienteCedula.getText();
			String nombre = txtClienteNombre.getText();
			String telefono = txtClienteTelefono.getText();
			String direccion = txtClienteDireccion.getText();
			String tipoCliente = cbmTipocliente.getSelectedItem().toString();

			// Actualizar los datos en la fila seleccionada de la tabla
			model.setValueAt(cedula, fila, 0);
			model.setValueAt(nombre, fila, 1);
			model.setValueAt(telefono, fila, 2);
			model.setValueAt(direccion, fila, 3);
			model.setValueAt(tipoCliente, fila, 4);

			// Obtener la instancia de Guardar
			Guardar guardar = Guardar.getInstance();

			// Obtener la lista actual de clientes desde el archivo binario
			ArrayList<Object> clientes = guardar.recuperarObjetos(guardar.getCliente());

			// Verificar si la lista de clientes no es nula
			if (clientes != null && fila < clientes.size()) {
				// Actualizar el objeto correspondiente a la fila seleccionada en la lista
				Cliente cliente = (Cliente) clientes.get(fila);
				cliente.setCedula(cedula);
				cliente.setNombre(nombre);
				cliente.setTelefono(telefono);
				cliente.setDireccion(direccion);
				cliente.setTipoCliente(tipoCliente);

				// Guardar la lista actualizada de clientes en el archivo binario
				guardar.guardarObjetos(clientes, guardar.getCliente());
			}
		}
	}

}
