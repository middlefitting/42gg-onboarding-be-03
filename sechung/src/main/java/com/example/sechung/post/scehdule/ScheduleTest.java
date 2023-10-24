package com.example.sechung.post.scehdule;

import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

/**
 * ScheduleTest.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/24
 */
@Component
public class ScheduleTest {

  private class MessagePrinterTask implements Runnable {

    private String message;

    public MessagePrinterTask(String message) {
      this.message = message;
    }

    public void run() {
      System.out.println(message);
    }
  }

  private TaskExecutor taskExecutor;

  public ScheduleTest(TaskExecutor taskExecutor) {
    this.taskExecutor = taskExecutor;
  }

  public void printMessages() {
    for (int i = 0; i < 25; i++) {
      taskExecutor.execute(new MessagePrinterTask("Message" + i));
    }
  }
}