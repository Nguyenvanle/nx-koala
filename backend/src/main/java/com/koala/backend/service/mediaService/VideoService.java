package com.koala.backend.service.mediaService;

import com.koala.backend.dto.request.mediaRequest.VideoCreateRequest;
import com.koala.backend.dto.response.mediaResponse.VideoResponse;
import com.koala.backend.entity.media.Video;
import com.koala.backend.exception.AppException;
import com.koala.backend.exception.ErrorCode;
import com.koala.backend.mapper.VideoMapper;
import com.koala.backend.repository.mediaRepository.VideoRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VideoService {
  VideoRepository videoRepository;
  VideoMapper videoMapper;

  public VideoResponse createVideo(VideoCreateRequest request) {
    Video video = videoMapper.toVideo(request);
    return videoMapper.toVideoResponse(videoRepository.save(video));
  }

  public VideoResponse getVideo(String videoId) {
    return videoMapper.toVideoResponse(videoRepository.findById(videoId)
      .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_VIDEO)));
  }

  public List<VideoResponse> getVideos() {
    var videos = videoRepository.findAll();
    return videos.stream().map(videoMapper::toVideoResponse).toList();
  }

  public void deleteVideo(String videoId) {
    videoRepository.deleteById(videoId);
  }
}
