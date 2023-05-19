package reference.study.controller;

import reference.study.controller.dto.StudyCreatRequestDto;
import reference.study.controller.dto.StudyCreatResponseDto;
import reference.study.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/study")
public class StudyController {

  private StudyService studyService;

  @PostMapping()
  public ResponseEntity<StudyCreatResponseDto> creatStudy(@RequestBody StudyCreatRequestDto studyCreatRequestDto) {
    studyService.addStudy(studyCreatRequestDto);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/test")
  public void b() {}

  @GetMapping()
  public void aaa() {}
}
