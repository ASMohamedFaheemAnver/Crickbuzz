package com.company.operation;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class OperationFactoryTest {
    String operator;
    int matchID;
    @Test
    public void shouldLaunchDefaultPageOperation(){
        OperationFactory operationFactory = new OperationFactory();
        operator = "-1";
        matchID = 1;

        VoidOperation operation = operationFactory.getInstance(operator, matchID);
        assertThat(operation, instanceOf(DefaultOperation.class));
    }

    @Test
    public void shouldLaunchFirstInningsPageOperation(){
        OperationFactory operationFactory = new OperationFactory();
        operator = "First Innings";
        matchID = 1;

        VoidOperation operation = operationFactory.getInstance(operator, matchID);
        assertThat(operation, instanceOf(FirstInningsOperation.class));
    }

    @Test
    public void shouldLaunchSecondInningsPageOperation(){
        OperationFactory operationFactory = new OperationFactory();
        operator = "Second Innings";
        matchID = 1;

        VoidOperation operation = operationFactory.getInstance(operator, matchID);
        assertThat(operation, instanceOf(SecondInningsOperation.class));
    }

    @Test
    public void shouldLaunchOverviewInningsPageOperation(){
        OperationFactory operationFactory = new OperationFactory();
        operator = "Innings Overview";
        matchID = 1;

        VoidOperation operation = operationFactory.getInstance(operator, matchID);
        assertThat(operation, instanceOf(OverviewInningsOperation.class));
    }
}
