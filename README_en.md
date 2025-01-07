### Prepared project
The project contains set of elements related to personnel control area:
- Department and Employee entities
- Additional association attribute - User#department
- Department and Employee standard views (list and detail)

### Task
To complete this homework, you will need to configure the application role model as follows and test the constraints in a running application.

#### 1. Resource roles
Create set of roles in the application source code:
- "View employees". Grants access to Employee entity view and read in the application UI (remember role scope).
- "Edit employees". Grants full access to Employee CRUD operations in UI.
- “Access to departments.” Provides department view and read access from the user interface. Additionally, role assignee only has access to change one department attribute - Department#notes.
- 
#### 2. Row-level role
Create new row-level role in the application source code:
- Role name - "Editing employees of own department".
- Politic type - predicate.
- Restricts the ability of creation, editing or deletion of Employees.
The above operations are only available to users of the same department (this means the user who wants to edit another user's information must be an employee of the same department)

#### 3. Composite roles
Run the application and create a set of composite roles using the Administration interface:
- "Viewer" - combines "ui-minimal" role with "View employees" role.
- "Supervisor" - combines "ui-minimal", "Edit employees", and "Access to departments" roles.

#### 4. Roles assignment and testing
"Viewer":
- Create a new "viewer" user in the running application.
- Assign this user with the "Viewer" role.
- Log-in as "viewer" user and check, that accesses and restrictions are working as expected:
    - Any Employee is viewable only

"Supervisor":
- Create a new user through the running application - “supervisor”.
- Assign supervisor with department = "IT"
- Assign this user with Supervisor and "Editing employees of own department" roles too.
- Log-in as supervisor and check:
    - Department view screen is available
    - Department - Notes - is editable attribute(unlike other attributes)
    - Employees from *own* ("IT" in this case) Department are editable and accessible for view and delete
    - Other departments (not "IT"") employees are accessible for view only

#### Optional
Take some screenshots of the open views for the "viewer" and "supervisor" users and add them to your homework assignment.
