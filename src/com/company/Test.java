package com.company;

import com.company.Crickbuzzpage.CrickbuzzPage;
import com.company.Crickbuzzpage.DefaultCrickbuzzPage;
import com.company.Operation.Operation;
import com.company.Operation.OperationFactory;

public class Test {
    public static void main(String[] args) {
        OperationFactory operationFactory = new OperationFactory();
        Operation operation = operationFactory.getInstance("First Innings", 1);
        operation.perform();
    }
}