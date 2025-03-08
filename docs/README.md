# Echo User Guide

Echo is a desktop app for managing tasks, optimized for use via a Command
Line Interface (CLI). In addition to tracking tasks and deadlines, Echo 
allows users to mark tasks as completed.

## Features

### Adding ToDo: `todo`

Adds a task with no deadline or timeframe. Indicated by [T] in the task list.

Format: `todo TASK_DESCRIPTION`

Example: `todo Math Assignment`

```
Got it. I've added this task:
[T][ ] Math Assignment
Now you have 1 tasks in the list.
```

### Adding Deadline: `deadline`

Adds a task with a deadline to complete the task by. Indicated by [D] in the task list.

Format: `deadline TASK_DESCRIPTION /by DEADLINE`

Example: `deadline Project Report /by Saturday 2359`

```
Got it. I've added this task:
[D][ ] Project Report (by: Saturday 2359)
Now you have 2 tasks in the list.
```

### Adding Event: `event`

Adds a task with a timeframe (e.g. an event with start and end time). 
Indicated by [E] in the task list.

Format: `event TASK_DESCRIPTION /from START_TIME /to END_TIME`

Example: `event Attend Career Fair /from 12 March 2pm /to 5pm`

```
Got it. I've added this task:
[E][ ] Attend Career Fair (from: 12 March 2pm to: 5pm)
Now you have 3 tasks in the list.
```

### Listing all tasks: `list`

Displays a list of all tasks added, and their respective task types and
completion status.

Format: `list`
* Task types are shown as [T], [D], or [E]
* Completion status are indicated by [ ] for incomplete tasks, or [X] for
completed tasks. Task completion status are displayed next to task types.


### Marking a task as complete: `mark`

Marks a specified task as completed. Indicated by an [X] next to the task 
type.

Format: `mark INDEX`  
* Marks the task at the specified `INDEX` as completed. `INDEX` refers to
 index number shown in the displayed task list. 


Example: `mark 3`

```
Task has been marked as done:
[E][X] Attend Career Fair (from: 12 March 2pm to: 5pm)
```

### Marking a task as incomplete: `unmark`

Marks a specified task as incomplete. Indicated by a [ ] next to the task
type.

Format: `unmark INDEX`
* Unmarks the task at the specified `INDEX` as completed. `INDEX` refers to
  index number shown in the displayed task list.


Example: `unmark 3`

```
Task has been marked as incomplete:
[E][ ] Attend Career Fair (from: 12 March 2pm to: 5pm)
```

### Deleting tasks: `delete`

Deletes the specified task from the task list.

Format: `delete INDEX`
* Deletes the task at the specified `INDEX` as completed. `INDEX` refers to
  index number shown in the displayed task list.

Example: `delete 3`

```
Noted. I've removed this task:
[E][ ] Attend Career Fair (from: 12 March 2pm to: 5pm)
Now you have 2 tasks in the list.
```

### Searching for tasks by description: `find`

Finds all tasks that descriptions contains any of the given keywords.

Format: `find KEYWORD`
* The search is case-insensitive. (e.g. `HOMEWORK` will match `homework`)
* The order of the keywords matters. (e.g. `lab project` will **not** match with `project lab`)
* Only the task description will be searched
* Partial words can be matched. (e.g. `a` will return all tasks with description containing
the letter `a`)
* Matching tasks will be returned in a list.

Example: `find Math`

```
1.[T][ ] Math Assignment
2.[E][ ] Mathematics Exam (from: 3pm to: 6pm)
3.[D][ ] Math Report (by: tmr)
```

### Exiting the program: `bye`

Exits the program.

Format: `bye`

### Saving data
Echo's data are saved in the hard disk automatically after any command that updates
the data. Echo also automatically loads previously saved data from the hard disk, or 
creates a new file to store the data if one does not exist. There is no need for the 
user to load or save data manually.
