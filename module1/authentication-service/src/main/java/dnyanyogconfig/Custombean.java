package dnyanyogconfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Custombean {
    
   @Bean
   public List<Long> longisbean(){
       return new ArrayList<Long>();
   }
   
   
}
