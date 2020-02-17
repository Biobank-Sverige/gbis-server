GBIS 3.0
========

Bakgrund
--------
Det finns en standard GBIS (Gemensam Biobank Informations Standard) 2.0 framtagen sedan tidigare.
Tyvärr används denna standarden ej (eller endast i mycket begränsad utsträckning) i praktiken.
Detta kan ha flera skäl, men ett av dem torde vara att den ger ganska lite praktisk vägledning i hur den ska appliceras.
I arbetet med GBIS 3.0 har jag tagit avstamp i den GBIS 2.0 och försökt att i så stor utsträckning som möjligt återanvända termer och begrepp. Skillnaden i version 3.0 är att den syftar mer till att också beskriva struktur (t.ex. filformat) och inte bara innehåll.
Målet är att göra en praktiskt användbar standard som snabbt kan tas i bruk snarare än en komplett nomenklatur för biobanksprovers hela livscykel. Detta innebär att standarden på intet sätt är heltäckande utan är tänkt att utvecklas i nya versioner allteftersom den används, dock med en stabil stomme.

I mitt arbete har jag också tittat på de standarder som arbetas på på andra håll (t.ex. [HL7FHIR - specimen](https://www.hl7.org/fhir/specimen.html)) och konstaterar till att de syftar till att lösa problem på en högre nivå, t.ex. annoteringar av resultat och utbyte av stora datamängder snarare än att som här primärt fokusera på ett fysiskt prov, eller är så komplexa att det i realiteten inte kan användas i den praktiska verksamheten.

Struktur
--------

GBIS 3.0 utgår från ett fysisk prov och det är också det som är den centrala, betydelsebärande, komponenten.

Man kan naturligtvis representera en standard på olika sätt och jag väljer här på att fokusera på JSON (JavaScript Object Notation, se [https://www.json.org/json-en.html](https://www.json.org/json-en.html)) när det kommer till praktiska exempel då detta är den absolut vanligaste och mest använda tekniken för informationsöverföring för denna typ av data mellan it-system idag.
CSV-filer (se [https://tools.ietf.org/html/rfc4180](https://tools.ietf.org/html/rfc4180)) är idag tyvärr fortfarande vanligt förekommande inom den medicinska världen och även om jag tror att det har en enorm nytta att röra sig mot modernare tekniker kommer jag att visa exempel på hur standarden kan se ut om man väljer att arbeta med filer.

Ett prov har följande information:

|Fältnamn| Datatyp | Obligatoriskt | Beskrivning
|---|---|---|---|
|_sample_id_|Sträng av minst 1, max 30 tecken från ASCII 33 - 126|Ja|Motsvarar den fysiska märkning som unikt identifierar ett rör inom en provsamling|
|_study_id_|Sträng av minst 1, max 30 tecken från ASCII 33 - 126|Nej|Identifierar den provsamling vilken provet tillhör. Används (bland annat) för att säkerställa unika identifierare i kombination med _sample_id_
|_sample_usage_|Någon av textsträngarna [RESEARCH, CARE, RESARCH_AND_CARE]|Ja|Beskriver hur provet får användas|
|_last_usage_date_|Datum enligt ISO 8601 på formatet YYYY-MM-DD utan tidszonsangivelse|Nej|Sista dag då provet får användas, t.ex. om dett finns ett etikprövningsbeslut som begränsar i tid.|
|_donor_|Sträng av minst 1, max 30 tecken från ASCII 33 - 126|Nej|Identifierar provgivaren med t.ex. personnummer eller studienummer. Om personnummer används ska det vara på formatet ÅÅÅÅMMDD-NNNN och ingen hänsyn tas till att personen fyllt hundra år utan skiljetecknet '-' används oavsett.
|_parent_sample_id_|Samma format som _sample_id_|Nej|Motsvarar den fysiska märkning som unikt identifierar det rör inom en provsamling som detta rör härstammar från|
|_material_type_|Sträng av 3 tecken, se separat tabell|Nej||
|_sample_volume_|Heltal mellan 0 och 1000000|Nej|Provmaterialets volym i mikroliter|
|_freeze_thaw_cycles_|Heltal mellan 0 och 255|Nej|Beskriver hur många gånger provet tinats och återinfrysts|
|_sample_plate_id_|Sträng av minst 1, max 30 tecken från ASCII 33 - 126|Nej|Motsvarar den fysiska märkning som unikt identifierar eventuell platta i vilket provet återfinns|
|_sample_plate_postition_|Sträng av minst 1, max 30 tecken från ASCII 33 - 126|Nej|Provets position i fysisk platta, t.ex. A01

Exempel på prov (JSON):

    {
        sample_id: 12345
        study_id: "HEART_STUDY_2"
        sample_usage: "RESEARCH"
        last_usage_date: "2023-06-12"
        donor: "19121212-1212"
        parent_sample_id: "43425-Y2"
        material_type: "SER"
        sample_volume: 125
        freeze_thaw_cycles: 4
        sample_plate_id: "3245-53"
        sample_plate_position: "A01"
     }

Exempel på prov (CSV):

    "sample_id","study_id","sample_usage","last_usage_date","donor","parent_sample_id","material_type","sample_volume","freeze_thaw_cycles","sample_plate_id","sample_plate_position"
    "123456","HEART_STUDY_2","RESEARCH","2023-06-12","19121212-1212","43425-Y2","SER","125","4","3245-53","A01"
    
OM csv-formatet används ska den ha exakt en header-rad enligt ovan och använda teckentabell UTF-8 med CRLF som radavslut. Samtliga fält ska vara quotade med " (även siffror). Escape-character ska vara \\ .

Naturligtvis kan en csv-fil innehålla mer än ett prov på samma sätt som en JSON-struktur.
OM JSON-strukturen sparas till fil ska denna fil använda teckentabell UTF-8 och radavslut CRLF.


TODO
====
- sampleDateTime
Provtagningsdatum och tidpunkt.
Tidsstämpel

- sampleState
Provets status i biobanken.

- referralId
  Provets remissId. 
  Sträng

- https://www.hl7.org/fhir/specimen.html

- https://www.hl7.org/fhir/v2/0487/index.html

- https://www.hl7.org/fhir/v2/0493/index.html