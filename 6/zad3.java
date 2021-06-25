//autor: Kamil Tasarz

import java.io.*;
import java.util.*;

class Bufor<T> {
    T[] tab;
    int ile, pocz, poj;

    public Bufor(int rozm) {
        tab = (T[]) new Object[rozm];
        ile = 0;
        pocz = 0;
        poj = rozm;
    }

    private void zwolnij() { // metoda służy tylko do spowolnienia wypisywania wyników programu
        try {
            Thread.sleep(250);
        } catch (InterruptedException ex) {
        }
    }

    public synchronized void push(T elem) {
        if (ile < poj) {
            System.out.println("Producent włożył: " + elem);
            tab[(pocz + ile) % poj] = elem;
            ile++;
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        zwolnij();
        notifyAll();
    }

    public synchronized T pop() {
        if (ile > 0) {
            T wyn = tab[pocz];
            pocz = (pocz + 1) % poj;
            ile--;
            zwolnij();
            notifyAll();
            return wyn;
        } else {
            System.out.println("                       bufor jest pusty!");
            try {
                wait();
            } catch (InterruptedException e) {
            }
            zwolnij();
            notifyAll();
            return null;
        }
    }
}

class Konsument<T> implements Runnable {
    private Bufor b;

    public Konsument(Bufor b) {
        this.b = b;
    }

    public void run() {
        while (true) {
            T elem = (T) b.pop();
            if (elem != null)
                System.out.println("                       Konsument zjadł: " + elem);
        }
    }
}

class Producent implements Runnable {
    private Bufor b;

    public Producent(Bufor b) {
        this.b = b;
    }

    public void run() {
        while (true) {
            String elem = Integer.toString((int) (Math.random() * 1000));
            b.push(elem);
        }
    }
}

public class zad3 {
    public static void main(String[] args) {

        Bufor b = new Bufor(7);
        Producent p = new Producent(b);
        Konsument c = new Konsument(b);
        Thread prod = new Thread(p);
        Thread cons = new Thread(c);
        prod.start();
        cons.start();
    }
}
