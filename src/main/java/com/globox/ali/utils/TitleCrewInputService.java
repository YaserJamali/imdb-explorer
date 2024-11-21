package com.globox.ali.utils;

import com.globox.ali.entities.TitleCrewEntity;
import com.globox.ali.repository.TitleCrewRepositoryImpl;
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
public class TitleCrewInputService {

    @Autowired
    private TitleCrewRepositoryImpl titleCrewRepository;

    @Transactional
    public void importTitlePrincipals(File file) throws IOException {
        try (InputStream inputStream = new FileInputStream(file);
             InputStream decompressedInputStream = GzipUtils.decompressGzip(inputStream);
             Reader reader = new InputStreamReader(decompressedInputStream, StandardCharsets.UTF_8);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('\t').withFirstRecordAsHeader())) {

            List<TitleCrewEntity> titleCrewEntities = new ArrayList<>();
            for (CSVRecord record : csvParser) {
                TitleCrewEntity entity = new TitleCrewEntity();
                entity.setTconst(record.get("tconst"));
                entity.setDirectors(parseArray(record.get("directors")));
                entity.setWriters(parseArray(record.get("writers")));
                titleCrewEntities.add(entity);
            }
            titleCrewRepository.saveAll(titleCrewEntities);
        }
    }


    @Transactional
//    @PostConstruct
    public void importTitleCrew() throws IOException {
        File file = new File("C:\\Users\\Yaser\\Downloads\\title.crew.tsv.gz");
        try (InputStream inputStream = new FileInputStream(file);
             InputStream decompressedInputStream = GzipUtils.decompressGzip(inputStream);
             Reader reader = new InputStreamReader(decompressedInputStream, StandardCharsets.UTF_8);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('\t').withFirstRecordAsHeader())) {

            List<TitleCrewEntity> titleCrewEntities = new ArrayList<>();
            int recordCount = 0;
            for (CSVRecord record : csvParser) {
                if (recordCount >= 2000) {
                    break;
                }
                TitleCrewEntity entity = new TitleCrewEntity();
                entity.setTconst(record.get("tconst"));
                entity.setDirectors(parseArray(record.get("directors")));
                entity.setWriters(parseArray(record.get("writers")));
                titleCrewEntities.add(entity);
                recordCount++;
            }
            titleCrewRepository.saveAll(titleCrewEntities);
        }
    }


    private List<String> parseArray(String value) {
        return value.equals("\\N") ? new ArrayList<>() : Arrays.asList(value.split(","));
    }
}