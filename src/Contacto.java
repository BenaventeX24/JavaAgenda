public class Contacto {
    String nombre;
    int num;
    String mail;

    public Contacto(String nombre, int num, String mail){
        this.nombre=nombre;
        this.num=num;
        if(mail.isBlank()){
            mail="No se registro un correo";
        }
        this.mail=mail;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getNum(){
        return this.num;
    }

    public String getMail(){
        return this.mail;
    }


}
