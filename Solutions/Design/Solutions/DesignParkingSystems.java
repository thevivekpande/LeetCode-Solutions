class ParkingSystem {
    
    int bigSize=0, mediumSize=0, smallSize=0;
    int bigCurr=0, mediumCurr=0, smallCurr=0;

    public ParkingSystem(int big, int medium, int small) {
        bigSize=big;
        mediumSize=medium;
        smallSize=small;
    }
    
    public boolean addCar(int carType) {
        if(carType==1){
            bigCurr++;
            return bigCurr<=bigSize;
        }else if(carType==2){
            mediumCurr++;
            return mediumCurr<=mediumSize;
        }else{
            smallCurr++;
            return smallCurr<=smallSize;
        }
    }
}