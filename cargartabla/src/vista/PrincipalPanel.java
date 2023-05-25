package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PrincipalPanel extends JPanel {
	private JTextField codigo;
	private JTextField nombre;
	private JTextField sexo;

	/**
	 * Create the panel.
	 */
	public PrincipalPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Datos Básicos Empleado");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(2, 4, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Identificación");
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sexo");
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel_3.add(lblNewLabel_4);
		
		codigo = new JTextField();
		panel_3.add(codigo);
		codigo.setColumns(10);
		
		nombre = new JTextField();
		panel_3.add(nombre);
		nombre.setColumns(10);
		
		sexo = new JTextField();
		panel_3.add(sexo);
		sexo.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		panel_3.add(btnNewButton);

	}

}
