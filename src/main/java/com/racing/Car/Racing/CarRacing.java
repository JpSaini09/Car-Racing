package com.racing.Car.Racing;

import java.util.Random;

public class CarRacing {
    private static int racingLength = 1000;
    private static boolean raceNotFinished = true;

    /**
     * the method computes the leading car in the race at any given instance.
     * @param cars array of cars
     * @return Leading Car model
     */
    private static Car fetchCarLeadingTheRace(Car[] cars) {
        int leadingCarIndex = 0;
        int maxLocation = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getLocation() > maxLocation) {
                maxLocation = cars[i].getLocation();
                leadingCarIndex = i;
            }
        }
        return cars[leadingCarIndex];
    }

    /**
     * this method finds the leading car and according to the car location finds out the winner of the race.
     * @param cars array of cars
     * @return true if winner found else false
     */
    private static boolean findTheWinnerAndLeadCar(Car[] cars) {
        Car leadCar = fetchCarLeadingTheRace(cars);
        int leadCarLocation = leadCar.getLocation();
        if (leadCarLocation < 900) {
            System.out.println(leadCar.getName() + " is in lead at : " + leadCar.getLocation() + " with speed of : " + leadCar.getSpeed());
        } else if (leadCarLocation < racingLength) {
            System.out.println(leadCar.getName() + " is in lead at : " + leadCar.getLocation() + " with speed of :" + leadCar.getSpeed());
            System.out.println("Racing is about to finish..");
        } else if (leadCarLocation >= racingLength) {
            System.out.println("Racing is completed...");
            System.out.println(leadCar.getName() + " is the winner of this race");
            raceNotFinished = false;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Random r = new Random();

        //initializing the car array of default size 10, i.e no of cars to be 10
        Car[] cars = new Car[10];
        //initializing the lane array to maintain a maxLane speed
        int[] maxLaneSpeed = new int[10];

        //populating the max lane speed with random values.
        for (int i = 0; i < 10; i++) {
            maxLaneSpeed[i] = r.nextInt(30);
        }

        //populating the car models, with default initial speed as 0, and location as 0 i.e. starting of the lane.
        for (int i = 0; i < 10; i++) {
            cars[i] = Car.builder().name("car" + (i + 1)).location(0).laneNo(i).speed(0).maxSpeed(r.nextInt(50)).build();
        }

        // starting the race
        while (raceNotFinished) {
            for (int i = 0; i < 10; i++) {
                //accelerate or de-accelerate
                int speed = r.nextInt(20);
                //taking random value as 10 to accelerate and de-accelerate accordingly.
                if (speed <= 10) {
                    cars[i].accelerate(speed, maxLaneSpeed[i]);
                } else {
                    cars[i].decelerate(speed - 10);
                }
            }
            //finding fetchCarLeadingTheRace
            if (findTheWinnerAndLeadCar(cars)) {
                break;
            }
        }
    }
}
