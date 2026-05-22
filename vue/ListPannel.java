package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import util.GenUtil;
import util.ObjectMaping;

public class ListPannel<T> extends JPanel {

    private ObjectMaping objectMaping;

    public ListPannel(Class<T> class1,Dimension size) {
        this.setPreferredSize(size);
        this.objectMaping = ObjectMaping.get(class1);
        this.setLayout(new BorderLayout());
    }

    public void showList(List<T> elements) throws NoSuchFieldException, SecurityException, NoSuchMethodException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.removeAll();
        String[] headers = objectMaping.getcolumns();
        Object[][] rows = listToTabObject(elements);

        DefaultTableModel model = new DefaultTableModel(rows, headers);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane,BorderLayout.CENTER);
    }

    public Object[][] listToTabObject(List<T> elements) throws NoSuchFieldException, SecurityException,
            NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // recuperer les informantion de colone
        ArrayList<Object[]> rowsLists = new ArrayList<>();
        for (Object el : elements) {
            Object[] fieldsValues = GenUtil.getFieldsValues(el);
            rowsLists.add(fieldsValues);
        }

        return rowsLists.toArray(new Object[0][]);
    }
}