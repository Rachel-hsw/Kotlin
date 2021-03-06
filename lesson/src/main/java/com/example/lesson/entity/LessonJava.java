package com.example.lesson.entity;

public class LessonJava {
    public enum State {
        PLAYBACK {
            public String stateName() {
                return "有回放";
            }
        },

        LIVE {
            public String stateName() {
                return "正在直播";
            }
        },

        WAIT {
            public String stateName() {
                return "等待中";
            }
        };

        public abstract String stateName();
    }

    private String date;
    private String content;
    private State state;

    public LessonJava(String date, String content, State state) {
        this.date = date;
        this.content = content;
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
