package com.globox.ali.utils;

import com.globox.ali.entities.TitleRatingsEntity;
import com.globox.ali.repository.TitleRatingsRepositoryImplI;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


@Service
public class TitleRatingsInputService {

    @Autowired
    private TitleRatingsRepositoryImplI repository;

    @Value("${app.import.file.to.table.title-rating}")
    private String path;

    @Transactional
    public void importTitleRatings() throws IOException {
        File file = new File(path);
        try (InputStream inputStream = new FileInputStream(file);
             InputStream decompressedInputStream = GzipUtils.decompressGzip(inputStream);
             Reader reader = new InputStreamReader(decompressedInputStream, StandardCharsets.UTF_8);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('\t').withFirstRecordAsHeader())) {

            List<TitleRatingsEntity> titleRatingsEntities = new ArrayList<>();
            for (CSVRecord record : csvParser) {
                TitleRatingsEntity entity = new TitleRatingsEntity();
                entity.setTconst(record.get("tconst"));
                entity.setAverageRating(Double.parseDouble(record.get("averageRating")));
                entity.setNumVotes(Integer.parseInt(record.get("numVotes")));
                titleRatingsEntities.add(entity);
            }
            repository.saveAll(titleRatingsEntities);
        }
    }
}
