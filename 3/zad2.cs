// Kamil Tasarz, 322492
using System;
using System.Collections.Generic;
using System.Text;

namespace zad2
{

public class Node<K, V> //wezel listy slownikowej
{
    public K key;
    public V value;
    public Node<K, V> next;

    public Node()
    {
        next = null;
    }
    public Node(K klucz, V wart){
        next = null;
        key = klucz;
        value = wart;
    }
}

    public class MyDictionary<K, V>
    {
        protected Node<K, V> akt;
        public MyDictionary()
        {
            akt = null;
        }

        public void dodaj(K key, V value)
        {
            Node<K, V> c = akt;
            while(c != null){
                if(c.key.Equals(key)){
                    c.value = value;
                    Console.WriteLine("obiekt o zadanym kluczu juz istnial - zaktualizowano jego wartosc");
                    return;
                }
                c = c.next;
            }
            Node<K, V> nowy = new Node<K, V>(key, value);
            c = akt;
            nowy.next = c;
            akt = nowy;
        }

        public V szukaj(K key)
        {
            Node<K, V> c = akt;
            while(c != null){
                if(c.key.Equals(key)){
                    return c.value;
                }
                c = c.next;
            }
            Console.WriteLine("brak elementu o szukanym kluczu");
            return default(V);
        }

        public V usun(K key)
        {
            Node<K, V> c = akt;
            if(c.key.Equals(key)){
                V wyn = c.value;
                akt = c.next;
                return wyn;
            }
            while(c.next != null){
                if(c.next.key.Equals(key)){
                    V wyn = c.next.value;
                    c = c.next.next;
                    return wyn;
                }
                c = c.next;
            }
            Console.WriteLine("brak elementu o szukanym kluczu");
            return default(V);
        }
    }
}