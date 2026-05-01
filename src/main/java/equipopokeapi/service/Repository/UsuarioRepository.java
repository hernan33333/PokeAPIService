/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package equipopokeapi.service.Repository;

import equipopokeapi.service.Ml.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
Usuario findByCorreo(String correo);
Usuario findByResetToken(String token);
Usuario findByActivationToken(String token);
}
