package Controladores;

import Componentes.Mensajes;
import static Componentes.URL.urlServer;
import Componentes.cargarComboBoxMovil;
import Datos.GestionarPuntoEmisionMovil;
import IU.dlgPuntoEmisionMovil;
import Modelo.PuntoEmisionMovil;
import Modelo.refMovil;
import com.devazt.networking.HttpClient;
import com.devazt.networking.OnHttpRequestComplete;
import com.devazt.networking.Response;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONException;
import org.json.JSONObject;

public class controlPuntoEmisionMovil {
    public static String addPuntoEmision()
    {
        String msg;
        int cod = Integer.parseInt(dlgPuntoEmisionMovil.txtCod.getText().trim());
        int idTimbrado = Integer.parseInt(cargarComboBoxMovil.getCodidgo(dlgPuntoEmisionMovil.cboTimbrado));
        String establecimiento = dlgPuntoEmisionMovil.txtEstablecimiento.getText().trim();
        String puntoEmision = dlgPuntoEmisionMovil.txtEmision.getText().trim();
        String direccion = dlgPuntoEmisionMovil.txtDireccion.getText().trim();
        int facturainicio= Integer.parseInt(dlgPuntoEmisionMovil.txtFInicio.getText().trim());
        int facturafin= Integer.parseInt(dlgPuntoEmisionMovil.txtFFin.getText().trim());
        int facturaactual= Integer.parseInt(dlgPuntoEmisionMovil.txtFActual.getText().trim());
        String tipo;
        
        String ip;
        if(dlgPuntoEmisionMovil.cbAMovil.isSelected()){
            tipo="M";
            ip="0.0.0.0";
        }else{
            tipo="L";
            ip=dlgPuntoEmisionMovil.txtIP.getText().trim();
        }
        String estado;
        if(dlgPuntoEmisionMovil.rbActivo.isSelected()){
            estado="Activo";
        }else{
            estado="Inactivo";
        }
        String finalidad = null;
        switch (dlgPuntoEmisionMovil.cbFinalidad.getSelectedIndex()) {
            case 1 -> finalidad="F";
            case 2 -> finalidad="NC";
            case 3 -> finalidad="RD";
            default -> {
            }
        }        
        PuntoEmisionMovil pm = new PuntoEmisionMovil(cod, idTimbrado, establecimiento,puntoEmision,direccion, facturainicio, facturafin, facturaactual, tipo, finalidad, ip, estado);
        msg = GestionarPuntoEmisionMovil.addPuntoEmision(pm);
        if(msg.equals("OK"))
        {
            Mensajes.informacion("Punto de Emisión Registrado");
        }
        else{
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static String addRef()
    {
        String msg;
        int cod = Integer.parseInt(dlgPuntoEmisionMovil.txtCod.getText().trim());
        int nventa= Integer.parseInt(dlgPuntoEmisionMovil.txtNVenta.getText().trim());        
        refMovil rf = new refMovil(cod,nventa);
        msg = GestionarPuntoEmisionMovil.addRef(rf);
        if(msg.equals("OK"))
        {
            Mensajes.informacion("Referencia Registrado");
        }
        else{
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static String actPuntoEmision()
    {
        String msg;
        int cod = Integer.parseInt(dlgPuntoEmisionMovil.txtCod.getText().trim());
        String establecimiento = dlgPuntoEmisionMovil.txtEstablecimiento.getText().trim();
        String puntoEmision = dlgPuntoEmisionMovil.txtEmision.getText().trim();
        String direccion = dlgPuntoEmisionMovil.txtDireccion.getText().trim();
        int facturainicio= Integer.parseInt(dlgPuntoEmisionMovil.txtFInicio.getText().trim());
        int facturafin= Integer.parseInt(dlgPuntoEmisionMovil.txtFFin.getText().trim());
        int facturaactual= Integer.parseInt(dlgPuntoEmisionMovil.txtFActual.getText().trim());
        String tipo;
        String ip;
        if(dlgPuntoEmisionMovil.cbAMovil.isSelected()){
            tipo="M";
            ip="0.0.0.0";
        }else{
            tipo="L";
            ip=dlgPuntoEmisionMovil.txtIP.getText().trim();
        }
        String finalidad = null;
        switch (dlgPuntoEmisionMovil.cbFinalidad.getSelectedIndex()) {
            case 1 -> finalidad="F";
            case 2 -> finalidad="NC";
            case 3 -> finalidad="RD";
            default -> {
            }
        }
        String estado;
        if(dlgPuntoEmisionMovil.rbActivo.isSelected()){
            estado="Activo";
        }else{
            estado="Inactivo";
        }
        
        PuntoEmisionMovil pm = new PuntoEmisionMovil(cod, establecimiento,puntoEmision,direccion, facturainicio, facturafin, facturaactual, tipo, finalidad, ip, estado);
        msg = GestionarPuntoEmisionMovil.actPuntoEmision(pm);
        if(msg.equals("OK"))
        {
            Mensajes.informacion("Punto de Emisión Actualizado");
        }
        else{
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static String actRef()
    {
        String msg;
        int cod = Integer.parseInt(dlgPuntoEmisionMovil.txtCod.getText().trim());
        int nventa= Integer.parseInt(dlgPuntoEmisionMovil.txtNVenta.getText().trim());        
        refMovil rf = new refMovil(cod,nventa);
        msg = GestionarPuntoEmisionMovil.actRef(rf);
        if(msg.equals("OK"))
        {
            Mensajes.informacion("Referencia Actualizada");
        }
        else{
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static String delPuntoEmision()    
    {
        String msg;
        int cod = Integer.parseInt(dlgPuntoEmisionMovil.txtCod.getText().trim());
        msg = GestionarPuntoEmisionMovil.delPuntoEmision(cod);
        if(msg.equals("OK"))
        {
            Mensajes.informacion("Punto de Emisión eliminado");
        }
        else{
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static void listPuntoEmision(JTable tabla)
    {
        try {
            HttpClient puntoemision = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonPE = new JSONObject(status.getResult());
                            for (int f = 0; /*f < jsonProductos.length()*/; f++) {
                                Object[] fila = new Object[14];
                                fila[0] = jsonPE.getJSONObject("" + f + "").get("idemision").toString();
                                fila[1] = jsonPE.getJSONObject("" + f + "").get("idtimbrado").toString();
                                fila[2] = jsonPE.getJSONObject("" + f + "").get("timbra").toString();
                                fila[3] = jsonPE.getJSONObject("" + f + "").get("establecimiento").toString();
                                fila[4] = jsonPE.getJSONObject("" + f + "").get("puntoemision").toString();
                                fila[5] = jsonPE.getJSONObject("" + f + "").get("direccion").toString();
                                fila[6] = jsonPE.getJSONObject("" + f + "").get("facturainicio").toString();
                                fila[7] = jsonPE.getJSONObject("" + f + "").get("facturafin").toString();
                                fila[8] = jsonPE.getJSONObject("" + f + "").get("facturaactual").toString();
                                fila[9] = jsonPE.getJSONObject("" + f + "").get("nventa").toString();
                                fila[10] = jsonPE.getJSONObject("" + f + "").get("tipo").toString();
                                fila[11] = jsonPE.getJSONObject("" + f + "").get("final").toString();
                                fila[12] = jsonPE.getJSONObject("" + f + "").get("ip").toString();
                                fila[13] = jsonPE.getJSONObject("" + f + "").get("estado").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });

            puntoemision.excecute(urlServer() + "getlistPuntoEmision.php");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}