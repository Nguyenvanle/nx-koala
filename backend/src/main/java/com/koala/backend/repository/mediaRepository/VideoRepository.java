package com.koala.backend.repository.mediaRepository;

import com.koala.backend.entity.media.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, String> {

}
