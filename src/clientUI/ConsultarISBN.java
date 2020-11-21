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

public class ConsultarISBN extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtISBN;

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
		lblNewLabel.setBounds(29, 21, 146, 14);
		contentPane.add(lblNewLabel);
		
		txtISBN = new JTextField();
		txtISBN.setBounds(29, 43, 295, 20);
		contentPane.add(txtISBN);
		txtISBN.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(140, 68, 89, 23);
		contentPane.add(btnBuscar);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(29, 102, 295, 139);
		contentPane.add(textArea);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WSClient client =  new WSClient();
				client.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setBounds(235, 298, 89, 23);
		contentPane.add(btnRegresar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(239, 68, 89, 23);
		contentPane.add(btnEliminar);
	}
}
