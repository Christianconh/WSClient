package clientUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import apiClient.RequestService;
import models.ResponseService;
import models.ResponseServiceMap;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarISBN extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtISBN;
	private JTextField txtUsuario;
	private JTextField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarISBN frame = new ConsultarISBN();
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
	public ConsultarISBN() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingresa ISBN:");
		lblNewLabel.setBounds(29, 130, 146, 14);
		contentPane.add(lblNewLabel);
		
		txtISBN = new JTextField();
		txtISBN.setBounds(29, 146, 295, 20);
		contentPane.add(txtISBN);
		txtISBN.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(29, 210, 295, 139);
		contentPane.add(textArea);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WSClient client =  new WSClient();
				client.setVisible(true);
				dispose();
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RequestService producto = new RequestService();	
				ResponseServiceMap prod = producto.getDetails(txtUsuario.getText(), txtPass.getText(), txtISBN.getText());				
				textArea.setText("code: "+prod.code + "\n" + "message:" + prod.message + "\n" + "data:" + prod.data +"\n" + "status:" + prod.status);
				
			}
		});
		btnBuscar.setBounds(139, 176, 89, 23);
		contentPane.add(btnBuscar);
		
		
		btnRegresar.setBounds(235, 360, 89, 23);
		contentPane.add(btnRegresar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RequestService productoE = new RequestService();
				ResponseService deleteProd = productoE.deleteProd(txtUsuario.getText(), txtPass.getText(), txtISBN.getText());
				
				textArea.setText("code: "+deleteProd.code + "\n" + "message:" + deleteProd.message + "\n"  + "status:" + deleteProd.status);
			}
		});
		btnEliminar.setBounds(235, 176, 89, 23);
		contentPane.add(btnEliminar);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(29, 22, 70, 14);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(29, 38, 295, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a");
		lblPass.setBounds(29, 66, 99, 14);
		contentPane.add(lblPass);
		
		txtPass = new JTextField();
		txtPass.setBounds(29, 91, 295, 20);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
	}
}
