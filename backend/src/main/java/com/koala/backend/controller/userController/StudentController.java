package com.koala.backend.controller.userController;

import com.koala.backend.dto.request.userRequest.StudentCreateRequest;
import com.koala.backend.dto.request.userRequest.StudentUpdateRequest;
import com.koala.backend.dto.response.ApiResponse;
import com.koala.backend.dto.response.userResponse.StudentResponse;
import com.koala.backend.service.userService.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {
  StudentService studentService;
  @PostMapping
  ApiResponse<StudentResponse> createStudent(@RequestBody StudentCreateRequest request) {
    return ApiResponse.<StudentResponse>builder()
      .result(studentService.createStudent(request))
      .build();
  }
  @PutMapping("/{userId}")
  ApiResponse<StudentResponse> updateStudent(@PathVariable String userId, @RequestBody StudentUpdateRequest request) {
    return ApiResponse.<StudentResponse>builder()
      .result(studentService.updateStudent(userId,request))
      .build();
  }
  @GetMapping("/{userId}")
  ApiResponse<StudentResponse> getStudent(@PathVariable String userId) {
    return ApiResponse.<StudentResponse>builder()
      .result(studentService.getStudent(userId))
      .build();
  }

  @GetMapping
  ApiResponse<List<StudentResponse>> getStudents() {
    return ApiResponse.<List<StudentResponse>>builder()
      .result(studentService.getStudents())
      .build();
  }

  @DeleteMapping("/{userId}")
  ApiResponse<Void> deleteStudent(@PathVariable String userId) {
    studentService.deleteStudent(userId);
    return ApiResponse.<Void>builder()
      .message("Student has been deleted!")
      .build();
  }

}
