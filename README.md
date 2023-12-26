# Puzzle15 Game

## Beskrivning

Detta projekt är ett Puzzle15-spel skrivet i Java med Swing för GUI. Spelet består av en 4x4-ruta med 15 numrerade brickor och en tom ruta. Målet med spelet är att ordna brickorna i numerisk ordning genom att flytta brickorna in i den tomma rutan.

## Funktioner

- **Nytt spel**: Blandar om brickorna för att starta ett nytt spel.
- **Vinn spelet**: Ordna brickorna i numerisk ordning för att vinna spelet.

## Klasser

- `EventHandling`: Hanterar alla händelser som genereras av användaren, till exempel knapptryckningar.
- `GameLogic`: Innehåller all logik för spelet, till exempel att blanda om brickorna och kontrollera om användaren har vunnit.
- `UI`: Skapar och hanterar användargränssnittet för spelet.

## Hur man kör spelet

För att köra spelet, kan du klona ner projektet och köra `Main`-klassen. Du kan också ladda ner en JAR-fil från [releases]() och köra den med `java -jar puzzle15.jar`.

## Framtida arbete

- Konvertera spelet till en webbapplikation med Spring Boot och Thymeleaf.
- Lägg till fler funktioner, till exempel en timer och en räknare för antalet drag.
