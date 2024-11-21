//package com.globox.ali.utils;
//
//import com.globox.ali.entities.NameBasicsEntity;
//import com.globox.ali.entities.TitleBasicsEntity;
//import com.globox.ali.entities.TitleCrewEntity;
//import com.globox.ali.repository.*;
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVParser;
//import org.apache.commons.csv.CSVRecord;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.*;
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class DataImportService {
//
//    @Autowired
//    private NameBasicRepositoryImpl nameBasicsRepository;
//    @Autowired
//    private TitleBasicsRepositoryImpl titleBasicsRepository;
//    @Autowired
//    private TitleCrewRepositoryImpl titleCrewRepository;
//    @Autowired
//    private TitlePrincipalsRepositoryImpl titlePrincipalsRepository;
//    @Autowired
//    private TitleRatingsRepositoryImpl titleRatingsRepository;
//
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
//                entity.setProfessions(parseArray(record.get("primaryProfession")));
//                entity.setKnownForTitles(parseArray(record.get("knownForTitles")));
//                nameBasicsEntities.add(entity);
//            }
//            nameBasicsRepository.saveAll(nameBasicsEntities);
//        }
//    }
////
////    @Transactional
////    public void importTitleBasics(File file) throws IOException {
////        try (InputStream inputStream = GzipUtils.decompressGzip(file);
////             Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
////             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('\t').withFirstRecordAsHeader())) {
////
////            List<TitleBasicsEntity> titleBasicsEntities = new ArrayList<>();
////            for (CSVRecord record : csvParser) {
////                TitleBasicsEntity entity = new TitleBasicsEntity();
////                entity.setTconst(record.get("tconst"));
////                entity.setTitleType(record.get("titleType"));
////                entity.setPrimaryTitle(record.get("primaryTitle"));
////                entity.setOriginalTitle(record.get("originalTitle"));
////                entity.setAdult(Boolean.parseBoolean(record.get("isAdult")));
////                entity.setStartYear(parseInteger(record.get("startYear")));
////                entity.setEndYear(parseInteger(record.get("endYear")));
////                entity.setRuntimeMinutes(parseInteger(record.get("runtimeMinutes")));
////                entity.setGenres(record.get("genres"));
////                titleBasicsEntities.add(entity);
////            }
////            titleBasicsRepository.saveAll(titleBasicsEntities);
////        }
////    }
////
////    @Transactional
////    public void importTitleCrew(File file) throws IOException {
////        try (InputStream inputStream = GzipUtils.decompressGzip(file);
////             Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
////             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('\t').withFirstRecordAsHeader())) {
////
////            List<TitleCrewEntity> titleCrewEntities = new ArrayList<>();
////            for (CSVRecord record : csvParser) {
////                TitleCrewEntity entity = new TitleCrewEntity();
////                entity.setTitleId(record.get("tconst"));
////                entity.setDirectorId(record.get("directors"));
////                entity.setWriterId(record.get("writers"));
////                titleCrewEntities.add(entity);
////            }
////            titleCrewRepository.saveAll(titleCrewEntities);
////        }
////    }
////
////    @Transactional
////    public void importTitlePrincipals(File file) throws IOException {
////        try (InputStream inputStream = GzipUtils.decompressGzip(file);
////             Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
////             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('\t').withFirstRecordAsHeader())) {
////
////            List<TitlePrincipalsEntity> titlePrincipalsEntities = new ArrayList<>();
////            for (CSVRecord record : csvParser) {
////                TitlePrincipalsEntity entity = new TitlePrincipalsEntity();
////                entity.setMovieId(record.get("tconst"));
////                entity.setName(record.get("nconst"));
////                entity.setCategory(record.get("category"));
////                titlePrincipalsEntities.add(entity);
////            }
////            titlePrincipalsRepository.saveAll(titlePrincipalsEntities);
////        }
////    }
////
////    @Transactional
////    public void importTitleRatings(File file) throws IOException {
////        try (InputStream inputStream = GzipUtils.decompressGzip(file);
////             Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
////             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('\t').withFirstRecordAsHeader())) {
////
////            List<TitleRatingsEntity> titleRatingsEntities = new ArrayList<>();
////            for (CSVRecord record : csvParser) {
////                TitleRatingsEntity entity = new TitleRatingsEntity();
////                entity.setTconst(record.get("tconst"));
////                entity.setAverageRating(Float.parseFloat(record.get("averageRating")));
////                entity.setNumVotes(Integer.parseInt(record.get("numVotes")));
////                titleRatingsEntities.add(entity);
////            }
////            titleRatingsRepository.saveAll(titleRatingsEntities);
////        }
////    }
//
//    private Integer parseInteger(String value) {
//        try {
//            return Integer.parseInt(value);
//        } catch (NumberFormatException e) {
//            return null;
//        }
//    }
//}