import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandomO1 {
    private final Map<Integer, Integer> map;
    private final List<Integer> list;
    private final Random rand;

    public InsertDeleteGetRandomO1() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
}