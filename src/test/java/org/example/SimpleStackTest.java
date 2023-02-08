package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test behaviour of a SimpleStack")
class SimpleStackTest {

    @Test
    @DisplayName("Test the state of a newly created slack")
    public void testCreateEmptyStack() { // Test case

        // When a freshly stack is created
        Stack stack = new SimpleStack();

        // Then… (oracle)
        assertTrue(stack.isEmpty(), "A new stack must be empty");
        assertEquals( 0, stack.getSize(), "A new stack has no element");
    }

    @Test
    @DisplayName("Test the push of items")
    public void testPush() throws EmptyStackException {

        // Given an empty stack and an item
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();

        // When the item is pushed in the stack
        stack.push(item);

        // Then…
        assertFalse(stack.isEmpty(), "The stack must not be empty");
        assertEquals(1, stack.getSize(),"The stack must constain 1 item");
        assertSame( item, stack.peek(),"The pushed item must be is on top of the stack");

        // Given a new item to add
        Item item2 = new SimpleItem();

        // When we add the new item
        stack.push(item2);

        // then...
        assertFalse(stack.isEmpty(), "The stack must be not empty");
        assertEquals(2, stack.getSize(),"The stack must constain 2 items");
        assertSame( item2, stack.peek(),"The pushed item must be on top of the stack");
    }

    @Test
    @DisplayName("Test peek a stack")
    public void testPeek() throws EmptyStackException {
        // Given an non empty stack
        Stack stack = new SimpleStack();
        stack.push(new SimpleItem());
        stack.push(new SimpleItem());
        Item lastItem = new SimpleItem();
        stack.push(lastItem);
        int initialSize = stack.getSize();

        // When we "peek" the stack
        Item peekedItem = stack.peek();

        // then the peeked item is the last item pushed
        assertSame(lastItem, peekedItem);
        // and the size of the stack remains the same
        assertEquals(initialSize, stack.getSize());

    }

    @Test
    @DisplayName("Test limit when trying to peek an empty stack")
    public void testPeekOnEmptyStack()  {
        // Given an empty stack
        Stack stack = new SimpleStack();

        // When we "peek" the stack, should throws an EmptyStackException.
        //assertThrows(EmptyStackException.class, ()->stack.peek(), "EmptyStackException not thrown");
        assertThrows(EmptyStackException.class, stack::peek, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test pop a stack")
    public void testPop() throws EmptyStackException {
        // Given an non empty stack
        Stack stack = new SimpleStack();
        stack.push(new SimpleItem());
        Item beforeLastItem = new SimpleItem();
        stack.push(beforeLastItem);
        Item lastItem = new SimpleItem();
        stack.push(lastItem);
        int initialSize = stack.getSize();

        // When we "pop" the stack
        Item popedItem = stack.pop();

        // then the poped item is the last item pushed
        assertSame(lastItem, popedItem);
        // and the size of the stack is minus one
        assertEquals(initialSize-1, stack.getSize());
        // and if we peek, we get the before last item
        assertSame(beforeLastItem, stack.peek());

    }

    @Test
    @DisplayName("Test limit when trying to pop an empty stack")
    public void testPopOnEmptyStack()  {
        // Given an empty stack
        Stack stack = new SimpleStack();

        // When we "pop" the stack, should throws an EmptyStackException.
        //assertThrows(EmptyStackException.class, ()->stack.pop(), "EmptyStackException not thrown");
        assertThrows(EmptyStackException.class, stack::pop, "EmptyStackException not thrown");
    }

    @Test
    @Disabled
    public void jouonsAvecEqualsSame() {
        assertEquals(new String("Toto"), new String("Toto"));
        assertNotSame(new String("Toto"), new String("Toto"));
        assertSame("Titi", "Titi");
    }
}
