package ru.geekbrains.notes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;


public class Note implements Parcelable {
    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public ru.geekbrains.notes.Note createFromParcel(Parcel in) {
            return new ru.geekbrains.notes.Note(in);
        }

        @Override
        public ru.geekbrains.notes.Note[] newArray(int size) {
            return new ru.geekbrains.notes.Note[size];
        }
    };
    private final String title;
    private final String content;
    private final Calendar creationDate;

    public Note(String title, String content, Calendar creationDate) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    protected Note(Parcel in) {
        title = in.readString();
        content = in.readString();
        creationDate = (Calendar) in.readSerializable();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(content);
        dest.writeSerializable(creationDate);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

}
