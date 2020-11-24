package clientUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import apiClient.RequestService;
import models.ResponseServiceMap;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;


import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ActualizarPass extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtPass;
	private JTextField txtNewPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActualizarPass frame = new ActualizarPass();
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
	public ActualizarPass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(20, 20, 68, 14);
		contentPane.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(124, 17, 200, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(20, 55, 94, 14);
		contentPane.add(lblNewLabel_1);
		
		txtPass = new JTextField();
		txtPass.setBounds(124, 52, 200, 20);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nueva Contrase\u00F1a:");
		lblNewLabel_2.setBounds(20, 91, 101, 14);
		contentPane.add(lblNewLabel_2);
		
		txtNewPass = new JTextField();
		txtNewPass.setBounds(124, 88, 200, 20);
		contentPane.add(txtNewPass);
		txtNewPass.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(20, 116, 200, 66);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RequestService password = new RequestService();
				ResponseServiceMap pass = password.updatePass(txtUsuario.getText(), txtPass.getText(), txtNewPass.getText());
				textArea.setText("code: "+pass.code + "\n" + "message:" + pass.message + "\n" + "data:" + pass.data +"\n" + "status:" + pass.status);
				
			}
		});
		btnNewButton.setBounds(230, 159, 94, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Regresar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WSClient client =  new WSClient();
				client.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(230, 193, 94, 23);
		contentPane.add(btnNewButton_1);
	}
}
