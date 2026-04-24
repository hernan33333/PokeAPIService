/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package equipopokeapi.service.DAO;

import equipopokeapi.service.Ml.Result;
import equipopokeapi.service.Ml.Usuario;


public interface IUsuario {
    Result  Add(Usuario usuario);
    Result Get();
    Result GetRol();
            

}
