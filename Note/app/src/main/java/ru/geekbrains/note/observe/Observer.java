package ru.geekbrains.note.observe;

import ru.geekbrains.note.data.Note;

public interface Observer {
    void updateNote(Note note);
}
