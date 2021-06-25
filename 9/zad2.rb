class Function2D
    def initialize(&blok)
        @blok = blok
    end

    def value(x, y)
        @blok.call(x, y)
    end

    def volume(a, b, c, d)
        e = 1000.0 #mozna edytowac dokladnosc
        dx = (b - a) / e
        dy = (d - c) / e
        wyn = 0.0
        for i in (0..e - 1)
            for j in (0..e - 1)
                xi = a + dx / 2 + i * dx
                yi = c + dy / 2 + j * dy
                wyn += value(xi, yi) * dx * dy
            end
        end
        return wyn
    end

    def contour_line(a, b, c, d, height)
        e = 0.000001 #dokladnosc
        kx = 0.01 #krok zmiany x
        ky = 0.01 #krok zmiany y
        wyn = Array.new()
        while a <= b
            i = c
            while i <= d
                if value(a, i) >= height - e && value(a, i) <= height + e
                    wyn.push([a, i])
                end
                i += ky
            end
            a += kx
        end
        return wyn
    end
end


f = Function2D.new{|x, y| x * x + 4 * y} # x^2 + 4y
print "f(x, y) = x^2 + 4y \n"
print "f(-1, 0) = ", f.value(-1, 0), "     f(2, 1) = ", f.value(2, 1), "      f(12, 17) = ", f.value(12, 17), "\n"
print "objętość: ", f.volume(11, 14, 7, 10), "\n"
print "wysokość: ", f.contour_line(11, 14, 7, 10, 209), "\n"
print "\n"

