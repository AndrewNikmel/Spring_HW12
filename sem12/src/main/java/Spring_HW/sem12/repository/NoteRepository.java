package Spring_HW.sem12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Spring_HW.sem12.model.Note;

import java.util.Optional;

//Репозиторий заметок
public interface NoteRepository extends JpaRepository<Note, Long> {
    Optional<Note> findNoteById(Long id);
}