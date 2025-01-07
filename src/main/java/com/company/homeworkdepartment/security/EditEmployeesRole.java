package com.company.homeworkdepartment.security;

import com.company.homeworkdepartment.entity.Employee;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "EditEmployees", code = EditEmployeesRole.CODE)
public interface EditEmployeesRole {
    String CODE = "edit-employees";

    @MenuPolicy(menuIds = "Employee.list")
    @ViewPolicy(viewIds = {"Employee.list", "Employee.detail"})
    void screens();

    @EntityAttributePolicy(entityClass = Employee.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Employee.class, actions = EntityPolicyAction.ALL)
    void employee();
}