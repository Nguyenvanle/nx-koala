package com.koala.backend.mapper;

import com.koala.backend.dto.request.mediaRequest.ImageCreateRequest;
import com.koala.backend.dto.response.mediaResponse.ImageResponse;
import com.koala.backend.entity.media.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper {
  Image toImage(ImageCreateRequest request);
  ImageResponse toImageResponse(Image image);
}
