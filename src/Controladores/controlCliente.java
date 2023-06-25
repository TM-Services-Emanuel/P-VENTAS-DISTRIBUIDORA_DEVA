package Controladores;

import Componentes.Fecha;
import Componentes.Mensajes;
import static Componentes.URL.urlServer;
import Datos.GestionarCliente;
import IU.dlgClientes;
import IU.dlgGestClientes;
import Modelo.ClienteMovil;
import com.devazt.networking.HttpClient;
import com.devazt.networking.OnHttpRequestComplete;
import com.devazt.networking.Response;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONException;
import org.json.JSONObject;

public class controlCliente {
    public static void aModificar() {
        int x = dlgClientes.tablaClientes.getSelectedRow();
        String cod = dlgClientes.tablaClientes.getValueAt(x, 0).toString();
        ClienteMovil c = GestionarCliente.busCliente(cod);
        dlgGestClientes.lblCodC.setText(String.valueOf(c.getIdCliente()));
        dlgGestClientes.txtRazonS.setText(c.getRazonSocial());
        dlgGestClientes.txtRuc.setText(c.getRuc());
        dlgGestClientes.cbotipopersona.setSelectedItem(c.getTipoPersona());
        dlgGestClientes.cboNacionalidad.setSelectedItem(c.getNacionalidad());
        dlgGestClientes.txtFecha.setText(Fecha.formatoFechaDd(c.getFechaN()));
        dlgGestClientes.txtFechaR.setText((c.getFechaN()));
        dlgGestClientes.cboSexo.setSelectedItem(c.getSexo());
        dlgGestClientes.txtDireccion.setText(c.getDireccion());
        dlgGestClientes.txtBarrio.setText(c.getBarrio());
        dlgGestClientes.txtTelefono.setText(c.getTelefono());
        dlgGestClientes.cbCiudad.setSelectedIndex(c.getCodCiudad());
        if(c.getSuper().equals("S")){
            dlgGestClientes.ckSupermercado.setSelected(true);
        }else{
            dlgGestClientes.ckSupermercado.setSelected(false);
        }
        if(c.getLunes().equals("S")){
            dlgGestClientes.ckLunes.setSelected(true);
        }else{
            dlgGestClientes.ckLunes.setSelected(false);
        }
        if(c.getMartes().equals("S")){
            dlgGestClientes.ckMartes.setSelected(true);
        }else{
            dlgGestClientes.ckMartes.setSelected(false);
        }
        if(c.getMiercoles().equals("S")){
            dlgGestClientes.ckMiercoles.setSelected(true);
        }else{
            dlgGestClientes.ckMiercoles.setSelected(false);
        }
        if(c.getJueves().equals("S")){
            dlgGestClientes.ckJueves.setSelected(true);
        }else{
            dlgGestClientes.ckJueves.setSelected(false);
        }
        if(c.getViernes().equals("S")){
            dlgGestClientes.ckViernes.setSelected(true);
        }else{
            dlgGestClientes.ckViernes.setSelected(false);
        }
        if(c.getSabado().equals("S")){
            dlgGestClientes.ckSabado.setSelected(true);
        }else{
            dlgGestClientes.ckSabado.setSelected(false);
        }
        if(c.getDomingo().equals("S")){
            dlgGestClientes.ckDomingo.setSelected(true);
        }else{
            dlgGestClientes.ckDomingo.setSelected(false);
        }
       
    }

