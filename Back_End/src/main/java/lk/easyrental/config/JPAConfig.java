package lk.easyrental.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class JPAConfig {


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource ds, JpaVendorAdapter va){
        LocalContainerEntityManagerFactoryBean bean=new LocalContainerEntityManagerFactoryBean();
        bean.setJpaVendorAdapter(va);
        bean.setDataSource(ds);
        bean.setPackagesToScan("lk.easyrental.entity");
        return bean;
    }
    
}
