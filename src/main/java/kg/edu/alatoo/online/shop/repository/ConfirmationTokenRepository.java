package kg.edu.alatoo.online.shop.repository;

import kg.edu.alatoo.online.shop.entity.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("confirmationTokenRepository")
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
    ConfirmationToken findByConfirmationToken(String confirmationToken);

    void deleteByConfirmationToken(ConfirmationToken confirmationToken);
}
