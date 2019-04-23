package servlet;



class Entry{
    float value;

    String intervalType;
    String name;
    String comment;
    int intervalPeriod;
    Entry(float vIn, String etIn, int epIn, String nameIn, String commentIn){
        value = vIn;
        intervalType = etIn;
        intervalPeriod = epIn;
        name = nameIn;
        comment = commentIn;
    }
    public int getIntervalVal(){
        if(intervalType.equals("daily")){
            return 1;
        }else if(intervalType.equals("weekly")){
            return 7;
        }else if(intervalType.equals("monthly")){
            return 30;
        }else if(intervalType.equals("yearly")) {
            return 365;
        }
        return 0;
    }
    public double getValue(){
        return value;
    }
    public int getPeriod(){
        return intervalPeriod;
    }
    public String toString(){
        return String.format("Entry: %f - %d times %s", value, intervalPeriod, intervalType);
    }
    public String getName()
    {
        return name;
    }
    public String getIntervalType()
    {
        return intervalType;
    }
}
