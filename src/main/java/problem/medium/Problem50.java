package problem.medium;

import java.util.List;

public class Problem50 {

    /**
     * 주어진 정수 리스트에서 합이 10을 초과하는 최초의 연속된 부분 리스트를 반환합니다.
     * 예를 들어, [1, 2, 3, 5, 4]의 경우 [3, 5, 4]가 해당합니다.
     *
     * @param numbers 정수 리스트
     * @return 합이 10을 초과하는 최초의 연속된 부분 리스트
     */
    public static List<Integer> findFirstSublistWithSumOverTen(List<Integer> numbers) {
        return numbers.stream()
                .filter(i -> numbers.get(i) + numbers.get(i+1) + numbers.get(i+2) > 10)
                .peek(i -> System.out.println(numbers.get(i)  + ", " + numbers.get(i+1) + ", " + numbers.get(i+2)))
                .toList();
    }
}
