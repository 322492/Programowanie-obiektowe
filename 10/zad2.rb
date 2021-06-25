class Kolekcja

    class Node
        def initialize(x)
            @val = x
            @next = nil
            @prev = nil
        end
        def val()
            @val
        end
        def next()
            @next
        end
        def prev()
            @prev
        end
        def set_next(w)
            @next = w
        end
        def set_prev(w)
            @prev = w
        end
    end

    private_constant :Node

    def initialize()
        @head = nil
        @tail = nil
        @size = 0
    end

    def insert(x) #dodawanie elementow do kolekcji
        n = Node.new(x)
        if @size == 0
            @head = n
            @tail = n
        elsif x <= @head.val
            @head.set_prev(n)
            n.set_next(@head)
            @head = n
        else
            i = @head
            while i.val < x && i != @tail
                i = i.next
            end
            if i == @tail && i.val < x
                @tail.set_next(n)
                n.set_prev(i)
                @tail = n
            else
                p = i.prev
                p.set_next(n)
                n.set_prev(p)
                n.set_next(i)
                i.set_prev(n)
            end
        end
        @size += 1
    end

   def show() #metoda pomocnicza do wypisywania
        print ". "
        i = @head
        while i != @tail
            print i.val, " "
            i = i.next
        end
        print i.val, " ."
    end

    def head()
        @head
    end

    def tail()
        @tail
    end

    def size()
        @size
    end

end

class Wyszukiwanie

    def brutalne(kol, x)
        p = kol.head
        while p != nil
            if p.val == x
                return true
            end
            p = p.next
        end
        return false
    end

    def binary_search(kol, x)
        pocz = kol.head
        kon = nil
        loop do
                m = srodek(pocz, kon)
                if m == nil
                    return false
                elsif m.val == x
                    return true
                elsif m.val < x
                    pocz = m.next
                else
                    kon = m
                end
            if pocz == kon && kon != nil
                break
            end
        end
        return false
    end

    def srodek(a, b)
        if a == nil
            return nil
        end
        wolny = a
        szybki = a.next
        while szybki != b
            szybki = szybki.next
            if szybki != b
                wolny = wolny.next
                szybki = szybki.next
            end
        end
        return wolny
    end

  private :srodek

end



#test

a = Kolekcja.new()

10.times{a.insert(rand(15))} #wstawianie 10 losowych liczb <15 do kolekcji
a.show()
print "\n"
w = Wyszukiwanie.new
print "brutalne:   binarne: \n"
0.upto(9){ |i| print i, " ", w.brutalne(a, i), "      ", w.binary_search(a, i), "\n"}


