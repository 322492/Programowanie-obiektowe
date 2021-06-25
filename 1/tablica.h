
typedef void Tablica;
typedef int typ; //typ wartosci, mozna zmieniac, ale wymaga zmian w kilku miejscach programu

Tablica *nowa_tablica();
void usun_tablice(Tablica *t);

void dodaj(Tablica *t, int indeks, typ wartosc);
typ indeks(Tablica *t, int x);
