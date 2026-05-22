package vue;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import util.GenUtil;
import util.ObjectMaping;

public class ListPannel<T> extends JPanel {

    private ObjectMaping objectMaping;

    public ListPannel(Class<T> class1) {
        this.setSize(500,500);
        this.objectMaping = ObjectMaping.get(class1);
    }

    public void showList(List<T> elements) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.removeAll();
        String[] headers = objectMaping.getcolumns();
        Object[][] rows = listToTabObject(elements);
        
        DefaultTableModel model = new DefaultTableModel(rows,headers);
        JTable table = new JTable(model);
        this.add(table);
    }

    public  Object[][] listToTabObject(List<T> elements) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        //recuperer les informantion de colone
        ArrayList<Object[]> rowsLists = new ArrayList<>();
        for (Object el : elements) {
            Object[] fieldsValues = GenUtil.getFieldsValues(el);
            rowsLists.add(fieldsValues);
        }

        return rowsLists.toArray(new Object[0][]);
    }
}