// Kamil Tasarz, 322492
using System;
using System.Collections.Generic;
using System.Text;

class IntStream
{
    protected int licznik = 0;
    protected bool end = false;

    public virtual int next()
    {
        if (!end)
        {
            licznik++;
            if (licznik == Int32.MaxValue) end = true;
            return licznik;
        }
        else
        {
            Console.WriteLine("koniec strumienia!");
            return -1;
        }
    }

    public virtual bool eos()
    {
        return end;
    }

    public virtual void reset()
    {
        licznik = 0;
        end = false;
        return;
    }
}

class PrimeStream : IntStream
{
    public override int next()
    {
        if (!end)
        {
            for (int i = this.licznik + 1; i <= Int32.MaxValue; i++)
            {
                if (pierwsza(i))
                {
                    this.licznik = i;
                    if (this.licznik == Int32.MaxValue) end = true;
                    return this.licznik;
                }
            }
            return 0; // bez tego mam "error CS0161: `PrimeStream.next()': not all code paths return a value"
            // Nie powinienem nigdy dojsc do tego miejsca, bo bede zawsze zwracal wartosc licznik z if albo -1 z else
        }
        else
        {
            Console.WriteLine("koniec strumienia!");
            return -1;
        }
    }

    private bool pierwsza(int x) //sprawdzam czy x jest liczba pierwsza (czas pierwiastkowy od x)
    {
        if(x < 2)return false;
        for (int i = 2; i <= Math.Sqrt(x); i++)
        {
            if (x % i == 0) return false;
        }
        return true;
    }

}

class RandomStream : IntStream
{
    Random rnd = new Random();

    public override int next()
    {
        return rnd.Next();
    }

    public override bool eos()
    {
        return false;
    }
}

class RandomWordStream
{
    private PrimeStream p = new PrimeStream();
    private RandomStream r = new RandomStream();

    public string next()
    {
        if (!p.eos())
        {
            return generuj(p.next());
        }
        else
        {
            return "Zadasz zbyt dlugiego napisu!";
        }
    }

    public void reset()
    {
        p.reset();
        return;
    }

    private string generuj(int x){
        string w = "";
        for(int i = 0; i < x; i++)
        w += (char)( r.next() % 93 + 33);
        return w;
    }
}

namespace zad1
{
    class Program
    {
        static void Main(string[] args)
        {
            //krotki test do ewentualnego odkomentowania
            /*
            IntStream a = new IntStream();
            Console.WriteLine("troche liczb naturalnych: ");
            for(int i=0; i<=37; i++)
            Console.Write("{0} ", a.next());

            a.reset();
            Console.WriteLine("\ni po resecie: ");

            for(int i=0; i<=17; i++)
            Console.Write("{0} ", a.next());

            PrimeStream p = new PrimeStream();
            Console.WriteLine("\n\ntroche liczb pierwszych: ");
            for(int i=0; i<=23; i++)
            Console.Write("{0} ", p.next());

            p.reset();

            Console.WriteLine("\ni po resecie: ");
            for(int i=0; i<=17; i++)
            Console.Write("{0} ", p.next());

            RandomStream r = new RandomStream();
            Console.WriteLine("\n\ntroche liczb losowych: ");
            for(int i=0; i<=20; i++)
            Console.WriteLine("{0} ", r.next());


            Console.WriteLine("\n\nlosowe slowa o dlugosci kolejnych liczb pierwszych: ");
            RandomWordStream rws = new RandomWordStream();
            for (int i = 0; i <= 10; i++)
            {
                Console.WriteLine(rws.next());
            }
            */
        }
    }
}
