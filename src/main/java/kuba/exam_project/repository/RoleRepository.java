package kuba.exam_project.repository;

import kuba.exam_project.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleName(String roleName);

}
