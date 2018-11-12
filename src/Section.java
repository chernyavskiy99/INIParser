import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Section {
    private String name;
    private Map<String, String> mapLine = new HashMap<>();

    Section(String name) {
        this.name = name;
    }

    Section(String name, Map<String, String> mapLine) {
        this.name = name;
        this.mapLine = mapLine;
    }

    String getName() {
        return name;
    }

    public Map<String, String> getMapLine() {
        return mapLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Section)) return false;
        Section section = (Section) o;
        return Objects.equals(getName(), section.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
