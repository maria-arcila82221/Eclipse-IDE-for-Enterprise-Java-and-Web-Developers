package vistaGUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class PanelMenu extends JPanel {

	public PanelMenu() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelMenu = new JPanel();
		add(panelMenu, BorderLayout.WEST);
		panelMenu.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panelMenu.add(panel, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("Gestion Computadores");
		panel.add(lblTitulo);
		
		JPanel panel_1 = new JPanel();
		panelMenu.add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panelMenu.add(panel_2, BorderLayout.EAST);
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Computador") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Maestras");
						node_1.add(new DefaultMutableTreeNode("Chasis"));
						node_1.add(new DefaultMutableTreeNode("Disco Duro"));
						node_1.add(new DefaultMutableTreeNode("Tipo Computador"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Operacion");
						node_1.add(new DefaultMutableTreeNode("basketball"));
						node_1.add(new DefaultMutableTreeNode("soccer"));
						node_1.add(new DefaultMutableTreeNode("football"));
						node_1.add(new DefaultMutableTreeNode("hockey"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Consultas Reportes");
						node_1.add(new DefaultMutableTreeNode("hot dogs"));
						node_1.add(new DefaultMutableTreeNode("pizza"));
						node_1.add(new DefaultMutableTreeNode("ravioli"));
						node_1.add(new DefaultMutableTreeNode("bananas"));
					add(node_1);
					add(new DefaultMutableTreeNode("Otra"));
				}
			}
		));
		panelMenu.add(tree, BorderLayout.CENTER);
		
		JPanel panelOperacion = new JPanel();
		add(panelOperacion, BorderLayout.CENTER);
		panelOperacion.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel(" ");
		panelOperacion.add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		panelOperacion.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_2 = new JLabel(" ");
		panelOperacion.add(lblNewLabel_2, BorderLayout.WEST);
		
		JLabel lblNewLabel_3 = new JLabel(" ");
		panelOperacion.add(lblNewLabel_3, BorderLayout.EAST);

	}

}
