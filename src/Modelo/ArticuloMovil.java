package Modelo;

public class ArticuloMovil {

    private int idproducto;
    private String codinterno;
    private String codBarra;
    private String descripcion;
    private int precio_costo;
    private int ganancia;
    private double porG;
    private int precio_venta;
    private double stock;
    private int um;
    private int division;
    private int iva;
    private String ventam;
    private double cantm;
    private int preciominorista;
    private int gananciaminorista;
    private double porGMinorista;
    private int preciosupermercado;
    private int gananciasupermercado;
    private double porGSupermercado;

    public ArticuloMovil(int idproducto, String codinterno, String codBarra, String descripcion, int precio_costo, int ganancia, double porG, int precio_venta, double stock, int um, int division, int iva, String ventam, double cantm, int preciominorista, int gananciaminorista, double porGMinorista, int preciosupermercado, int gananciasupermercado, double porGSupermercado) {
        this.idproducto = idproducto;
        this.codinterno = codinterno;
        this.codBarra = codBarra;
        this.descripcion = descripcion;
        this.precio_costo = precio_costo;
        this.ganancia = ganancia;
        this.porG = porG;
        this.precio_venta = precio_venta;
        this.stock = stock;
        this.um = um;
        this.division = division;
        this.iva = iva;
        this.ventam = ventam;
        this.cantm = cantm;
        this.preciominorista = preciominorista;
        this.gananciaminorista = gananciaminorista;
        this.porGMinorista = porGMinorista;
        this.preciosupermercado = preciosupermercado;
        this.gananciasupermercado = gananciasupermercado;
        this.porGSupermercado = porGSupermercado;
    }
      //Constructor para actualizar stock
    public ArticuloMovil(int idproducto, double stock) {
        this.idproducto = idproducto;
        this.stock = stock;
    }
    //Constructor Vacio
    public ArticuloMovil() {
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getCodinterno() {
        return codinterno;
    }

    public void setCodinterno(String codinterno) {
        this.codinterno = codinterno;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(int precio_costo) {
        this.precio_costo = precio_costo;
    }

    public int getGanancia() {
        return ganancia;
    }

    public void setGanancia(int ganancia) {
        this.ganancia = ganancia;
    }

    public double getPorG() {
        return porG;
    }

    public void setPorG(double porG) {
        this.porG = porG;
    }

    public int getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(int precio_venta) {
        this.precio_venta = precio_venta;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public int getUm() {
        return um;
    }

    public void setUm(int um) {
        this.um = um;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public String getVentam() {
        return ventam;
    }

    public void setVentam(String ventam) {
        this.ventam = ventam;
    }

    public double getCantm() {
        return cantm;
    }

    public void setCantm(double cantm) {
        this.cantm = cantm;
    }

    public int getPreciominorista() {
        return preciominorista;
    }

    public void setPreciominorista(int preciominorista) {
        this.preciominorista = preciominorista;
    }

    public int getGananciaminorista() {
        return gananciaminorista;
    }

    public void setGananciaminorista(int gananciaminorista) {
        this.gananciaminorista = gananciaminorista;
    }

    public double getPorGMinorista() {
        return porGMinorista;
    }

    public void setPorGMinorista(double porGMinorista) {
        this.porGMinorista = porGMinorista;
    }

    public int getPreciosupermercado() {
        return preciosupermercado;
    }

    public void setPreciosupermercado(int preciosupermercado) {
        this.preciosupermercado = preciosupermercado;
    }

    public int getGananciasupermercado() {
        return gananciasupermercado;
    }

    public void setGananciasupermercado(int gananciasupermercado) {
        this.gananciasupermercado = gananciasupermercado;
    }

    public double getPorGSupermercado() {
        return porGSupermercado;
    }

    public void setPorGSupermercado(double porGSupermercado) {
        this.porGSupermercado = porGSupermercado;
    }

    
      
}
