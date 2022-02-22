
package swing;

import java.awt.Component;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author laura
 */
public class Table extends JTable {

    // Creamos objeto cellRenderer
    DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();

    public Table() {
        // Damos formato a nuestra tabla
        setShowHorizontalLines(true);
        setBackground(Color.WHITE);
        setFont(new Font("sanserif", 1, 12));
        setForeground(new Color(102, 102, 102));
        setBorder(new EmptyBorder(10, 5, 10, 5));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean bln, boolean blnl, int i, int il) {
                
                //Centramos los componentes de la tabla
                cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
                table.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
                table.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
                table.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
                table.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
                
                // Devolvemos la tabla
                return super.getTableCellRendererComponent(table, o, bln, blnl, i, il);

            }
        });

    }
}
