package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {

    public String tagBody;
    public List<Tag> otherTags;

    public PairedTag(String tagName, Map<String, String> tagAttributes, String tagBody, List<Tag> otherTags) {
        super(tagName, tagAttributes);
        this.tagBody = tagBody;
        this.otherTags = otherTags;
    }

    @Override
    public String toString() {

        var tagResult = "";

        if (getTagAttributes().isEmpty()) {
            tagResult = String.format("<%s>", getTagName());
        } else {
            var tagAttributesString = getTagAttributes().keySet().stream()
                .map(key -> String.format("%s=\"%s\"", key, getTagAttributes().get(key)))
                .collect(Collectors.joining(" "));
            tagResult = String.format("<%s %s>", getTagName(), tagAttributesString);
        }

        var otherTagsResult = "";

        for (var otherTag : otherTags) {
            otherTagsResult += otherTag.toString();
        }

        return String.format("%s%s%s</%s>", tagResult, otherTagsResult, tagBody, getTagName());
    }
}
// END
