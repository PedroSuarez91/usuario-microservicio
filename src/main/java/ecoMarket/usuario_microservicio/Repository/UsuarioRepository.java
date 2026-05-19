package ecoMarket.usuario_microservicio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecoMarket.usuario_microservicio.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
