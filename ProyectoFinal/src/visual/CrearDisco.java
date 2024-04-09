package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollBar;

public class CrearDisco extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNumeroSerie;
	private JTextField txtPrecio;
	private JTextField txtCantDispo;
	private JTextField txtMarca;
	private JTextField txtAlmacenamiento;
	private JTextField txtTipoConexion;
	private JTextField txtModelo;
	private JTable tblProductos;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearDisco dialog = new CrearDisco();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearDisco() {
		setBounds(100, 100, 600, 622);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new LineBorder(new Color(0, 128, 192)));
			panel.setBackground(Color.WHITE);
			panel.setBounds(33, 30, 498, 255);
			contentPanel.add(panel);
			{
				JLabel lblNewLabel_1 = new JLabel("Numero de serie");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1.setBounds(34, 33, 107, 14);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1_1 = new JLabel("Precio");
				lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1_1.setBounds(34, 75, 56, 14);
				panel.add(lblNewLabel_1_1);
			}
			{
				JLabel lblNewLabel_1_2 = new JLabel("Cantidad disponible");
				lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1_2.setBounds(34, 118, 130, 14);
				panel.add(lblNewLabel_1_2);
			}
			{
				JLabel lblNewLabel_1_3 = new JLabel("Marca");
				lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1_3.setBounds(263, 33, 56, 14);
				panel.add(lblNewLabel_1_3);
			}
			{
				JLabel lblNewLabel_1_4 = new JLabel("Almacenamiento");
				lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1_4.setBounds(263, 75, 107, 14);
				panel.add(lblNewLabel_1_4);
			}
			{
				JLabel lblNewLabel_1_5 = new JLabel("Tipo de conexion");
				lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1_5.setBounds(263, 118, 108, 14);
				panel.add(lblNewLabel_1_5);
			}
			{
				txtNumeroSerie = new JTextField();
				txtNumeroSerie.setFont(new Font("Tahoma", Font.PLAIN, 12));
				txtNumeroSerie.setColumns(10);
				txtNumeroSerie.setBounds(138, 31, 76, 20);
				panel.add(txtNumeroSerie);
			}
			{
				txtPrecio = new JTextField();
				txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
				txtPrecio.setColumns(10);
				txtPrecio.setBounds(84, 73, 130, 20);
				panel.add(txtPrecio);
			}
			{
				txtCantDispo = new JTextField();
				txtCantDispo.setFont(new Font("Tahoma", Font.PLAIN, 12));
				txtCantDispo.setColumns(10);
				txtCantDispo.setBounds(167, 116, 47, 20);
				panel.add(txtCantDispo);
			}
			{
				txtMarca = new JTextField();
				txtMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
				txtMarca.setColumns(10);
				txtMarca.setBounds(317, 30, 138, 20);
				panel.add(txtMarca);
			}
			{
				txtAlmacenamiento = new JTextField();
				txtAlmacenamiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
				txtAlmacenamiento.setColumns(10);
				txtAlmacenamiento.setBounds(369, 72, 86, 20);
				panel.add(txtAlmacenamiento);
			}
			{
				txtTipoConexion = new JTextField();
				txtTipoConexion.setFont(new Font("Tahoma", Font.PLAIN, 12));
				txtTipoConexion.setColumns(10);
				txtTipoConexion.setBounds(381, 116, 74, 20);
				panel.add(txtTipoConexion);
			}
			{
				JButton btnGuardar = new JButton("Guardar");
				btnGuardar.setForeground(Color.WHITE);
				btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnGuardar.setBackground(new Color(0, 128, 255));
				btnGuardar.setBounds(209, 196, 96, 29);
				panel.add(btnGuardar);
			}
			
			JLabel lblNewLabel_1_1 = new JLabel("Modelo");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1_1.setBounds(34, 158, 56, 14);
			panel.add(lblNewLabel_1_1);
			
			txtModelo = new JTextField();
			txtModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtModelo.setColumns(10);
			txtModelo.setBounds(84, 156, 130, 20);
			panel.add(txtModelo);
		}
		
		JLabel lblCrearDiscoDuro = new JLabel("Crear Disco Duro");
		lblCrearDiscoDuro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblCrearDiscoDuro.setBounds(206, 0, 172, 30);
		contentPanel.add(lblCrearDiscoDuro);
		
		JPanel panel = new JPanel();
		panel.setBounds(33, 302, 498, 212);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(481, 11, 17, 201);
		panel.add(scrollBar);
		
		tblProductos = new JTable();
		tblProductos.setBounds(10, 11, 465, 190);
		panel.add(tblProductos);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
