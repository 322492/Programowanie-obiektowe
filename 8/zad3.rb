class Jawna
    def initialize(napis)
        @napis = napis
    end

    def zaszyfruj(key)
        wyn = ""
        @napis.each_char{ |a| wyn = wyn + key[a]}
        return Ciphered.new(wyn)
    end
    
    def to_s
        @napis
    end
end

class Ciphered
    def initialize(napis)
        @napis = napis
    end

    def oszyfruj(key)
        wyn = ""
        @napis.each_char{ |a| wyn += key.invert[a]}
        return Ciphered.new(wyn)
    end
    
    def to_s
        @napis
    end
end

#testy
key = {'a' => 'b', 'b' => 'r', 'r' => 'y', 'y' => 'u', 'u' => 'a', 'R' => 'Działa! '}
jawny = Jawna.new("Ruby")
zaszyfrowany = Ciphered.new("yaru")
print jawny.zaszyfruj(key), "\n"
print zaszyfrowany.oszyfruj(key), "\n"
