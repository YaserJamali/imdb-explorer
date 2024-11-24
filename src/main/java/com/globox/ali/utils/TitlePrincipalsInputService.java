package com.globox.ali.utils;

import com.globox.ali.entities.TitlePrincipalsEntity;
import com.globox.ali.repository.TitlePrincipalsRepositoryImplI;
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
public class TitlePrincipalsInputService {

    @Autowired
    private TitlePrincipalsRepositoryImplI titlePrincipalsRepository;

    @Value("${app.import.file.to.table.title-principals}")
    private String path;

    @Transactional
    public void importTitlePrincipals() throws IOException {
        File file = new File(path);
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

}
