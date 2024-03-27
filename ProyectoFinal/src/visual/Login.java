package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	private String usuario;

  

    public String getUsuario() {
        return usuario;
    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setImageLabel(JLabel labelName,String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
		labelName.setIcon(icon);
		this.repaint();
	}
	/**
	 * Create the dialog.
	 */
	public Login() {
		setTitle("Login");
		setBounds(100, 100, 751, 481);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(0, 0, 735, 442);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			{
				JLabel lblUsuario = new JLabel("Usuario");
				lblUsuario.setForeground(new Color(0, 51, 255));
				lblUsuario.setFont(new Font("Arial", Font.BOLD, 16));
				lblUsuario.setBounds(41, 187, 72, 30);
				panel.add(lblUsuario);
			}
			{
				JLabel lblContrasena = new JLabel("Contrasena");
				lblContrasena.setForeground(new Color(0, 51, 255));
				lblContrasena.setFont(new Font("Arial", Font.BOLD, 16));
				lblContrasena.setBounds(41, 257, 100, 30);
				panel.add(lblContrasena);
			}
			
			txtUsuario = new JTextField();
			txtUsuario.setBounds(41, 220, 237, 30);
			panel.add(txtUsuario);
			txtUsuario.setColumns(10);
			
			txtContrasena = new JTextField();
			txtContrasena.setColumns(10);
			txtContrasena.setBounds(41, 298, 237, 30);
			panel.add(txtContrasena);
			
			JButton btnNewButton = new JButton("Entrar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(txtUsuario.getText().equalsIgnoreCase("Admin") && txtContrasena.getText().equals("1234")) {
						usuario = txtUsuario.getText();
						
						JOptionPane.showMessageDialog(null, "Inicio de sesion completado, Bienvenido: " + txtUsuario.getText(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
						
						Menu m = new Menu();
						m.dispose();
						m.setVisible(true);
						m.setLocationRelativeTo(null);
						
						dispose();
						
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Usuario o contrasena incorrectos. ","Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton.setForeground(new Color(0, 51, 255));
			btnNewButton.setBounds(41, 349, 237, 36);
			panel.add(btnNewButton);
			
			JLabel lblImage = new JLabel("New label");
			lblImage.setBounds(61, 0, 194, 176);
			panel.add(lblImage);
			
			
			{
				JLabel lblBackground = new JLabel("New label");
				lblBackground.setBounds(319, 0, 416, 442);
				panel.add(lblBackground);
				setImageLabel(lblImage,"src/imagenes/user.png");
				setImageLabel(lblBackground,"src/imagenes/welcome.jpg");
				
				
			}
			
		}
			
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

