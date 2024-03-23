import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Assignment5 {
    public static void main(String[] args) {
        simpleQueueTest();
        //scheduleTasks("taskset1.txt");
        //scheduleTasks("taskset2.txt");
        //scheduleTasks("taskset3.txt");
        //scheduleTasks("taskset4.txt");
        //scheduleTasks("taskset5.txt");
    }

    public static void scheduleTasks(String taskFile) {
        // TODO: Uncomment code here as you complete the tasks and scheduling algorithm
//        Queue<Task> tasksByDeadline = new LinkedList<>();
//        Queue<Task> tasksByStart = new LinkedList<>();
//        Queue<Task> tasksByDuration = new LinkedList<>();
//
//        readTasks(taskFile, tasksByDeadline, tasksByStart, tasksByDuration);
//
//        schedule("Deadline Priority : "+ taskFile, tasksByDeadline);
//        schedule("Startime Priority : " + taskFile, tasksByStart);
//        schedule("Duration priority : " + taskFile, tasksByDuration);
    }

    public static void simpleQueueTest() {
        // TODO: Uncomment code here for a simple test of your priority queue code
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        queue.enqueue(9);
//        queue.enqueue(7);
//        queue.enqueue(5);
//        queue.enqueue(3);
//        queue.enqueue(1);
//        queue.enqueue(10);
//
//        while (!queue.isEmpty()) {
//            System.out.println(queue.dequeue());
//        }
    }

    /**
     * Reads the task data from a file, and creates the three different sets of tasks for each
     */
    public static void readTasks(String filename,
                                 Queue<Task> tasksByDeadline,
                                 Queue<Task> tasksByStart,
                                 Queue<Task> tasksByDuration) {
        // TODO: Write your task reading code here
    }

    /**
     * Given a set of tasks, schedules them and reports the scheduling results
     */
    public static void schedule(String label, Queue<Task> tasks) {
        // TODO: Write your scheduling algorithm here
    }
}
