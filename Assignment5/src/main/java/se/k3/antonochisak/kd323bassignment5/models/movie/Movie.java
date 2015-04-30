package se.k3.antonochisak.kd323bassignment5.models.movie;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * Created by isak on 2015-04-24.
 */

public class Movie {
    private String title;
    private String slugline;
    private String poster;
    private String fanArt;
    private String overview;
    private String tagline;
    private String imdbId;
    private String runtime;

    private int year;
    private int likes;
    private String rating;

    @ParcelConstructor
    private Movie(Builder builder) {
        this.title = builder.title;
        this.slugline = builder.slugline;
        this.poster = builder.poster;
        this.fanArt = builder.fanArt;
        this.year = builder.year;
        this.overview = builder.overview;
        this.tagline = builder.tagline;
        this.likes = builder.likes;
        this.imdbId = builder.imdbId;
        this.rating = builder.rating;
        this.runtime = builder.runtime;
    }

    public String getImdbId() {
        return imdbId;
    }
    public String getTitle() {
        return title;
    }

    public String getSlugline() {
        return slugline;
    }

    public String getPoster() {
        return poster;
    }

    public String getFanArt() {
        return fanArt;
    }

    public int getYear() {
        return year;
    }

    public String getOverview() {
        return overview;
    }

    public String getTagline() {
        return tagline;
    }

    public int getLikes() {
        return likes;
    }

    public String getRating() {
        return rating;
    }

    public String getRuntime() {
        return runtime;
    }


    public static class Builder {
        private String title, slugline, poster, fanArt, overview, tagline, runtime;
        private int year;
        public int likes;
        private String imdbId;
        public String rating;

        public Builder likes(int likes){
            this.likes = likes;
                    return this;
        }
        public Builder imdbId(String imdbId) {
            this.imdbId = imdbId;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder slugLine(String slugLine) {
            this.slugline = slugLine;
            return this;
        }

        public Builder poster(String poster) {
            this.poster = poster;
            return this;
        }

        public Builder fanArt(String fanArt) {
            this.fanArt = fanArt;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder overview(String overview) {
            this.overview = overview;
            return this;
        }

        public Builder tagline(String tagline) {
            this.tagline = tagline;
            return this;
        }

        public Builder rating(String rating) {
            this.rating = rating;
            return this;
        }

        public Builder runtime(String runtime) {
            this.runtime = runtime;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }


    }
}
