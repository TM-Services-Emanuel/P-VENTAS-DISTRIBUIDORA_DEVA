package Controladores;

import Componentes.Login;
import Componentes.Mensajes;
import static Componentes.URL.urlServer;
import Datos.GestionarProveedor;
import IU.dlgGestProveedor;
import IU.dlgProveedores;
import Modelo.Proveedor;
import com.devazt.networking.HttpClient;
import com.devazt.networking.OnHttpRequestComplete;
import com.devazt.networking.Response;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONException;
import org.json.JSONObject;

public class controlProveedor {

    static String UsuarioL = "";

    public static void aModificar() {
        DefaultTableModel m = (DefaultTableModel) dlgProveedores.tablaProveedores.getModel();
        int x = dlgProveedores.tablaProveedores.getSelectedRow();

        String cod = m.getValueAt(x, 0).toString();
        Proveedor pr = GestionarProveedor.busProveedor(cod);

        dlgGestProveedor.lblCodP.setText(String.valueOf(pr.getCodP()));
        dlgGestProveedor.txtRazonS.setText(pr.getRazoS());
        dlgGestProveedor.txtRuc.setText(pr.getRuc());
        dlgGestProveedor.txtContacto.setText(pr.getContac());
        dlgGestProveedor.txtCelular.setText(pr.getCelu());
        dlgGestProveedor.txtTelefono.setText(pr.getTelef());
        dlgGestProveedor.txtDireccion.setText(pr.getDireccion());
        dlgGestProveedor.cbCiudad.setSelectedIndex(pr.getCodCiudad());
        dlgGestProveedor.txaS.setText(pr.getObs());
    }

    public static Proveedor capturarCampos() {
        Proveedor pr;
        String contac;
        String telef;
        String direc;
        String obs;
        int cod = Integer.parseInt(dlgGestProveedor.lblCodP.getText());
        String razonS = dlgGestProveedor.txtRazonS.getText();
        String ruc = dlgGestProveedor.txtRuc.getText();
        if (dlgGestProveedor.txtContacto.getText().trim() == null) {
            contac = "''";
        } else {
            contac = dlgGestProveedor.txtContacto.getText().toUpperCase();
        }
        String celu = dlgGestProveedor.txtCelular.getText();
        if (dlgGestProveedor.txtTelefono.getText().trim() == null) {
            telef = "''";
        } else {
            telef = dlgGestProveedor.txtTelefono.getText();
        }
        if (dlgGestProveedor.txtDireccion.getText().trim() == null) {
            direc = "''";
        } else {
            direc = dlgGestProveedor.txtDireccion.getText().toUpperCase();
        }
        int codCiu = Integer.valueOf(dlgGestProveedor.lbCiudad.getText().trim());
        if (dlgGestProveedor.txaS.getText().trim() == null) {
            obs = "''";
        } else {
            obs = dlgGestProveedor.txaS.getText();
        }
        String usuario = UsuarioL = Login.getUsuarioLogueado();
        pr = new Proveedor(cod, codCiu, razonS, ruc, contac, celu, telef, direc, obs, usuario);
        return pr;
    }

    public static String addProveedor() {
        String msg;
        Proveedor pr = capturarCampos();
        msg = GestionarProveedor.addProveedor(pr);
        if (msg == null) {
            Mensajes.informacion("Proveedor Registrado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String actProveedor() {
        String msg;
        Proveedor pr = capturarCampos();
        msg = GestionarProveedor.actProveedor(pr);
        if (msg == null) {
            Mensajes.informacion("Proveedor Actualizado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String delProveedor() {
        int x = dlgProveedores.tablaProveedores.getSelectedRow();
        String msg;
        String cod = dlgProveedores.tablaProveedores.getValueAt(x, 0).toString();
        String usuario = UsuarioL = Login.getUsuarioLogueado();
        msg = GestionarProveedor.delProveedor(cod, usuario);
        if (msg == null) {
            Mensajes.informacion("Proveedor Eliminado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static void listProveedor(JTable tabla) {
        try {
            HttpClient clientes = new HttpClient((Response status) -> {
                if (status.isSuccess()) {
                    try {
                        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                        JSONObject jsonClientes = new JSONObject(status.getResult());
                        for (int f = 0; /*f < jsonProductos.length()*/; f++) {
                            Object[] fila = new Object[9];
                            fila[0] = jsonClientes.getJSONObject("" + f + "").get("codigo").toString();
                            fila[1] = jsonClientes.getJSONObject("" + f + "").get("descripcion").toString();
                            fila[2] = jsonClientes.getJSONObject("" + f + "").get("ruc").toString();
                            fila[3] = jsonClientes.getJSONObject("" + f + "").get("telefono").toString();
                            fila[4] = jsonClientes.getJSONObject("" + f + "").get("contacto").toString();
                            fila[5] = jsonClientes.getJSONObject("" + f + "").get("celular").toString();
                            fila[6] = jsonClientes.getJSONObject("" + f + "").get("ciudad").toString();
                            fila[7] = jsonClientes.getJSONObject("" + f + "").get("direccion").toString();
                            fila[8] = jsonClientes.getJSONObject("" + f + "").get("observacion").toString();
                            tb.addRow(fila);
                        }

                    } catch (JSONException e) {
                    }
                }
            });

            clientes.excecute(urlServer() + "getlistProveedor.php");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void filProveedor(JTable tabla, String cod) {
        try {
            String caden;
            if (cod.contains(" ")) {
                caden = cod.replace(" ", "%20");
            } else {
                caden = cod;
            }
            HttpClient clientes = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonClientes = new JSONObject(status.getResult());
                            for (int f = 0; /*f < jsonProductos.length()*/; f++) {
                                Object[] fila = new Object[9];
                                fila[0] = jsonClientes.getJSONObject("" + f + "").get("codigo").toString();
                                fila[1] = jsonClientes.getJSONObject("" + f + "").get("descripcion").toString();
                                fila[2] = jsonClientes.getJSONObject("" + f + "").get("ruc").toString();
                                fila[3] = jsonClientes.getJSONObject("" + f + "").get("telefono").toString();
                                fila[4] = jsonClientes.getJSONObject("" + f + "").get("contacto").toString();
                                fila[5] = jsonClientes.getJSONObject("" + f + "").get("celular").toString();
                                fila[6] = jsonClientes.getJSONObject("" + f + "").get("ciudad").toString();
                                fila[7] = jsonClientes.getJSONObject("" + f + "").get("direccion").toString();
                                fila[8] = jsonClientes.getJSONObject("" + f + "").get("observacion").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });

            clientes.excecute(urlServer() + "getfilRazonSProveedor.php?param=" + caden);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void filID(JTable tabla, String cod) {
        List lista;
        lista = GestionarProveedor.filID(cod);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }

    public static void filRuc(JTable tabla, String cod) {
        List lista;
        lista = GestionarProveedor.filRuc(cod);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }

}
