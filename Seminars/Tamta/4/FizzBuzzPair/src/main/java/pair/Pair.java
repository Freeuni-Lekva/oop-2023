package pair;

public class Pair<T1, T2> {
    private T1 x;
    private T2 y;

    public T1 getX(){
        return x;
    }
    public T2 getY(){
        return y;
    }

    public void setX(T1 x){
        this.x = x;
    }
    public void setY(T2 y){
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof Pair)) {
            return false;
       }
       return ((Pair<?, ?>) obj).x.equals(this.x) &&   ((Pair<?, ?>) obj).y.equals(this.y);
    }
}
