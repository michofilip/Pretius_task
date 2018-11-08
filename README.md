# Pretius_task - zadanie

Budowa aplikacji wymaga podania polecenia 
mvn clean install 
w głównym folderze projektu

Uruchomienie aplikacji wymaga podania polecenia 
java -jar Task-0.0.1.RELEASE.jar
w foderze target

Aplikacja przyjmuje rządanie POST pod adresem /exchange/ o postaci

{
  "value": "123.45",
  "currency": "USD",
  "targetCurrency": "EUR"
}

Zwracana postać

{
    "sourceCurrency": "USD",
    "sourceValue": "123.45",
    "targetCurrency": "EUR",
    "targetValue": "108.067252"
}
