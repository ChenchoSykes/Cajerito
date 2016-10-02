
package cajerito;

public class Usuario{
    private int idUsuario;
    private String nombre;
    private String Apellidos;
    private String pass;
    private String type;
    private String Sexo;
    private int edad;
	private int saldo;

    public Usuario() {
    }
    
    public Usuario(int idUsuario,String nombre, String pass,int saldo) {
        this.idUsuario=idUsuario;
        this.nombre = nombre;

        this.pass = pass;

    }


    public int getId() {
        return idUsuario;
    }

    public void setId(int idUsuario) {
        this.idUsuario = idUsuario;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String Pass) {
        this.pass = Pass;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
