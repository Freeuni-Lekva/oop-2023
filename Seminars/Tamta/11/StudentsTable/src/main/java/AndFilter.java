import java.util.ArrayList;
import java.util.List;

public class AndFilter implements Filter{
    List<Filter> filters;

    public AndFilter() {
        filters = new ArrayList<>();
    }

    public void addFilter(Filter newFilter) {
        filters.add(newFilter);
    }

    @Override
    public boolean filter(Student student) {
        for (Filter filter: filters) {
            if (!filter.filter(student))
                return false;
        }
        return true;
    }
}
