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
    if (usuario.getActivo() == null) {
        usuario.setActivo(true);
    }

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
            existente.setTelefono(usuario.getTelefono());
            existente.setDireccion(usuario.getDireccion());
            existente.setPassword(usuario.getPassword());
            return usuarioRepository.save(existente);
            

            
        }
        return null;
    }
    
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
       
    }

    public Usuario desactivar(Long id) {

    Usuario usuario = usuarioRepository.findById(id).orElse(null);

    if (usuario != null) {
        usuario.setActivo(false);
        return usuarioRepository.save(usuario);
    }

    return null;
    }
}
