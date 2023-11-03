package br.com.cifresuasmusicas.repository;

import java.util.Optional;

import br.com.cifresuasmusicas.enums.RolesEnum;
import br.com.cifresuasmusicas.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {

    Optional<RoleModel> findByName(RolesEnum name);
}