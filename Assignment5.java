import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Assignment5 {
    public static void main(String[] args) {
//        simpleQueueTest();
//        scheduleTasks("taskset1.txt");
//        scheduleTasks("taskset2.txt");
        //scheduleTasks("taskset3.txt");
        scheduleTasks("taskset4.txt");
        //scheduleTasks("taskset5.txt");
    }

    public static void scheduleTasks(String taskFile) {
        // TODO: Uncomment code here as you complete the tasks and scheduling algorithm
        Queue<Task> tasksByDeadline = new LinkedList<>();
        Queue<Task> tasksByStart = new LinkedList<>();
        Queue<Task> tasksByDuration = new LinkedList<>();

        readTasks(taskFile, tasksByDeadline, tasksByStart, tasksByDuration);

        schedule("Deadline Priority : "+ taskFile, tasksByDeadline);
        schedule("Startime Priority : " + taskFile, tasksByStart);
        schedule("Duration priority : " + taskFile, tasksByDuration);
    }

    public static void simpleQueueTest() {
        // TODO: Uncomment code here for a simple test of your priority queue code
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(9);
        queue.enqueue(7);
        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(1);
        queue.enqueue(10);

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }

    /**
     * Reads the task data from a file, and creates the three different sets of tasks for each
     */
    public static void readTasks(String filename,
                                 Queue<Task> tasksByDeadline,
                                 Queue<Task> tasksByStart,
                                 Queue<Task> tasksByDuration){
        File file = new File(filename);
        try {
            Scanner input = new Scanner(file);
            int count = 1;
            while (input.hasNext()){
                String currentLine = input.nextLine();
                String[] taskArray = currentLine.split("\t");
                TaskByStart newStart = new TaskByStart(count, Integer.parseInt(taskArray[0]), Integer.parseInt(taskArray[1]), Integer.parseInt(taskArray[2]));
                tasksByStart.add(newStart);
                TaskByDuration newDuration = new TaskByDuration(count, Integer.parseInt(taskArray[0]), Integer.parseInt(taskArray[1]), Integer.parseInt(taskArray[2]));
                tasksByDuration.add(newDuration);
                TaskByDeadline newDeadLine = new TaskByDeadline(count, Integer.parseInt(taskArray[0]), Integer.parseInt(taskArray[1]), Integer.parseInt(taskArray[2]));
                tasksByDeadline.add(newDeadLine);
                count++;
            }
        } catch (
                IOException var9) {
            System.out.println("An error occurred trying to read the filename: " + String.valueOf(var9));
        }
    }
    /**
     * Given a set of tasks, schedules them and reports the scheduling results
     */
    public static void schedule(String label, Queue<Task> tasks) {
        System.out.println(label);
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();

        int clock = 1;
        int lateCount = 0;
        int lateAmountTotal = 0;
        int tasksSize = tasks.size();
        for(int i = 0; i < tasksSize; i++){
            Task task = tasks.remove();
            taskQueue.enqueue(task);
        }
        while(!taskQueue.isEmpty()){
            Task currentTask = taskQueue.dequeue();
            while(currentTask.start > clock && !taskQueue.isEmpty()){
                tasks.add(currentTask);
                currentTask = taskQueue.dequeue();
            }
            if (clock >= currentTask.start) {
                currentTask.duration--;
                if (currentTask.duration == 0) {
                    if (clock > currentTask.deadline) {
                        int lateAmount = clock - currentTask.deadline;
                        lateCount++;
                        lateAmountTotal = lateAmountTotal + lateAmount;
                        System.out.println("\t\tTime\t" + clock + ": " + currentTask + " ** Late " + lateAmount);
                    } else {
                        System.out.println("\t\tTime\t" + clock + ": " + currentTask + " **");
                    }
                } else {
                    System.out.println("\t\tTime\t" + clock + ": " + currentTask);
                    taskQueue.enqueue(currentTask);
                }
            }else {
                taskQueue.enqueue(currentTask);
                System.out.println("\t\tTime\t" + clock + ": ---");
            }
            tasksSize = tasks.size();
            if(tasksSize != 0){
                for(int i = 0; i < tasksSize; i++){
                    Task task = tasks.remove();
                    taskQueue.enqueue(task);
                }
            }


            clock++;

        }
        System.out.println("Tasks late "+ lateCount+" Total Late " + lateAmountTotal);
    }
}
