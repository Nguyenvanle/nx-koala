package com.koala.backend.service.userService;

import com.koala.backend.dto.request.userRequest.StudentCreateRequest;
import com.koala.backend.dto.request.userRequest.StudentUpdateRequest;
import com.koala.backend.dto.response.userResponse.StudentResponse;
import com.koala.backend.entity.user.Student;
import com.koala.backend.enums.Role;
import com.koala.backend.exception.AppException;
import com.koala.backend.exception.ErrorCode;
import com.koala.backend.mapper.StudentMapper;
import com.koala.backend.repository.mediaRepository.ImageRepository;
import com.koala.backend.repository.userRepository.StudentRepository;
import com.koala.backend.repository.userRepository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService {
  StudentRepository studentRepository;
  UserRepository userRepository;
  ImageRepository imageRepository;
  StudentMapper studentMapper;

  public StudentResponse createStudent(StudentCreateRequest request) {
    if (userRepository.existsByUsername(request.getUsername())) throw new AppException(ErrorCode.USERNAME_EXISTED);
    Student student = studentMapper.toStudent(request);
    student.setRole(Role.STUDENT.name());
    if (request.getImageUrl() != null) {
      var image = imageRepository.findById(request.getImageUrl())
        .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_IMAGE));
      student.setImage(image);
    }
    return studentMapper.toStudentResponse(studentRepository.save(student));
  }

  public StudentResponse updateStudent(String userId, StudentUpdateRequest request) {
    var student = studentRepository.findById(userId)
      .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
    studentMapper.updateStudent(student, request);
    if (request.getImageUrl() != null) {
      var image = imageRepository.findById(request.getImageUrl())
        .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_IMAGE));
      student.setImage(image);
    }
    return studentMapper.toStudentResponse(studentRepository.save(student));
  }

  public StudentResponse getStudent(String userId) {
    return studentMapper.toStudentResponse(studentRepository.findById(userId)
      .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
  }

  public List<StudentResponse> getStudents() {
    return studentRepository.findAll()
      .stream()
      .map(studentMapper::toStudentResponse)
      .toList();
  }

  public void deleteStudent(String userId) {
    studentRepository.deleteById(userId);
  }

}
