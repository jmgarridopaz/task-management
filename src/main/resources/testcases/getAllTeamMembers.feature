Feature: GET ALL TEAM MEMBERS

	AS
	an employee
	
	I WANT TO
	know the members of my team
	
	SO THAT
	I can pick one of them to assign a task to


Scenario: Should return the employees of my department as team members

Given the company has these departments:

| DEP_ID | DEP_NAME  | UPPER_DEP_ID |
| 1      | Acme      |              |
| 2      | Marketing | 1            |

And there exists these employees:

| EMP_ID | EMP_FIRST_NAME | EMP_LAST_NAME | EMP_EMAIL          | IS_MANAGER | DEP_ID |
| 1      | Juan           | Garrido       | jgarrido@email.com | yes        | 1      |
| 2      | María          | López         | mlopez@email.com   | no         | 1      |
| 3      | Jesús          | Pérez         | jperez@email.com   | yes        | 2      |
| 4      | Alicia         | Lucena        | alucena@email.com  | no         | 2      |
| 5      | Pedro          | Mateos        | pmateos@email.com  | no         | 2      |

When employee with id '4' asks the app for the members of the team

Then we should get these team members:

| MEMBER_ID | MEMBER_NAME   | MEMBER_EMAIL       |
| 3         | Jesús Pérez   | jperez@email.com   |
| 4         | Alicia Lucena | alucena@email.com  |
| 5         | Pedro Mateos  | pmateos@email.com  |
