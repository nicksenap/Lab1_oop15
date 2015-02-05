# Lab1_oop15
Lab 1 to oop15, Object Oriented Programming

Labb1

Implementera ett program som utför konverteringar mellan olika valutor. Programmet skall klara av att hantera åtminstone valutor som finns i filen valutor.txt.

Indata till programmet, d.v.s. valuta och belopp skall anges på kommandoraden.

    Om endast en valuta anges, skall det givna beloppet konverteras till SEK.
    Om två valutor anges, skall beloppet konverteras från den första till den andra.
    Programmet ska hantera fel med undantag (exceptions)
    Programmet ska meddela sig begripligt med användaren, t.ex 
    Programmet ska inte innehålla varken koduppreprepning eller hårdkodning (förutom filnamnet valutor.txt)
    Programmet ska vara uppdelat i kommenterade funktioner enligt förra kursens principer
    Det ska finnas ett testprogram som testar programmet

Tre exempel på körning följer nedan:

~pem> java Converter USD 24.30
24.30 USD = 194.18 SEK

~pem> java Converter USD 24.30 JPY
24.30 USD = 2814.22 JPY

~pem> java Converter EUR 243 FRA
'FRA' is not a recognized currency.

~pem> java Converter 23
Usage: java Converter currency amount [currency]

