package com.koala.backend.controller.mediaController;

import com.koala.backend.dto.request.mediaRequest.VideoCreateRequest;
import com.koala.backend.dto.response.ApiResponse;
import com.koala.backend.dto.response.mediaResponse.VideoResponse;
import com.koala.backend.service.mediaService.VideoService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/media/videos")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VideoController {
  VideoService videoService;

  @PostMapping
  ApiResponse<VideoResponse> createVideo(@RequestBody VideoCreateRequest request) {
    return ApiResponse.<VideoResponse>builder()
      .result(videoService.createVideo(request))
      .build();
  }

  @GetMapping("/{videoId}")
  ApiResponse<VideoResponse> getVideo(@PathVariable String videoId) {
    return ApiResponse.<VideoResponse>builder()
      .result(videoService.getVideo(videoId))
      .build();
  }

  @GetMapping
  ApiResponse<List<VideoResponse>> getVideos() {
    return ApiResponse.<List<VideoResponse>>builder()
      .result(videoService.getVideos())
      .build();
  }

  @DeleteMapping("/{videoId}")
  ApiResponse<Void> deleteVideo(@PathVariable String videoId) {
    videoService.deleteVideo(videoId);
    return ApiResponse.<Void>builder()
      .message("Video has been deleted!")
      .build();
  }
}
