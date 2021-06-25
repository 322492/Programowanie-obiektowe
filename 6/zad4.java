import java.io.*;
import java.util.*;

class MergeSort<T> implements Runnable {
    private Comparable[] t;

    public MergeSort(Comparable[] t) {
        this.t = (Comparable[])t;
    }

    private <T extends Comparable<T>> void Merge(Comparable[] tab, Comparable[] L, Comparable[] P) {
        int i = 0, j = 0; // aktualne indeksy w tablicach lewej i prawej
        int akt = 0; // aktualne uzupelniane miejsce w tablicy tab
        while (i < L.length && j < P.length) {
            if (L[i].compareTo(P[j]) <= 0) {
                tab[akt] = L[i];
                i++;
            } else {
                tab[akt] = P[j];
                j++;
            }
            akt++;
        }
        while (i < L.length) {
            tab[akt] = L[i];
            i++;
            akt++;
        }
        while (j < P.length) {
            tab[akt] = P[j];
            j++;
            akt++;
        }
    }

    private <T extends Comparable<T>> void Sort(T[] tab) {
        if (tab.length <= 1) return;

            int s = tab.length / 2;
            Comparable L[] = new Comparable[s];
            Comparable P[] = new Comparable[tab.length-s];
            System.arraycopy(tab, 0, L, 0, s);
            System.arraycopy(tab, s, P, 0, tab.length-s);

            Thread TL = new Thread(new MergeSort(L));
            Thread TP = new Thread(new MergeSort(P));
            TL.start();
            TP.start();
            try {
                TL.join();
                TP.join();
            } catch (InterruptedException e) {
                System.out.print("Coś sie bardzo zepsuło!");
            }

            Merge(tab, L, P);
    }

    public void run() {
        Sort(t);
    }

}

public class zad4 {
    public static void main(String[] args) {
        //poniższe testy można odkomentować w razie chęci sprawdzenia dla innych typów danych w tablicy
        Integer[] tab = { 3, 7, 4, 6, 5, 2, 8, 7, 0, 1};
        //Character[] tab = {'x', 'a', 'p', 'p', 'b', 's', 'd'};
        //String[] tab = {"3, 2, 1", "param", "pam", "pam", "a", "xd", "krowa"};
        
        MergeSort m = new MergeSort(tab);
        Thread t = new Thread(m);

        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.print("\n");

        t.start();
        try { //ogarnia kolejność robienia wątków, sprawia, że ten czeka, aż wszystkie w nim wywołane się zakończą - bez tego sortowanie nie działa
            t.join();
        } catch (InterruptedException e) {
            System.out.print("Coś sie bardzo zepsuło!");
        }

        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.print("\n");
    }
}
