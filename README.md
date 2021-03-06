
## USER GUIDE
Duke is a desktop Command-line interface app for managing tasks. It keeps track of your tasks with categorization into Events, Todos and Deadlines.

Features
- Add a **todo**.
- Add a **deadline**.
- Add an **event**.
- **List** out all tasks.
- **Delete** tasks.
- **Find** tasks with a keyword.
- set tasks to **Done**.
- Exit the program.

## Usage

`todo` - Adds a todo task to the List

Format: todo Description

**Example**

input: `todo basketball training`

Expected output:
```
Got it. I've added this task:
  [T][x] basketball training
Now you have 1 tasks in the list
```
`deadline` - Adds a deadline task to the List

Format: todo Description /by Time
* Time can be both date and time but must be indicated after `/by`
* Shows an error message when `/by` is not typed in after description.


**Example**

input: `deadline homework /by friday`

Expected output:
```
Got it. I've added this task:
  [D][x] homework (by: friday)
Now you have 1 tasks in the list
```
`event` - Adds an event task to the List

Format: todo Description /at Time
* Time can be both date and time but must be indicated after `/by`
* Shows an error message when `/at` is not typed in after description.


**Example**

input: `event Team Meeting /at Monday 1pm`

Expected output:
```
Got it. I've added this task:
  [E][x] Team Meeting (at: Monday 1pm)
Now you have 1 tasks in the list
```
`list` - Lists and prints out all tasks

Format: list
* List order is in chronological order. The first task added in will be indexed 1.


**Example**

input: `list`

Expected output:
```
Here are the tasks in your list:
1.[E][x] Team Meeting (at: Monday 1pm)
2.[D][x] homework (by: friday)
3.[T][x] basketball training
```
`delete` - Deletes tasks at a specified index.

Format: delete index
* List order is in chronological order. The first task added in will be indexed 1.
* Index must not be bigger than size of list, if not an error message will show.

**Example**

input: `Delete 2`

Expected output:
```
 Noted. I've removed this task: 
  [T][x] basketball training
Now you have 1 tasks in the list
```
`find` - Find tasks with a specific keyword

Format: find keyword
* A list with the tasks that match the keyword will be displayed

**Example**

current list:
```
Here are the tasks in your list:
1.[T][x] read book
2.[T][x] buy book
3.[E][x] book meeting (at: 2pm)
4.[T][x] basketball
```

input: `find book`

Expected output:
```
Here are the matching tasks in your list:
1.[T][x] read book
2.[T][x] buy book
3.[E][x] book meeting (at: 2pm)

```

`done` - Sets a task at a specific index to be done.

Format: done index
* List order is in chronological order. The first task added in will be indexed 1.
* Index must not be bigger than size of list, if not an error message will show.

**Example**

input: `Done 2`

Expected output:
```
 Nice! I've marked this task as done:
 [T][✓] buy book
```
`Bye` - Exits the program and stores the tasks in the list in a text file

Format: bye
* All information in the remaining list will be stored and will be carried over next time Duke is ran.

**Example**

input: `bye`

Expected output:
```
Bye. Hope to see you again soon!
```

## COMMAND SUMMARY

Feature | Input Format | Example
------------ | ------------- | ----
Adding a todo task | todo description | `todo meeting`
Adding an event task | event description /at time | `event basketball training /at friday 2pm`
Adding a deadline task | deadline description /by time | `deadline project /by thursday 5pm`
Listing out all tasks | list | `list`
Deleting a specified task at an index | delete index | `delete 2`
Find a task with a keyword | find keyword | `find book`
Set a task at a specified index to done  | done index | `done 2`
Exit the program | bye | `bye`