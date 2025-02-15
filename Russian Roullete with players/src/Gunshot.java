public class Gunshot  {
    private int bullet;
    private int spot;

    public Gunshot(int bullet,int spot){
        this.bullet=bullet;
        this.spot=spot;
    }
    public int GetBullet(){
        return bullet;
    }
    public int GetSpot(){
        return spot;
    }
    public void SetBullet(int bullet){
        this.bullet=bullet;
    }
    public void SetSpot(int spot){
        this.spot=spot;
    }


}
