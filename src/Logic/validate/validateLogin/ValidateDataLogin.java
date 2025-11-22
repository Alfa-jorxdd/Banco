package Logic.validate.validateLogin;

import bd.conectionBd.ConnectionBd;
import java.sql.*;
import javax.swing.JOptionPane;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ValidateDataLogin {
    
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    
    public static int comparePasswords(String bankAccount, String passwordEntered){
        String sql = "SELECT hash_password FROM usuarios WHERE bank_account = ? LIMIT 1";
        
        try(Connection con = ConnectionBd.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, bankAccount);
            
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    String databasePassword = rs.getString("hash_password");
                    
                    if(encoder.matches(passwordEntered, databasePassword)){
                        return 0;
                    } else{
                        return 1;
                    }    
                } else {
                    return 1;
                } 
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al verificar el login");
            System.out.println("Error al verificar el login: " + e);
            return 2;
        }
    }
}
