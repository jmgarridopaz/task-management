Feature: ASSIGN TASK TO EMPLOYEE

	AS
	an employee
	
	I WANT TO
	assign a task to an employee
	
	SO THAT
	the assignee can start performing the task


Scenario: Successful assignment

Given there exist this employee:

| ID | FIRST_NAME | LAST_NAME | EMAIL                    | JOB        |
| 1  | John       | Blake     | john.blake@mycompany.com | Programmer |

And there exist this user:

| ID | LOGIN  | PASSWORD |
| 1  | jblake | secret   |

And next available task id is '1000'

When I do the following request for assigning a task:

| TASK_TITLE    | Develop a hexagonal app in Java |
| TASK_DUE_DATE | 2021-03-01                      |
| ASSIGNEE_ID   | 1                               |

Then this task should have been stored:

| ID   | TITLE                           | DUE_DATE   | ASSIGNEE_ID | ASSIGNEE_NAME | ASSIGNEE_EMAIL           |
| 1000 | Develop a hexagonal app in Java | 2021-03-01 | 1           | jblake        | john.blake@mycompany.com |
