package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
@Getter
@Setter
@AllArgsConstructor
public class Tag {
    private String tagName;
    private Map<String, String> tagAttributes;
}
// END
