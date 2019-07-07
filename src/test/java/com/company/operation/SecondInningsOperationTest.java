package com.company.operation;

import org.junit.Test;


import static org.mockito.Mockito.mock;

public class SecondInningsOperationTest {
    @Test
    public void shouldPerform(){
        VoidOperation opration = mock(SecondInningsOperation.class);
        opration.perform();
    }
}
