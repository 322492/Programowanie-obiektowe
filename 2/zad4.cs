// Kamil Tasarz, 322492

using System;
using System.Collections.Generic;
using System.Text;

class ListaLeniwa
{
    protected List<int> lista = new List<int>();

    public virtual int element(int x)
    {
        if (lista.Count == 0) lista.Add(-1); // o ile zrozumialem tresc zadania to lista jest indeksowana od 1 i nie mozna odwolac sie do elementu pod indeksem 0
        if(x <= 0) //blad
        {
            Console.WriteLine("podano zly indeks");
            return -1;
        }
        if (x > lista.Count)
        {
            for (int i = lista.Count; i <= x; i++)
                lista.Add(i); //pod indeksem i jest wartosc i
        }
        return lista[x];
    }

    public int size()
    {
        if (lista.Count == 0) return 0; // jak jest pusta
        return lista.Count - 1; //odejmuje 1, bo indeksuje od 1, a nie od 0
    }
}

class Pierwsze : ListaLeniwa
{
    public override int element(int x)
    {
        if (lista.Count == 0) lista.Add(1); //tutaj rowniez nie odwoluje sie do elementu 0, indeksuje od 1
        if(x <= 0)
        {
            Console.WriteLine("podano zly indeks");
            return -1;
        }
        while (x >= lista.Count || x > 105097565) //ta dziwna liczba to liczba liczb pierwszych mieszczacych sie w zakresie int
        {
            for (int i = lista[lista.Count - 1] + 1; i < Int32.MaxValue; i++) // przechowuje liczby pierwsze maksymalnie z zakresu inta
            {
                if (pierwsza(i))
                {
                    lista.Add(i);
                    break;
                }
            }
            if( x >= 105097565)break; // wykraczalbym poza zakres inta
        }
        if (x <= lista.Count)
            return lista[x];
        else
        {
            Console.WriteLine("nie potrafie znalezc {0}. liczby pierwszej", x);
            return -1;
        }
    }

    private bool pierwsza(int x) //sprawdzam czy x jest liczba pierwsza (czas pierwiastkowy od x)
    {
        for (int i = 2; i <= Math.Sqrt(x); i++)
        {
            if (x % i == 0)
                return false;
        }
        return true;
    }
}

namespace zad4
{
    class Program
    {
        static void Main(string[] args)
        {
            // krotkie testy, wystarczy odkomentowac
            /*
            ListaLeniwa cas = new ListaLeniwa();
            ListaLeniwa ext = new Pierwsze();
            Console.WriteLine("liczby naturalne:");
            Console.WriteLine("rozmiar: {0} ", cas.size());
            Console.WriteLine("element {0} to: {1} ", 8, cas.element(8));
            Console.WriteLine("rozmiar: {0} ", cas.size());
            Console.WriteLine("element {0} to: {1} ", 567, cas.element(567));
            Console.WriteLine("rozmiar: {0} ", cas.size());
            Console.WriteLine("element {0} to: {1} ", 235, cas.element(235));
            Console.WriteLine("rozmiar: {0} ", cas.size());

            Console.WriteLine("\nliczby pierwsze:");
            Console.WriteLine("rozmiar: {0} ", ext.size());
            Console.WriteLine("element {0} to: {1} ", 1, ext.element(1));
            Console.WriteLine("rozmiar: {0} ", ext.size());
            Console.WriteLine("element {0} to: {1} ", 432, ext.element(432));
            Console.WriteLine("rozmiar: {0} ", ext.size());
            Console.WriteLine("element {0} to: {1} ", 5, ext.element(5));
            Console.WriteLine("rozmiar: {0} ", ext.size());
            */
        }
    }
}
