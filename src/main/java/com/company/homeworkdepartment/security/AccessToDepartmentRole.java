package com.company.homeworkdepartment.security;

import com.company.homeworkdepartment.entity.Department;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "AccessToDepartment", code = AccessToDepartmentRole.CODE)
public interface AccessToDepartmentRole {
    String CODE = "access-to-department";

    @MenuPolicy(menuIds = "Department.list")
    @ViewPolicy(viewIds = {"Department.list", "Department.detail"})
    void screens();

    @EntityAttributePolicy(entityClass = Department.class, attributes = "notes", action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = Department.class, attributes = {"id", "name", "internalPhoneNumber"}, action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Department.class, actions = {EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
    void department();
}