    public static ClienteMovil capturarCampos() {
        ClienteMovil c;
        int codC = Integer.parseInt(dlgGestClientes.lblCodC.getText());
        int codCi = Integer.parseInt(dlgGestClientes.lbCiudad.getText());
        String razonS = dlgGestClientes.txtRazonS.getText().toUpperCase();
        String ruc = dlgGestClientes.txtRuc.getText().toUpperCase();
        String tipoPersona = dlgGestClientes.cbotipopersona.getSelectedItem().toString();
        String nacionalidad = dlgGestClientes.cboNacionalidad.getSelectedItem().toString();
        String fechaN = dlgGestClientes.txtFechaR.getText();
        String sexo = dlgGestClientes.cboSexo.getSelectedItem().toString(); 
        String telf = dlgGestClientes.txtTelefono.getText();
        String direc = dlgGestClientes.txtDireccion.getText().toUpperCase();
        String barrio = dlgGestClientes.txtBarrio.getText().toUpperCase();
        String Super;
        if(dlgGestClientes.ckSupermercado.isSelected()){
            Super="S";
        }else{
            Super="N";
        }
        String lunes;
        if(dlgGestClientes.ckLunes.isSelected()){
            lunes="S";
        }else{
            lunes="N";
        }
        String martes;
        if(dlgGestClientes.ckMartes.isSelected()){
            martes="S";
        }else{
            martes="N";
        }
        String miercoles;
        if(dlgGestClientes.ckMiercoles.isSelected()){
            miercoles="S";
        }else{
            miercoles="N";
        }
        String jueves;
        if(dlgGestClientes.ckJueves.isSelected()){
            jueves="S";
        }else{
            jueves="N";
        }
        String viernes;
        if(dlgGestClientes.ckViernes.isSelected()){
            viernes="S";
        }else{
            viernes="N";
        }
        String sabado;
        if(dlgGestClientes.ckSabado.isSelected()){
            sabado="S";
        }else{
            sabado="N";
        }
        String domingo;
        if(dlgGestClientes.ckDomingo.isSelected()){
            domingo="S";
        }else{
            domingo="N";
        }
        c = new ClienteMovil(codC, razonS, ruc, tipoPersona, nacionalidad, fechaN, sexo, direc, barrio,
                telf, codCi, Super, lunes, martes, miercoles, jueves, viernes, sabado, domingo);
        return c;
    }

    public static ClienteMovil capturarCampos1() {
        ClienteMovil c = null;
        /*String telf;
        int codC = Integer.parseInt(dlgGestClientes1.lblCodC.getText());
        int codCi = Integer.parseInt(dlgGestClientes1.lbCiudad.getText());
        String razonS = dlgGestClientes1.txtRazonS.getText().toUpperCase();
        String ruc = dlgGestClientes1.txtRuc.getText().toUpperCase();
        if (dlgGestClientes1.txtTelefono.getText().isEmpty()) {
            telf = "' '";
        } else {
            telf = dlgGestClientes1.txtTelefono.getText();
        }
        String direc = dlgGestClientes1.txtDireccion.getText().toUpperCase();
        c = new ClienteMovil(codC, razonS, ruc, direc, telf, codCi);*/
        return c;
    }

