package problem.hard;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem61 {

    /**
     * 주어진 문자열 리스트에서, 'key=value' 형태의 패턴을 가진 문자열을 찾아,
     * 이를 Map으로 변환합니다. 여기서 key는 Map의 키로, value는 정수 값으로 변환되어 Map의 값이 됩니다.
     * 문자열이 올바른 'key=value' 형태가 아니거나, value가 정수로 변환될 수 없는 경우 해당 문자열은 무시합니다.
     *
     * @param strings 문자열 리스트
     * @return 'key=value' 패턴의 문자열을 key와 정수 value로 변환한 Map
     */
    public static Map<String, Integer> extractKeyValuePairs(List<String> strings) {
        return strings.stream()
                .filter(str -> str.contains("="))
                .map(str -> str.split("="))
                .filter(arr -> isInteger(arr[1]))
                .collect(Collectors.toMap(
                        arr -> arr[0],
                        arr -> Integer.valueOf(arr[1])
                ));
    }

    private static boolean isInteger(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
