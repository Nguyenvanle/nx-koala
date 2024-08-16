package com.koala.backend.repository.mediaRepository;

import com.koala.backend.entity.media.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {

}
