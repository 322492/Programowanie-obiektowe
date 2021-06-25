class Collection

    def initialize()
        @tab = []
    end

    def add(x) #dodawanie elementow do kolekcji
        @tab.push(x)
    end

    def daj(n) #metoda do testow zwracajaca losowa kolekcje n elementow
        n.times{@tab.push(rand(100))}
    end

    def length()
        return @tab.length
    end

    def get(i)
        return @tab[i]
    end

    def swap(i, j)
        @tab[i], @tab[j] = @tab[j], @tab[i]
    end

    def show() #metoda do wypisywania kolekcji
        @tab.to_s
    end

    def ustaw(i, x) #metoda pomocna przy merge_sort do przepisywania kolekcji
       @tab[i] = x
    end

end

class Sorter

    def bubble_sort(kol)

        for i in 0...kol.length()
            for j in 1...kol.length() - i
                if (kol.get(j) < kol.get(j - 1))
                    kol.swap(j, j - 1)
                end
            end
        end
    end

    def merge_sort(kol)
        msort(kol, 0, kol.length()-1)
    end

    def msort(kol, l, p)
        if p != l
            s = (l + p) / 2;
            msort(kol, l, s)
            msort(kol, s + 1, p)
            merge(kol, l, s + 1, s, p)
        end
    end

    def merge(kol, pocz1, pocz2, kon1, kon2)
        wyn = Collection.new()
        i = pocz1
        j = pocz2
        
        while (i <= kon1 && j <= kon2)
            if kol.get(i) < kol.get(j)
                wyn.add(kol.get(i))
                i += 1
            else
                wyn.add(kol.get(j))
                j += 1
            end
        end

        while i <= kon1
            wyn.add(kol.get(i))
            i += 1
        end

        while j <= kon2
            wyn.add(kol.get(j))
            j += 1
        end

        for i in 0...wyn.length()
            kol.ustaw(pocz1 + i, wyn.get(i))
        end
    end

    private :msort, :merge

end

#test

a = Collection.new()
b = Collection.new()
a.daj(10);
b.daj(10);


print a.show(), "    ", b.show(), "\n"

sa = Sorter.new
sb = Sorter.new
sa.bubble_sort(a);
sb.merge_sort(b);

print a.show(), "    ", b.show(), "\n"

c = Collection.new()
d = Collection.new()
c.daj(10000);
d.daj(1000000);
sc = Sorter.new
sd = Sorter.new

ct1 = Time.now
sc.bubble_sort(c);
ct2 = Time.now

print "czas sortowania 10^4 elementów bubble_sortem: ", ct2-ct1, "\n"

dt1 = Time.now
sd.merge_sort(d);
dt2 = Time.now

print "czas sortowania 10^6 elementów merge_sortem: ", dt2-dt1, "\n"

