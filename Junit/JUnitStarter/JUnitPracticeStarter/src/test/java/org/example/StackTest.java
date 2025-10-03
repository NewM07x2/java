package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StackTest {
    public Stack<String> stack;
    public String anElement = "要素1";

    @Test
    public void isEmpty() {
        stack = new Stack<>();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void throwsExceptionWhenPopped() {
        stack = new Stack<>();
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    public void isNotEmpty() {
        stack = new Stack<>();
        stack.push(anElement);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void returnElementWhenPopped() {
        stack = new Stack<>();
        stack.push(anElement);
        assertEquals(anElement, stack.pop());
    }

}
