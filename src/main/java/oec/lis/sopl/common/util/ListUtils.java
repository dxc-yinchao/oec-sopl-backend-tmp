package oec.lis.sopl.common.util;

import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {
    public static List<String> intersect( List<String> list, List<String> otherList ) {
        List<String> result = list.stream()
            .distinct()
            .filter(otherList::contains)
            .collect(Collectors.toList());

        return result;
    }
}
