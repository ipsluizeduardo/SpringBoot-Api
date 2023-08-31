package dio.web.api.repository;

import dio.web.api.handler.BusinessException;
import dio.web.api.handler.CampoObrigatorioException;
import dio.web.api.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {
    public void save(Usuario usuario){
        if(usuario.getLogin()==null)
            throw new CampoObrigatorioException("login");

        if(usuario.getPassword()==null)
            throw new CampoObrigatorioException("password");

        if(usuario.getId() == null)
            System.out.println("SAVE - Recebendo o usuario na camada de repositorio");
        else
            System.out.println("UPDATE - Recebendo o usuario na camada de repositorio");

        System.out.println(usuario);
    }

    public  void deleteById(Integer id) {
        System.out.println(String.format("DELETE/ID - Recebendo o id: %d para", id));
        System.out.println(id);
    }

    public List<Usuario> findAll() {
        System.out.println("LIST - Listando os usuarios do sistema");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Luiz", "password"));
        usuarios.add(new Usuario("Joao", "senha"));
        return usuarios;
    }

    public Usuario findById(Integer id) {
        System.out.println(String.format("FIND/id - Recebendo o id: para localizar um usuario ", id));
        return new Usuario("Luiz","password");
    }

    public Usuario findByUserName(String username) {
        System.out.println(String.format("FIND/username - Recebendo o username: %s para localizar um usuario ", username));
        return new Usuario("Joao","senha");
    }
}
