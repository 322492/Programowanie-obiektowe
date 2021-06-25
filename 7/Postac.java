//autor: Kamil Tasarz

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Postac implements Serializable {

    String sila;
    String zrecznosc;
    String ekwipunek;

    public Postac() {
        sila = Integer.toString((int) (Math.random() * 100));
        zrecznosc = Integer.toString((int) (Math.random() * 100));
    }

    public Postac(String s, String z, String e) {
        sila = s;
        zrecznosc = z;
        ekwipunek = e;
    }

    public String toString() {
        return "Twoja postać ma statystyki: " + sila + "/" + zrecznosc + "i posiada: " + ekwipunek;
    }
}

class Czlowiek extends Postac {

    public Czlowiek() {
        sila = Integer.toString((int) (Math.random() * 100));
        zrecznosc = Integer.toString((int) (Math.random() * 100));
        ekwipunek = "miecz";
    }

    public Czlowiek(String s, String z, String e) {
        sila = s;
        zrecznosc = z;
        ekwipunek = e;
    }

    public String toString() {
        return "Twoja postać to człowiek o statystykach: " + sila + "/" + zrecznosc + "i posiada: " + ekwipunek;
    }
}

class Elf extends Postac {

    public Elf() {
        sila = Integer.toString((int) (Math.random() * 100));
        zrecznosc = Integer.toString((int) (Math.random() * 100));
        ekwipunek = "łuk";
    }

    public Elf(String s, String z, String e) {
        sila = s;
        zrecznosc = z;
        ekwipunek = e;
    }

    public String toString() {
        return "Twoja postać to elf o statystykach: " + sila + "/" + zrecznosc + "i posiada: " + ekwipunek;
    }
}