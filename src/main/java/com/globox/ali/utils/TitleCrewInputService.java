package com.globox.ali.utils;

import com.globox.ali.entities.TitleCrewEntity;
import com.globox.ali.repository.TitleCrewRepositoryImplI;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
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
    private TitleCrewRepositoryImplI titleCrewRepository;

    @Value("${app.import.file.to.table.title-crew}")
    private String path;

    @Transactional
    public void importTitleCrew() throws IOException {
        File file = new File(path);
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