package com.example.musicplayer;

/**
 * Created by asus on 2018/12/3.
 */

public class SongInfo {
    public String songName;//歌曲名
    public String singer;//歌手

    public String songPath;//歌曲地址

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }
}


