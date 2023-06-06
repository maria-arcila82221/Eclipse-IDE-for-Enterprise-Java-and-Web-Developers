package vistaGUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PanelFormulario extends JPanel {
	private JTable table;
	private JTextField textFieldUsuario;
	private JTextField textFieldClave;

	public PanelFormulario() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelIngreso = new JPanel();
		add(panelIngreso, BorderLayout.NORTH);
		panelIngreso.setLayout(new GridLayout(2, 4, 0, 0));
		
		JLabel lblUsuario = new JLabel("Usuario");
		panelIngreso.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave");
		panelIngreso.add(lblClave);
		
		JLabel lblEstado = new JLabel("Estado");
		panelIngreso.add(lblEstado);
		
		JLabel lblVacio = new JLabel("");
		panelIngreso.add(lblVacio);
		
		textFieldUsuario = new JTextField();
		panelIngreso.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldClave = new JTextField();
		panelIngreso.add(textFieldClave);
		textFieldClave.setColumns(10);
		
		JComboBox comboBoxEstado = new JComboBox();
		panelIngreso.add(comboBoxEstado);
		
		JButton btnInsertar = new JButton("Insertar");
		panelIngreso.add(btnInsertar);
		
		String[][] datos = {{"Juan","1","true"},
							{"Maria","2",""}};
		String[] encabezado = {"Usuario", "Clave", "Estado"};
		
		
		DefaultTableModel model = new DefaultTableModel(encabezado, 3);
		
		
		table = new JTable(model);
		add(table, BorderLayout.CENTER);
		
		
		
	}

}
