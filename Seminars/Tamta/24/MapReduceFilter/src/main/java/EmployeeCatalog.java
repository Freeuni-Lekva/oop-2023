import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeCatalog {

    List<Employee> employees;

    public EmployeeCatalog(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee findEmployeeWithHighestSalary() {
        return employees.stream().reduce(null, (maxSalary, employee) -> {
            if (maxSalary == null) return employee;
            if (maxSalary.getSalary() <= employee.getSalary()) {
                return employee;
            }
            return maxSalary;
        });
    }

    private class MinMax{

        private int min;
        private int max;

        public MinMax(int min, int max){
            this.min = min;
            this.max = max;
        }

        public int getMin(){
            return min;
        }

        public int getMax(){
            return max;
        }
    }

    public int getSalaryGapInDepartment(Employee.Department department) {
        MinMax minMax =
            employees.stream()
                    .filter((x) -> x.getDepartment().equals(department))
                    .map((employee) -> new MinMax(employee.getSalary(), employee.getSalary()))
                    .reduce(null, (result, current) -> {
                        if (result == null) {
                            return current;
                        }
                        int min = Math.min(result.getMin(), current.getMin());
                        int max = Math.max(result.getMax(), current.getMax());

                        return new MinMax(min, max);
                    });

        if (minMax == null)
                return 0;
        return minMax.getMax() - minMax.getMin();

    }

    public Employee.Department findDepartmentWithHighestCumulativeSalary() {
        Map<Employee.Department, Integer> result = employees
                .stream()
                .map(employee -> Map.of(employee.getDepartment(), employee.getSalary()))
                .reduce((resultMap, employeeMap) -> {
                    Map<Employee.Department, Integer> newMap = new HashMap<>(resultMap);

                    for( Map.Entry<Employee.Department, Integer> entry: employeeMap.entrySet()){
                        int value = entry.getValue();
                        if(resultMap.containsKey(entry.getKey())){
                            value += resultMap.get(entry.getKey());
                        }
                        newMap.put(entry.getKey(), value);
                    }
                    return newMap;
                }).get();

        return result
                .entrySet()
                .stream()
                .reduce((currentResult, entry) -> {
                    if (currentResult.getValue() > entry.getValue())
                        return currentResult;
                    return entry;
                })
                .get()
                .getKey();
    }
}
