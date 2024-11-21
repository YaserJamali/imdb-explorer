package com.globox.ali.utils;

import com.globox.ali.entities.NameBasicsEntity;
import com.globox.ali.repository.NameBasicRepositoryImpl;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class NameBasicsInputService {

    @Autowired
    private NameBasicRepositoryImpl nameBasicsRepository;

    @Transactional
    public void importNameBasics(File file) throws IOException {
        try (InputStream inputStream = new FileInputStream(file);
             InputStream decompressedInputStream = GzipUtils.decompressGzip(inputStream);
             Reader reader = new InputStreamReader(decompressedInputStream, StandardCharsets.UTF_8);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('\t').withFirstRecordAsHeader())) {

            List<NameBasicsEntity> nameBasicsEntities = new ArrayList<>();
            for (CSVRecord record : csvParser) {
                NameBasicsEntity entity = new NameBasicsEntity();
                entity.setNconst(record.get("nconst"));
                entity.setPrimaryName(record.get("primaryName"));
                entity.setBirthYear(parseInteger(record.get("birthYear")));
                entity.setDeathYear(parseInteger(record.get("deathYear")));
                entity.setPrimaryProfession(parseArray(record.get("primaryProfession")));
                entity.setKnownForTitles(parseArray(record.get("knownForTitles")));
                nameBasicsEntities.add(entity);
            }
            nameBasicsRepository.saveAll(nameBasicsEntities);
        }
    }

    @Transactional
//    @PostConstruct
    public void importNameBasics() throws IOException {
        File file = new File("C:\\Users\\Yaser\\Downloads\\name.basics.tsv.gz");

        try (InputStream inputStream = new FileInputStream(file);
             InputStream decompressedInputStream = GzipUtils.decompressGzip(inputStream);
             Reader reader = new InputStreamReader(decompressedInputStream, StandardCharsets.UTF_8);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('\t').withFirstRecordAsHeader())) {

            List<NameBasicsEntity> nameBasicsEntities = new ArrayList<>();
            int recordCount = 0;
            for (CSVRecord record : csvParser) {
                if (recordCount >= 3000) {
                    break;
                }
                NameBasicsEntity entity = new NameBasicsEntity();
                entity.setNconst(record.get("nconst"));
                entity.setPrimaryName(record.get("primaryName"));
                entity.setBirthYear(parseInteger(record.get("birthYear")));
                entity.setDeathYear(parseInteger(record.get("deathYear")));
                entity.setPrimaryProfession(parseArray(record.get("primaryProfession")));
                entity.setKnownForTitles(parseArray(record.get("knownForTitles")));
                nameBasicsEntities.add(entity);
                recordCount++;
            }
            nameBasicsRepository.saveAll(nameBasicsEntities);
        }
    }

    private Integer parseInteger(String value) {
        return value.equals("\\N") ? null : Integer.parseInt(value);
    }

    private List<String> parseArray(String value) {
        return value.equals("\\N") ? new ArrayList<>() : Arrays.asList(value.split(","));
    }
}
