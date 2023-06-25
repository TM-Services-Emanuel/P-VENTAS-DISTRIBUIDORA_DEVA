package Controladores;

import IU.frmPrincipal;

public class controlPerfil {

    public static void perfil() {
        String perf = ControlLogeo.perfil();
        if (perf.equalsIgnoreCase("ALMACEN"))
        {
            frmPrincipal.btnClientes.setVisible(false);
            //frmPrincipal.btnProveedores.setVisible(false);
            //frmPrincipal.btnCompras.setVisible(false);
            //frmPrincipal.btnVentas.setVisible(false);
            frmPrincipal.mnCompras.setVisible(false);
            frmPrincipal.mnVentas.setVisible(false);
            frmPrincipal.mnMantenimiento.setVisible(false);
            frmPrincipal.mnCaja.setVisible(false);
            frmPrincipal.rpVentas.setVisible(false);
            frmPrincipal.rpCompras.setVisible(false);
            frmPrincipal.rpClientes.setVisible(false);
            frmPrincipal.rpVendedores.setVisible(false);
            frmPrincipal.mnNCProveedor.setVisible(false);
            
            frmPrincipal.mnGNCVenta.setVisible(false);
            frmPrincipal.mnComision.setVisible(false);
            frmPrincipal.mnConfiguracion.setVisible(false);
            frmPrincipal.smModUsuariosD.setVisible(false);
            frmPrincipal.mnGsIn.setVisible(false);
            
        } else if (perf.equalsIgnoreCase("COMPRA"))
        {
            //frmPrincipal.btnIMD.setVisible(false);
            //frmPrincipal.btnVentas.setVisible(false);
            frmPrincipal.btnClientes.setVisible(false);
            frmPrincipal.mnProductos.setVisible(false);
            frmPrincipal.mnVentas.setVisible(false);
            frmPrincipal.mnClientes.setVisible(false);
            frmPrincipal.mnEmpleados.setVisible(false);
            frmPrincipal.mnSeguridad.setVisible(false);
            frmPrincipal.mnCaja.setVisible(false);
            frmPrincipal.rpVentas.setVisible(false);
            frmPrincipal.rpArticulos.setVisible(false);
            frmPrincipal.rpClientes.setVisible(false);
            frmPrincipal.rpVendedores.setVisible(false);
            frmPrincipal.mnNCProveedor.setVisible(false);
            frmPrincipal.mnGNCVenta.setVisible(false);
            frmPrincipal.mnComision.setVisible(false);
            frmPrincipal.mnConfiguracion.setVisible(false);
            frmPrincipal.smModUsuariosD.setVisible(false);
            frmPrincipal.mnGsIn.setVisible(false);
            frmPrincipal.mnTransferencias.setVisible(false);
            //frmPrincipal.btnTransferencia.setVisible(false);
        } else if (perf.equalsIgnoreCase("VENTA"))
        {
            //frmPrincipal.btnIMD.setVisible(false);
            //frmPrincipal.btnProveedores.setVisible(false);
            //frmPrincipal.btnCompras.setVisible(false);
            frmPrincipal.mnEmpleados.setVisible(false);
            frmPrincipal.mnProveedores.setVisible(false);
            frmPrincipal.mnSeguridad.setVisible(false);
            frmPrincipal.mnProductos.setVisible(false);
            frmPrincipal.mnCompras.setVisible(false);
            frmPrincipal.rpCompras.setVisible(false);
            frmPrincipal.rpArticulos.setVisible(false);
            frmPrincipal.rpClientes.setVisible(false);
            frmPrincipal.rpVendedores.setVisible(false);
            frmPrincipal.mnNCProveedor.setVisible(false);
            frmPrincipal.mnGNCVenta.setVisible(false);
            frmPrincipal.mnComision.setVisible(false);
            frmPrincipal.mnConfiguracion.setVisible(false);
            frmPrincipal.smModUsuariosD.setVisible(false);
            frmPrincipal.mnGVE.setVisible(false);
            frmPrincipal.mnCaja.setVisible(false);
            frmPrincipal.S1.setVisible(false);
            frmPrincipal.mnLogistica.setVisible(false);
            frmPrincipal.S3.setVisible(false);
            frmPrincipal.divisor3.setVisible(false);
            frmPrincipal.divisor4.setVisible(false);
            frmPrincipal.S7.setVisible(false);
            frmPrincipal.mnReparto.setVisible(false);
            //frmPrincipal.btnIMD.setVisible(false);
            //frmPrincipal.btnCMD.setVisible(false);
            //frmPrincipal.btnGestionarCompras.setVisible(false);
            //frmPrincipal.btnSalidaP.setVisible(false);
            //frmPrincipal.btnRepartos.setVisible(false);
            frmPrincipal.mnGsIn.setVisible(false);
            frmPrincipal.mnTransferencias.setVisible(false);
           // frmPrincipal.btnTransferencia.setVisible(false);
            
        } else if (perf.equalsIgnoreCase("ADMINISTRADOR")) {
            frmPrincipal.mnComision.setVisible(false);
            frmPrincipal.mnConfiguracion.setVisible(false);
            frmPrincipal.smModUsuariosD.setVisible(false);
        } else if (perf.equalsIgnoreCase("DESARROLLADOR")) {
            //frmPrincipal.btnIMD.setVisible(true);
            //frmPrincipal.btnProveedores.setVisible(true);
            //frmPrincipal.btnCompras.setVisible(true);
            frmPrincipal.btnClientes.setVisible(true);
            //frmPrincipal.btnVentas.setVisible(true);
            frmPrincipal.mnMantenimiento.setVisible(true);
            frmPrincipal.mnProductos.setVisible(true);
            frmPrincipal.mnCompras.setVisible(true);
            frmPrincipal.mnVentas.setVisible(true);
            frmPrincipal.mnCaja.setVisible(true);
            frmPrincipal.mnComision.setVisible(true);
            frmPrincipal.mnConfiguracion.setVisible(true);
            frmPrincipal.mnGsIn.setVisible(true);
        }else {
           // frmPrincipal.btnIMD.setVisible(false);
            //frmPrincipal.btnProveedores.setVisible(false);
            //frmPrincipal.btnCompras.setVisible(false);
            frmPrincipal.btnClientes.setVisible(false);
            //frmPrincipal.btnVentas.setVisible(false);
            frmPrincipal.mnMantenimiento.setVisible(false);
            frmPrincipal.mnProductos.setVisible(false);
            frmPrincipal.mnCompras.setVisible(false);
            frmPrincipal.mnVentas.setVisible(false);
            frmPrincipal.mnCaja.setVisible(false);
            frmPrincipal.mnComision.setVisible(false);
            frmPrincipal.mnConfiguracion.setVisible(false);
            frmPrincipal.smModUsuariosD.setVisible(false);
            frmPrincipal.mnGsIn.setVisible(false);
        }
    }

}
