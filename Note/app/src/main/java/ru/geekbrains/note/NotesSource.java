package ru.geekbrains.note;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collections;

public class NotesSource implements NotesSourceInterface, Parcelable {
    public static final Creator<NotesSource> CREATOR = new Creator<NotesSource>() {
        @Override
        public NotesSource createFromParcel(Parcel in) {
            return new NotesSource(in);
        }

        @Override
        public NotesSource[] newArray(int size) {
            return new NotesSource[size];
        }
    };
    private final ArrayList<Note> notes;

    protected NotesSource(Parcel in) {
        notes = in.createTypedArrayList(Note.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(notes);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public NotesSourceInterface init(NotesSourceResponse notesSourceResponse) {
        Collections.addAll(notes);
        if (notesSourceResponse != null) {
            notesSourceResponse.initialized(this);
        }
        return this;
    }

    @Override
    public Note getNote(int position) {
        return notes.get(position);
    }

    @Override
    public int size() {
        return notes.size();
    }

    @Override
    public void deleteNote(int position) {
        notes.remove(position);
    }

    @Override
    public void changeNote(int position, Note note) {
        notes.set(position, note);
    }

    @Override
    public void addNote(Note note) {
        notes.add(note);
    }
}
