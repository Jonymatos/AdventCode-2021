public class Number {
    
    private int _number;
    private boolean _isMarked = false;

    //public Number(){}

    public Number(int number){
        _number = number;
    }

    /*Getters*/
    public int getNumber(){
        return _number;
    }

    public boolean getMarker(){
        return _isMarked;
    }

    /*Setters*/
    public void setNumber(int number){
        _number = number;
    }

    public void setMarker(){
        _isMarked = true;
    }

    public void setMarkerToFalse(){
        _isMarked = false;
    }

}
