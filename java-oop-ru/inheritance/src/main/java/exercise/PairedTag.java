package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private final String body;
    private final List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        String childrenAsString = children.stream()
                .map(Tag::toString)
                .collect(Collectors.joining());
        StringBuilder builder = new StringBuilder("<");
        builder.append(getName());
        for (Map.Entry<String, String> entry: getAttributes().entrySet()) {
            builder.append(" ");
            builder.append(entry.getKey());
            builder.append("=");
            builder.append("\"");
            builder.append(entry.getValue());
            builder.append("\"");
        }
        builder.append(">");
        builder.append(body);
        builder.append(childrenAsString);
        builder.append("</");
        builder.append(getName());
        builder.append(">");
        return builder.toString();
    }
}
// END
