package kg.edu.alatoo.online.shop.service;

import kg.edu.alatoo.online.shop.entity.User;
import kg.edu.alatoo.online.shop.payload.ItemRequestDTO;
import kg.edu.alatoo.online.shop.payload.ItemResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    ItemResponseDTO create(ItemRequestDTO itemRequestDTO, User user);
    ItemResponseDTO update(Long id, ItemRequestDTO itemRequestDTO, User user);
    ItemResponseDTO get(Long id, User user);
    List<ItemResponseDTO> getAll(User user);
    void delete(Long id);
}
