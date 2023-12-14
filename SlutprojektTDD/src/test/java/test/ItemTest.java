package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Item;
import test.mockedObjects.MockHelperItem;

class ItemTest {

	
	//Constructor 
    @Test
    @DisplayName("Test constructor")
    public void testConstructor() {
        String itemId = "TestItemId";
        MockHelperItem item = new MockHelperItem(itemId);
        
        assertEquals(itemId.toLowerCase(), item.getId());
    }
    
    //Numbers
    @Test
    @DisplayName("Testing invalid datatype for Constructor (int)")
    void testSetConstructorWithIntegerInput() {
    	MockHelperItem item = new MockHelperItem("123");

        assertEquals("123", item.getId());
    }
    
    //Null
    @Test
    @DisplayName("Test constructor with null ID")
    void testConstructorWithNullId() throws NullPointerException {
        assertThrows(NullPointerException.class, () -> new Item(null));
    }
    
    //Empty String
    @Test
    @DisplayName("Test constructor with empty ID")
    void testConstructorWithEmptyId() {
    	MockHelperItem item = new MockHelperItem("");
    	
        assertTrue(item.getId().isEmpty());
    }
    
    //To lower case
    @Test
    @DisplayName("Test Constructor to lower case")
    public void testConstructorToLowerCase() {
        MockHelperItem item = new MockHelperItem("TEST");

        assertEquals("test", item.getId());
    }
    
    @Test
    @DisplayName("Test item with special characters")
    void testItemSpecialCharacters() {
        MockHelperItem item1 = new MockHelperItem("test");
        MockHelperItem item2 = new MockHelperItem("!@#$%^&*()");

        assertNotNull(item2);
        assertEquals("!@#$%^&*()", item2.getId());
        assertNotEquals(item1, item2);
    }
    
    //To String ///////////////////////////////////////////////////////////
    
    //To lower case 
    @Test
    @DisplayName("Test toString method")
    public void testToString() {
        String itemId = "TestItemId";
        MockHelperItem item = new MockHelperItem(itemId);

        assertEquals(itemId.toLowerCase(), item.toString());
    }
    //Number
    @Test
    @DisplayName("Test toString method with numbers input")
    public void testToStringWithNumbers() {
        String itemId = "1234";
        Item item = new Item(itemId);

        assertEquals(itemId.toLowerCase(), item.toString());
    }
    
    //Empty string 
    @Test
    @DisplayName("Test to string with empty ID")
    void testToStringWithEmptyId() {
    	MockHelperItem item = new MockHelperItem("");
    	
        assertTrue(item.toString().isEmpty());
    }
    
    
    //Set id ///////////////////////////////////////////////////////////////

    //New id 
    @Test
    @DisplayName("Test setId method")
    public void testSetId() {
        String initialId = "InitialId";
        String newId = "NewId";

        MockHelperItem item = new MockHelperItem(initialId);
        
        assertEquals(initialId.toLowerCase(), item.getId());

        item.setId(newId);
        
        assertEquals(newId.toLowerCase(), item.getId());
    }
    
    //Null
    @Test
    @DisplayName("Test if item id is null")
    void testItemIsNull() throws NullPointerException {
    	MockHelperItem item = new MockHelperItem("Test");
        assertNotNull(item);
        
        assertThrows(NullPointerException.class, () -> item.setId(null));
    }
    
    //Numbers
    @Test
    @DisplayName("Testing invalid datatype for ID (int)")
    void testSetIdWithIntegerInput() {
        MockHelperItem item = new MockHelperItem("test");

        item.setId(String.valueOf(123));

        assertEquals("123", item.getId());
    }
    
    //To lower case 
    @Test
    @DisplayName("Test toString method")
    public void testSetIdTolowerCase() {
        MockHelperItem item = new MockHelperItem("TEST");
        item.setId("NEW");

        assertEquals("new", item.getId());
    }
    
    //Set id Empty string 
    @Test
    @DisplayName("Test to string with empty ID")
    void testSetIdWithEmptyId() {
    	MockHelperItem item = new MockHelperItem("TEST");
    	item.setId("");
    	
        assertTrue(item.getId().isEmpty());
    }
    
    //Get id ///////////////////////////////////////////////////////////////
    @Test
    @DisplayName("Test to check if id is lower case")
    public void testToLowerCase() {
        
        MockHelperItem item = new MockHelperItem("B");

        assertEquals("b", item.getId());
    }
    
    @Test
    @DisplayName("Test item equality")
    void testItemEquality() {
    	MockHelperItem item1 = new MockHelperItem("test");
    	MockHelperItem item2 = new MockHelperItem("test");
        MockHelperItem item3 = new MockHelperItem("different");
        
        assertEquals(item1.getId(), item2.getId());
        assertNotEquals(item1.getId(), item3.getId());
    }
	    
    
    ///////////////////////////////////////////////////////
	    
	    /*
	     * Item, null, tom string, bokstäver, siffror
	     * toString samma - null
	     * SetId samma som första
	     */

}
