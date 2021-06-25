class Function
    def initialize(&blok)
        @blok = blok
    end

    def value(x)
        @blok.call(x)
    end

    def zero(a, b, e)
        wyn = Array.new()
        while a <= b
            if value(a) >= -e && value(a) <= e
                wyn.push(a)
            end
            a += e
        end
        if wyn.length() == 0
            return nil
        else
            return wyn
        end
    end

    def field(a, b)
        dx = (b - a) / 1000000.0 #mozna edytowac dokladnosc
        wyn = 0.0
        a += dx
        while a <= b
            wyn += dx * value(a)
            a += dx
        end
        return wyn
    end

    def deriv(x) #zakladam, ze funkcja jest okreslona w x
        h = 0.000001
        return (value(x + h) - value(x)) / h
    end
end


f = Function.new{|x| (x - 1) * (x - 1)} # (x-1)^2
print "f(x) = (x-1)^2 \n"
print "f(-1) = ", f.value(-1), "     f(0) = ", f.value(0), "      f(3) = ", f.value(3), "\n"
print "miejsca zerowe: ", f.zero(-5.0, 15, 0.01).inspect, "\n"
print "area: ", f.field(0, 2), "\n"
print "f'(1) = ", f.deriv(1), "     f'(2) = ", f.deriv(2), "\n"
print "\n"

g = Function.new{|x| Math.sin(x).abs } # |sin(x)|
print "g(x) = |sin(x)| \n"
print "g(pi) = ", g.value(Math::PI),  "      g(1) = ", g.value(1.0),   "      g(pi/2) = ", g.value(Math::PI / 2.0), "\n"
print "miejsca zerowe: ", g.zero(0.0, 4.0*Math::PI, 0.001).inspect, "\n"
print "area: ", f.field(2, 10), "\n"
print "f'(0) = ", f.deriv(0), "     f'(pi/2) = ", f.deriv(Math::PI), "\n"
print "\n"
