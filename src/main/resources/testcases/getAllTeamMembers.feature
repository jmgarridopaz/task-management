Feature: GET TEAM MEMBERS

	AS
	an employee
	
	I WANT TO
	know the members of my team
	
	SO THAT
	I can pick one of them to assign a task to


Scenario: Should return the employees of my department as team members

Given the company has these departments:

| DEP_ID | DEP_NAME   | DEP_LOCATION | UPPER_DEP_ID |
| 1      | Acme       | Chicago      |              |
| 2      | Research   | New York     | 1            |
| 3      | Accounting | Dallas       | 1            |

And the company has these employees:

| EMP_ID | EMP_FIRST_NAME | EMP_LAST_NAME | EMP_EMAIL          | EMP_JOB | EMP_IS_MANAGER | DEP_ID |
| 1      | Juan           | Garrido       | jgarrido@email.com |         | yes            | 1      |
| 2      | María          | López         | mlopez@email.com   |         | yes            | 2      |
| 3      | Jesús          | Pérez         | jperez@email.com   |         | yes            | 3      |
| 4      | Alicia         | Lucena        | alucena@email.com  |         | no             | 3      |
| 5      | Pedro          | Mateos        | pmateos@email.com  |         | no             | 3      |

And current user id is '4'

When we ask for the members of the team

Then we should get these team members:

| MEMBER_ID | MEMBER_NAME   | MEMBER_EMAIL       |
| 3         | Jesús Pérez   | jperez@email.com   |
| 4         | Alicia Lucena | alucena@email.com  |
| 5         | Pedro Mateos  | pmateos@email.com  |
