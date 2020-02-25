Referensimplementation för GBIS 3.0
===================================

Detta projekt är en referensimplementation av den föreslagna GBIS 3.0 standarden.
För dokumentation av själva standarden, se [GBIS 3.md](doc/GBIS 3.md).

Köra lokalt
===========

För att starta referensservern lokalt krävs java 11 och Maven.

Bygg projektet med `mvn clean verify`
Kör sedan `java -jar target/gbis-server*.jar`
Öppna en webbläsare och gå till [http://localhost:8080](http://localhost:8080) för att se data

Detta använder en csv-filen [src/main/resources/example-data.csv](src/main/resources/example-data.csv) som källa och exponerar den som JSON.

Frontend
========

Det finns en enkel webbfrontend utvecklad (gbis-frontend) för att visa hur man kan använda standarden för att visualisera data. Även denna finns på Biobank Sveriges github [https://github.com/Biobank-Sverige](https://github.com/Biobank-Sverige)
Instruktioner om hur denna startas finns där.