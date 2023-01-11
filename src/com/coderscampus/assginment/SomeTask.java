package com.coderscampus.assginment;

import java.util.Random;
import java.util.concurrent.Callable;

public class SomeTask implements Callable<TaskDto> {
    private static int taskId = 0;


    @Override
    public TaskDto call() {
        TaskDto taskDto = new TaskDto();
        for (int i = 0;i<100000;i++){
            Integer int1 = new Random().nextInt();
            Integer int2 = new Random().nextInt();
            Double something = (int1 + int2)*1.5;
            taskDto.setValue(something);
        }
        System.out.println("Start value " + taskId);
        taskId++;
        System.out.println("Hey look at me, I'm task-id" + taskId +"!"+ "I'm a task! I'm running on the thread: " + Thread.currentThread().getName());
        taskDto.setFinished(true);
        return taskDto;
    }
}

