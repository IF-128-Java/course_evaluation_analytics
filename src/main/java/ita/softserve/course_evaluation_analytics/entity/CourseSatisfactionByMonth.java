package ita.softserve.course_evaluation_analytics.entity;

public class CourseSatisfactionByMonth {
    public CourseSatisfactionByMonth() {
    }

    public CourseSatisfactionByMonth(String monthName, int rate) {
        this.monthName= monthName;
        this.rate = rate;
    }

    private String monthName;
    private int rate;
}
