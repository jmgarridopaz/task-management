# Task Management (Hexagonal App with ACL)

Simple code example for illustrating the article

https://jmgarridopaz.github.io/content/therightboundary.html

WARNING: It has been done quickly so: there's no exception handling, no dependencies between packages (but I take care of them), no implementation hiding (all types are public), just programmed the code needed to run one test case, ... but those things don't matter now for the topic of the article.

___Task Management___ is an application, a collaborative tool, used by employees of a company for assigning tasks to each other. The domain model has concepts like "assignee", that is the employee who a task is assigned to, and has to perform it. An assignee has an id, a unique short name kindof an alias, and an email.

### Development environment:

- Java 1.8.0_261

- Maven 3.5.4

- Eclipse IDE 2019-12 (4.14.0)

- Ubuntu 18.04.5 LTS (Linux 5.4.0-60-generic)

### Instructions:

- Download and extract this GitHub repository to a local directory on your computer ( `<tm_dir>` )

- Generate jar file:

  ~~~
  cd <tm_dir>
  mvn clean package
  ~~~

- Run jar file:

  ~~~
  cd <tm_dir>
  java -jar ./target/task-management-1.0.0.jar
  ~~~
