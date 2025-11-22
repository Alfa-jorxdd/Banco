package Logic.validate.validateRegister;

import bd.usuarioDAO.InsertBd;

public class ValidateDataRegister {
    
    
    public int validateData(String name, String lastname, String dni){
        //Verificar si la variable no a sido asignada con un valor
        if(name == null || lastname == null || dni == null){
            return 1;
        }
        //Eliminar espacios y hace todo minusculas
        name = name.trim().toLowerCase();
        lastname = lastname.trim().toLowerCase();
        dni = dni.trim().toLowerCase();
        
        //Verifica si los campos están vacíos
        if(name.isEmpty()||lastname.isEmpty()||dni.isEmpty()){
            return 1;
        }
        //Verifica que no se pase de 50 carácteres
        if(name.length() > 50 && lastname.length() > 50){
            return 2;
        }
        //Verifica que dni tenga 9 números y que si o si contenga números
        if(dni.length() != 8 || !dni.matches("\\d+")){
            return 3; // "\\d+" evalúa que solo contenga números
        }
        if(InsertBd.userExists(name, lastname, dni)){
            return 4;
        }
        return 0;
    }
}
