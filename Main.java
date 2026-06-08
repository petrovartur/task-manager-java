import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskService service = new TaskService();

        while (true) {

            System.out.println("\n=== TASK TRACKER ===");
            System.out.println("1. Добавить сотрудника");
            System.out.println("2. Создать задачу");
            System.out.println("3. Назначить задачу");
            System.out.println("4. Изменить статус");
            System.out.println("5. Задачи сотрудника");
            System.out.println("6. Задачи по статусу");
            System.out.println("7. Статистика");
            System.out.println("0. Выход");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("ID: ");
                    int empId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Имя: ");
                    String name = sc.nextLine();

                    System.out.print("Роль: ");
                    String role = sc.nextLine();

                    service.addEmployee(
                            new Employee(empId, name, role));

                    break;

                case 2:

                    System.out.print("ID задачи: ");
                    int taskId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Название: ");
                    String title = sc.nextLine();

                    System.out.print("Описание: ");
                    String desc = sc.nextLine();

                    System.out.print("Приоритет (LOW/MEDIUM/HIGH): ");
                    Priority priority =
                            Priority.valueOf(sc.nextLine().toUpperCase());

                    Task task = new Task(
                            taskId,
                            title,
                            desc,
                            TaskStatus.TODO,
                            priority,
                            0,
                            1
                    );

                    service.addTask(task);

                    break;

                case 3:

                    System.out.print("ID задачи: ");
                    int tId = sc.nextInt();

                    System.out.print("ID сотрудника: ");
                    int eId = sc.nextInt();

                    service.assignTask(tId, eId);

                    break;

                case 4:

                    System.out.print("ID задачи: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Статус (TODO/IN_PROGRESS/DONE): ");

                    try {
                        TaskStatus status =
                                TaskStatus.valueOf(
                                        sc.nextLine().toUpperCase());

                        service.updateStatus(id, status);

                    } catch (Exception e) {
                        System.out.println("Неверный статус!");
                    }

                    break;

                case 5:

                    System.out.print("ID сотрудника: ");
                    int emp = sc.nextInt();

                    service.getTasksByEmployee(emp);

                    break;

                case 6:

                    sc.nextLine();

                    System.out.print("Статус: ");

                    try {

                        TaskStatus status =
                                TaskStatus.valueOf(
                                        sc.nextLine().toUpperCase());

                        service.getTasksByStatus(status);

                    } catch (Exception e) {
                        System.out.println("Неверный статус!");
                    }

                    break;

                case 7:

                    service.showStatistics();

                    break;

                case 0:

                    return;

                default:

                    System.out.println("Неверный пункт меню.");
            }
        }
    }
}
