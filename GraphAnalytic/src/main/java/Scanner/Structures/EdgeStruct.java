package Scanner.Structures;

import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public class EdgeStruct {
    int weight;
    UUID id;

    public EdgeStruct() {
        weight = 1;
        id = UUID.randomUUID();
    }

    public EdgeStruct(int wt) {
        weight = wt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EdgeStruct)) return false;
        EdgeStruct that = (EdgeStruct) obj;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }
}
