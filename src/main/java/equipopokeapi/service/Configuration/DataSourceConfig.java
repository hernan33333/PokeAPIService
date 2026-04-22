/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipopokeapi.service.Configuration;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Alien 7
 */
@Configuration
public class DataSourceConfig {
    
    @Bean
    public DataSource dataSource(){
    
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        dataSource.setUrl("jdbc:oracle:thin:@192.167.0.227:1521:orcl");
        dataSource.setUsername("HMartinezPokeAPI");
        dataSource.setPassword("password1");
        
        return dataSource;
    
    }
    
}
