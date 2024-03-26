package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class CrearRam extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNumeroSerie;
	private JTextField txtPrecio;
	private JTextField txtCantDispo;
	private JTextField txtMarca;
	private JTextField txtCantMemoria;
	private JTextField txtTipoMemoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearRam dialog = new CrearRam();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearRam() {
		setBounds(100, 100, 610, 340);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBorder(new LineBorder(new Color(0, 128, 192)));
			panel.setBounds(30, 40, 528, 213);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Numero de serie");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1.setBounds(34, 33, 107, 14);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_1_1 = new JLabel("Precio");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1_1.setBounds(34, 75, 56, 14);
			panel.add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_1_2 = new JLabel("Cantidad disponible");
			lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1_2.setBounds(34, 118, 130, 14);
			panel.add(lblNewLabel_1_2);
			
			JLabel lblNewLabel_1_3 = new JLabel("Marca");
			lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1_3.setBounds(263, 33, 88, 14);
			panel.add(lblNewLabel_1_3);
			
			JLabel lblNewLabel_1_4 = new JLabel("Cantidad de memoria");
			lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1_4.setBounds(263, 75, 130, 14);
			panel.add(lblNewLabel_1_4);
			
			JLabel lblNewLabel_1_5 = new JLabel("Tipo de memoria");
			lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1_5.setBounds(263, 118, 108, 14);
			panel.add(lblNewLabel_1_5);
			
			txtNumeroSerie = new JTextField();
			txtNumeroSerie.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtNumeroSerie.setBounds(138, 31, 86, 20);
			panel.add(txtNumeroSerie);
			txtNumeroSerie.setColumns(10);
			
			txtPrecio = new JTextField();
			txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtPrecio.setColumns(10);
			txtPrecio.setBounds(84, 73, 140, 20);
			panel.add(txtPrecio);
			
			txtCantDispo = new JTextField();
			txtCantDispo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtCantDispo.setColumns(10);
			txtCantDispo.setBounds(167, 116, 57, 20);
			panel.add(txtCantDispo);
			
			txtMarca = new JTextField();
			txtMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtMarca.setColumns(10);
			txtMarca.setBounds(317, 30, 172, 20);
			panel.add(txtMarca);
			
			txtCantMemoria = new JTextField();
			txtCantMemoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtCantMemoria.setColumns(10);
			txtCantMemoria.setBounds(403, 73, 86, 20);
			panel.add(txtCantMemoria);
			
			txtTipoMemoria = new JTextField();
			txtTipoMemoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtTipoMemoria.setColumns(10);
			txtTipoMemoria.setBounds(381, 116, 108, 20);
			panel.add(txtTipoMemoria);
			
			JButton btnGuardar = new JButton("Guardar");
			btnGuardar.setForeground(new Color(255, 255, 255));
			btnGuardar.setBackground(new Color(0, 128, 255));
			btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnGuardar.setBounds(205, 161, 96, 29);
			panel.add(btnGuardar);
		}
		
		JLabel lblNewLabel = new JLabel("Crear Memoria Ram");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(204, 11, 172, 30);
		contentPanel.add(lblNewLabel);
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
