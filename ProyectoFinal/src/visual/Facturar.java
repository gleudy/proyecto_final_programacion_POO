package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;

public class Facturar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecio;
	private JTable table;
	private JTextField txtTotal;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Facturar dialog = new Facturar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("serial")
	public Facturar() {
		
		setBounds(100, 100, 689, 529);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 128, 255)));
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(31, 42, 608, 404);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JComboBox cbProductos = new JComboBox();
				cbProductos.setFont(new Font("Tahoma", Font.BOLD, 12));
				cbProductos.setBounds(52, 54, 155, 30);
				panel.add(cbProductos);
			}
			{
				JLabel lblNewLabel = new JLabel("Productos:");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNewLabel.setBounds(52, 29, 89, 14);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblPrecio = new JLabel("Precio:");
				lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblPrecio.setBounds(250, 31, 89, 14);
				panel.add(lblPrecio);
			}
			{
				txtPrecio = new JTextField();
				txtPrecio.setEditable(false);
				txtPrecio.setText("0.00");
				txtPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtPrecio.setBounds(250, 54, 104, 30);
				panel.add(txtPrecio);
				txtPrecio.setColumns(10);
			}
			
			JButton btnAgregar = new JButton("Agregar al carrito");
			btnAgregar.setBackground(new Color(0, 128, 192));
			btnAgregar.setForeground(new Color(255, 255, 255));
			btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnAgregar.setBounds(412, 50, 155, 34);
			panel.add(btnAgregar);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(52, 137, 515, 155);
				panel.add(scrollPane);
				
				table = new JTable();
				scrollPane.setViewportView(table);
				table.setFont(new Font("Tahoma", Font.BOLD, 12));
				table.addAncestorListener(new AncestorListener() {
					public void ancestorAdded(AncestorEvent event) {
					}
					public void ancestorMoved(AncestorEvent event) {
					}
					public void ancestorRemoved(AncestorEvent event) {
					}
				});
				table.setSurrendersFocusOnKeystroke(true);
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Nombre del producto", "Cantidad", "Precio unitario", "Total"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				table.getColumnModel().getColumn(0).setPreferredWidth(117);
				table.setToolTipText("");
				table.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
			
			JButton btnFacturar = new JButton("Facturar");
			btnFacturar.setForeground(new Color(255, 255, 255));
			btnFacturar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnFacturar.setBackground(new Color(0, 128, 0));
			btnFacturar.setBounds(412, 343, 155, 34);
			panel.add(btnFacturar);
			{
				JLabel lblTotalAPagar = new JLabel("Total a pagar:");
				lblTotalAPagar.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTotalAPagar.setBounds(52, 312, 104, 22);
				panel.add(lblTotalAPagar);
			}
			{
				txtTotal = new JTextField();
				txtTotal.setText("0.00");
				txtTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtTotal.setEditable(false);
				txtTotal.setColumns(10);
				txtTotal.setBounds(153, 310, 104, 30);
				panel.add(txtTotal);
			}
		}
		{
			JLabel lblFacturacion = new JLabel("Facturacion");
			lblFacturacion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			lblFacturacion.setBounds(270, 11, 160, 20);
			contentPanel.add(lblFacturacion);
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
