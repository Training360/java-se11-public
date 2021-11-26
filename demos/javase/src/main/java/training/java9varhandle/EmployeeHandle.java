package training.java9varhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;

public class EmployeeHandle {

    public static void main(String[] args) {
        Employee employee = new Employee("John Doe", 30);

        try {
            MethodType mt = MethodType.methodType(String.class);
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            MethodHandle handle = lookup.findVirtual(Employee.class, "getName", mt);
            String name = (String) handle.invoke(employee);
            System.out.println(name);
        } catch (Throwable t) {
            throw new IllegalStateException("Can not call method", t);
        }

        try {
            VarHandle handle = MethodHandles
                .privateLookupIn(Employee.class, MethodHandles.lookup())
                .findVarHandle(Employee.class, "name", String.class);
            String name = (String) handle.get(employee);
            System.out.println(name);
        } catch (Throwable t) {
            throw new IllegalStateException("Can not get value", t);
        }

        try {
            VarHandle handle = MethodHandles
                    .privateLookupIn(Employee.class, MethodHandles.lookup())
                    .findVarHandle(Employee.class, "age", int.class);
            handle.getAndAdd(employee, 1);
        } catch (Throwable t) {
            throw new IllegalStateException("Can not get value", t);
        }

        System.out.println(employee.getAge());
    }
}
