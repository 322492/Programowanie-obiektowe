//autor: Kamil Tasarz

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PostacWidok extends JFrame implements ActionListener, Serializable {

    public JButton zapisz;
    public JTextField sila, zrecznosc, ekwipunek;
    Postac p;
    File plik;

    public PostacWidok(String nazwa, String klasa) {
        initWidok();

        p = new Postac();
        plik = new File(nazwa);
        readFromFile(plik);
    }

    private void readFromFile(File f) {
        try {
            FileReader czytacz = new FileReader(f);
            BufferedReader buff = new BufferedReader(czytacz);
            p.sila = buff.readLine();
            p.zrecznosc = buff.readLine();
            p.ekwipunek = buff.readLine();

            sila.setText(p.sila);
            zrecznosc.setText(p.zrecznosc);
            ekwipunek.setText(p.ekwipunek);

        } catch (Exception e) {
            p = new Postac();

            sila.setText(p.sila);
            zrecznosc.setText(p.zrecznosc);
            ekwipunek.setText(p.ekwipunek);
        }
    }

    private void writeToFile(File f) {
        try {
            FileWriter skryba = new FileWriter(f);
            skryba.write(sila.getText() + "\n" + zrecznosc.getText() + "\n" + ekwipunek.getText());
            skryba.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == zapisz) {
            writeToFile(plik);
        }
    }

    private void initWidok() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocation(50, 50);
        setLayout(new GridLayout(4, 2));

        JLabel tabs = new JLabel("Siła:");
        add(tabs);
        sila = new JTextField("");
        add(sila);

        JLabel tabz = new JLabel("Zręczność:");
        add(tabz);
        zrecznosc = new JTextField("");
        add(zrecznosc);

        JLabel tabe = new JLabel("Ekwipunek:");
        add(tabe);
        ekwipunek = new JTextField("");
        add(ekwipunek);

        zapisz = new JButton("Zapisz");
        add(zapisz);

        zapisz.addActionListener(this);
        setVisible(true);
    }
}