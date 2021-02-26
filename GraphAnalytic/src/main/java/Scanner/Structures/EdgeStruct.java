package Scanner.Structures;

import java.util.Objects;

public class EdgeStruct {
    int weight;

    public EdgeStruct() {
        weight = 1;
    }

    public EdgeStruct(int wt) {
        weight = wt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EdgeStruct)) return false;
        EdgeStruct that = (EdgeStruct) obj;
        return weight == that.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }
}
