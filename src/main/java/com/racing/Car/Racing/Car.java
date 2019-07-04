package com.racing.Car.Racing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Car {
    private String name;
    private int speed;
    private int maxSpeed;
    private int location;
    private int laneNo;

    void accelerate(int speed, int maxLaneSpeed) {
        this.speed += speed;
        int speedToIncrease = Math.min(speed, maxLaneSpeed);
        if (this.speed > speedToIncrease) {
            this.speed = speedToIncrease;
        }
        this.location += this.speed;
    }

    void decelerate(int speed) {
        this.speed -= speed;
        if (this.speed < 0) {
            this.speed = 0;
        }
        this.location += this.speed;
    }
}
