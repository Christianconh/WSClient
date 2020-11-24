package clientUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import apiClient.RequestService;
import models.Product;
import models.ResponseServiceMap;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

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
	private JTextField txtUsuario;
	private JTextField txtPass;

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
		setBounds(100, 100, 349, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblISBN = new JLabel("ISBN:");
		lblISBN.setBounds(32, 118, 46, 14);
		contentPane.add(lblISBN);
		
		txtISBN = new JTextField();
		txtISBN.setBounds(32, 138, 270, 20);
		contentPane.add(txtISBN);
		txtISBN.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(32, 169, 74, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(32, 183, 270, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(32, 218, 46, 14);
		contentPane.add(lblAutor);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(32, 234, 270, 20);
		contentPane.add(txtAutor);
		txtAutor.setColumns(10);
		
		JLabel lblAnio = new JLabel("A\u00F1o:");
		lblAnio.setBounds(32, 265, 46, 14);
		contentPane.add(lblAnio);
		
		txtAnio = new JTextField();
		txtAnio.setBounds(32, 281, 270, 20);
		contentPane.add(txtAnio);
		txtAnio.setColumns(10);
		
		JLabel lblEditorial = new JLabel("Editorial:");
		lblEditorial.setBounds(32, 312, 61, 14);
		contentPane.add(lblEditorial);
		
		txtEditorial = new JTextField();
		txtEditorial.setBounds(32, 329, 270, 20);
		contentPane.add(txtEditorial);
		txtEditorial.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(32, 360, 46, 14);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(32, 375, 270, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(32, 23, 74, 14);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(32, 41, 270, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a: ");
		lblPass.setBounds(32, 72, 89, 14);
		contentPane.add(lblPass);
		
		txtPass = new JTextField();
		txtPass.setBounds(32, 87, 270, 20);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(32, 430, 270, 90);
		contentPane.add(textArea);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RequestService producto = new RequestService();
				Product newProd = new Product();
				newProd.ISBN = txtISBN.getText();
				newProd.Año = txtAnio.getText();
				newProd.Autor = txtAutor.getText();
				newProd.Editorial = txtEditorial.getText();
				newProd.Nombre = txtNombre.getText();
				newProd.Precio = txtPrecio.getText();
				ResponseServiceMap prod = producto.setProd(txtUsuario.getText(), txtPass.getText(), txtISBN.getText(), newProd);
				
				textArea.setText("code: "+prod.code + "\n" + "message:" + prod.message + "\n" + "data:" + prod.data +"\n" + "status:" + prod.status);
			}
		});
		btnRegistrar.setBounds(85, 406, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RequestService prodActu = new RequestService();
				Product prodUpdated = new Product();
				prodUpdated.ISBN = txtISBN.getText();
				prodUpdated.Año = txtAnio.getText();
				prodUpdated.Autor = txtAutor.getText();
				prodUpdated.Editorial = txtEditorial.getText();
				prodUpdated.Nombre = txtNombre.getText();
				prodUpdated.Precio = txtPrecio.getText();
				
				ResponseServiceMap prodActualizado = prodActu.updateProd(txtUsuario.getText(), txtPass.getText(), prodUpdated);
				
				textArea.setText("code: "+prodActualizado.code + "\n" + "message:" + prodActualizado.message + "\n" + "data:" + prodActualizado.data +"\n" + "status:" + prodActualizado.status);
			}
		});
		btnActualizar.setBounds(194, 406, 107, 23);
		contentPane.add(btnActualizar);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WSClient client = new WSClient();
				client.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setBounds(213, 521, 89, 23);
		contentPane.add(btnRegresar);		
		
	}
}
