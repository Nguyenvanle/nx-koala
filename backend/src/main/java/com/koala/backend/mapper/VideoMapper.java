package com.koala.backend.mapper;

import com.koala.backend.dto.request.mediaRequest.VideoCreateRequest;
import com.koala.backend.dto.response.mediaResponse.VideoResponse;
import com.koala.backend.entity.media.Video;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VideoMapper {
  Video toVideo(VideoCreateRequest request);
  VideoResponse toVideoResponse(Video video);
}
