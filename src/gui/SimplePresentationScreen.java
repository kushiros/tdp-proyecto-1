package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;


@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField textField;
	private JTextField textField_apellido;
	private JTextField textField_nombre;
	private JTextField textField_Mail;
	private JTextField textField_URL;

	public SimplePresentationScreen(Student studentData) {
		
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 268));
		setResizable(false);
		setContentPane(contentPane);
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setForeground(Color.RED);
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Informacion del alumno", null, tabInformation, "Muestra la informacion declarada por el alumno");
		tabInformation.setLayout(null);
		
		JLabel LU = new JLabel("LU");
		LU.setFont(new Font("Arial", Font.PLAIN, 11));
		LU.setBounds(8, 10, 45, 13);
		tabInformation.add(LU);
		
		JLabel Apellido = new JLabel("Apellido");
		Apellido.setFont(new Font("Arial", Font.PLAIN, 11));
		Apellido.setBounds(8, 45, 64, 13);
		tabInformation.add(Apellido);
		
		JLabel Nombre = new JLabel("Nombre");
		Nombre.setFont(new Font("Arial", Font.PLAIN, 11));
		Nombre.setBounds(8, 80, 45, 13);
		tabInformation.add(Nombre);
		
		JLabel mail = new JLabel("E-mail");
		mail.setFont(new Font("Arial", Font.PLAIN, 11));
		mail.setBounds(8, 115, 45, 13);
		tabInformation.add(mail);
		
		JLabel Github = new JLabel("Github URL");
		Github.setFont(new Font("Arial", Font.PLAIN, 11));
		Github.setBounds(8, 150, 79, 13);
		tabInformation.add(Github);
		
		String fecha= LocalDate.now().toString();
		String hora= LocalTime.now().toString().substring(0,8);
		
		JLabel generado = new JLabel();
		generado.setFont(new Font("Arial", Font.BOLD, 11));
		generado.setText("Esta ventana fue generada el "+fecha+" a las "+hora);
		contentPane.add(generado, BorderLayout.SOUTH);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 11));
		textField.setText(Integer.toString(studentData.getId()));
		textField.setBounds(87, 10, 328, 19);
		tabInformation.add(textField);
		textField.setColumns(10);
		
		textField_apellido = new JTextField();
		textField_apellido.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_apellido.setText(studentData.getLastName());
		textField_apellido.setColumns(10);
		textField_apellido.setBounds(87, 45, 328, 19);
		tabInformation.add(textField_apellido);
		
		textField_nombre = new JTextField();
		textField_nombre.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_nombre.setText(studentData.getFirstName());
		textField_nombre.setColumns(10);
		textField_nombre.setBounds(87, 80, 328, 19);
		tabInformation.add(textField_nombre);
		
		textField_Mail = new JTextField();
		textField_Mail.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_Mail.setText(studentData.getMail());
		textField_Mail.setColumns(10);
		textField_Mail.setBounds(87, 115, 328, 19);
		tabInformation.add(textField_Mail);
		
		textField_URL = new JTextField();
		textField_URL.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_URL.setText(studentData.getGithubURL());
		textField_URL.setColumns(10);
		textField_URL.setBounds(87, 150, 328, 19);
		tabInformation.add(textField_URL);
		
		contentPane.add(tabbedPane, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		
		JLabel lblPFoto = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto()));
        Image imagen = imageIcon.getImage(); //conseguir imagen 
        imagen = imagen.getScaledInstance(155,155,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(imagen);  //cambiar la imagen del imageIcon
        lblPFoto.setIcon(imageIcon);
		contentPane.add(lblPFoto, BorderLayout.EAST);
		
	}
}