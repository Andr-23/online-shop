package kg.edu.alatoo.online.shop.controller;

import kg.edu.alatoo.online.shop.entity.User;
import kg.edu.alatoo.online.shop.payload.ItemRequestDTO;
import kg.edu.alatoo.online.shop.payload.ItemResponseDTO;
import kg.edu.alatoo.online.shop.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PreAuthorize("hasRole('SELLER') or hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<?> create(@AuthenticationPrincipal User user,
                                                  @RequestBody @Valid ItemRequestDTO itemRequestDTO) {
        return new ResponseEntity<>(itemService.create(itemRequestDTO, user), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('SELLER') or hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,  @RequestBody @Valid ItemRequestDTO itemRequestDTO,
                                                  @AuthenticationPrincipal User user) {
        return new ResponseEntity<>(itemService.update(id, itemRequestDTO, user), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER') or hasRole('SELLER') or hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id, @AuthenticationPrincipal User user) {
        return new ResponseEntity<>(itemService.get(id, user), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER') or hasRole('SELLER') or hasRole('ADMIN')")
    @GetMapping()
    public ResponseEntity<?> getAll(@AuthenticationPrincipal User user) {
        return new ResponseEntity<>(itemService.getAll(user), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('SELLER') or hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        itemService.delete(id);
        return new ResponseEntity<>("Вещь успешно удалена", HttpStatus.OK);
    }


}
