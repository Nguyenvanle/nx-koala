package com.koala.backend.service.mediaService;

import com.koala.backend.dto.request.mediaRequest.ImageCreateRequest;
import com.koala.backend.dto.response.mediaResponse.ImageResponse;
import com.koala.backend.entity.media.Image;
import com.koala.backend.exception.AppException;
import com.koala.backend.exception.ErrorCode;
import com.koala.backend.mapper.ImageMapper;
import com.koala.backend.repository.mediaRepository.ImageRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ImageService {
  ImageRepository imageRepository;
  ImageMapper imageMapper;

  public ImageResponse createImage(ImageCreateRequest request) {
    Image image = imageMapper.toImage(request);
    return imageMapper.toImageResponse(imageRepository.save(image));
  }

  public ImageResponse getImage(String imageId) {
    return imageMapper.toImageResponse(imageRepository.findById(imageId)
      .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_IMAGE)));
  }

  public List<ImageResponse> getImages() {
    var images = imageRepository.findAll();
    return images.stream().map(imageMapper::toImageResponse).toList();
  }

  public void deleteImage(String imageId) {
    imageRepository.deleteById(imageId);
  }
}
