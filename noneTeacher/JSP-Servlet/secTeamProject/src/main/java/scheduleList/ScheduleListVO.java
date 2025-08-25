package scheduleList;

import java.sql.Date;
import java.sql.Time;

public class ScheduleListVO {
    public int scheduleId;
    public int movieId;
    public int cinemaId;
    public Date showDate;
    public Time showTime;
    
    // 조인해서 가져올 추가 정보들
    public String movieTitle;
    public String cinemaName;
    public String poster;
    
    public ScheduleListVO() {
    }
    
    // Getters and Setters
    public int getScheduleId() {
        return scheduleId;
    }
    
    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }
    
    public int getMovieId() {
        return movieId;
    }
    
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    
    public int getCinemaId() {
        return cinemaId;
    }
    
    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }
    
    public Date getShowDate() {
        return showDate;
    }
    
    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }
    
    public Time getShowTime() {
        return showTime;
    }
    
    public void setShowTime(Time showTime) {
        this.showTime = showTime;
    }
    
    public String getMovieTitle() {
        return movieTitle;
    }
    
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
    
    public String getCinemaName() {
        return cinemaName;
    }
    
    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }
    
    public String getPoster() {
        return poster;
    }
    
    public void setPoster(String poster) {
        this.poster = poster;
    }
}