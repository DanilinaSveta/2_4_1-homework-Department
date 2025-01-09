package com.company.homeworkdepartment.security;

import com.company.homeworkdepartment.entity.Employee;
import com.company.homeworkdepartment.entity.User;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.security.model.RowLevelBiPredicate;
import io.jmix.security.model.RowLevelPolicyAction;
import io.jmix.security.role.annotation.PredicateRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;
import org.springframework.context.ApplicationContext;

@RowLevelRole(name = "EditEmployeesOfOwnDepartment", code = EditEmployeesOfOwnDepartmentRole.CODE)
public interface EditEmployeesOfOwnDepartmentRole {
    String CODE = "edit-employees-of-own-department";

    @PredicateRowLevelPolicy(entityClass = Employee.class,
            actions = {
                    RowLevelPolicyAction.UPDATE,
                    RowLevelPolicyAction.DELETE})
    default RowLevelBiPredicate<Employee, ApplicationContext> employeePredicate() {
        return (employee, applicationContext) -> {
            CurrentAuthentication currentAuthentication = applicationContext.getBean(CurrentAuthentication.class);
            User user = (User) currentAuthentication.getUser();
            return user.getDepartment().equals(employee.getDepartment());
        };
    }
}