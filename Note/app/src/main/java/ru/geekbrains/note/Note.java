package ru.geekbrains.note;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;

public class Note implements Parcelable {
    public static final Parcelable.Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public ru.geekbrains.note.Note createFromParcel(Parcel in) {
            return new ru.geekbrains.note.Note(in);
        }

        @Override
        public ru.geekbrains.note.Note[] newArray(int size) {
            return new ru.geekbrains.note.Note[size];
        }
    };
    private String title;
    private String content;
    private Calendar creationDate;

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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }
}
