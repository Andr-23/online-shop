package kg.edu.alatoo.online.shop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 150, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
