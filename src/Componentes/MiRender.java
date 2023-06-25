package Componentes;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MiRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        int cant = Integer.parseInt(table.getValueAt(row, 8).toString());
        int cantmin = Integer.parseInt(table.getValueAt(row, 9).toString());
        String venta = (table.getValueAt(row, 17).toString());
        if (cant < cantmin) {
            this.setOpaque(true);
            this.setBackground(new java.awt.Color(255,255,118));
            this.setForeground(Color.BLACK);
        if (cant == 0) {
            this.setOpaque(true);
            this.setBackground(new java.awt.Color(255,63,63));
            this.setForeground(Color.BLACK);
            
        }
        }else if(venta.equals("CONTROLADO")){
            this.setOpaque(true);
            this.setBackground(new java.awt.Color(83,83,253));
            this.setForeground(Color.BLACK);
            
        }else {
            this.setOpaque(false);
            //this.setBackground(new java.awt.Color(210,229,235));
           // this.setForeground(Color.GREEN);
        }
        return this;
    }

}

