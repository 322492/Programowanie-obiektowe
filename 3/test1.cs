// Kamil Tasarz, 322492
using System;
using System.Collections.Generic;
using System.Text;
using zad1;

class Program
{
    static void Main(string[] args)
    {
        Lista<int> s = new Lista<int>();
        for (int i = 1; i <= 7; i++)
            s.push_front (i);
        
        s.pokaz(); //opis w pliku dll

        for (int i = 1; i <= 7; i++)
            s.push_back (i);
        
        s.pokaz();

        for (int i = 1; i <= 6; i++)
        {
            Console.Write("usuwam: ");
            Console.Write(s.pop_front());
            Console.Write(" i ");
            Console.Write(s.pop_back());
            Console.Write("\n");
            s.pokaz();
        }

        Console.Write("czy pusta?: ");
        Console.Write(s.is_empty());
        Console.Write("\n");
        Console.Write("usuwam: ");
        Console.Write(s.pop_front());
        Console.Write(" \n");
        s.pokaz();
        Console.Write("usuwam: ");
        Console.Write(s.pop_front());
        Console.Write(" \n");
        Console.Write("czy pusta?: ");
        Console.Write(s.is_empty());
        Console.Write(" \n");
        Console.Write(s.pop_front());
    }
}
