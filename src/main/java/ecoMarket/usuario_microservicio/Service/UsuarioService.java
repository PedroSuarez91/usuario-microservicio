package ecoMarket.usuario_microservicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecoMarket.usuario_microservicio.model.Usuario;
import ecoMarket.usuario_microservicio.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario crear(Usuario usuario) {
        return usuarioRepository.save(usuario);
        
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario modificar(Long id, Usuario usuario) {
        Usuario existente=usuarioRepository.findById(id).orElse(null);
        if (existente!=null){
            existente.setNombre(usuario.getNombre());
            existente.setEmail(usuario.getEmail());
            existente.setClave(usuario.getClave());
            return usuarioRepository.save(existente);
            
        }
        return null;
    }
    
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
       
    }
}
