package com.example.musicsy;

public class SongInfo {

        private String Songname;
        private String Artistname;
        private String Albumname;
        private String SongUrl;

        public SongInfo() {
        }

        public SongInfo(String songname, String artistname, String albumname, String songUrl) {
            Songname = songname;
            Artistname = artistname;
            SongUrl = songUrl;
            Albumname = albumname;
        }

    public void setAlbumname(String albumname) {
        Albumname = albumname;
    }

    public void setArtistname(String artistname) {
        Artistname = artistname;
    }

    public void setSongUrl(String songUrl) {
        SongUrl = songUrl;
    }



    public String getSongname() {
            return Songname;
        }

    public void setSongname(String songname) {
        Songname = songname;
    }

    public String getArtistname() {
            return Artistname;
        }
    public String getAlbumname() { return Albumname; }
    public String getSongUrl() {
            return SongUrl;
        }


    }
