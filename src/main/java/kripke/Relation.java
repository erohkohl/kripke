package kripke;

/**
 * @author Matthias on 16.08.2017.
 */
public class Relation {
    private final String first;
    private final String second;

    public Relation(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Relation relation = (Relation) o;

        if (first != null ? !first.equals(relation.first) : relation.first != null) return false;
        return second != null ? second.equals(relation.second) : relation.second == null;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "first='" + first + '\'' +
                ", second='" + second + '\'' +
                '}';
    }
}
