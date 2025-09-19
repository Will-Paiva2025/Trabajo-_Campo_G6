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
	private JButton btnAdicionar_1;
	private JButton btnBuscar_1;
	private JButton btnModificar_1;
	private JButton btnEliminar_1;

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
		setTitle("Sistema de Inventario bodega");
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
		txtS.setEditable(false);
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
		
		btnEliminar_1 = new JButton("Eliminar");
		btnEliminar_1.addActionListener(this);
		btnEliminar_1.setBounds(356, 111, 89, 23);
		contentPane.add(btnEliminar_1);
		
		btnModificar_1 = new JButton("Modificar");
		btnModificar_1.addActionListener(this);
		btnModificar_1.setBounds(268, 111, 89, 23);
		contentPane.add(btnModificar_1);
		
		btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.addActionListener(this);
		btnBuscar_1.setBounds(182, 111, 89, 23);
		contentPane.add(btnBuscar_1);
		
		btnAdicionar_1 = new JButton("Adicionar");
		btnAdicionar_1.addActionListener(this);
		btnAdicionar_1.setBounds(98, 111, 89, 23);
		contentPane.add(btnAdicionar_1);
		
		btnNewButton_1 = new JButton("Listar");
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
		
		btnNewButton = new JButton("-");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(310, 31, 47, 44);
		contentPane.add(btnNewButton);
		
		btnNewButton_2 = new JButton("+");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(366, 31, 47, 44);
		contentPane.add(btnNewButton_2);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_2) {
			do_btnNewButton_2_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar_1) {
			do_btnEliminar_1_actionPerformed(e);
		}
		if (e.getSource() == btnModificar_1) {
			do_btnModificar_1_actionPerformed(e);
		}
		if (e.getSource() == btnAdicionar_1) {
			do_btnAdicionar_1_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar_1) {
			do_btnBuscar_1_actionPerformed(e);
		}
	}
	protected void do_btnBuscar_1_actionPerformed(ActionEvent e) {
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
	ArregloProducto ap = new ArregloProducto();
	private JTextField txtStock;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JButton btnNewButton_2;
	
	void Listado() {
		Imprimir("Codigo\tProducto\tPrecio\tStock");
		for (int i = 0; i <ap.Tamaño() ; i++) {
		Imprimir(""+ap.Obtener(i).getCodigo()+
				"\t"+ap.Obtener(i).getProducto()+
				"\t"+ap.Obtener(i).getPrecio()+
				"\t"+ap.Obtener(i).getStock());
		}
	}	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		txtS.setText("");
		Listado();
	}
	protected void do_btnAdicionar_1_actionPerformed(ActionEvent e) {
		Producto pr = ap.Buscar(LeerCodigo());
		if (pr==null) {
			Producto p1=new Producto(LeerCodigo(), LeerProducto(), LeerPrecio(), LeerStock());
		ap.Adicionar(p1);
		JOptionPane.showMessageDialog(this,"Producto añadido");
		}
		else JOptionPane.showMessageDialog(this, "Codigo Existente");
	}
	protected void do_btnModificar_1_actionPerformed(ActionEvent e) {
		Producto pr=ap.Buscar(LeerCodigo());
		if (pr!=null) {
			pr.setProducto(LeerProducto());
			pr.setPrecio(LeerPrecio());
			pr.setStock(LeerStock());
			JOptionPane.showMessageDialog(this,"Producto Modificado");
		}
		else JOptionPane.showConfirmDialog(this,"No existe el codgio del producto");
	}
	protected void do_btnEliminar_1_actionPerformed(ActionEvent e) {
		Producto pr=ap.Buscar(LeerCodigo());
		if (pr!=null) {
		 ap.Eliminar(pr);
         JOptionPane.showMessageDialog(this, "Producto Eliminado");
		}
		else JOptionPane.showMessageDialog(this, "No Existe el Codigo del producto");
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
	    Producto pr=ap.Buscar(LeerCodigo());
	    if (pr!=null) {
	    	pr.setStock(pr.getStock() +LeerStock());
	    	txtPreci.setText(String.valueOf(pr.getPrecio()));
	    	txtProd.setText(pr.getProducto());
	    	txtS.setText("");
	    	Listado();
	    }else JOptionPane.showMessageDialog(this, "No Existe el Codigo del producto");
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		Producto pr=ap.Buscar(LeerCodigo());
	    if (pr!=null) {
	    	if (pr.getStock() > 0) {
                pr.setStock(pr.getStock()-LeerStock());
            }
	    	txtPreci.setText(String.valueOf(pr.getPrecio()));
	    	txtProd.setText(pr.getProducto());
	    	txtS.setText("");
	    	Listado();
	    }else JOptionPane.showMessageDialog(this, "No Existe el Codigo del producto");
	}
}

