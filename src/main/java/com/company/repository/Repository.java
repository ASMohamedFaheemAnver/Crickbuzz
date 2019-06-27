package main.java.com.company.repository;

import java.sql.ResultSet;

public interface Repository{
    ResultSet read(String quary);
}
