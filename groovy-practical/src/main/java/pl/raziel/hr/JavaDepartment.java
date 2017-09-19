package pl.raziel.hr;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class JavaDepartment {
    private int id;
    private String name;
    private Map<Integer, Employee> employeeMap = new HashMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hire(Employee e) {
        employeeMap.put(e.getId(), e);
    }

    public void layOff(Employee e) {
        employeeMap.remove(e.getId());
    }

    public Collection<Employee> getEmployees() {
        return employeeMap.values();
    }

    public JavaDepartment plus(Employee e) {
        hire(e);
        return this;
    }

    public JavaDepartment minus(Employee e) {
        layOff(e);
        return this;
    }

    public JavaDepartment leftShift(Employee e) {
        hire(e);
        return this;
    }
}
