package kg.edu.alatoo.online.shop.repository;

import kg.edu.alatoo.online.shop.entity.Item;
import kg.edu.alatoo.online.shop.entity.User;
import kg.edu.alatoo.online.shop.payload.ItemResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<ItemResponseDTO> findByUser(User user);
}
