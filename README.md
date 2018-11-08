# Pretius_task - zadanie

Budowa aplikacji wymaga podania polecenia </br>
mvn clean install </br>
w głównym folderze projektu </br>

Uruchomienie aplikacji wymaga podania polecenia </br>
java -jar Task-0.0.1.RELEASE.jar </br>
w foderze target </br>

Aplikacja przyjmuje rządanie POST pod adresem /exchange/ o postaci </br>
```
{
  "value": "123.45",
  "currency": "USD",
  "targetCurrency": "EUR"
}
```
Zwracana postać
```
{
    "sourceCurrency": "USD",
    "sourceValue": "123.45",
    "targetCurrency": "EUR",
    "targetValue": "108.067252"
}
```
