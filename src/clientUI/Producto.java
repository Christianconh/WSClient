package clientUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Producto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtISBN;
	private JTextField txtNombre;
	private JTextField txtAutor;
	private JTextField txtAnio;
	private JTextField txtEditorial;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Producto frame = new Producto();
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
	public Producto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblISBN = new JLabel("ISBN:");
		lblISBN.setBounds(20, 20, 46, 14);
		contentPane.add(lblISBN);
		
		txtISBN = new JTextField();
		txtISBN.setBounds(20, 40, 270, 20);
		contentPane.add(txtISBN);
		txtISBN.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 71, 46, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(20, 85, 270, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(20, 120, 46, 14);
		contentPane.add(lblAutor);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(20, 136, 270, 20);
		contentPane.add(txtAutor);
		txtAutor.setColumns(10);
		
		JLabel lblAnio = new JLabel("A\u00F1o:");
		lblAnio.setBounds(20, 167, 46, 14);
		contentPane.add(lblAnio);
		
		txtAnio = new JTextField();
		txtAnio.setBounds(20, 183, 270, 20);
		contentPane.add(txtAnio);
		txtAnio.setColumns(10);
		
		JLabel lblEditorial = new JLabel("Editorial:");
		lblEditorial.setBounds(20, 214, 61, 14);
		contentPane.add(lblEditorial);
		
		txtEditorial = new JTextField();
		txtEditorial.setBounds(20, 231, 270, 20);
		contentPane.add(txtEditorial);
		txtEditorial.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(20, 262, 46, 14);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(20, 277, 270, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(72, 329, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(183, 329, 107, 23);
		contentPane.add(btnActualizar);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WSClient client = new WSClient();
				client.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setBounds(201, 377, 89, 23);
		contentPane.add(btnRegresar);
	}

}
