package ArbolBinarioDeBusqueda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Ventana extends JFrame implements ActionListener {
	
	JButton insertarB;
	JButton eliminarB;
	JButton buscarB;
	
	JCheckBox preordenC;
	JCheckBox ordenC;
	JCheckBox postordenC;
	JCheckBox nivelC;
	JCheckBox maxC;
	JCheckBox minC;
	
	JTextField preordenT;
	JTextField ordenT;
	JTextField postordenT;
	JTextField nivelT;
	JTextField maxT;
	JTextField minT;
	
	NodoABB raiz;
	
	public Ventana() {
		
		super("Arbol Binario de Busqueda");
		this.setSize(400, 800);
		
		/*------JPanels------*/
		JPanel panelBotones= new JPanel();
		JPanel panelCasillas= new JPanel();
		
		panelBotones.setBackground(Color.DARK_GRAY);
		panelBotones.setPreferredSize(new Dimension(100, 100));
		
		panelCasillas.setBackground(Color.BLACK);
		
		this.add(panelBotones, BorderLayout.SOUTH);
		this.add(panelCasillas, BorderLayout.CENTER);
			
		
		/*------Panel Botones------*/
		insertarB= new JButton("Insertar");
		eliminarB= new JButton("Eliminar");
		buscarB= new JButton("Buscar");
		
		insertarB.addActionListener(this);
		eliminarB.addActionListener(this);
		buscarB.addActionListener(this);
		
		panelBotones.add(insertarB);
		panelBotones.add(eliminarB);
		panelBotones.add(buscarB);
		
		
		/*------Panel Casillas------*/
		panelCasillas.setLayout(new GridLayout(6, 2));
		
		preordenC= new JCheckBox("Preorden");
		ordenC= new JCheckBox("Orden");
		postordenC= new JCheckBox("Postorden");
		nivelC= new JCheckBox("Nivel");
		maxC= new JCheckBox("Maximo");
		minC= new JCheckBox("Minimo");
		
		preordenC.addActionListener(this);
		ordenC.addActionListener(this);
		postordenC.addActionListener(this);
		nivelC.addActionListener(this);
		maxC.addActionListener(this);
		minC.addActionListener(this);
		
		preordenT= new JTextField();
		ordenT= new JTextField();
		postordenT= new JTextField();
		nivelT= new JTextField();
		maxT= new JTextField();
		minT= new JTextField();
		
		panelCasillas.add(preordenC);
		panelCasillas.add(preordenT);
		panelCasillas.add(ordenC);
		panelCasillas.add(ordenT);
		panelCasillas.add(postordenC);
		panelCasillas.add(postordenT);
		panelCasillas.add(nivelC);
		panelCasillas.add(nivelT);
		panelCasillas.add(maxC);
		panelCasillas.add(maxT);
		panelCasillas.add(minC);
		panelCasillas.add(minT);
	
		
		/*------Visibilidad del frame------*/
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		/*------Arbol------*/
		/*Al abrir la ventana, no estara inicializdo el arbol. Es nulo. 
		Asi que se inicializa con la raiz que se ingresa.*/
		
		try {
			if(raiz==null) {
				String raizInsertarStr= JOptionPane.showInputDialog("Ingresa la raiz del arbol");
				int raizInsertarInt= Integer.valueOf(raizInsertarStr);
				
				raiz= NodoABB.insertaABB(raiz, raizInsertarInt);
			}
		} 
		catch (Exception e) {
			raiz= new NodoABB();
		}	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*------Botones------*/
		//Si se presiona el boton "Insertar", se lanza una ventana preguntando el elemento a insertar
		if(e.getSource()==insertarB) {
			
			String elemInsertarStr= JOptionPane.showInputDialog("Ingresa el elemento a insertar: ");
			int elemInsertarInt= Integer.valueOf(elemInsertarStr);
			
			NodoABB.insertaABB(raiz, elemInsertarInt);
			
			actualizaCasillas();
		}
		
		//Si es el boton "Eliminar", se pregunta por el elemento a eliminar
		if(e.getSource()==eliminarB) {
			
			String elemEliminarStr= JOptionPane.showInputDialog("Ingresa el elemento a eliminar: ");
			int elemEliminarInt= Integer.valueOf(elemEliminarStr);
			
			NodoABB.eliminaABB(raiz, elemEliminarInt);
			
			actualizaCasillas();
		}
		
		//Si es el boton "Buscar", se pregunta por el elemento a buscar
		if(e.getSource()==buscarB) {
			
			String elemBuscarStr= JOptionPane.showInputDialog("Ingresa el elemento a buscar: ");
			int elemBuscarInt= Integer.valueOf(elemBuscarStr);
			
			if(NodoABB.buscaABB(raiz, elemBuscarInt)== true) {
				JOptionPane.showMessageDialog(null, "Se encontro el elemento " + elemBuscarStr, "Buscar", JOptionPane.PLAIN_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "NO se encontro el elemento " + elemBuscarStr, "Buscar", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		/*------Casillas------*/
		//Preorden
		if(e.getSource()== preordenC) {
			
			if(preordenC.isSelected()==true) {
				Recorridos.resetStrings();
				Recorridos.preorden(raiz);
				preordenT.setText(Recorridos.strPreorden);
			}
			else {
				preordenT.setText("");
			}
		}
		
		//Orden
		if(e.getSource()==ordenC) {
			
			if (ordenC.isSelected()==true) {
				Recorridos.resetStrings();
				Recorridos.orden(raiz);
				ordenT.setText(Recorridos.strOrden);
			}
			else {
				ordenT.setText("");
			}
		}
		
		//Postorden
		if(e.getSource()==postordenC) {
			
			if (postordenC.isSelected()==true) {
				Recorridos.resetStrings();
				Recorridos.postorden(raiz);
				postordenT.setText(Recorridos.strPostorden);
			}
			else {
				postordenT.setText("");
			}
		}
		
		//Nivel
		if(e.getSource()==nivelC) {
			
			if (nivelC.isSelected()==true) {
				Recorridos.resetStrings();
				Recorridos.nivel(raiz);
				nivelT.setText(Recorridos.strNivel);
			}
			else {
				nivelT.setText("");
			}
		}
		
		//Maximo
		if(e.getSource()==maxC) {
			
			if (maxC.isSelected()==true) {
				maxT.setText(Integer.toString(NodoABB.encuentraMax(raiz)));
			}
			else {
				maxT.setText("");
			}
		}
		
		//Minimo
		if(e.getSource()==minC) {
			
			if (minC.isSelected()==true) {
				minT.setText(Integer.toString(NodoABB.encuentraMin(raiz)));
			}
			else {
				minT.setText("");
			}
		}	
	}
	
	public void actualizaCasillas() {
		
		/*------Casillas------*/
		//Preorden
		if(preordenC.isSelected()==true) {
			Recorridos.resetStrings();
			Recorridos.preorden(raiz);
			preordenT.setText(Recorridos.strPreorden);
		}
		else {
			preordenT.setText("");
		}
		
		//Orden	
		if (ordenC.isSelected()==true) {
			Recorridos.resetStrings();
			Recorridos.orden(raiz);
			ordenT.setText(Recorridos.strOrden);
		}
		else {
			ordenT.setText("");
		}
		
		//Postorden	
		if (postordenC.isSelected()==true) {
			Recorridos.resetStrings();
			Recorridos.postorden(raiz);
			postordenT.setText(Recorridos.strPostorden);
		}
		else {
			postordenT.setText("");
		}
		
		//Nivel	
		if (nivelC.isSelected()==true) {
			Recorridos.resetStrings();
			Recorridos.nivel(raiz);
			nivelT.setText(Recorridos.strNivel);
		}
		else {
			nivelT.setText("");
		}
		
		//Maximo	
		if (maxC.isSelected()==true) {
			maxT.setText(Integer.toString(NodoABB.encuentraMax(raiz)));
		}
		else {
			maxT.setText("");
		}
		
		//Minimo	
		if (minC.isSelected()==true) {
			minT.setText(Integer.toString(NodoABB.encuentraMin(raiz)));
		}
		else {
			minT.setText("");
		}
	}
}
