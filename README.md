# task-management


# >>>>>>>>>> IN PROGRESS <<<<<<<<<<


Simple code example for illustrating the article https://jmgarridopaz.github.io/content/therightboundary.html

It has be done quickly so: there's no exception handling, no dependencies between packages (but I take care of them), all types are public, just programmed the code needed to test one use case, ... but those things don't matter now for the topic of the article.

**Task Management** is an application, a collaborative tool, that allows members of a team to assign tasks to each other.

It's going to be used by the employees of a company, which is structured in departments.

DDD is based on the language, the ubiquitous language (UL), so that each bounded context (BC) has its own UL, with the terms and the meaning that has sense in that BC. We have 3 BC:

- COMPANY: Employees and Departments management.

- IAM (Identity and Access Management): Users of our application. Some terms of the UL: user, role, current user, login, password, ...

- TASK MANAGEMENT: Team, team member, task, assignee, task owner, ...

A user in the IAM context will be an employee in the Company context, and a team member in the Task Management context, but each context will have different data

that will access our application, but we don't need the same data of that person in all the BCs. For example, for an employee we store the salary, but we don't need it 


We already have 2 existing systems:

- _Company Structure_, with information about departments
- _Human Resources_, with information about employees.

Our domain knows of concepts like team, members, tasks, ... But in real life we have concepts like departments, employees, ... So our application has to integrate with both external systems, translating concepts from their contexts to our own context.

Using strategic DDD patterns, we have the following context map:

![Context Map](context-map.png)

- __Integration with Company Structure system__: "_Company Structure_" context is upstream (U), with an OHS/PL (Open Host Service / Published Language) offering information about departments. This OHS is a HTTP REST API, using JSON as the PL. Our "_Task Management_" context is downstream (D), with an ACL (Anti Corruption Layer) for preventing "_Company Structure_" model leaking into our domain. This ACL accesses "_Company Structure_" API, and translates "_Company Structure_" model into "_Task Management_" model (a department will be a team).
- __Integration with Human Resources system__: "_Human Resources_" context is upstream (U), with an OHS/PL offering information about employees. This OHS is a HTTP REST API, using JSON as the PL. Our "_Task Management_" context is downstream (D), with an ACL for preventing "_Human Resources_" model leaking into our domain. This ACL accesses "_Human Resources_" API, and translates "_Human Resources_" model into "_Task Management_" model (an employee will be a member of the team corresponding to the department the employee belongs to).

Both integrations will be synchronous, i.e. "_Task Management_" context will send a web request and wait for response every time it needs information from the remote context.

__Implementing "Task Management" context using HA (Hexagonal Architecture)__, we have this drawing showing interfaces, classes and packages from source code:







ACL concept is wider than HA adapter, since it does semantic translation besides technological one.

Once the HA adapter has fetched the concept from the repository (upstream context), the hexagon has to translate it into terms of our domain.

So, for DDD, the semantic translation is part of the infra code. But from HA point of view, the infra code is just the technological adapter for the repository.

That's what I say, HA is what it is, not what I want it to be.

So if I want to fit DDD into HA, I put that semantic translation inside the hexagon but outside the domain. You are still protecting your domain with a domain service interface.



![Task Management](task-management.png)



Regarding tests, this way ACL logic doesn't scape from acceptance tests (business logic tests), since it belongs to the hexagon.

Testing the hexagon in isolation driven by test drivers, mocking external technologies, is one of the main goals of HA, and putting ACL logic outside breaks this.

