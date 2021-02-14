/*
 * Copyright (c) 2021 Randall Rowland
 */

public class Task {

  private String taskId;
  private String name;
  private String description;

  Task() {
    taskId = "INITIAL";
    name = "INITIAL";
    description = "INITIAL DESCRIPTION";
  }

  Task(String taskId) {
    checkTaskId(taskId);
    name = "INITIAL";
    description = "INITIAL DESCRIPTION";
  }

  Task(String taskId, String name) {
    checkTaskId(taskId);
    setName(name);
    description = "INITIAL DESCRIPTION";
  }

  Task(String taskId, String name, String desc) {
    checkTaskId(taskId);
    setName(name);
    setDescription(desc);
  }

  public final String getTaskId() { return taskId; }

  public final String getName() { return name; }

  protected void setName(String name) {
    if (name == null || name.length() > 20) {
      throw new IllegalArgumentException(
          "Task name is invalid. Ensure it is shorter than 20 characters and not empty.");
    } else {
      this.name = name;
    }
  }

  public final String getDescription() { return description; }

  protected void setDescription(String taskDescription) {
    if (taskDescription == null || taskDescription.length() > 50) {
      throw new IllegalArgumentException(
          "Task description is invalid. Ensure it is shorter than 50 characters and not empty.");
    } else {
      this.description = taskDescription;
    }
  }

  private void checkTaskId(String taskId) {
    if (taskId == null || taskId.length() > 10) {
      throw new IllegalArgumentException(
          "Error: The task ID was null or longer than 10 characters");
    } else {
      this.taskId = taskId;
    }
  }
}
