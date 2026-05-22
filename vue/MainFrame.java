package vue;
import java.awt.List;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.Ordi;
import model.Personne;

public class MainFrame extends JFrame {
    
    public MainFrame() {
        this.setSize(200, 200);
        this.setLocationRelativeTo(null);

        FormCreatePannel formCreate = new FormCreatePannel(Personne.class);
        this.add(formCreate);
        
        Personne p1 = new Personne("Soa", "Fara",19, 1.65,Date.valueOf("2026-01-01"));
        Personne p2 = new Personne("Rakoto", "Bema",20, 1.70,Date.valueOf("2026-02-02"));

        ArrayList<Personne> personnes = new ArrayList<>();
        personnes.add(p1);
        personnes.add(p2);

        ListPannel<Personne> listPannel = new ListPannel<>(Personne.class);
        try {
            listPannel.showList(personnes);
        } catch (NoSuchFieldException | SecurityException | NoSuchMethodException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
        this.add(listPannel);


        this.setVisible(true);
    }
}
