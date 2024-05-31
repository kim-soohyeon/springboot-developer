import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitCycleQuiz {

    // 각 테스트를 수행하기 전 출력
    @BeforeEach
    public void beforeEach(){
        System.out.println("Hello!");
    }

    // 모든 테스트 종료 후 출력
    @AfterAll
    static void afterAll(){
        System.out.println("Bye!");
    }

    @Test
    public void junitQuiz3(){
        System.out.println("This is first test");
    }

    @Test
    public void junitQuiz4(){
        System.out.println("This is second test");
    }
}
