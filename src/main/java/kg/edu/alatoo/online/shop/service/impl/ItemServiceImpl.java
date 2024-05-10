package kg.edu.alatoo.online.shop.service.impl;

import kg.edu.alatoo.online.shop.entity.Item;
import kg.edu.alatoo.online.shop.entity.User;
import kg.edu.alatoo.online.shop.exception.ItemNotFoundException;
import kg.edu.alatoo.online.shop.mapper.ItemMapper;
import kg.edu.alatoo.online.shop.payload.ItemRequestDTO;
import kg.edu.alatoo.online.shop.payload.ItemResponseDTO;
import kg.edu.alatoo.online.shop.repository.ItemRepository;
import kg.edu.alatoo.online.shop.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @Override
    public ItemResponseDTO create(ItemRequestDTO itemRequestDTO, User user) {
        Item item = itemMapper.toItem(itemRequestDTO);
        item.setUser(user);
        return itemMapper.toItemResponseDTO(itemRepository.save(item));
    }

    @Override
    public ItemResponseDTO update(Long id, ItemRequestDTO itemRequestDTO, User user) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Вещи с таким id не существует"));
        item.setName(itemRequestDTO.getName());
        item.setDescription(itemRequestDTO.getDescription());
        return itemMapper.toItemResponseDTO(itemRepository.save(item));
    }

    @Override
    public ItemResponseDTO get(Long id, User user) {
        return itemMapper.toItemResponseDTO(itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Вещи с таким id не существует")));
    }

    @Override
    public List<ItemResponseDTO> getAll(User user) {
       return itemRepository.findByUser(user);
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
