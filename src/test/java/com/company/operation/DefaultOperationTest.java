package com.company.operation;

import org.junit.Test;

import static org.mockito.Mockito.mock;

public class DefaultOperationTest {
    @Test
    public void shouldPerform(){
        VoidOperation opration = mock(DefaultOperation.class);
        opration.perform();
    }
}
