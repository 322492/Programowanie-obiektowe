// Kamil Tasarz, 322492
using System;
using System.Collections.Generic;
using System.Text;
using zad2;

namespace zad2
{
    class Program
    {
        static void Main(string[] args)
        {
            MyDictionary<int, string> s = new MyDictionary<int, string>();
            s.dodaj(12, "jedenascie");
            s.dodaj(8, "osiem");
            s.dodaj(12, "dwanascie");
            s.dodaj(5, "piec");
            s.dodaj(0, "zero");

            Console.WriteLine(s.szukaj(12));
            Console.WriteLine(s.szukaj(0));
            Console.WriteLine(s.szukaj(8));
            Console.WriteLine(s.usun(5));
            Console.WriteLine(s.usun(0));
            Console.WriteLine(s.usun(7));
        }
    }
}
