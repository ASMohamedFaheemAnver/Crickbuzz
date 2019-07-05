package com.company.operation;

import java.sql.SQLException;

public interface IntOperation {
    int perform(String qr, int choice) throws SQLException;
}
