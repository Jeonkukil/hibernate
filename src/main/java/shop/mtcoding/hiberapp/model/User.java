package shop.mtcoding.hiberapp.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@NoArgsConstructor
@Getter
@Entity
@Table(name = "user_tb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    // json으로 파싱하지 마라 @JsonIgnore
    @JsonIgnore 
    private String password;   
    private String email;
    @CreationTimestamp
    private Timestamp createdAt;

    
    @Builder
    public User(Long id, String username, String password, String email, Timestamp createdAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
    }



    public void update(String password, String email) {
        this.password = password;
        this.email = email;
    }
    
}
