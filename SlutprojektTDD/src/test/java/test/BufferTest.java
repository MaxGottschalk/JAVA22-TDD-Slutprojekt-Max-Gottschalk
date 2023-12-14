package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Item;
import test.mockedObjects.MockConsumer;
import test.mockedObjects.MockHelperBuffer;
import test.mockedObjects.MockHelperItem;
import test.mockedObjects.MockProducer;

class BufferTest {

	
		@Test
		@DisplayName("Check if add returns true")
		public void checkBooleanAddIsTrue() {
			MockHelperBuffer buffer = new MockHelperBuffer();

			MockHelperItem item = new MockHelperItem("test");
	        assertTrue(buffer.add(item));
		}
		
		 @Test
		 @DisplayName("Test Buffer remove method with mockConsumer")
		 void testBufferRemoveWithMockConsumer() {
		     MockHelperBuffer buffer = new MockHelperBuffer();
	         MockConsumer consumer = new MockConsumer(buffer);
	         Item item = new Item("B");
		     buffer.add(item);
		     Item result = consumer.removeItem();
		     assertEquals(item, result);
		     assertTrue(buffer.getBuffer().isEmpty());    
		 }
		
	    @Test
	    @DisplayName("Test add method")
	    public void testProducerAdd() {
	        MockHelperBuffer buffer = new MockHelperBuffer();
	        MockProducer producer = new MockProducer(buffer);
	        MockHelperItem item = new MockHelperItem("B");

            assertTrue(producer.addItem(item));
            assertNotNull(buffer); 
	    }

	    @Test
	    @DisplayName("Test remove method when buffer is not empty")
	    public void testRemoveWhenNotEmpty() {
	    	MockHelperBuffer buffer = new MockHelperBuffer();
            MockConsumer consumer = new MockConsumer(buffer);
            MockHelperItem item = new MockHelperItem("B");
            buffer.add(item); 

            Item removed = consumer.removeItem();

            assertNotNull(removed);
        }
	    
	    @Test
	    @DisplayName("Test getBuffer method")
	    public void testGetBuffer() {
	        MockHelperBuffer mockHelperBuffer = new MockHelperBuffer();

	        MockHelperItem mockItem = mock(MockHelperItem.class);

	        mockHelperBuffer.add(mockItem);

	        Queue<Item> buffer = mockHelperBuffer.getBuffer();

	        assertTrue(buffer.contains(mockItem));
	    }
	    
	    @Test
	    @DisplayName("Test adding null item to the buffer")
	    void testAddNullItem() {
	        MockHelperBuffer buffer = new MockHelperBuffer();
	        MockProducer producer = new MockProducer(buffer);
	        producer.addItem(null);
	        
	        assertNotEquals(null, buffer.getBuffer());
	        assertTrue(buffer.add(null));
	    }
	    
	    @Test
	    @DisplayName("Test buffer contents after adding an item")
	    void testBufferContentsAfterAdd() {
	        MockHelperBuffer buffer = new MockHelperBuffer();
	        MockHelperItem item = new MockHelperItem("test");
	        
	        assertTrue(buffer.add(item));

	        Queue<Item> expectedBuffer = new ConcurrentLinkedQueue<>();
	        expectedBuffer.add(item);
	        System.out.println("GetBuffer" + buffer.getBuffer());
	        System.out.println("Expected " + expectedBuffer);

	        assertEquals(expectedBuffer.toString(), buffer.getBuffer().toString());
	    }
	    
	    @Test
	    @DisplayName("Test waiting functionality")
	    public void testWaitingFunctionality() throws InterruptedException {
	        MockHelperBuffer buffer = new MockHelperBuffer();

	        Thread thread = new Thread(() -> {
	            synchronized (buffer) {
	                buffer.remove();
	            }
	        });

	        thread.start();
	        Thread.sleep(100);
	        
	        assertEquals(Thread.State.WAITING, thread.getState());

	        thread.interrupt();

	        thread.join();
	    }
	    
	    /*
	     * Buffer list
	     * Add, att ngt lagts till, sysout att det skrivs ut en lista [], Null värde, return true
	     * Remove, buffer är empty,  
	     */
}
