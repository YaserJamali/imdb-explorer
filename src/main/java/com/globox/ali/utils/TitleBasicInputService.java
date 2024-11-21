package com.globox.ali.utils;

import com.globox.ali.entities.TitleBasicsEntity;
import com.globox.ali.repository.TitleBasicsRepositoryImpl;
import jakarta.annotation.PostConstruct;
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
public class TitleBasicInputService {

    @Autowired
    private TitleBasicsRepositoryImpl titleBasicsRepository;

    @Transactional
    public void importTitleBasics(File file) throws IOException {
        try (InputStream inputStream = new FileInputStream(file);
             InputStream decompressedInputStream = GzipUtils.decompressGzip(inputStream);
             Reader reader = new InputStreamReader(decompressedInputStream, StandardCharsets.UTF_8);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('\t').withFirstRecordAsHeader())) {

            List<TitleBasicsEntity> titleBasicsEntities = new ArrayList<>();
            for (CSVRecord record : csvParser) {
                TitleBasicsEntity entity = new TitleBasicsEntity();
                entity.setTconst(record.get("tconst"));
                entity.setTitleType(record.get("TITLE_TYPE"));
                entity.setPrimaryTitle(record.get("PRIMARY_TITLE"));
                entity.setOriginalTitle(record.get("ORIGINAL_TITLE"));
                entity.setAdult(parseBoolean(record.get("IS_ADULT")));
                entity.setStartYear(parseInteger(record.get("START_YEAR")));
                entity.setEndYear(parseInteger(record.get("END_YEAR")));
                entity.setRuntimeMinutes(parseInteger(record.get("RUNTIME_MINUTES")));
                entity.setGenres(parseArray(record.get("genres")));
                titleBasicsEntities.add(entity);
            }
            titleBasicsRepository.saveAll(titleBasicsEntities);
        }
    }


    @Transactional
//    @PostConstruct
    public void importTitleBasics() throws IOException {
        File file = new File("C:\\Users\\Yaser\\Downloads\\title.basics.tsv.gz");
        try (InputStream inputStream = new FileInputStream(file);
             InputStream decompressedInputStream = GzipUtils.decompressGzip(inputStream);
             Reader reader = new InputStreamReader(decompressedInputStream, StandardCharsets.UTF_8);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('\t').withFirstRecordAsHeader())) {

            List<TitleBasicsEntity> titleBasicsEntities = new ArrayList<>();
            int recordCount = 0;
            for (CSVRecord record : csvParser) {
                if (recordCount >= 2) {
                    break;
                }
                TitleBasicsEntity entity = new TitleBasicsEntity();
                entity.setTconst(record.get("tconst"));
                entity.setTitleType(record.get("TITLE_TYPE"));
                entity.setPrimaryTitle(record.get("PRIMARY_TITLE"));
                entity.setOriginalTitle(record.get("ORIGINAL_TITLE"));
                entity.setAdult(parseBoolean(record.get("IS_ADULT")));
                entity.setStartYear(parseInteger(record.get("START_YEAR")));
                entity.setEndYear(parseInteger(record.get("END_YEAR")));
                entity.setRuntimeMinutes(parseInteger(record.get("RUNTIME_MINUTES")));
                entity.setGenres(parseArray(record.get("genres")));
                titleBasicsEntities.add(entity);
                recordCount++;
            }
            titleBasicsRepository.saveAll(titleBasicsEntities);
        }
    }

    private Integer parseInteger(String value) {
        return value.equals("\\N") ? null : Integer.parseInt(value);
    }

    private Boolean parseBoolean(String value) {
        return value.equals("1");
    }

    private List<String> parseArray(String value) {
        return value.equals("\\N") ? new ArrayList<>() : Arrays.asList(value.split(","));
    }
}
