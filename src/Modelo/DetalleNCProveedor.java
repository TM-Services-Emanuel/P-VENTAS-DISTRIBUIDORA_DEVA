package Modelo;

public class DetalleNCProveedor {
    
    private int idnota;
    private int idproducto;
    private double cant;
    private int precio;
    private int monto;
    private int iva;
    
    //Constructor sin codigo de Salida
    public DetalleNCProveedor(int idproducto, double cant, int precio, int monto) {
        this.idproducto = idproducto;
        this.cant = cant;
        this.precio = precio;
        this.monto = monto;
    }
    
    public DetalleNCProveedor(int idproducto) {
        this.idproducto = idproducto;
    }
    
    public DetalleNCProveedor(int idproducto, double cant) {
        this.idproducto = idproducto;
        this.cant = cant;
    }
    
    public DetalleNCProveedor(double cant, int monto) {
        this.monto = monto;
    }
    

    //Constructor Completo
    public DetalleNCProveedor(int idnota, int idproducto, double cant, int precio, int monto, int iva) {
        this.idnota = idnota;
        this.idproducto = idproducto;
        this.cant = cant;
        this.precio = precio;
        this.monto = monto;
        this.iva = iva;
    }

    //Constructor Vacio
    public DetalleNCProveedor() {
    }
    
    //Getter y Setter

    public int getIdnota() {
        return idnota;
    }

    public void setIdnota(int idnota) {
        this.idnota = idnota;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public double getCant() {
        return cant;
    }

    public void setCant(double cant) {
        this.cant = cant;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }
    
    
}
