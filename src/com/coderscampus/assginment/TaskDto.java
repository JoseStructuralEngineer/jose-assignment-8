package com.coderscampus.assginment;

public class TaskDto {

    private Double value;
    private Boolean finished = false;

    public Double getValue() {
        return value;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public TaskDto() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }


}
