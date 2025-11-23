package test;

import main.StopProgram;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestStopProgram {
    String[] validInputs = {"korv","Sausages","pölse","körv","Äggsmörgås","Eggsandwich","Räkamacka","Älg","Stop","Kaos"};
    String[] invalidInputs = {"Hej!","h2eh","asd!!2","lasd%%&213","212","&&&&","!s2","Bamse"};
    String [] stopInputs = {"Hej","Då","Stop","Korv","stop"};
    String [] longestInput = {"Fjorton","Tretton","Flaggstångsknopp"};
    String[] onlyLetters = {"korv sås","mellan slag","pölse","körv","Ägga macka"};


    @Test
    void testAppShutsDownWhenUserTypesStop() {
        StopProgram testUser = new StopProgram();
        for(String stopWord : stopInputs) {
            if(stopWord.equalsIgnoreCase("Stop")) {
                break;
            }
            testUser.countLines(stopWord);
        }
        assertEquals(2,testUser.getTotalWords());
        assertEquals(5,testUser.getTotalCharacters());
        assertEquals("Hej",testUser.getLongestWord());
    }
    @Test
    void testAppCountsEveryWordExcludingStop() {
        StopProgram testUser = new StopProgram();
        for(String valid:validInputs) {
            testUser.countLines(valid);
        }
        assertEquals(8,testUser.getTotalWords());
        assertEquals(54,testUser.getTotalCharacters());
        assertEquals("Eggsandwich",testUser.getLongestWord());


    }
    @Test
    void testAppOnlyCountLetters() {
        StopProgram testUser = new StopProgram();
        for (String letters : onlyLetters) {
            testUser.countLines(letters);
            }
        assertEquals(8,testUser.getTotalWords());
        assertEquals(35,testUser.getTotalCharacters());
        assertEquals("mellan",testUser.getLongestWord());

    }
    @Test
    void testAppWritesOutLongestWord() {
        StopProgram testUser = new StopProgram();
        for(String longest : longestInput) {
            testUser.countLines(longest);
        }
        assertEquals(16,testUser.getLongestWord().length());
        assertEquals("Flaggstångsknopp",testUser.getLongestWord());

    }
    @Test
    void testAppWritesOnlyValidWords() {
        StopProgram testUser = new StopProgram();
        for(String invalid : invalidInputs) {
            testUser.countLines(invalid);
        }
        assertEquals(1,testUser.getTotalWords());
        assertEquals(5,testUser.getTotalCharacters());
        assertEquals("Bamse",testUser.getLongestWord());

    }
    @Test
    void testAppWritesOutEveryWordWithBlankspace() {
        StopProgram testUser = new StopProgram();
    for(String valid : validInputs){
        testUser.countLines(valid);
    }
    String expected = "korv Sausages pölse körv Äggsmörgås Eggsandwich Räkamacka Älg";
    assertEquals(expected,testUser.getPrintedWords());
    assertEquals(8,testUser.getTotalWords());

    }
}
