/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.DAO;

import equipopokeapi.service.Ml.Result;
import equipopokeapi.service.Ml.Rol;
import equipopokeapi.service.Ml.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;


@Repository
public class UsuarioImplementación implements IUsuario{
    
    @Autowired
    private EntityManager entitimanager;



    @Override
  @Transactional
    public Result Add(Usuario usuario) {
        Result result = new Result();
        try{
            entitimanager.persist(usuario);
            result.correct = true;
            
            
        }catch(Exception ex){
            result.correct= false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex= ex;
        }
        return result;
    }

    @Override
    public Result Get() {
        Result result = new Result();
        try{
            TypedQuery<Usuario> queryUsuario = entitimanager.createQuery("FROM usuario", Usuario.class);
            List<Usuario> usuarios = queryUsuario.getResultList();
            result.objects = new ArrayList<>(usuarios);
            
            result.correct = true;
            
        }catch(Exception ex){
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }

    @Override
    public Result GetRol() {
           Result result = new Result();
        try{
            TypedQuery<Rol> queryUsuario = entitimanager.createQuery("FROM Rol", Rol.class);
            List<Rol> usuarios = queryUsuario.getResultList();
            result.objects = new ArrayList<>(usuarios);
            
            result.correct = true;
            
        }catch(Exception ex){
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }
    }
    


