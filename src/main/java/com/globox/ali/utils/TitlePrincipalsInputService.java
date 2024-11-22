package com.globox.ali.utils;

import com.globox.ali.entities.TitlePrincipalsEntity;
import com.globox.ali.repository.TitlePrincipalsRepositoryImpl;
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
public class TitlePrincipalsInputService {

    @Autowired
    private TitlePrincipalsRepositoryImpl titlePrincipalsRepository;

    @Transactional
    public void importTitlePrincipals(File file) throws IOException {
        try (InputStream inputStream = new FileInputStream(file);
             InputStream decompressedInputStream = GzipUtils.decompressGzip(inputStream);
             Reader reader = new InputStreamReader(decompressedInputStream, StandardCharsets.UTF_8);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('\t').withFirstRecordAsHeader())) {

            List<TitlePrincipalsEntity> titlePrincipalsEntities = new ArrayList<>();
            for (CSVRecord record : csvParser) {
                TitlePrincipalsEntity entity = new TitlePrincipalsEntity();
                entity.setTconst(record.get("tconst"));
                entity.setOrdering(Integer.parseInt(record.get("ordering")));
                entity.setNconst(record.get("nconst"));
                entity.setCategory(record.get("category"));
                entity.setJob(record.get("job").equals("\\N") ? null : record.get("job"));
                entity.setCharacters(record.get("characters").equals("\\N") ? null : record.get("characters"));
                titlePrincipalsEntities.add(entity);
            }
            titlePrincipalsRepository.saveAll(titlePrincipalsEntities);
        }
    }


    @Transactional
//    @PostConstruct
    public void importTitlePrincipals() throws IOException {
        File file = new File("C:\\Users\\Yaser\\Downloads\\title.principals.tsv.gz");
        try (InputStream inputStream = new FileInputStream(file);
             InputStream decompressedInputStream = GzipUtils.decompressGzip(inputStream);
             Reader reader = new InputStreamReader(decompressedInputStream, StandardCharsets.UTF_8);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('\t').withFirstRecordAsHeader())) {

            List<TitlePrincipalsEntity> titlePrincipalsEntities = new ArrayList<>();
            int recordCount = 0;
            for (CSVRecord record : csvParser) {
                if (recordCount >= 200000) {
                    break;
                }
                TitlePrincipalsEntity entity = new TitlePrincipalsEntity();
                entity.setTconst(record.get("tconst"));
                entity.setOrdering(Integer.parseInt(record.get("ordering")));
                entity.setNconst(record.get("nconst"));
                entity.setCategory(record.get("category"));
                entity.setJob(record.get("job").equals("\\N") ? null : record.get("job"));
                entity.setCharacters(record.get("characters").equals("\\N") ? null : record.get("characters"));
                titlePrincipalsEntities.add(entity);
                recordCount++;
            }
            titlePrincipalsRepository.saveAll(titlePrincipalsEntities);
        }
    }

    private List<String> parseArray(String value) {
        return value.equals("\\N") ? new ArrayList<>() : Arrays.asList(value.split(","));
    }
}
