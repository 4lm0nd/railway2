package dataobject;

public class BookTicket {
    public String getDepartDate(String departDate) {
        return this.departDate;
    }

    public String getDepartStation(String departStation) {
        return this.departStation;
    }

    public String getArriveStation(String arriveStation) {
        return this.arriveStation;
    }

    public String getSeatType(String seatType) {
        return this.seatType;
    }

    public BookTicket(String departDate, String departStation, String arriveStation, String seatType) {
        this.departDate = departDate;
        this.departStation = departStation;
        this.arriveStation = arriveStation;
        this.seatType = seatType;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public void setDepartStation(String departStation) {
        this.departStation = departStation;
    }

    public void setArriveStation(String arriveStation) {
        this.arriveStation = arriveStation;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }
    private String departDate;
    private String departStation;
    private String arriveStation;
    private String seatType;
}

