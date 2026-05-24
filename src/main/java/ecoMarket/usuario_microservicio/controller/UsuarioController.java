package ecoMarket.usuario_microservicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecoMarket.usuario_microservicio.model.Usuario;
import ecoMarket.usuario_microservicio.Service.UsuarioService;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping()
    public Usuario postUsuario(@RequestBody Usuario usuario){
        return usuarioService.crear(usuario);
    }

    @GetMapping()
    public List<Usuario> getUsuarios() {
        return usuarioService.listar();
    }

    @PutMapping("{id}")
    public Usuario putUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.modificar(id,usuario);
    }

    @DeleteMapping("{id}")
    public void deleteUsuario (@PathVariable Long id) {
        usuarioService.eliminar(id);
    }

}
