package main;

// Importera av vissa verktyg som finns inom Java för att lösa uppgiften tillhands.
import java.util.ArrayList; // Detta behövs för att kunna skapa en Arraylist.
import java.util.Scanner; // För att kunna ta in en användarens input så behöver vi en Scanner.

public class StopProgram {
    // Våra olika variabler som används i detta program. Vi har valt att ha dessa private för de ska bara var tillgängliga i denna klass.
    private int totalCharacters; // Variabel för att kunna räkna ut antalet tecken som skrivs.
    private int totalWords; // Variabel för att räkna ut antalet ord som skrivs.
    private String longestWord; // En strängvariabel för att spara det längsta ordet.
    private boolean stopFlag = false; // boolean som sätts till false i början. Används för att bryta while-loop.
    private ArrayList<String> validWords = new ArrayList<>(); // Arraylista som tar in godkända ord och sparar i denna lista.
    // Väljer en arrayList då vi inte vill begränsa antalet som en EU kan

    // Konstruktor med 0 värden, ändras detta så kommer EU börja med nedan förutsättningar.
    public StopProgram() {
        totalCharacters = 0;
        totalWords = 0;
        longestWord = "";
    }

// Denna metod anropas i main-klassen 'MainCounting'. Det är denna som tar in och hanterar all input som EU fyller i.
    // Den tar hjälp av metoderna checkForStop och countLines för att hantera om ordet stop fylls i, eller om den ska räkna ord, rader och hantera längst ord.
    public void startCounting() {
        Scanner myScanner = new Scanner(System.in);
        // Denna while-loop körs så länge trueFlag inte ändras till true, vilket sätts i checkForStop.
        while(!stopFlag) {
            String input = myScanner.nextLine();
            countLines(input);
            if(stopFlag) {
                break;
            }

        }
        // Metoden printSummary anropas här för en mer lätthanterlig kod.
        printSummary();
        myScanner.close();
    }
// Denna metod sätts till private för vi har inget behov av att den är nåbar någon annanstans än i denna klass.
    private void printSummary() {
        System.out.println("Antal ord: "+totalWords);
        System.out.println("Longest word: "+longestWord);
        System.out.println("Number of characters: "+totalCharacters);
        System.out.println(String.join(" ",validWords));
    }

    // Metod som räknar ihop EU:s input. Programmet ska inte ta emot ord med annat än svenska bokstäver.
    // Är det ord som innehåller detta så ska det inte räknas in i totalen.
    // Vår arrayLista validWords där ord läggs till som matchar våra krav.

    public void countLines(String input) {
        if(stopFlag) return;
        String[] words = input.split("\\s+");
        for(String word : words) {
            if(word.equalsIgnoreCase("Stop")){
                stopFlag = true;
                break;
            }
            if(word.matches("[a-zA-ZåäöÅÄÖ]+")){
                totalWords +=1;
                totalCharacters += word.length();
                if(word.length()> longestWord.length()) {
                    longestWord = word;
                }
                validWords.add(word);
            }
        }

    }
// Våra getters som anropas i vår Testsuite.
    public int getTotalWords() {
        return totalWords;
    }
    public int getTotalCharacters() {
        return totalCharacters;
    }

    public String getLongestWord() {
        return longestWord;
    }
    //Getter som tar orden i arrayListan validWords och returnerar dom med mellanrum.
    public String getPrintedWords() {
        return String.join(" ",validWords);
    }

}