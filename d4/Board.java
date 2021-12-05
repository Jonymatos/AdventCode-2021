import java.util.*;

public class Board{

    private Number _grid[][];
    private boolean _isDone = false;

    public Board(){
        _grid = new Number[5][5];
    }

    public void processLine(String[] nums, int row){
        for (int i=0; i < 5; i++)
            _grid[row][i] = new Number(Integer.parseInt(nums[i]));
        
    }

    public void searchNumber(int number){
        for (int i=0; i < 5; i++){

            for (int j=0; j < 5; j++){

                if (_grid[i][j].getNumber() == number){
                    _grid[i][j].setMarker();
                    return;
                }
            }
        }
    }

    public boolean checkRows(){

        for (int i=0; i < 5; i++){

            for (int j=0; j < 5; j++){

                if(!_grid[i][j].getMarker())
                    break;
                
                if (j == 4){
                    _isDone = true;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkCols(){

        for (int i=0; i < 5; i++){

            for (int j=0; j < 5; j++){

                if(!_grid[j][i].getMarker())
                    break;

                if (j == 4){
                    _isDone = true;
                    return true;
                }
            }
        }
        return false;
    }

    public int allUnmarkedNumbers(){
        int sum = 0;
        for (int i=0; i < 5; i++){

            for (int j=0; j < 5; j++){

                if (!_grid[i][j].getMarker())
                    sum += _grid[i][j].getNumber();   

            }  

        }
        return sum;
    }

    public void resetBoard(){
        _isDone = false;

        for (int i=0; i < 5; i++)

            for (int j=0; j < 5; j++)
                _grid[i][j].setMarkerToFalse();

    }

    public int simulateLastBoard(List <Integer> nums){
        for (int i=0; i < nums.size(); i++){
            
            this.searchNumber(nums.get(i));
            if (this.checkCols() || this.checkRows())
                return this.allUnmarkedNumbers() * nums.get(i);

        }
        /*Error*/
        return 0;
    }

    /*Getters*/
    public Number getNumber(int row, int col){
        return _grid[row][col];
    }

    public boolean isDone(){
        return _isDone;
    }

    /*Setters*/
    public void setNumber(int row, int col, int number){
        _grid[row][col].setNumber(number);
    }

    public void markNumber(int row, int col){
        _grid[row][col].setMarker();
    }

    @Override
    public String toString(){
        String board = "";
        for (int i=0; i < 5; i++){

            for (int j=0; j < 5; j++)
                board += _grid[i][j].getNumber() + " ";
        
            board += '\n';
        }
        return board;
    }

}