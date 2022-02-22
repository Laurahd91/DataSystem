
package swing;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import vista.ClienteRegistrado;

/**
 *
 * @author laura
 */
public class TableHeader extends JLabel {

    public TableHeader(String text) {
        //Damos formato al Header de nuestra tabla
        super(text);
        setOpaque(true);
        setBackground(Color.WHITE);
        setFont(new Font("sanserif", 1, 12));
        setForeground(new Color(102, 102, 102));
        setBorder(new EmptyBorder(10, 5, 10, 5));
    }
}
