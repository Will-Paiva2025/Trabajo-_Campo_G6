package GUI;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Conexion.ConexionMySQL;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JLabel lblIntentos;
    private int intentos = 3;

	/**
	 * Create the frame.
	 */
    public Login() {
        setTitle("Inicio de Sesión - Sistema de Inventario");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("INICIO DE SESIÓN", JLabel.CENTER);
        lblTitulo.setBounds(113, 16, 158, 22);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(lblTitulo);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(133, 61, 58, 14);
        panel.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(193, 58, 78, 20);
        panel.add(txtUsuario);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(113, 101, 78, 14);
        panel.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(193, 98, 78, 20);
        panel.add(txtPassword);

        lblIntentos = new JLabel("Intentos restantes: 3");
        lblIntentos.setBounds(140, 138, 151, 14);
        lblIntentos.setForeground(Color.RED);
        panel.add(lblIntentos);

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(155, 172, 92, 23);
        panel.add(btnIngresar);

        btnIngresar.addActionListener(e -> validarLogin());
        txtPassword.addActionListener(e -> validarLogin());
    }
    private void validarLogin() {
        String usuario = txtUsuario.getText().trim();
        String clave = String.valueOf(txtPassword.getPassword());

        if (usuario.isEmpty() || clave.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar usuario y contraseña");
            return;
        }

        boolean valido = validarUsuarioBD(usuario, clave);

        if (valido) {
            JOptionPane.showMessageDialog(this, "BIENVENIDO " + usuario.toUpperCase());
            new MenuPrincipal(usuario).setVisible(true); 
            this.dispose();
        } else {
            intentos--;
            lblIntentos.setText("Intentos restantes: " + intentos);

            if (intentos == 0) {
                JOptionPane.showMessageDialog(this, "Demasiados intentos fallidos");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
            }
        }
    }

    private boolean validarUsuarioBD(String usuario, String clave) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND clave = ?";

        try (Connection con = ConexionMySQL.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ps.setString(2, clave);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error de conexión: " + e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}
