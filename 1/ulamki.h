
typedef void Ulamki;
Ulamki *nowy_ulamek(float num, float denom);
void usun_ulamek(Ulamki *u);

// koncowka _new mowi, ze otrzymamy wskaznik na nowy Ulamek
Ulamki *dodaj_new(Ulamki * a, Ulamki *b);
Ulamki *odejmij_new(Ulamki *a, Ulamki *b);
Ulamki *pomnoz_new(Ulamki *a, Ulamki *b);
Ulamki *podziel_new(Ulamki *a, Ulamki *b);

// koncowka _old mowi, ze zostanie zmodyfikowany Ulamek podany jako drugi argument
void dodaj_old(Ulamki * a, Ulamki *b);
void odejmij_old(Ulamki *a, Ulamki *b);
void pomnoz_old(Ulamki *a, Ulamki *b);
void podziel_old(Ulamki *a, Ulamki *b);

void wypisz_ulamek(Ulamki * a);
