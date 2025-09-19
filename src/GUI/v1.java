package GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Arreglo.ArregloProducto;
import Clases.Producto;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class v1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JLabel lblNewLabel;
	private JLabel lblNombre;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtCod;
	private JTextField txtProd;
	private JTextField txtPreci;
	private JButton btnNewButton_1;
<<<<<<< HEAD
	private JButton btnAdicionar_1;
	private JButton btnBuscar;
=======
>>>>>>> df70e2c (Tercer Avance Alexandra)

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					v1 frame = new v1();
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
	public v1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 154, 469, 140);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(10, 36, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNombre = new JLabel("Producto");
		lblNombre.setBounds(10, 61, 46, 14);
		contentPane.add(lblNombre);
		
		lblNewLabel_1 = new JLabel("AÑADIR PRODUCTO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 11, 134, 24);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setBounds(10, 86, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtCod = new JTextField();
		txtCod.setBounds(49, 33, 86, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		txtProd = new JTextField();
		txtProd.setBounds(66, 58, 86, 20);
		contentPane.add(txtProd);
		txtProd.setColumns(10);
		
		txtPreci = new JTextField();
		txtPreci.setColumns(10);
		txtPreci.setBounds(49, 83, 86, 20);
		contentPane.add(txtPreci);
		
<<<<<<< HEAD
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(190, 111, 89, 23);
		contentPane.add(btnBuscar);
		
		btnAdicionar_1 = new JButton("Adicionar");
		btnAdicionar_1.addActionListener(this);
		btnAdicionar_1.setBounds(98, 111, 89, 23);
		contentPane.add(btnAdicionar_1);
		
		btnNewButton_1 = new JButton("Listar");
=======
		btnNewButton_1 = new JButton("Reporte");
>>>>>>> df70e2c (Tercer Avance Alexandra)
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(10, 111, 89, 23);
		contentPane.add(btnNewButton_1);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(214, 33, 86, 20);
		contentPane.add(txtStock);
		
		lblNewLabel_3 = new JLabel("Stock");
		lblNewLabel_3.setBounds(172, 36, 46, 14);
		contentPane.add(lblNewLabel_3);
<<<<<<< HEAD

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar_1) {
			do_btnAdicionar_1_actionPerformed(e);
=======
		
		btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(101, 112, 85, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_2 = new JButton("Buscar");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(194, 112, 85, 21);
		contentPane.add(btnNewButton_2);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_2) {
			do_btnNewButton_2_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
>>>>>>> df70e2c (Tercer Avance Alexandra)
		}
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
<<<<<<< HEAD
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_1_actionPerformed(e);
		}
	}
	
=======
	}
>>>>>>> df70e2c (Tercer Avance Alexandra)
	int LeerCodigo() {
		return Integer.parseInt(txtCod.getText());
	}
	String LeerProducto() {
		return txtProd.getText();
    }
	Double LeerPrecio() {
		return Double.parseDouble(txtPreci.getText());
	}
	int LeerStock() {
		return Integer.parseInt(txtStock.getText());
	}
	void Imprimir(String s) {
		txtS.append(s+"\n");
	}
<<<<<<< HEAD
	
	ArregloProducto ap = new ArregloProducto();
	private JTextField txtStock;
	private JLabel lblNewLabel_3;
	
=======
	ArregloProducto ap = new ArregloProducto();
	private JTextField txtStock;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JButton btnNewButton_2;
>>>>>>> df70e2c (Tercer Avance Alexandra)
	
	void Listado() {
		Imprimir("Codigo\tProducto\tPrecio\tStock");
		for (int i = 0; i <ap.Tamaño() ; i++) {
		Imprimir(""+ap.Obtener(i).getCodigo()+
				"\t"+ap.Obtener(i).getProducto()+
				"\t"+ap.Obtener(i).getPrecio()+
				"\t"+ap.Obtener(i).getStock());
		}
<<<<<<< HEAD
	}
	//Funciones de los botones	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		txtS.setText("");
		Listado();
	}
	protected void do_btnAdicionar_1_actionPerformed(ActionEvent e) {
=======
	}	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		txtS.setText("");
		Listado();
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
>>>>>>> df70e2c (Tercer Avance Alexandra)
		Producto pr = ap.Buscar(LeerCodigo());
		if (pr==null) {
			Producto p1=new Producto(LeerCodigo(), LeerProducto(), LeerPrecio(), LeerStock());
		ap.Adicionar(p1);
		JOptionPane.showMessageDialog(this,"Producto añadido");
		}
		else JOptionPane.showMessageDialog(this, "Codigo Existente");
	}
<<<<<<< HEAD
	protected void do_btnBuscar_1_actionPerformed(ActionEvent e) {
=======
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
>>>>>>> df70e2c (Tercer Avance Alexandra)
		Producto pr=ap.Buscar(LeerCodigo());
		if (pr!=null) {
			txtS.setText("");
			Imprimir("Codigo\tProducto\tPrecio\tStock");
			Imprimir(""+pr.getCodigo()+
					"\t"+pr.getProducto()+
					"\t"+pr.getPrecio()+
					"\t"+pr.getStock());
			JOptionPane.showMessageDialog(this, "Producto encontrado");
		}
		else JOptionPane.showMessageDialog(this, "No existe el codigo del producto");
	}
}

