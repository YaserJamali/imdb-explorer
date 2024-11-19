package com.globox.ali.repository;

import com.globox.ali.entities.Library;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier("libraryRepository")
public interface LibraryRepository extends BaseRepository<Library, Long> {

}
