package hello.core.member;

public class Member {
    private Long id;
    private String name;
    private Grade grade;


    //command N 생성자 만드는 단축키 command+ a 전체 선택
// 객체가 생성될 때 필요한 초기값을 설정하거나, 객체를 사용하기 전에 필요한 설정 작업을 수행한다.
    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
//데이터를 다른 클래스에서 가져오고, 저장하기 위해 (일시적으로 뽑고 넣음) private 값 설정 가능
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
