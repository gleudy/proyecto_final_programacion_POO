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
import javax.swing.JComboBox;

public class CrearCombo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearCombo dialog = new CrearCombo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearCombo() {
		setBounds(100, 100, 515, 436);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new LineBorder(new Color(0, 128, 192)));
			panel.setBackground(Color.WHITE);
			panel.setBounds(28, 45, 442, 292);
			contentPanel.add(panel);
			{
				JLabel lblNewLabel_1 = new JLabel("Memoria Ram");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1.setBounds(34, 33, 107, 14);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1_1 = new JLabel("Precio total");
				lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1_1.setBounds(34, 213, 71, 14);
				panel.add(lblNewLabel_1_1);
			}
			{
				JLabel lblNewLabel_1_2 = new JLabel("Mother Board");
				lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1_2.setBounds(34, 118, 96, 14);
				panel.add(lblNewLabel_1_2);
			}
			{
				JLabel lblNewLabel_1_3 = new JLabel("Microprocesador");
				lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1_3.setBounds(242, 33, 118, 14);
				panel.add(lblNewLabel_1_3);
			}
			{
				JLabel lblNewLabel_1_5 = new JLabel("Disco duro");
				lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1_5.setBounds(242, 118, 86, 14);
				panel.add(lblNewLabel_1_5);
			}
			{
				textField_1 = new JTextField();
				textField_1.setEditable(false);
				textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				textField_1.setColumns(10);
				textField_1.setBounds(116, 210, 86, 20);
				panel.add(textField_1);
			}
			{
				JButton btnGuardar = new JButton("Guardar");
				btnGuardar.setForeground(Color.WHITE);
				btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnGuardar.setBackground(new Color(0, 128, 255));
				btnGuardar.setBounds(173, 252, 96, 29);
				panel.add(btnGuardar);
			}
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(44, 58, 140, 22);
			panel.add(comboBox);
			
			JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setBounds(252, 58, 140, 22);
			panel.add(comboBox_1);
			
			JComboBox comboBox_2 = new JComboBox();
			comboBox_2.setBounds(44, 143, 140, 22);
			panel.add(comboBox_2);
			
			JComboBox comboBox_3 = new JComboBox();
			comboBox_3.setBounds(252, 143, 140, 22);
			panel.add(comboBox_3);
		}
		{
			JLabel lblEligeTusComponentes = new JLabel("Elige tus componentes ");
			lblEligeTusComponentes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			lblEligeTusComponentes.setBounds(153, 11, 188, 30);
			contentPanel.add(lblEligeTusComponentes);
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
