# BudgetVerwaltung
 Sinnvolles Tool gegen sinnlose Ausgaben!

## Projektstruktur
Wie bereits abgesprochen ist unser Projekt unterteilt in drei verschiedene "Arbeitsgruppen", dies ist über drei unterschiedliche Java-Projekte abgebildet:
- BuVer_Core , welches die eigentliche Java-Logik enthält
- BuVer_DB , welches die Datenbankdatei und eine Javaseitige Schnittstelle enthält
- BuVer_Web , als (erste) Oberfläche unserer Anwendung. Aus technischen Gründen liegt die Web-Schnittstelle in einem eigenen Projekt: (https://github.com/DvDOOM/budgetverwaltung-web)

Die Reihenfolge der Abhängigkeiten ist *Web* -> *Core* -> *DB*

Alle Projekte sind bereits angelegt, mit korrekten Abhängigkeiten verkabelt und mit kleinen Beispiel-Klassen aus allen Bereichen versehen, also ruhig schonmal auschecken und reinlesen.

## Organisatorische Struktur
### Git
Wir verwenden (offensichtlich) Git um unsere jeweiligen Änderungen zu synchronisieren. Git ist hierbei hoch effizient und übersichtlich, sobald man die Technologie und notwendigen Arbeitsschritte verstanden hat. Der *master-Branch* hier und im Web-Projekt hat der jeweils aktuellste, funktionierende Stand zu sein.
**Wer noch nie von Git gehört hat, kann sich ja schonmal einlesen. Aber bitte erst am Mittwoch einführen lassen, bevor ihr auf dem Repo arbeitet.**

### Maven
Unser Projekt hat Abhängigkeiten in sich selbst und zu Fremdsoftware. Um diese Abhängigkeiten zu verwalten, sind unsere Projekte als Apache Maven-Projekte aufgesetzt: Jedes Projekt ist mit einer "pom.xml" versehen, in der Abhängigkeiten zu anderer Software deklariert werden. Maven kümmert sich dann um die Beschaffung und den korrekten Einbau dieser. Für den initialen Stand müssten alle Konfigurationen korrekt sein.
**Wer noch nie mit Maven gearbeitet hat, verändert am besten nichts irgendeiner pom**

### UML
Auf Dauer wäre es villeicht sinnvoll, die Beschreibung des Service-Interface und die Hierarchie der Typen als UML abzulegen. Dann können sich alle Projekte darauf beziehen

## Technische Struktur
### Module
**!Absolut nur interessant für Maven-Verständnis!**:
Bei genauem Hinsehen stellt man fest, dass das DB- und Core-Projekt in einem gemeinsamen Ordner "Budgetverwaltung" liegen, welcher selbst wieder eine POM hat - DB und Core sind hier *Module* eines gemeinsamen *Multi-Modul-Projektes*, "Budgetverwaltung" ist dabei das (übergeordnete) **POM-Projekt**. Nach außen werden diese stets als ein einziges *Artefakt* (nur eine jar Datei) exportiert.
An der Arbeit damit ändert dies kaum etwas - ein Commit des POM-Projektes entspricht einem Commit der Änderungen beider Unterprojekte.

### Spring
Alle Projekte Der Budgetverwaltung sind *Spring-Projekte*, sie haben also an irgendeiner Stelle eine Abhängigkeit auf Code aus dem *Spring-Framework* (spring.io), einer sehr mächtigen Sammlung aus Open-Source-Frameworks. Für viele Standard-Programmiermuster/-Anforderugnen stellt Spring einfache Lösungen bereit, z.B. Authentifizierung, WebServer/-Anwendugnen, User-Sessions, Verteilung von Services, Datenmanagement, Monitoring, Logging, ...

#### Services / Beans
Ein Beispiel aus unserer Anwendung: Das Web-Projekt benötigt Services aus dem Core-Projekt für seine Arbeit - instanziiert es sich diese einfach? Diese Services selbst brauchen eine Verbindung aus dem Datenbank-Projekt - wo kommt dieser wieder? Kurz: Wer instanziiert welche Service-Klassen, in welcher Reihenfolge und wo werden diese verwaltet?

Spring bietet für dieses Problem das "Beans"-Framework an (diese Idee selbst kommt nicht von Spring): Alle Projekte welche Service-Instanzen für den Weitergebrauch anbieten, deklarieren diese als *Beans* (ist einfach eine Annotation) in einer *Configurations*-Klasse (auch eine Annotation). An allen Stellen wo ein solcher Service benötigt wird, implementiert man ihn als nicht initialisierte private Instanzvariable und versieht mit (natürlich der Annotation) *Autowired*. Bevor der eigentliche Programmablauf gestartet wird, wird Spring nun dafür sorgen, dass alle Beans in der richtigen Reihenfolge instanziiert und an den *autowired* Stellen eingesetzt werden
