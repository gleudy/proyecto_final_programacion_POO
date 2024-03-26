package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

public class CrearMicro extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNumeroSerie;
	private JTextField txtPrecio;
	private JTextField txtCantDispo;
	private JTextField txtMarca;
	private JTextField txtTipoConexion;
	private JTextField txtVelocidad;
	private JTextField txtModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearMicro dialog = new CrearMicro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearMicro() {
		setBounds(100, 100, 606, 371);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCrearMicroprocesador = new JLabel("Crear Microprocesador");
			lblCrearMicroprocesador.setBounds(193, 11, 197, 20);
			lblCrearMicroprocesador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			contentPanel.add(lblCrearMicroprocesador);
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new LineBorder(new Color(0, 128, 192)));
			panel.setBackground(Color.WHITE);
			panel.setBounds(29, 42, 538, 249);
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
				lblNewLabel_1_3.setBounds(263, 33, 88, 14);
				panel.add(lblNewLabel_1_3);
			}
			{
				JLabel lblNewLabel_1_4 = new JLabel("Tipo de conexion");
				lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1_4.setBounds(263, 75, 130, 14);
				panel.add(lblNewLabel_1_4);
			}
			{
				JLabel lblNewLabel_1_5 = new JLabel("Velocidad de procesamiento");
				lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1_5.setBounds(263, 118, 171, 14);
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
				txtMarca.setBounds(317, 30, 183, 20);
				panel.add(txtMarca);
			}
			{
				txtTipoConexion = new JTextField();
				txtTipoConexion.setFont(new Font("Tahoma", Font.PLAIN, 12));
				txtTipoConexion.setColumns(10);
				txtTipoConexion.setBounds(383, 72, 117, 20);
				panel.add(txtTipoConexion);
			}
			{
				txtVelocidad = new JTextField();
				txtVelocidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
				txtVelocidad.setColumns(10);
				txtVelocidad.setBounds(444, 115, 56, 20);
				panel.add(txtVelocidad);
			}
			{
				JButton btnGuardar = new JButton("Guardar");
				btnGuardar.setForeground(Color.WHITE);
				btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnGuardar.setBackground(new Color(0, 128, 255));
				btnGuardar.setBounds(212, 197, 96, 29);
				panel.add(btnGuardar);
			}
			{
				JLabel lblNewLabel_1_3 = new JLabel("Modelo");
				lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1_3.setBounds(34, 154, 56, 14);
				panel.add(lblNewLabel_1_3);
			}
			
			txtModelo = new JTextField();
			txtModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtModelo.setColumns(10);
			txtModelo.setBounds(84, 151, 130, 20);
			panel.add(txtModelo);
		}
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
