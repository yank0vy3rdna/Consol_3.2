package SpaceMarine;


public class Coordinates {
    private Float x; //Поле не может быть null, Значение поля должно быть больше -372
    private Double y; //Поле не может быть null
    Coordinates(float x, double y){
        this.x = x;
        this.y = y;
    }

    public void setX(float x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }

    public float getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }
}
