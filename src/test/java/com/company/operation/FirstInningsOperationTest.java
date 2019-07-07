package com.company.operation;

import org.junit.Test;

import static org.mockito.Mockito.mock;

public class FirstInningsOperationTest {
    @Test
    public void shouldPerform(){
        VoidOperation opration = mock(FirstInningsOperation.class);
        opration.perform();
    }
}
