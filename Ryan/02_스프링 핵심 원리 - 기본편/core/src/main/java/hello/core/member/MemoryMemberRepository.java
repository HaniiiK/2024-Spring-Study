package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{
    //실무에서는 동시성 문제 때문에 ConcurrentHashMap 사용한다
    //메모리 버전의 구현체이다. 아직 실제 DB사용x
    private static Map<Long, Member> store = new HashMap<>();
//static 다른 클래스에서 store를 사용하려면, Member 클래스의 인스턴스를 생성하지 않고도 직접 접근할 수 있다.
//option+enter
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
