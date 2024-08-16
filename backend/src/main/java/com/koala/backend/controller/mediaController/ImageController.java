package com.koala.backend.controller.mediaController;

import com.koala.backend.dto.request.mediaRequest.ImageCreateRequest;
import com.koala.backend.dto.response.ApiResponse;
import com.koala.backend.dto.response.mediaResponse.ImageResponse;
import com.koala.backend.service.mediaService.ImageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/media/images")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ImageController {
  ImageService imageService;

  @PostMapping
  ApiResponse<ImageResponse> createImage(@RequestBody ImageCreateRequest request) {
    return ApiResponse.<ImageResponse>builder()
      .result(imageService.createImage(request))
      .build();
  }

  @GetMapping("/{imageId}")
  ApiResponse<ImageResponse> getImage(@PathVariable String imageId) {
    return ApiResponse.<ImageResponse>builder()
      .result(imageService.getImage(imageId))
      .build();
  }

  @GetMapping
  ApiResponse<List<ImageResponse>> getImages() {
    return ApiResponse.<List<ImageResponse>>builder()
      .result(imageService.getImages())
      .build();
  }

  @DeleteMapping("/{imageId}")
  ApiResponse<Void> deleteImage(@PathVariable String imageId) {
    imageService.deleteImage(imageId);
    return ApiResponse.<Void>builder()
      .message("Image has been deleted!")
      .build();
  }
}
