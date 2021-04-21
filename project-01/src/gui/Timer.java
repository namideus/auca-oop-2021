package gui;

import processing.core.PApplet;

class Timer {

    private int savedTime; // When Timer started
    private int totalTime; // How long Timer should last
    private int begin;
    private int duration;
    private int time;
    private PApplet canvas;

    public Timer(PApplet canvas, int tempTotalTime) {
        this.canvas = canvas;
        this.totalTime = tempTotalTime;
        this.begin = canvas.millis();
        this.duration = this.time = 0;
    }

    // Starting the timer
    void reset() {
        // When the timer starts it stores the current time in milliseconds.
        this.duration = this.time = 0;
        this.begin = canvas.millis();
    }

    // Get ellapsed time
    public int getEllapsedTime() {
        return duration + (canvas.millis() - begin)/1000;
    }

    // The function isFinished() returns true if 5,000 ms have passed.
    // The work of the timer is farmed out to this method.
    boolean isFinished() {
        // Check how much time has passed
        int passedTime = this.canvas.millis()- savedTime;
        return passedTime > totalTime;
    }

}//end class
