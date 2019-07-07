package com.company.operation;

import org.junit.Test;

import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculateTotalOperationTest {
    @Test
    public void shouldReturnTotal() throws SQLException {
        int totalRun = 5;
        IntOperation total = mock(CalculateTotalOperation.class);
        when(total.perform("SELECT * FORM MATCHBOWLING", 2)).thenReturn(totalRun);
    }
}
