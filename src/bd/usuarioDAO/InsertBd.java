package bd.usuarioDAO;

import bd.conectionBd.ConnectionBd;
import config.Hashed;
import java.util.Random;
import java.sql.*;
import javax.swing.JOptionPane;

public class InsertBd {
    
    private static String bank_account;
    
    //MÉTODO QUE REGISTRA AL USUARIO EN LA BASE DE DATOS
    public static boolean registerUsers(String name, String lastname, String dni, String password){
        String sql = "INSERT INTO usuarios (name_user, lastname_user, DNI, hash_password, bank_account) VALUES(?,?,?,?,?)";
        //Recibe la contraseña y la encripta con nuestra clase
        String hashedPassword = Hashed.hashPassword(password);
        //Genera el numero de cuenta de 20 dígitos y que empiece por 20
        bank_account = generateAccount();
        
        try(Connection con = ConnectionBd.getConnection();
            PreparedStatement st = con.prepareStatement(sql)){
            
            st.setString(1, name);
            st.setString(2, lastname);
            st.setString(3, dni);
            st.setString(4, hashedPassword);
            st.setString(5, bank_account);
            
            int filas = st.executeUpdate();
            return filas > 0;
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al registrar usuarios");
            return false;
        }
    }
    
    //MÉTODO QUE VERIFICA SI LOS DATOS INGRESADOS YA EXISTEN EN LA BASE DE DATOS (ESTO DESDE LA INTERFAZ DE REGISTRO DE DATOS)
    public static boolean userExists(String name, String lastname, String dni){
        //Pedimos que encuentre al menos una coincidencia
        String sql = "SELECT 1 FROM usuarios WHERE name_user = ? AND lastname_user = ? AND DNI = ?";
        
        try(Connection con = ConnectionBd.getConnection();
            PreparedStatement st = con.prepareStatement(sql)){
            
            st.setString(1, name);
            st.setString(2, lastname);
            st.setString(3, dni);
            
            //Un "SELECT" devuekve un ResultSet (resultado con filas y columnas)
            ResultSet rs = st.executeQuery();
            
            return rs.next(); //Devolverá true si encuentra una coincidencia
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Usuario ya registrado");
            return false;
        }
    }
    
    //MÉTODO QUE GENERA EL NÚMERO DE CUENTA
    private static String generateAccount(){
        Random random = new Random();
        StringBuilder account = new StringBuilder();
        account.append("20");
        for(int i = 0; i < 18; i++){
            int digito = random.nextInt(10);//genera un número del 0 al 9
            account.append(digito);
        }
        return account.toString();
    }
    
    //GETTER DEL bank_account
    public static String getBankAccount(){
        return bank_account;
    }
}
