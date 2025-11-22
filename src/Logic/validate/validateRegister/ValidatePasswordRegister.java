package Logic.validate.validateRegister;

public class ValidatePasswordRegister {
    
    public int validatePassword(String password1, String password2){
        //Verificar si la variable no a sido asignada con un valor
        if(password1 == null||password2 == null){
            return 1;
        }
        //Eliminar espacios
        password1 = password1.trim();
        password2 = password2.trim();
        
        //Verifica si los campos están vacíos
        if(password1.isEmpty()||password2.isEmpty()){
            return 1;
        }
        //Verifica que no se pase de 50 carácteres
        if(password1.length() > 50 || password2.length() > 50){
            return 2;
        }
        //Verifica que ambas contraseñas sean iguales
        if(!password1.matches(password2)){
            return 3;
        }
        return 0;
    }
}
