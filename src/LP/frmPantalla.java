package LP;


import static COMUN.clsConstantes.CMD_BTN_INICIAR_SESION;
import static COMUN.clsConstantes.CMD_BTN_REGISTRARSE;
import static COMUN.clsConstantes.CMD_BTN_INICIAR_SESION2;
import static COMUN.clsConstantes.CMD_BTN_REGISTRARSE2;
import static COMUN.clsConstantes.CMD_BTN_ATRAS;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.border.TitledBorder;

import COMUN.clsElementoRepetido;
import COMUN.clsEmailNoValido;
import COMUN.clsUsuarioNoRegistrado;
import LN.clsGestor;
import LN.clsMailNoValido;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;


public class frmPantalla extends JFrame implements ActionListener
{
	private JButton btnIniciarSesion;
	private JButton btnRegistrarse;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JPasswordField contrausutxt;
	private JTextField nomusutxt;
	private JTextField corretxt;
	private JTextField apetxt;
	private JTextField nomtxt;
	JPanel contentPane = new JPanel();
	/**
	 * Esta es la pantalla en s� misma, �nicamente ella.
	 */
	public frmPantalla()
	{
		setTitle("Buscaminas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 100, 600, 431);
		setContentPane(VentanaInicial());
	}
	
	/**
	 * Este es el m�todo que organiza los diferentes eventos que se dan en nuestra pantalla inicial.
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch (e.getActionCommand()) 
		{
		
		case CMD_BTN_ATRAS:
			setContentPane(VentanaInicial());
			contentPane.revalidate();
			break;
			
		case CMD_BTN_INICIAR_SESION :
//			http://www.chuidiang.org/index.php?title=El_hilo_de_awt
			setContentPane(IniciarSesion());
			contentPane.revalidate();
			break;
			
		case CMD_BTN_REGISTRARSE:
	
			setContentPane(Registrarse());
			contentPane.revalidate();
			break;

		case CMD_BTN_INICIAR_SESION2:
			try 
			{
				clsGestor.ComprobarUsuario(t1.getText(), t2.getText());
				clsGestor.IniciarSesion(t1.getText(), t2.getText());
				this.setVisible(false);
//				frmMenuPrincipal frame = new frmMenuPrincipal();
//				frame.setVisible(true);
				clsHilo repeticion = new clsHilo();
				repeticion.start();
			} 
			catch (clsUsuarioNoRegistrado e1)
			{
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}				
			break;
	
		case CMD_BTN_REGISTRARSE2:
			
			try {
				clsGestor.validarEmail(corretxt.getText());
			} catch (clsMailNoValido e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}
			try 
			{
				clsGestor.AltaUsuario(nomtxt.getText(), apetxt.getText(), corretxt.getText(), nomusutxt.getText(), contrausutxt.getText());
		        JOptionPane.showMessageDialog(null, "Compruebe que se ha registrado correctamente en su direcci�n de correo electr�nico. �Gracias!" );

				this.setVisible(false);
//					frmMenuPrincipal frame = new frmMenuPrincipal();
//					frame.setVisible(true);
					clsHilo repeticion = new clsHilo();
					repeticion.start();
				
			} 
			catch (clsElementoRepetido e1) 
			{
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
			 
			
			break;
			
		default: break;
			}	
	}
	
	/**
	 * Este es el content pane que se visualizar� primero en la ventana que hemos creado. 
	 * Cuando escojamos alguna de las dos opciones que se nos dan, se borrar� este panel
	 * y se visualizar� otro.
	 * @return panel a visualizar.
	 */
	public JPanel VentanaInicial()
	{
		contentPane.removeAll();
		
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel Buscaminas = new JLabel("");
		ImageIcon logo= new ImageIcon("src/imagenes/buscaminas.png");
		Buscaminas.setIcon(logo);
		Buscaminas.setBounds(140, 53, 537, 203);
		contentPane.add(Buscaminas);
		ImageIcon im= new ImageIcon("src/imagenes/bombita.jpg");
	    this.setIconImage(im.getImage());
		
		btnIniciarSesion = new JButton("Iniciar Sesi�n");
		btnIniciarSesion.setBounds(100, 267, 180, 23);
		btnIniciarSesion.setActionCommand(CMD_BTN_INICIAR_SESION);
		btnIniciarSesion.addActionListener(this);
		contentPane.add(btnIniciarSesion);
		
		
		btnRegistrarse= new JButton("Registrarse");
		btnRegistrarse.setBounds(319, 267, 180, 23);
		btnRegistrarse.setActionCommand(CMD_BTN_REGISTRARSE);
		btnRegistrarse.addActionListener(this);
		contentPane.add(btnRegistrarse);
		
		this.repaint();
		return contentPane;
	}
	/**
	 * Este es el panel que se visualizar� si escogemos la opci�n de inicio de sesi�n.
	 * Borra el panel inicial, y despu�s de haber definido este panel con todos sus elementos,
	 * ense�a el panel de inicio de sesi�n.
	 * @return panel de inicio de sesi�n.
	 */
	public JPanel IniciarSesion()
	{
		contentPane.removeAll();
		
		JLabel Buscaminas = new JLabel("");
		ImageIcon logo= new ImageIcon("src/imagenes/buscaminas.png");
		Image image = logo.getImage(); 
		Image newimg = image.getScaledInstance(180, 110,  java.awt.Image.SCALE_SMOOTH);
		logo = new ImageIcon(newimg); 
		Buscaminas.setIcon(logo);
		Buscaminas.setBounds(5, 5, 180, 150);
		contentPane.add(Buscaminas);
		
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel i1 = new JLabel("Nombre de Usuario:");
		i1.setBounds(200, 60, 150,50);
		t1 = new JTextField(15);
		t1.setBounds(320, 75,150,20);
		
		JLabel i2 = new JLabel("Direcci�n de correo electr�nico:");
		i2.setBounds(130, 130, 200, 50);
		t2 = new JTextField(15);
		t2.setBounds(320, 150,150,20);
		
		JLabel i3 = new JLabel("Contrase�a:");
		i3.setBounds(240, 200,200,50);
		t3 = new JPasswordField(15);
		t3.setBounds(320, 220,150,20);
		
		contentPane.add(i1);
		contentPane.add(t1);
		contentPane.add(i2);
		contentPane.add(t2);
		contentPane.add(i3);
		contentPane.add(t3);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesi�n");
		btnIniciarSesion.setBounds(200, 280, 180, 25);
		btnIniciarSesion.addActionListener(this);
		btnIniciarSesion.setActionCommand(CMD_BTN_INICIAR_SESION2);
		contentPane.add(btnIniciarSesion);
		
		JButton btnAtras = new JButton("Volver");
		btnAtras.setBounds(394, 359, 180, 23);
		btnAtras.addActionListener(this);
		btnAtras.setActionCommand(CMD_BTN_ATRAS);
		contentPane.add(btnAtras);
		
		this.repaint();
		return contentPane;
	}
	
	/**
	 * Este es el panel que se visualizar� si escogemos la opci�n de registro.
	 * Borra el panel inicial, y despu�s de haber definido este panel con todos sus elementos,
	 * ense�a el panel de registro de usuarios.
	 * @return panel de registro de usuarios.
	 */
	public JPanel Registrarse()
	{
		contentPane.removeAll();
		
		JLabel Buscaminas = new JLabel("");
		ImageIcon logo= new ImageIcon("src/imagenes/buscaminas.png");
		Image image = logo.getImage(); 
		Image newimg = image.getScaledInstance(180, 110,  java.awt.Image.SCALE_SMOOTH);
		logo = new ImageIcon(newimg); 
		Buscaminas.setIcon(logo);
		Buscaminas.setBounds(5, 5, 180, 150);
		contentPane.add(Buscaminas);
		
		JLabel nombre = new JLabel("Nombre:");
		nombre.setBounds(215, 30, 80, 25);
		contentPane.add(nombre);
		
		nomtxt = new JTextField();
		nomtxt.setBounds(275, 30, 160, 25);
		contentPane.add(nomtxt);
		
		JLabel apellido = new JLabel("Apellidos:");
		apellido.setBounds(215, 90, 160, 25);
		contentPane.add(apellido);
		
		apetxt = new JTextField();
		apetxt.setBounds(275, 90, 160, 25);
		contentPane.add(apetxt);
		
		JLabel correo = new JLabel("Correo electr�nico:");
		correo.setBounds(155, 150, 160, 25);
		contentPane.add(correo);
		
		corretxt = new JTextField();
		corretxt.setBounds(275, 150, 160, 25);
		contentPane.add(corretxt);
		
		JLabel nomusu = new JLabel("Nombre de usuario:");
		nomusu.setBounds(155, 210, 160, 25);
		contentPane.add(nomusu);
		
		nomusutxt = new JTextField();
		nomusutxt.setBounds(275, 210, 160, 25);
		contentPane.add(nomusutxt);
		
		JLabel contrausu = new JLabel("Contrase�a:");
		contrausu.setBounds(195, 270, 160, 25);
		contentPane.add(contrausu);
		
		contrausutxt = new JPasswordField();
		contrausutxt.setBounds(275, 270, 160, 25);
		contentPane.add(contrausutxt);
		
		JButton btnMeterUsuarios = new JButton("Registrarse");
		btnMeterUsuarios.setBounds(205, 320, 180, 25);
		btnMeterUsuarios.setActionCommand(CMD_BTN_REGISTRARSE2);
		btnMeterUsuarios.addActionListener(this);
		contentPane.add(btnMeterUsuarios);
		
		JButton btnAtras = new JButton("Volver");
		btnAtras.setBounds(394, 359, 180, 23);
		btnAtras.addActionListener(this);
		btnAtras.setActionCommand(CMD_BTN_ATRAS);
		contentPane.add(btnAtras); 
		
		this.repaint();
		return contentPane;
	}
}

