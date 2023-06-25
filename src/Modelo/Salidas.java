package Modelo;

public class Salidas {

    private int codSal;
    private int codProv;
    private int iddeposito;
    private int idcaja;
    private int idmotivo_salida;
    private String fecha;
    private String hora;
    private int monto;
    private String Obs;
    private String estado;
    private String usu;

    //Constructor

    public Salidas(int codSal, int codProv, int iddeposito, int idcaja, int idmotivo_salida, String fecha, String hora, int monto, String Obs, String estado, String usu) {
        this.codSal = codSal;
        this.codProv = codProv;
        this.iddeposito = iddeposito;
        this.idcaja = idcaja;
        this.idmotivo_salida = idmotivo_salida;
        this.fecha = fecha;
        this.hora = hora;
        this.monto = monto;
        this.Obs = Obs;
        this.estado = estado;
        this.usu = usu;
    }
    
    //Constructor Vacio
    public Salidas() {
    }

    //Getter y Setter

    public int getCodSal() {
        return codSal;
    }

    public void setCodSal(int codSal) {
        this.codSal = codSal;
    }

    public int getCodProv() {
        return codProv;
    }

    public void setCodProv(int codProv) {
        this.codProv = codProv;
    }

    public int getIddeposito() {
        return iddeposito;
    }

    public void setIddeposito(int iddeposito) {
        this.iddeposito = iddeposito;
    }

    public int getIdcaja() {
        return idcaja;
    }

    public void setIdcaja(int idcaja) {
        this.idcaja = idcaja;
    }

    public int getIdmotivo_salida() {
        return idmotivo_salida;
    }

    public void setIdmotivo_salida(int idmotivo_salida) {
        this.idmotivo_salida = idmotivo_salida;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String Obs) {
        this.Obs = Obs;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }
    

}
