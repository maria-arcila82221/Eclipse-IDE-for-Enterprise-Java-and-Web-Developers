package vistaGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

/*permite que esta clase escuche todo lo que pasa dentro de ella: lo que pasa con los objetos dentro de la clase*/
public class PanelPrincipal extends JPanel {
	
	public PanelPrincipal() {

		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		
		JPanel hola = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addComponent(hola, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(hola, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
		);
		hola.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		hola.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 98));
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setBackground(new Color(0, 255, 0));
		
		JButton chao = new JButton("New button");
		chao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PanelMenu j=new PanelMenu();
				hola.removeAll();
				hola.add(j);
				revalidate();
				repaint();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(161)
							.addComponent(chao)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(chao)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 66, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		
	}

	/*private void initialize() {
		frame = new JFrame();
		//frame.setBackground(new Color(colorR, colorG, colorRGB));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PanelPrincipal panelSuperior = new PanelPrincipal();
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLogin = new JPanel();
		panelSuperior.add(panelLogin, BorderLayout.WEST);
		panelLogin.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel IbIUsuario = new JLabel("Usuario");
		panelLogin.add(IbIUsuario);
		
		textUsuario = new JTextField();
		panelLogin.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave");
		panelLogin.add(lblClave);
		
		textClave = new JTextField();
		panelLogin.add(textClave);
		textClave.setColumns(10);
		
		JLabel lblVacio = new JLabel(" ");
		panelLogin.add(lblVacio);
		
		JButton btnIngresar = new JButton("Ingresar");
		panelLogin.add(btnIngresar);
		
		JLabel lblVacio1 = new JLabel("");
		panelLogin.add(lblVacio1);
		
		JLabel lblNombreUsuario = new JLabel("");
		panelLogin.add(lblNombreUsuario);
		
		JPanel panelTitulo = new JPanel();
		panelSuperior.add(panelTitulo);
		panelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblTitulo = new JLabel("Sistema Computador");
		panelTitulo.add(lblTitulo);
		
		JPanel panelCentro = new JPanel();
		frame.getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelInferior = new JPanel();
		frame.getContentPane().add(panelInferior, BorderLayout.SOUTH);
		panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}*/
	
	
	


	
}
