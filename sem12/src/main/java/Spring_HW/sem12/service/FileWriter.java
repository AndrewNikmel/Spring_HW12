package Spring_HW.sem12.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;
import Spring_HW.sem12.model.Note;

@MessagingGateway(defaultRequestChannel = "inputChanel")
public interface FileWriter {
    void writeToFile(@Header(FileHeaders.FILENAME) String filename, Note note);
}
