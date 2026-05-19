package vue;
import javax.swing.JFrame;

import model.Personne;

public class MainFrame extends JFrame {
    
    public MainFrame() {
        this.setSize(200, 200);
        this.setLocationRelativeTo(null);

        CrudPanel crudPanel = new CrudPanel(Personne.class);
        this.add(crudPanel);
        this.setVisible(true);
    }
}
