package reserveList;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class ReserveListVO {
    public int reservationId;
    public int userId;
    public int scheduleId;
    public String movieTitle;
    public String cinemaName;
    public Timestamp startTime;
    public Integer price;
    public Date showDate;     // 상영 날짜 추가
    public Time showTime;     // 상영 시간 추가
    
    public String moviePoster;

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }

    
    public int getReservationId() { return reservationId; }
    public void setReservationId(int reservationId) { this.reservationId = reservationId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getScheduleId() { return scheduleId; }
    public void setScheduleId(int scheduleId) { this.scheduleId = scheduleId; }


    public String getMovieTitle() { return movieTitle; }
    public void setMovieTitle(String movieTitle) { this.movieTitle = movieTitle; }

    public String getCinemaName() { return cinemaName; }
    public void setCinemaName(String cinemaName) { this.cinemaName = cinemaName; }


    public Timestamp getStartTime() { return startTime; }
    public void setStartTime(Timestamp startTime) { this.startTime = startTime; }


    public Integer getPrice() { return price; }
    public void setPrice(Integer price) { this.price = price; }

    public Date getShowDate() { return showDate; }
    public void setShowDate(Date showDate) { this.showDate = showDate; }

    public Time getShowTime() { return showTime; }
    public void setShowTime(Time showTime) { this.showTime = showTime; }
}