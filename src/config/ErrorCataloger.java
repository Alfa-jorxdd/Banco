package config;

import javax.swing.JOptionPane;

public class ErrorCataloger {
    
    public static void errorCatalogerDataRegister(int error){
        switch (error) {
            case 1 ->   JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos");
            case 2 ->   JOptionPane.showMessageDialog(null, "Demasiados caracteres");
            case 3 ->   JOptionPane.showMessageDialog(null, "El campo de DNI debe tener solo números de 8 dígitos");
            case 4 ->   JOptionPane.showMessageDialog(null, "Los datos ya fueron registrados. Por favor, ingrese otros datos");
            default ->  JOptionPane.showMessageDialog(null, "gaa");
        }
    }
    
    public static void errorCatalogerPasswordRegister(int error){
        switch (error) {
            case 1 ->   JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos");
            case 2 ->   JOptionPane.showMessageDialog(null, "Demasiados caracteres");
            case 3 ->   JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            default ->  JOptionPane.showMessageDialog(null, "gaa");
        }
    }
    
    public static void errorCatalogerDataLogin(int error){
        switch (error) {
            case 1 ->   JOptionPane.showMessageDialog(null, "El número de cuenta o la contraseña son incorrectos");
            case 2 ->   JOptionPane.showMessageDialog(null, "Error SQL");
            default ->  JOptionPane.showMessageDialog(null, "gaa");
        }
    }
}
