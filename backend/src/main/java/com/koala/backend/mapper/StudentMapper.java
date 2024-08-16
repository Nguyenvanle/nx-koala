package com.koala.backend.mapper;

import com.koala.backend.dto.request.userRequest.StudentCreateRequest;
import com.koala.backend.dto.request.userRequest.StudentUpdateRequest;
import com.koala.backend.dto.response.userResponse.StudentResponse;
import com.koala.backend.entity.user.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {
  @Mapping(target = "image", ignore = true)// dismiss mapping image_url
  Student toStudent(StudentCreateRequest request);
  StudentResponse toStudentResponse(Student student);
void updateStudent(@MappingTarget Student student, StudentUpdateRequest request);
}
