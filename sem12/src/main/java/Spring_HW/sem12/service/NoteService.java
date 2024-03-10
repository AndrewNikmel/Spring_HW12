package Spring_HW.sem12.service;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import Spring_HW.sem12.model.Note;
import Spring_HW.sem12.observer.NoteCreateEvent;
import Spring_HW.sem12.repository.NoteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteService {
    //Репозиторий
    private final NoteRepository noteRepository;
    //Сохранение в файл
    private final FileWriter fileWriter;
    //Для прослушки событий
    private final ApplicationEventPublisher publisher;

    //Получим конкретную заметку
    public Note getNoteById(Long id) {
        Note note = noteRepository.findNoteById(id).orElse(null);
        publisher.publishEvent(new NoteCreateEvent(this, "Произведена выборка", note));
        return note;
    }

    //Получим все заметки
    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    //Добавление/Редактирование заметки
    public void save(Note note) {
        Note newNote = noteRepository.save(note);
        fileWriter.writeToFile("notes", newNote);
        publisher.publishEvent(new NoteCreateEvent(this, "Добавлена или отредактирована заметка",
                newNote));
    }

    //Удаление заметки
    public void delete(Long id) {
        Note note = noteRepository.findNoteById(id).orElse(null);
        noteRepository.deleteById(id);
        publisher.publishEvent(new NoteCreateEvent(this, "Удалена заметка", note));
    }
}