package com.company.Repository;

import java.sql.ResultSet;

public interface Repository{
    ResultSet read(String quary);
}
