package visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;



import java.awt.Color;

public class Impresion extends JFrame implements Printable {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel panel;
    private String componente1;
    private String componente2;
    private String componente3;
    private String componente4;
    private String itbis;
    private String subtotal;
    private String idFactura;
    private String total;
    private String detalle1;
    
    private JLabel lblCombos;
    private JLabel lblDetalle1;
    
    private JLabel lblComponentes_1;
    private JLabel lblComponentes_2;
    private JLabel lblComponentes_3;
    private JLabel lblComponentes_4;
    private JLabel lblCliente;
    private JLabel lblIdFactura;
    private JLabel lblSubTotal;
    private JLabel lblItbis;
    private JLabel lblTotal;
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Impresion frame = new Impresion();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Impresion() {
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 440, 690);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        LocalDate fechaActual = LocalDate.now();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnImprimir = new JButton("Imprimir");
        btnImprimir.setForeground(new Color(255, 255, 255));
        btnImprimir.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnImprimir.setBackground(new Color(0, 0, 255));
        btnImprimir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setPrintable(Impresion.this); // Cambiado para referenciar al objeto actual
                if (job.printDialog()) {
                    try {
                        job.print();
                    } catch (PrinterException ex) {
                        ex.printStackTrace();
                    }
                }
                
            }
        
        });
        
        btnImprimir.setBounds(293, 609, 121, 31);
        contentPane.add(btnImprimir);
        
        panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBounds(10, 11, 404, 587);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("PC Componentes");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(10, 11, 138, 14);
        panel.add(lblNewLabel);
        
        JLabel lblFactura = new JLabel("Factura");
        lblFactura.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblFactura.setBounds(164, 36, 69, 14);
        panel.add(lblFactura);
        
        lblIdFactura = new JLabel("ID Factura:");
        lblIdFactura.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblIdFactura.setBounds(37, 100, 287, 20);
        panel.add(lblIdFactura);
        
        lblCliente = new JLabel("Cliente:");
        lblCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblCliente.setBounds(37, 137, 224, 27);
        panel.add(lblCliente);
        
        JLabel lblFecha = new JLabel("Fecha: " + fechaActual);
        lblFecha.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblFecha.setBounds(37, 187, 165, 14);
        panel.add(lblFecha);
        
        lblSubTotal = new JLabel("Sub Total:");
        lblSubTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblSubTotal.setBounds(37, 460, 287, 20);
        panel.add(lblSubTotal);
        
        lblItbis = new JLabel("ITBIS:");
        lblItbis.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblItbis.setBounds(37, 503, 287, 20);
        panel.add(lblItbis);
        
        lblTotal = new JLabel("Total:");
        lblTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTotal.setBounds(37, 542, 287, 20);
        panel.add(lblTotal);
        
        JLabel lblComponentes = new JLabel("Componentes:");
        lblComponentes.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblComponentes.setBounds(37, 223, 117, 27);
        panel.add(lblComponentes);
        
        lblComponentes_1 = new JLabel("Componentes:");
        lblComponentes_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblComponentes_1.setBounds(37, 261, 258, 27);
        panel.add(lblComponentes_1);
        
        lblComponentes_2 = new JLabel("Componentes:");
        lblComponentes_2.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblComponentes_2.setBounds(37, 292, 258, 27);
        panel.add(lblComponentes_2);
        
        lblComponentes_3 = new JLabel("Componentes:");
        lblComponentes_3.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblComponentes_3.setBounds(37, 323, 258, 27);
        panel.add(lblComponentes_3);
        
        lblCombos = new JLabel("Combos:");
        lblCombos.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblCombos.setBounds(37, 385, 357, 20);
        panel.add(lblCombos);
        
        lblDetalle1 = new JLabel("Combos:");
        lblDetalle1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblDetalle1.setBounds(37, 416, 357, 27);
        panel.add(lblDetalle1);
        
        lblComponentes_4 = new JLabel("Componentes:");
        lblComponentes_4.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblComponentes_4.setBounds(37, 354, 258, 27);
        panel.add(lblComponentes_4);
    }
    public void setComponente1(String componente1) {
        this.componente1 = componente1;
    }

    public void setComponente2(String componente2) {
        this.componente2 = componente2;
    }

    public void setComponente3(String componente3) {
        this.componente3 = componente3;
    }
    public void setComponente4(String componente4) {
        this.componente4 = componente4;
    }
    public void setCombo(String detalle1) {
    	
    	this.detalle1 =detalle1;
    }
    public void setTextoCliente(String texto) {
        lblCliente.setText("Cliente: " + texto);
    }
    public void setIdFactura(String id) {
        this.idFactura = id;
    }

    // Método para establecer el subtotal en el JLabel correspondiente
    public void setSubtotal(double subtotal) {
        this.subtotal = (String.valueOf(subtotal));
    }

    // Método para establecer el ITBIS en el JLabel correspondiente
    public void setItbis(double itbis) {
        this.itbis = (String.valueOf(itbis));
    }

    // Método para establecer el total en el JLabel correspondiente
    public void setTotal(double total) {
        this.total =(String.valueOf(total));
    }

    
   
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex == 0) {
        	lblComponentes_1.setText(componente1);
            lblComponentes_2.setText(componente2);
            lblComponentes_3.setText(componente3);
            lblComponentes_4.setText(componente4);
            lblDetalle1.setText(detalle1);
            lblIdFactura.setText("ID Factura: " + idFactura);
            lblSubTotal.setText("Subtotal: " + subtotal);
            lblItbis.setText("ITBIS: " + itbis);
            lblTotal.setText("Total: " + total);
            
            Graphics2D graphics2d = (Graphics2D) graphics;
            graphics2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

            // Obtener las dimensiones del panel
            Dimension panelSize = panel.getSize();

            // Ajustar el tamaño del área imprimible a las dimensiones del panel
            double scaleX = pageFormat.getImageableWidth() / panelSize.width;
            double scaleY = pageFormat.getImageableHeight() / panelSize.height;
            graphics2d.scale(scaleX, scaleY);

            // Imprimir el panel
            panel.print(graphics2d);

            return Printable.PAGE_EXISTS;
        } else {
            return Printable.NO_SUCH_PAGE;
        }
    }
}