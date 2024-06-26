package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private String nombreUsuario = Login.usuario;
	public boolean Rol = true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		Login l = new Login();
		
		if(nombreUsuario.equalsIgnoreCase("Trabajador")) {
			Rol = false;
		}else {
			Rol = true;
		}
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 780, 628);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(35, 55, 713, 532);
		panel.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(new Color(0, 128, 255), 1, true));
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(34, 49, 196, 158);
		panel_1.add(panel_1_1);
		
		JLabel lblDisco = new JLabel("New label");
		lblDisco.setBounds(10, 11, 183, 144);
		panel_1_1.add(lblDisco);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(0, 64, 128));
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(new Color(0, 128, 255));
		panel_2.setBounds(34, 206, 196, 74);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Discos Duro");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 0, 186, 28);
		panel_2.add(lblNewLabel_1);
		
		JTextPane txtDisco = new JTextPane();
		txtDisco.setBackground(new Color(0, 128, 255));
		txtDisco.setText("Los mejores discos duros del \r\nmercado en calidad precio del pais");
		txtDisco.setBounds(10, 25, 176, 34);
		panel_2.add(txtDisco);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 128, 255), 1, true));
		panel_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1.setBounds(256, 49, 204, 158);
		panel_1.add(panel_1_1_1);
		
		JLabel lblMemoria = new JLabel("New label");
		lblMemoria.setBounds(10, 11, 184, 135);
		panel_1_1_1.add(lblMemoria);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1.setBackground(new Color(0, 128, 255));
		panel_2_1.setBounds(256, 206, 204, 74);
		panel_1.add(panel_2_1);
		
		JTextPane txtRam = new JTextPane();
		txtRam.setBackground(new Color(0, 128, 255));
		txtRam.setText("La mejor calidad en memoria \r\npara que tu equipo sea top ");
		txtRam.setBounds(10, 29, 176, 34);
		panel_2_1.add(txtRam);
		
		JLabel lblNewLabel_1_1 = new JLabel("Memoria Ram");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 0, 186, 28);
		panel_2_1.add(lblNewLabel_1_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new LineBorder(new Color(0, 128, 255), 1, true));
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setBounds(484, 49, 196, 158);
		panel_1.add(panel_1_2);
		
		JLabel lblMicro = new JLabel("New label");
		lblMicro.setBounds(10, 11, 183, 144);
		panel_1_2.add(lblMicro);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_2.setBackground(new Color(0, 128, 255));
		panel_2_2.setBounds(484, 206, 196, 74);
		panel_1.add(panel_2_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Micro Procesadores");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(10, 0, 186, 28);
		panel_2_2.add(lblNewLabel_1_2);
		
		JTextPane txtMicro = new JTextPane();
		txtMicro.setBackground(new Color(0, 128, 255));
		txtMicro.setText("Los mejores micro procesadores\r\na el mejor precio posible para tu PC");
		txtMicro.setBounds(10, 25, 176, 34);
		panel_2_2.add(txtMicro);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBorder(new LineBorder(new Color(0, 128, 255), 1, true));
		panel_1_3.setBackground(Color.WHITE);
		panel_1_3.setBounds(151, 291, 196, 158);
		panel_1.add(panel_1_3);
		
		JLabel lblTarjeta = new JLabel("New label");
		lblTarjeta.setBounds(10, 11, 183, 144);
		panel_1_3.add(lblTarjeta);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setLayout(null);
		panel_2_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_3.setBackground(new Color(0, 128, 255));
		panel_2_3.setBounds(151, 445, 196, 74);
		panel_1.add(panel_2_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mother Board");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(10, 0, 186, 28);
		panel_2_3.add(lblNewLabel_1_3);
		
		JTextPane txtTarjeta = new JTextPane();
		txtTarjeta.setBackground(new Color(0, 128, 255));
		txtTarjeta.setText("No encuentras la mother board\r\npara tu pc, aqui la tenemos");
		txtTarjeta.setBounds(10, 25, 176, 34);
		panel_2_3.add(txtTarjeta);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setLayout(null);
		panel_1_4.setBorder(new LineBorder(new Color(0, 128, 255), 1, true));
		panel_1_4.setBackground(Color.WHITE);
		panel_1_4.setBounds(371, 291, 196, 158);
		panel_1.add(panel_1_4);
		
		JLabel lblCombo = new JLabel("New label");
		lblCombo.setBounds(10, 11, 176, 144);
		panel_1_4.add(lblCombo);
		l.setImageLabel(lblCombo, "src/imagenes/pc2.jpg");
		l.setImageLabel(lblMicro, "src/imagenes/microprocesador6.jpg");
		l.setImageLabel(lblMemoria, "src/imagenes/memoriaRam.jpeg");
		l.setImageLabel(lblTarjeta, "src/imagenes/motherBoard.jpg");
		l.setImageLabel(lblDisco, "src/imagenes/Disco.jpg");
		
		JPanel panel_2_4 = new JPanel();
		panel_2_4.setLayout(null);
		panel_2_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_4.setBackground(new Color(0, 128, 255));
		panel_2_4.setBounds(371, 445, 196, 74);
		panel_1.add(panel_2_4);
		
		JLabel lblNewLabel_1_4 = new JLabel("PC combo");
		lblNewLabel_1_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(10, 0, 186, 28);
		panel_2_4.add(lblNewLabel_1_4);
		
		JTextPane txtCombo = new JTextPane();
		txtCombo.setBackground(new Color(0, 128, 255));
		txtCombo.setText("Te quieres llevar tu combo\r\ncompleto con el mejor descuento");
		txtCombo.setBounds(10, 25, 164, 38);
		panel_2_4.add(txtCombo);
		
		JLabel lblNewLabel = new JLabel("Nuestros productos");
		lblNewLabel.setBounds(272, 0, 169, 30);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.setBounds(0, 0, 788, 44);
		panel.add(menuBar);
		
		
		
		JMenu mnNewMenu = new JMenu("PC Componentes");
		mnNewMenu.setForeground(new Color(0, 0, 255));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 16));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Facturacion");
		mnNewMenu_1.setForeground(new Color(0, 0, 0));
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Venta");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturar f = new Facturar();
				f.setModal(true);
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_4 = new JMenu("Clientes");
		mnNewMenu_4.setForeground(new Color(0, 0, 0));
		mnNewMenu_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_4);
		mnNewMenu_4.setEnabled(Rol);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Crear cliente");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCliente cc = new CrearCliente();
				cc.setModal(true);
				cc.setLocationRelativeTo(null);
				cc.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("Componentes");
		mnNewMenu_2.setForeground(new Color(0, 0, 0));
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_2);
		
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Crear Microprocesador");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearMicro cmp = new CrearMicro();
				cmp.setLocationRelativeTo(null);
				cmp.setModal(true);
				cmp.setVisible(true);
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Crear  Memoria Ram");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearRam cr = new CrearRam();
				cr.setLocationRelativeTo(null);
				cr.setModal(true);
				cr.setVisible(true);
				
				
			}
		});
		
		
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Crear Disco duro");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CrearDisco cd = new CrearDisco();
				cd.setLocationRelativeTo(null);
				cd.setModal(true);
				cd.setVisible(true);
				
			}
		});
		
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Crear MotherBoard");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearMother cm = new CrearMother();
				cm.setLocationRelativeTo(null);
				cm.setModal(true);
				cm.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Crear Combo");
		mntmNewMenuItem_6.setEnabled(Rol);
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CrearCombo cc = new CrearCombo();
				cc.setLocationRelativeTo(null);
				cc.setModal(true);
				cc.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_3 = new JMenu("Historial");
		mnNewMenu_3.setForeground(new Color(0, 0, 0));
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_3);
		mnNewMenu_3.setEnabled(Rol);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		menuBar.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("Cerrar Sesion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres cerrar la sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION);
		        if (confirmacion == JOptionPane.YES_OPTION) {
		            
		            JOptionPane.showMessageDialog(null, "Sesión cerrada exitosamente.", "Cerrar Sesión", JOptionPane.INFORMATION_MESSAGE);
		            
		            dispose();
		            Login l = new Login();
		            l.setVisible(true);
		            l.setModal(true);
		            l.setLocationRelativeTo(null);
		        }
		    }
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(204, 0, 0));
		btnNewButton.setBounds(207, 11, 131, 31);
		panel_3.add(btnNewButton);
	}
}
