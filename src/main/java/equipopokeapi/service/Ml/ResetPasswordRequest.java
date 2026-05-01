/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.Ml;



public class ResetPasswordRequest {
    private String token;
    private String newPassword;
    
    public ResetPasswordRequest(){
        
    }
    public ResetPasswordRequest(String token, String newPassword){
        this.token = token;
        this.newPassword = newPassword;
    }
    
    public String getToken(){
        return token;
    }
    public void setToken(String token){
        this.token = token;
    }
    
    public String getNewPassword(){
        return newPassword;
    }
    public void setNewPassword(String newPassword){
        this.newPassword = newPassword;
    }
}