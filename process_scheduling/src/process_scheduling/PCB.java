package process_scheduling;

public class PCB {  //定义PCB属性
    private String name;
    private int duringTime;
    private int priority;
    private  String state;

    PCB(String aName, int aDuringTime, int aPriority, String aState){
        this.name = aName;
        this.duringTime = aDuringTime;
        this.priority = aPriority;
        this.state = aState;
    }

    @Override
    public String toString() {

        return getName()+"\t\t"+getDuringTime()+"\t\t"+getState()+"\t\t"+getPriority();
    }

    public void setDuringTime(int duringTime) {

        this.duringTime = duringTime;
    }

    public void setPriority(int priority) {

        this.priority = priority;
    }

    public void setState(String state) {

        this.state = state;
    }

    public String getName() {

        return name;
    }

    public int getDuringTime() {

        return duringTime;
    }

    public int getPriority() {

        return priority;
    }

    public String getState() {

        return state;
    }

}
