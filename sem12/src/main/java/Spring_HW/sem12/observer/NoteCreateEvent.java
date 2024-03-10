package Spring_HW.sem12.observer;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import Spring_HW.sem12.model.Note;
@Getter
public class NoteCreateEvent extends ApplicationEvent {
    private final Note note;
    private final String message;
    //Конструктор
    public NoteCreateEvent(Object object,String message, Note note) {
        super(object);
        this.message = message;
        this.note = note;
    }
}
