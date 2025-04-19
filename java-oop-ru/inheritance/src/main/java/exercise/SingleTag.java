package exercise;

import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String tagName, Map<String, String> tagAttributes) {
        super(tagName, tagAttributes);
    }

    @Override
    public String toString() {

        if (getTagAttributes().isEmpty()) {
            return String.format("<%s>", getTagName());
        }

        var tagAttributesString = getTagAttributes().keySet().stream()
            .map(key -> String.format("%s=\"%s\"", key, getTagAttributes().get(key)))
            .collect(Collectors.joining(" "));
        return String.format("<%s %s>", getTagName(), tagAttributesString);

    }
}
// END
