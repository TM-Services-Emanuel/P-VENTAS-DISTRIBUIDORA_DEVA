package Componentes;

public class Combo {

    public int codigo;
    public String desc;
    public String desc2;

    //Constructor Vacio
    public Combo() {
    }

    //Constructor LLeno
    public Combo(int codigo, String desc) {
        this.codigo = codigo;
        this.desc = desc;
    }
    
    public Combo(int codigo, String desc, String desc2) {
        this.codigo = codigo;
        this.desc = desc;
        this.desc2 = desc2;
    }

    //Getter y Setter
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    @Override
    public String toString() {//Muestra la descripcion completa
        return desc;
    }

}
