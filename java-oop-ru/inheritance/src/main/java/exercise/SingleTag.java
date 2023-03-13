package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
    }

    @Override
    public String toString() {
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
        return builder.toString();
    }
}
// END
