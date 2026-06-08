import java.util.ArrayList;
import java.util.HashMap;

public class TaskService {

    private ArrayList<Task> tasks = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();

    private HashMap<Integer, Task> taskMap = new HashMap<>();
    private HashMap<Integer, Employee> employeeMap = new HashMap<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employeeMap.put(employee.getId(), employee);
    }

    public void addTask(Task task) {
        tasks.add(task);
        taskMap.put(task.getId(), task);
    }

    public void assignTask(int taskId, int employeeId) {

        if (!employeeMap.containsKey(employeeId)) {
            System.out.println("Сотрудник не найден!");
            return;
        }

        if (!taskMap.containsKey(taskId)) {
            System.out.println("Задача не найдена!");
            return;
        }

        taskMap.get(taskId).setAssigneeId(employeeId);

        System.out.println("Задача назначена.");
    }

    public void updateStatus(int taskId, TaskStatus status) {

        if (!taskMap.containsKey(taskId)) {
            System.out.println("Задача не найдена!");
            return;
        }

        taskMap.get(taskId).setStatus(status);

        System.out.println("Статус обновлён.");
    }

    public void getTasksByEmployee(int employeeId) {

        for (Task task : tasks) {
            if (task.getAssigneeId() == employeeId) {
                System.out.println(task);
            }
        }
    }

    public void getTasksByStatus(TaskStatus status) {

        for (Task task : tasks) {
            if (task.getStatus() == status) {
                System.out.println(task);
            }
        }
    }

    public void showStatistics() {

        int todo = 0;
        int progress = 0;
        int done = 0;

        for (Task task : tasks) {

            switch (task.getStatus()) {
                case TODO:
                    todo++;
                    break;
                case IN_PROGRESS:
                    progress++;
                    break;
                case DONE:
                    done++;
                    break;
            }
        }

        System.out.println("TODO = " + todo);
        System.out.println("IN_PROGRESS = " + progress);
        System.out.println("DONE = " + done);
    }
}
