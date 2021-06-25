//Kamil Tasarz 322492
using System;
using System.Collections;
using System.Collections.Generic;

namespace zad2
{
    class PrimeEnum : IEnumerator
    {
        private int np;

        public PrimeEnum()
        {
            np = 1;
        }

        private bool czy_piewsza(int a)
        {
            for (int i = 2; i <= Math.Sqrt(a); i++)
            {
                if (a % i == 0) return false;
            }
            return true;
        }

        public bool MoveNext()
        {
            // if (np > 100) return false; // sztuczne ograniczenie wielkosci zwracanych liczb
            if (np == int.MaxValue) return false;
            np++;
            while (!czy_piewsza(np)) np++;
            return true;
        }

        public object Current
        {
            get
            {
                return np;
            }
        }

        public void Reset()
        {
            np = 1;
        }
    }

    public class PrimeCollection : IEnumerable
    {
        public IEnumerator GetEnumerator()
        {
            return new PrimeEnum();
        }
    }

    class Program
    {
        static void Main()
        {
            PrimeCollection pc = new PrimeCollection();
            foreach (int p in pc)
            {
                Console.WriteLine (p);
            }
        }
    }
}
