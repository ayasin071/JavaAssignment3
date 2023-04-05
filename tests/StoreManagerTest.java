package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

class StoreManagerTest {

    private StoreManager storeManager;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() throws Exception {
        storeManager = new StoreManager();
        storeManager.loadData();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testSearchAndPurchase() {
        // Test searching and purchasing a toy
        String input = "1\nS01\n1\n";
        System.setIn(input.getBytes());
        storeManager.searchAndPurchase();
        String expectedOutput = "Search toy by\n1. Serial Number\n2. Name\n3. Type\nEnter your choice : Enter the serial number of the toy : Do you want to purchase this toy? 1. Yes\n2. No\nEnter your choice : ";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testAddNewToy() {
        // Test adding a new toy
        Toy t = new Figures("2835360879";"Cow";"Game Assassin";"19.52";"0";"7";"Plastic";"M");
        storeManager.addNewToy(t);
        boolean found = false;
        for (Toy toy : storeManager.listOfToys) {
            if (toy.getSerialNumber().equals("2835360879")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

