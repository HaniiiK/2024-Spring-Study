package hello.core.singleton;

public class SingletonService {
    // static -> 클래스 레벨에 올라가서 하나만 존재하게 된다.
    //스태틱 영역에 하나만 만들어져서 올라가게된다.
    private static final SingletonService instance = new SingletonService();

    //싱글톤 객체를 외부에서 가져다 쓸 수 있도록 하기위해 public으로 메서드를 선언한다.
    //싱글톤 패턴에서 인스턴스를 얻기 위한 메서드
    //jvm뜰 때 객체 생성해서 instance에 넣어둠. 조회할 때 getInstance()
    public static SingletonService getInstance() {
        return instance;
    }

    //private 생성자: 생성을 막기위해
    //->private 다른 class에서 SingletonService singletonService = new SingletonService(); 안됨
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }


}
//정리: 자바가 뜨면서 스태틱 영역에 있는 SingletonService instance를 초기화 하면서 new 생성해서 가지고 있고, 인스턴스의 참조를 꺼낼 수 있는 방법은
//static 메서드를 사용함으로써 인스턴스를 생성하지 않아도 클래스명을 통해 메서드에 접근할 수 있다. 정적 변수는 클래스가 로드될 때 메모리에 할당되며, 해당 클래스의 모든 인스턴스가 공유한다.