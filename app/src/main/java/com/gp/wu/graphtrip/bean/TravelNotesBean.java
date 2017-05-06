package com.gp.wu.graphtrip.bean;

import java.io.Serializable;

/**
 * Created by wu on 2017/5/6.
 */

public class TravelNotesBean implements Serializable{
    private String picSrc;

    private String faceSrc;
    private String faceHref;
    private String titleText;
    private String notesHref;

    private String noteTime;
    private String noteViews;
    private String noteReplys;
    private String noteLikes;
    private String noteAnthor;

    private String noteText;


    public String getPicSrc() {
        return picSrc;
    }

    public void setPicSrc(String picSrc) {
        this.picSrc = picSrc;
    }

    public String getFaceSrc() {
        return faceSrc;
    }

    public void setFaceSrc(String faceSrc) {
        this.faceSrc = faceSrc;
    }

    public String getFaceHref() {
        return faceHref;
    }

    public void setFaceHref(String faceHref) {
        this.faceHref = faceHref;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public String getNotesHref() {
        return notesHref;
    }

    public void setNotesHref(String notesHref) {
        this.notesHref = notesHref;
    }

    public String getNoteTime() {
        return noteTime;
    }

    public void setNoteTime(String noteTime) {
        this.noteTime = noteTime;
    }

    public String getNoteViews() {
        return noteViews;
    }

    public void setNoteViews(String noteViews) {
        this.noteViews = noteViews;
    }

    public String getNoteReplys() {
        return noteReplys;
    }

    public void setNoteReplys(String noteReplys) {
        this.noteReplys = noteReplys;
    }

    public String getNoteLikes() {
        return noteLikes;
    }

    public void setNoteLikes(String noteLikes) {
        this.noteLikes = noteLikes;
    }

    public String getNoteAnthor() {
        return noteAnthor;
    }

    public void setNoteAnthor(String noteAnthor) {
        this.noteAnthor = noteAnthor;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }
}
