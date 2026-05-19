package vue;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import util.CastUtil;
import util.GenUtil;
import util.ObjectMaping;
import util.exeption.IncastableClassExeption;
import java.awt.event.ActionListener;

public class CrudPanel extends JPanel {

    private HashMap<String, JTextArea> columnsInputs;
    private Class<?> class1;
    private JButton submitBtn;

    public CrudPanel(Class<?> class1) {
        this.setSize(500, 500);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.class1 = class1;
        this.columnsInputs = new HashMap<>();

        //cree les inputs des atributs
        this.buildInputColumns();

        // ajout du bouton submit
        this.submitBtn = new JButton("Valider");
        this.add(submitBtn);

        //teste de bontion submit
        this.addActionListnerOnSubmit( ev -> {
            try {
                System.out.println(this.getObject().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void addActionListnerOnSubmit(ActionListener e) {
        this.submitBtn.addActionListener(e);
    }

    private void buildInputColumns() {
        ObjectMaping objectMaping = ObjectMaping.toObjetMap(class1);
        String[] colunms = objectMaping.getcolumns();
        for (String col : colunms) {
            JLabel label = new JLabel(col + " : ");
            JTextArea textArea = new JTextArea(5, 15);
            this.columnsInputs.put(col, textArea);
            this.add(label);
            this.add(textArea);
        }
    }

    public Object getObject()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, IncastableClassExeption, NoSuchFieldException {
        Object intance = this.class1.getConstructor().newInstance();
        HashMap<String, Object> columsValues = new HashMap<>();
        for (Map.Entry<String, JTextArea> entry : columnsInputs.entrySet()) {
            // recuperer le type de l atributs
            Class<?> typeAtribut = GenUtil.getAttributsType(class1, entry.getKey());
            columsValues.put(entry.getKey(), CastUtil.valueOf(typeAtribut, entry.getValue().getText()));
        }
        GenUtil.setAtributs(intance, columsValues);
        return intance;
    }
}
