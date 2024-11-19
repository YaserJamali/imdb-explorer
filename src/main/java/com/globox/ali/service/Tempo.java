//package com.globox.ali.service;
//
//public class Tempo {
//}
//
//
////        2.
////خواندن و
////استخراج فایلهای
////gzip
////import java.io .*;
////        import java.util.zip.GZIPInputStream;
//
//public class GzipUtils {
//    public static InputStream decompressGzip(File file) throws IOException {
//        return new GZIPInputStream(new FileInputStream(file));
//    }
//}
//
////3.
////خواندن دادههای
////TSV و
////تبدیل آنها
////به موجودیتهای
////جاوا
////import org.apache.commons.csv.CSVFormat;
////import org.apache.commons.csv.CSVParser;
////import org.apache.commons.csv.CSVRecord;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import javax.transaction.Transactional;
////import java.io .*;
////        import java.nio.charset.StandardCharsets;
////import java.util.ArrayList;
////import java.util.List;
//
//@Service
//public class DataImportService {
//
//    @Autowired
//    private NameBasicsRepository nameBasicsRepository;
//    @Autowired
//    private TitleBasicsRepository titleBasicsRepository;
//    @Autowired
//    private TitleCrewRepository titleCrewRepository;
//    @Autowired
//    private TitlePrincipalsRepository titlePrincipalsRepository;
//    @Autowired
//    private TitleRatingsRepository titleRatingsRepository;
//
//    @Transactional
//    public void importNameBasics(File file) throws IOException {
//        try (InputStream inputStream = GzipUtils.decompressGzip(file);
//             Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
//             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('\t').withFirstRecordAsHeader())) {
//
//            List<NameBasicsEntity> nameBasicsEntities = new ArrayList<>();
//            for (CSVRecord record : csvParser) {
//                NameBasicsEntity entity = new NameBasicsEntity();
//                entity.setNconst(record.get("nconst"));
//                entity.setPrimaryName(record.get("primaryName"));
//                entity.setBirthYear(parseInteger(record.get("birthYear")));
//                entity.setDeathYear(parseInteger(record.get("deathYear")));
//                nameBasicsEntities.add(entity);
//            }
//            nameBasicsRepository.saveAll(nameBasicsEntities);
//        }
//    }
//
//    @Transactional
//    public void importTitleBasics(File file) throws IOException {
//        try (InputStream inputStream = GzipUtils.decompressGzip(file);
//             Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
//             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('\t').withFirstRecordAsHeader())) {
//
//            List<TitleBasicsEntity> titleBasicsEntities = new ArrayList<>();
//            for (CSVRecord record : csvParser) {
//                TitleBasicsEntity entity = new TitleBasicsEntity();
//                entity.setTconst(record.get("tconst"));
//                entity.setTitleType(record.get("titleType"));
//                entity.setPrimaryTitle(record.get("primaryTitle"));
//                entity.setOriginalTitle(record.get("originalTitle"));
//                entity.setIsAdult(Boolean.parseBoolean(record.get("isAdult")));
//                entity.setStartYear(parseInteger(record.get("startYear")));
//                entity.setEndYear(parseInteger(record.get("endYear")));
//                entity.setRuntimeMinutes(parseInteger(record.get("runtimeMinutes")));
//                entity.setGenres(record.get("genres"));
//                titleBasicsEntities.add(entity);
//            }
//            titleBasicsRepository.saveAll(titleBasicsEntities);
//        }
//    }
//
//    @Transactional
//    public void importTitleCrew(File file) throws IOException {
//        try (InputStream inputStream = GzipUtils.decompressGzip(file);
//             Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
//             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('\t').withFirstRecordAsHeader())) {
//
//            List<TitleCrewEntity> titleCrewEntities = new ArrayList<>();
//            for (CSVRecord record : csvParser) {
//                TitleCrewEntity entity = new TitleCrewEntity();
//                entity.setTitleId(record.get("tconst"));
//                entity.setDirectorId(record.get("directors"));
//                entity.setWriterId(record.get("writers"));
//                titleCrewEntities.add(entity);
//            }
//            titleCrewRepository.saveAll(titleCrewEntities);
//        }
//    }
//
//    @Transactional
//    public void importTitlePrincipals(File file) throws IOException {
//        try (InputStream inputStream = GzipUtils.decompressGzip(file);
//             Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
//             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('\t').withFirstRecordAsHeader())) {
//
//            List<TitlePrincipalsEntity> titlePrincipalsEntities = new ArrayList<>();
//            for (CSVRecord record : csvParser) {
//                TitlePrincipalsEntity entity = new TitlePrincipalsEntity();
//                entity.setMovieId(record.get("tconst"));
//                entity.setName(record.get("nconst"));
//                entity.setCategory(record.get("category"));
//                titlePrincipalsEntities.add(entity);
//            }
//            titlePrincipalsRepository.saveAll(titlePrincipalsEntities);
//        }
//    }
//
//    @Transactional
//    public void importTitleRatings(File file) throws IOException {
//        try (InputStream inputStream = GzipUtils.decompressGzip(file);
//             Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
//             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('\t').withFirstRecordAsHeader())) {
//
//            List<TitleRatingsEntity> titleRatingsEntities = new ArrayList<>();
//            for (CSVRecord record : csvParser) {
//                TitleRatingsEntity entity = new TitleRatingsEntity();
//                entity.setTconst(record.get("tconst"));
//                entity.setAverageRating(Float.parseFloat(record.get("averageRating")));
//                entity.setNumVotes(Integer.parseInt(record.get("numVotes")));
//                titleRatingsEntities.add(entity);
//            }
//            titleRatingsRepository.saveAll(titleRatingsEntities);
//        }
//    }
//
//    private Integer parseInteger(String value) {
//        try {
//            return Integer.parseInt(value);
//        } catch (NumberFormatException e) {
//            return null;
//        }
//    }
//}
//
////4.Repositoryها
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface NameBasicsRepository extends JpaRepository<NameBasicsEntity, String> {
//}
//
//public interface TitleBasicsRepository extends JpaRepository<TitleBasicsEntity, String> {
//}
//
//public interface TitleCrewRepository extends JpaRepository<TitleCrewEntity, Long> {
//}
//
//public interface TitlePrincipalsRepository extends JpaRepository<TitlePrincipalsEntity, Long> {
//}
//
//public interface TitleRatingsRepository extends JpaRepository<TitleRatingsEntity, String> {
//}
//
////5.
////اجرای وارد
////کردن دادهها
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.io.File;
//
//@Component
//public class DataImportRunner implements CommandLineRunner {
//
//    @Autowired
//    private DataImportService dataImportService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        dataImportService.importNameBasics(new File("path/to/name.basics.tsv.gz"));
//        dataImportService.importTitleBasics(new File("path/to/title.basics.tsv.gz"));
//        dataImportService.importTitleCrew(new File("path/to/title.crew.tsv.gz"));
//        dataImportService.importTitlePrincipals(new File("path/to/title.principals.tsv.gz"));
//        dataImportService.importTitleRatings(new File("path/to/title.ratings.tsv.gz"));
//    }
//}