    public static String addCliente() {
        String msg;
        ClienteMovil c = capturarCampos();
        msg = GestionarCliente.addCliente(c);
        if (msg.equals("OK")) {
            Mensajes.informacion("Cliente Registrado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String addCliente1() {
        String msg;
        ClienteMovil c = capturarCampos1();
        msg = GestionarCliente.addCliente(c);
        if (msg == null) {
            Mensajes.informacion("Cliente Registrado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String actCliente() {
        String msg;
        ClienteMovil c = capturarCampos();
        msg = GestionarCliente.actCliente(c);
        if (msg.equals("OK")) {
            Mensajes.informacion("Cliente Actualizado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String delCliente() {
        int x = dlgClientes.tablaClientes.getSelectedRow();
        String msg;
        String cod = dlgClientes.tablaClientes.getValueAt(x, 0).toString();
        msg = GestionarCliente.delCliente(cod);
        if (msg.equals("OK")) {
            Mensajes.informacion("Cliente Eliminado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static void listClientes(JTable tabla) {
        try {
            HttpClient clientes = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonClientes = new JSONObject(status.getResult());
                            for (int f = 0; /*f < jsonProductos.length()*/; f++) {
                                Object[] fila = new Object[6];
                                fila[0] = jsonClientes.getJSONObject("" + f + "").get("idcliente").toString();
                                fila[1] = jsonClientes.getJSONObject("" + f + "").get("razon_social").toString();
                                fila[2] = jsonClientes.getJSONObject("" + f + "").get("ruc").toString();
                                fila[3] = jsonClientes.getJSONObject("" + f + "").get("direccion").toString();
                                fila[4] = jsonClientes.getJSONObject("" + f + "").get("telefono").toString();
                                fila[5] = jsonClientes.getJSONObject("" + f + "").get("ciudad").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });

            clientes.excecute(urlServer() + "getlistClientes.php");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void listClientesContaduria(JTable tabla) {
        List lista;
        lista = GestionarCliente.listClientesContaduria();
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            if (fila[2].toString().contains("-")) {
                String ruc = fila[2].toString();
                Object[] parts = ruc.split("-");
                fila[2] = parts[0].toString();
                fila[3] = parts[1].toString();
            } else {
                fila[2].toString();
                fila[3]=null;
            }

            tb.addRow(fila);
        }
    }
    
    public static void listActosGravados(JTable tabla) {
        List lista;
        lista = GestionarCliente.listActosGravados();
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            tb.addRow(fila);
        }
    }
    
    public static void listVCContaduria(JTable tabla, String desde, String hasta) {
        List lista;
        lista = GestionarCliente.listVCContaduria(desde, hasta);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0]= fila[0].toString();
            fila[1]= fila[1].toString()+"-"+fila[2].toString();
            fila[2]= Fecha.formatoFechaVMRInverter(fila[3].toString());
            fila[3]= Integer.parseInt(fila[4].toString());
            if(fila[5].toString().equals("CONTADO")){
                fila[4]= "1";
            }else if(fila[5].toString().equals("CRÉDITO")){
                fila[4]= "2";
            }
            if(fila[6] == null){
               fila[5] =""; 
            }else{
                fila[5] = fila[6].toString();
            }
            fila[6] = "1";

            tb.addRow(fila);
        }
    }
    
    public static void listVDContaduria(JTable tabla, String desde, String hasta) {
        List lista;
        lista = GestionarCliente.listVDContaduria(desde, hasta);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0]= fila[2].toString();
            fila[1]= fila[3].toString()+"-"+fila[4].toString();
            fila[2]= Fecha.formatoFechaVMRInverter(fila[5].toString());
            fila[3]= Integer.parseInt(fila[6].toString());
            if(fila[7].toString().equals("CONTADO")){
                fila[4]= "1";
            }else if(fila[7].toString().equals("CRÉDITO")){
                fila[4]= "2";
            }
            if(fila[8] == null){
                fila[5]="";
            }else{
                fila[5]= fila[8].toString();
            }
            fila[6] = fila[9].toString();
            fila[7] = fila[10].toString();
            fila[8] = fila[11].toString();
            fila[9] = "0";
            fila[10] = "0";
            tb.addRow(fila);
        }
    }

    public static void filtClientes(JTable tabla, String cad) {
        try {
            String caden;
            if(cad.contains(" ")){
                caden=cad.replace(" ", "%20");
            }else{
                caden=cad;
            }
            HttpClient clientes = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonClientes = new JSONObject(status.getResult());
                            for (int f = 0; /*f < jsonProductos.length()*/; f++) {
                                Object[] fila = new Object[6];
                                fila[0] = jsonClientes.getJSONObject("" + f + "").get("idcliente").toString();
                                fila[1] = jsonClientes.getJSONObject("" + f + "").get("razon_social").toString();
                                fila[2] = jsonClientes.getJSONObject("" + f + "").get("ruc").toString();
                                fila[3] = jsonClientes.getJSONObject("" + f + "").get("direccion").toString();
                                fila[4] = jsonClientes.getJSONObject("" + f + "").get("telefono").toString();
                                fila[5] = jsonClientes.getJSONObject("" + f + "").get("ciudad").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });

            clientes.excecute(urlServer() + "getfilRazonS.php?param="+caden);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void filtRuc(JTable tabla, String cad) {
        List lista = null;
        lista = GestionarCliente.filRuc(cad);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }
    /*public static void filContacto(JTable tabla, String cad)
    {
        List lista = null;
        lista = GestionarCliente.filContacto(cad);
        for(int i=1;i<lista.size();i++)
        {
            DefaultTableModel tb = (DefaultTableModel)tabla.getModel();
            Object[]fila = (Object[])lista.get(i);
            tb.addRow(fila);
        }
    }
     */
 /*public static void filDireccion(JTable tabla, String cad)
    {
        List lista = null;
        lista = GestionarCliente.filDireccion(cad);
        for(int i=1;i<lista.size();i++)
        {
            DefaultTableModel tb = (DefaultTableModel)tabla.getModel();
            Object[]fila = (Object[])lista.get(i);
            tb.addRow(fila);
        }
    }
     */
}
