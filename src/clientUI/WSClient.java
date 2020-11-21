package clientUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;



public class WSClient extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WSClient frame = new WSClient();
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
	public WSClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConsultarCategoria = new JButton("Consultar \r\nCategoria");
		btnConsultarCategoria.setBackground(new Color(30, 144, 255));
		btnConsultarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultarCategoria categoria = new ConsultarCategoria();
				categoria.setVisible(true);
				dispose();
			}

			
		});
		
		btnConsultarCategoria.setBounds(100, 33, 133, 40);
		contentPane.add(btnConsultarCategoria);
		
		JButton btnConsultarProducto = new JButton("Consultar Producto");
		btnConsultarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarISBN producto = new ConsultarISBN();
				producto.setVisible(true);
				dispose();
			}
		});
		btnConsultarProducto.setBackground(new Color(30, 144, 255));
		btnConsultarProducto.setForeground(new Color(0, 0, 0));
		btnConsultarProducto.setBounds(100, 100, 133, 40);
		contentPane.add(btnConsultarProducto);
		
		JButton btnRegistrarPRoducto = new JButton("Registrar Producto");
		btnRegistrarPRoducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto product = new Producto();
				product.setVisible(true);
				dispose();
			}
		});
		btnRegistrarPRoducto.setBackground(new Color(30, 144, 255));
		btnRegistrarPRoducto.setBounds(100, 162, 133, 40);
		contentPane.add(btnRegistrarPRoducto);
		
		JButton btnNewButton = new JButton("Actualizar Producto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto product = new Producto();
				product.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setBounds(100, 228, 133, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Actualizar Pass");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.setBounds(100, 292, 133, 40);
		contentPane.add(btnNewButton_1);
	}
}
