class Integer
    def czynniki
        tab=Array.new();
        1.upto(self) do |x|
            if self % x == 0
                tab.push(x)
            end
        end
        return tab
    end

    def ack(y)
        if self == 0
            return y + 1
        elsif  y == 0
            return (self - 1).ack(1)
        else
            (self - 1).ack(self.ack(y - 1))
        end
    end

    def doskonala
        return (self.czynniki).sum - self == self
    end

    def slownie
        slowa = ["zero", "jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć"]
        wynik = ""
        self.digits.reverse.each{|np| wynik = wynik + slowa[np] + " "}
        return wynik
    end

end

#testowanie

print "1) czynniki liczb 0-12: \n"
    0.upto(12) do |x|
        print x, ": ", (x.czynniki).inspect, "\n"
    end

print "\n"

print "2) kilka Ackermanów: \n", 2.ack(1), " ", 1.ack(1), " ", 2.ack(2), "\n"

print "\n"

print "3) liczby doskonałe do 1000: " 
    1.upto(1000) do |x| 
        if x.doskonala 
            print x, " "
        end
    end

print "\n\n"

print "4) kilka liczb słownie: \n", 123.slownie, "\n", 50.slownie, "\n", 17.slownie