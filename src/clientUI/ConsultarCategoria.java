package clientUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import apiClient.RequestService;
import models.ResponseServiceMap;


public class ConsultarCategoria extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCategoria;
	private JTextField txtUsuario;
	private JTextField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarCategoria frame = new ConsultarCategoria();
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
	public ConsultarCategoria() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingresa categoria:");
		lblNewLabel.setBounds(29, 110, 146, 14);
		contentPane.add(lblNewLabel);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(29, 135, 200, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(29, 11, 70, 14);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(29, 29, 200, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a:");
		lblPass.setBounds(29, 60, 89, 14);
		contentPane.add(lblPass);
		
		txtPass = new JTextField();
		txtPass.setBounds(29, 79, 200, 20);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(29, 186, 295, 139);
		contentPane.add(textArea);	
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RequestService categoria = new RequestService();					
				ResponseServiceMap cat = categoria.getProd(txtUsuario.getText(), txtPass.getText(), txtCategoria.getText().toLowerCase());
				
				textArea.setText("code: "+cat.code + "\n" + "message:" + cat.message + "\n" + "data:" + cat.data +"\n" + "status:" + cat.status);
			
			}
		});
		btnBuscar.setBounds(235, 134, 89, 23);
		contentPane.add(btnBuscar);
		
		
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WSClient client =  new WSClient();
				client.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setBounds(235, 336, 89, 23);
		contentPane.add(btnRegresar);
		
		
	}
}
