package com.globox.ali.imdb.explorer.repository;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseInputFromFile {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:h2:mem:testdb";
        String username = "sa";
        String password = "";

        String filePath = "E:\\IMDB\\title.ratings.tsv";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "INSERT INTO TESTDB (tconst, averageRating, numVotes) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            FileReader reader = new FileReader(filePath);
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('\t').withFirstRecordAsHeader());

            for (CSVRecord record : csvParser) {
                String tconst = record.get("tconst");
                float averageRating = Float.parseFloat(record.get("averageRating"));
                int numVotes = Integer.parseInt(record.get("numVotes"));

                statement.setString(1, tconst);
                statement.setFloat(2, averageRating);
                statement.setInt(3, numVotes);

                statement.addBatch();
            }

            statement.executeBatch();
            csvParser.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}