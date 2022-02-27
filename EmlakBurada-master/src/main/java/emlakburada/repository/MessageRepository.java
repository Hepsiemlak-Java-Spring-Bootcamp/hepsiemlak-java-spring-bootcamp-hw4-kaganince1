package emlakburada.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import emlakburada.model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
