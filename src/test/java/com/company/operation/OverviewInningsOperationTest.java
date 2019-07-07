package com.company.operation;

import org.junit.Test;

import static org.mockito.Mockito.mock;

public class OverviewInningsOperationTest {
    @Test
    public void shouldPerform(){
        VoidOperation opration = mock(OverviewInningsOperation.class);
        opration.perform();
    }
}
