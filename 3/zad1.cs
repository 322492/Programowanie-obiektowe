// Kamil Tasarz, 322492
using System;
using System.Collections.Generic;
using System.Text;

namespace zad1
{
    public class Node<T> //wezel listy
    {
        public T value;
        public Node<T> next;
        public Node<T> prev;

        public Node()
        {
            next = null;
            prev = null;
        }
    }

    public class Lista<T>
    {
        protected Node<T> pierwszy;
        protected Node<T> ostatni;

        public Lista()
        {
            pierwszy = null;
            ostatni = null;
        }

        public void push_front(T elem)
        {
            if (pierwszy == null)
            {
                pierwszy = new Node<T>();
                pierwszy.value = elem;
                ostatni = pierwszy;
            }
            else
            {
                Node<T>  nowy = new Node<T>();
                nowy.value = elem;
                nowy.next = null;
                pierwszy.next = nowy;
                nowy.prev = pierwszy;
                pierwszy = nowy;
            }
        }

        public void push_back(T elem)
        {
            if (ostatni == null)
            {
                ostatni = new Node<T>();
                ostatni.value = elem;
                pierwszy = ostatni;
            }
            else
            {
                Node<T> nowy = new Node<T>();
                nowy.value = elem;
                ostatni.prev = nowy;
                nowy.next = ostatni;
                nowy.prev = null;
                ostatni = nowy;
            }

        }

        public T pop_front()
        {
            if (pierwszy == null)
            {
                Console.WriteLine("Pusta lista!");
                return default(T);
            }
            else
            {
                T wyn = pierwszy.value;
                if(pierwszy.prev == null)pierwszy = null;
                else{
                pierwszy = pierwszy.prev;
                pierwszy.next = null;
                }
                return wyn;
            }
        }

        public T pop_back()
        {
            if (ostatni == null)
            {
                Console.WriteLine("Pusta lista!");
                return default(T);
            }
            else
            {
                T wyn = ostatni.value;
                if(ostatni.next == null)ostatni = null;
                else{
                ostatni = ostatni.next;
                ostatni.prev = null;
                }
                return wyn;
            }
        }

        public bool is_empty()
        {
            if (pierwszy == null || ostatni == null)
                return true;
            else
                return false;
        }

        public void pokaz()
        //metoda dodana z wlasnej inicjatywy - wypisuje aktualna liste od poczatku do konca w jedenj linii
        //znacznie zwieksza atrakcyjnosc programu pokazujacego mozliwosci kodu
        //oczywiscie nie dziala zawsze, bo nie zawsze T value jest wypisywalne w taki sposob jak ponizej
        {
            Node<T> a = pierwszy;
            if(a == null)return;
            Console.Write("lista: ");
            while (a.prev != null)
            {
                Console.Write(a.value);
                Console.Write(" ");
                a = a.prev;
            }
            Console.Write(a.value);
            Console.Write(" \n");
        }

    }
}