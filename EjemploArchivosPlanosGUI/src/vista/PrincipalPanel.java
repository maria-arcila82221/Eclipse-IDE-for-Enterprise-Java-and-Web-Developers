package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;

import logica.GuardarDatos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class PrincipalPanel extends JPanel {
	private JTextField codigo;
	private JTextField nombre;
	private JTextField salario;
	private JTextField fecha;

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
		
		JPanel datosPanel = new JPanel();
		panel_1.add(datosPanel);
		datosPanel.setLayout(new GridLayout(2, 5, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Identificación");
		datosPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		datosPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Salario");
		datosPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("<html><body>Fecha Nacimiento<br>&nbsp;&nbsp;(AAAA-MM-DD)</body></html>");
		datosPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("     ");
		datosPanel.add(lblNewLabel_5);
		
		codigo = new JTextField();
		datosPanel.add(codigo);
		codigo.setColumns(10);
		
		nombre = new JTextField();
		datosPanel.add(nombre);
		nombre.setColumns(10);
		
		salario = new JTextField();
		datosPanel.add(salario);
		salario.setColumns(10);
		
		fecha = new JTextField();
		datosPanel.add(fecha);
		fecha.setColumns(10);
		
		JButton guardar = new JButton("Guardar");
		guardar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{  
				GuardarDatos guardar = new GuardarDatos(Integer.parseInt(codigo.getText()), 
						nombre.getText(), 
						Long.parseLong(salario.getText()), 
						LocalDate.parse(fecha.getText()));

						JOptionPane.showMessageDialog(null, "Datos Almacenados");
			}
		});
		datosPanel.add(guardar);

	}

}
