package reference.study.entiy;

import com.example.studyproject.Entity.Member;
import com.example.studyproject.domain.defaultEntity.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Study extends BaseTimeEntity {

  @Id
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String subject;

  @Column(nullable = false)
  private String method;

  @OneToMany(fetch = FetchType.LAZY)
  private List<Member> members = new ArrayList<>();

  public Study(){}

  public Study(String name, String subject) {
    this.name = name;
    this.subject = subject;
  }
}
