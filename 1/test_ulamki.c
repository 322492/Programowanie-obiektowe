#include<stdio.h>
#include<string.h>

#include "ulamki.h"

int main(){

Ulamki *a = nowy_ulamek(-2.234, 4.468);
Ulamki *b = nowy_ulamek(1234.123, -1.0);
Ulamki *c = nowy_ulamek(-150.222, -50.222);
Ulamki *d = nowy_ulamek(0.3333, 1.0);
Ulamki *zero = nowy_ulamek(0.0, 77.77);

Ulamki *e, *f;

wypisz_ulamek(a);
wypisz_ulamek(b);
wypisz_ulamek(c);
wypisz_ulamek(d);
wypisz_ulamek(zero);

e=pomnoz_new(a, b);
wypisz_ulamek(e);
e=dodaj_new(b, d);
wypisz_ulamek(e);
e=odejmij_new(c, zero);
odejmij_old(c, zero);
wypisz_ulamek(zero);

f=podziel_new(a, b);
wypisz_ulamek(f);
podziel_old(a, b);
wypisz_ulamek(b);
podziel_old(a, a);
wypisz_ulamek(a);
f=podziel_new(d, c);
podziel_old(d, c);
wypisz_ulamek(f);
wypisz_ulamek(c);


usun_ulamek(a);
usun_ulamek(b);
usun_ulamek(c);
usun_ulamek(d);
usun_ulamek(e);
usun_ulamek(f);
usun_ulamek(zero);

return 0;
}
