package Proyecto;

public class UsuarioLogin {
    String usuario; 
    char[] contraseņa;

    public UsuarioLogin(String usuario, char[] contraseņa) {
        this.usuario = usuario;
        this.contraseņa = contraseņa;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", contrase\u00f1a=" + contraseņa + '}';
    }
    
}