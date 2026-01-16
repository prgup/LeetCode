class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea=0.0;
        ArrayList<double []> events  = new ArrayList<>();
        for (int [] square : squares){
            double y = square[1], length = square[2];
            events.add(new double []  {y, length});
            events.add(new double []  {y+length, -length});
            totalArea+=length*length;
        }

        events.sort((x , y) -> Double.compare(x[0],y[0]));

        double target =totalArea/2.00;
        double prevY=0.0, currArea=0.0, prevW=0.0; 

        for (double [] event : events){
            double y = event[0], width =event[1];

            double change = y-prevY;
            currArea+= change*prevW;

            if (currArea >= target ){
                double prevArea = currArea-change*prevW;
                double need = target  -  prevArea;
                return prevY + need/prevW;
            }

            prevY = y;
            prevW+=width;
        }

        return -1;

    }
}